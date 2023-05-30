## API Test Automation With Retrofit

This project demonstrates an api test automation design, combining **retrofit2, OkHttp3, BDD & AI DataGenerator**. 

### IssuesApi.feature
There are **26 api calls** that were implemented, representing various interactions with Gitlab, including creating a project, creating an issue in a
given project, print all issues in a project, update issues in a project, clone issue in a project, delete issue in a
project smf acquiring issues filtered by author, assignee, state, title, description & labels.
The project also has built in slack integration, built in the same design with the rest of the project.

### BookStore.feature

There are **6 api calls** that were implemented, representing various interactions with BookStore, including creating a 
user, authenticating with a user, assigning books to a user, getting all registered books, getting a user and deleting a user.
Project demonstrates a good example of a full basic authentication cycle.
Project also has built in slack integration, built in the same design with the rest of the project.

### AI DataGenerator:
The project uses Gpt Utilities dependency to generate data objects
```xml
<!-- GPT Utilities -->
<dependency>
    <groupId>io.github.umutayb</groupId>
    <artifactId>gpt-utilities</artifactId>
    <version>0.0.7</version>
</dependency> 
```

Data generation is done by:

```java
import api_assured.ApiUtilities;
import gpt.utilities.DataGenerator;
import context.ContextStore;
import  models.bookstore.CredentialModel;
import  models.bookstore.UserResponse;

public class BookStore extends ApiUtilities {

    DataGenerator generator = new DataGenerator(Utilities.gpt);

    public void createUserWithGpt() {
        generator.setTemperature(1.0);
        CredentialModel user = generator.instantiate(CredentialModel.class, "password"); // Data is generated here
        user.setPassword("Alpha1234*");
        UserResponse userResponse = createUser(user);
        ContextStore.put("user", user);
        ContextStore.put("userId", userResponse.getUserID());
    }
}
```

### Running:
Running the tests are done by combining feature and scenario tags.

``` shell
mvn -B clean test -q -Dcucumber.filter.tags="@BookStore and @SCN-Post-Book-Test"
```

Please remember to clone the repository, create a gitlab token and update the gitlab-token property 
within test.properties (src/test/resources/test.properties) file. Add the id of your newly created 
project to the Project.java enum & Finally update the scenario with the name of your new enum.

Add your openAI gpt token to the test properties file with ket **gpt-token**
