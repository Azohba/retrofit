package models.bookstore;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserResponse {
    String userID;
    String username;
    List<BookModel> books;
}
