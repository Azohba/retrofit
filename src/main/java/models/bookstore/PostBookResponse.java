package models.bookstore;

import lombok.Getter;

import java.util.List;

public class PostBookResponse {
    @Getter
    List<CollectionOfIsbn.IsbnModel> books;
}
