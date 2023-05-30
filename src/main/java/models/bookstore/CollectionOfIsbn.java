package models.bookstore;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class CollectionOfIsbn {
    String userId;
    List<IsbnModel> collectionOfIsbns;

    @AllArgsConstructor @Getter
    public static class IsbnModel{
        String isbn;
    }
}
