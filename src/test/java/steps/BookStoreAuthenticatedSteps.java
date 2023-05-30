package steps;

import bookstore.BookStore;
import context.ContextStore;
import io.cucumber.java.en.Given;
import models.bookstore.*;
import java.util.ArrayList;
import java.util.List;

public class BookStoreAuthenticatedSteps {

    BookStore bookStore = new BookStore();

    BookStore.BookStoreAuthenticated bookStoreAuthenticated;

    public BookStoreAuthenticatedSteps(){
        bookStoreAuthenticated = new BookStore.BookStoreAuthenticated(ContextStore.get("token").toString());
    }

    @Given("Get user by id: {}")
    public void getUser(String userId) {
        UserResponse userResponse = bookStoreAuthenticated.getUser(userId);
        ContextStore.put("userResponse", userResponse);
    }

    @Given("Post books by publisher named {} to the user in context")
    public void postBooks(String publisher) {
        List<CollectionOfIsbn.IsbnModel> isbns = new ArrayList<>();
        String userId = ContextStore.get("userId");

        for (BookModel book: bookStore.getAllBooks().getBooks())
            if (book.getPublisher().equalsIgnoreCase(publisher))
                isbns.add(new CollectionOfIsbn.IsbnModel(book.getIsbn()));
        CollectionOfIsbn collection = new CollectionOfIsbn(userId, isbns);

        PostBookResponse bookResponse = bookStoreAuthenticated.postBooks(collection);
        ContextStore.put("postedBooks", bookResponse);
        bookStoreAuthenticated.log.new Success("Books posted successfully");
    }

    @Given("Get user in context")
    public void getUserInContext() {
        getUser(ContextStore.get("userId").toString());
    }

    @Given("Delete user by Id: {}")
    public void deleteUserById(String userId) {
        bookStoreAuthenticated.deleteUser(userId);
        bookStoreAuthenticated.log.new Success("User deleted successfully");
    }

    @Given("Delete the user in context")
    public void deleteUserInContext() {
        deleteUserById(ContextStore.get("userId"));
    }
}
