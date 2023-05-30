package bookstore;

import api_assured.ApiUtilities;
import api_assured.ServiceGenerator;
import common.Utilities;
import context.ContextStore;
import gpt.utilities.DataGenerator;
import models.bookstore.*;
import okhttp3.Headers;
import retrofit2.Call;

public class BookStore extends ApiUtilities {

    BookStoreServices bookStore = new ServiceGenerator().generate(BookStoreServices.class);
    DataGenerator generator = new DataGenerator(Utilities.gpt);

    public UserResponse createUser(CredentialModel credentialModel) {
        log.new Info("Creating a user");
        Call<UserResponse> userCall = bookStore.postUser(credentialModel);
        return perform(userCall, true, true);
    }

    public TokenResponse generateToken(CredentialModel user) {
        log.new Info("Generating a token for " + user.getUserName());
        Call<TokenResponse> tokenCall = bookStore.generateToken(user);
        return perform(tokenCall, true, true);
    }

    public void createUserWithGpt() {
        generator.setTemperature(1.0);
        CredentialModel user = generator.instantiate(CredentialModel.class, "password");
        user.setPassword("Alpha1234*");
        UserResponse userResponse = createUser(user);
        ContextStore.put("user", user);
        ContextStore.put("userId", userResponse.getUserID());
    }

    public void generateTokenForContext() {
        TokenResponse tokenResponse = generateToken(ContextStore.get("user"));
        if (tokenResponse.getStatus().equalsIgnoreCase("failed"))
            log.new Warning("Process failed");
        else log.new Success("Token generated successfully");
        ContextStore.put("token", tokenResponse.getToken());
    }

    public BookListModel getAllBooks() {
        log.new Info("Getting all the books from database");
        Call<BookListModel> bookListCall = bookStore.getAllBooks();
        return perform(bookListCall, true, true);
    }

    public static class BookStoreAuthenticated extends ApiUtilities {
        BookStoreServices.Authorised bookStoreAuthorized;

        public BookStoreAuthenticated(String bearer){
            bookStoreAuthorized = new ServiceGenerator(
                    new Headers.Builder().add("Authorization", "Bearer " + bearer).build()
            ).generate(BookStoreServices.Authorised.class);
        }

        public PostBookResponse postBooks(CollectionOfIsbn collection) {
            log.new Info("Posting book(s)");
            Call<PostBookResponse> bookCall = bookStoreAuthorized.postBooks(collection);
            return perform(bookCall, true, true);
        }

        public UserResponse getUser(String userId) {
            log.new Info("Getting user: " + userId);
            Call<UserResponse> userCall = bookStoreAuthorized.getUser(userId);
            return perform(userCall, true, true);
        }

        public Object deleteUser(String userId) {
            log.new Info("Deleting user");
            Call<Object> userCall = bookStoreAuthorized.deleteUser(userId);
            return perform(userCall, true, true);
        }
    }
}
