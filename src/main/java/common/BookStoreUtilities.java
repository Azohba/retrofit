package common;

import models.bookstore.BookListModel;
import models.bookstore.BookModel;

public class BookStoreUtilities {

    public static String acquireBookByPublisher(String publisher, BookListModel books) {
        for (BookModel book: books.getBooks())
            if (book.getPublisher().equalsIgnoreCase(publisher))
                return book.getIsbn();
        throw new RuntimeException("Book is not found");
    }

}
