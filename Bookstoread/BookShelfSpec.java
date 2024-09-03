package Bookstoread;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BookShelfSpec {
    @Test
    public void shelfEmptyWhenNoBookAdded() throws Exception {
        BookShelf shelf = new BookShelf();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }
    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
    	BookShelf shelf = new BookShelf(); 
    	shelf.add("Effective Java", "Code Complete");
    	List<String> books = shelf.books();
    	assertEquals(2, books.size(), () -> "BookShelf should have two books.");
    }
    
    @Test
    public void emptyBookShelfWhenAddIsCalledWithoutBooks() {
    	BookShelf shelf = new BookShelf();
    	shelf.add();
    	List<String> books = shelf.books();
    	assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

@Test
void booksReturnedFromBookShelfIsImmutableForClient() {
	BookShelf shelf = new BookShelf();
	shelf.add("Effective Java", "Code Complete");
	List<String> books = shelf.books();
	try {
		books.add("The Mythical Man-Month");
		fail(() -> "Should not be able to add book to books");
	} catch (Exception e) {
		assertTrue(e instanceof UnsupportedOperationException, () -> "Should throw UnsupportedOperationException.");
	}
}

@Test
void bookshelfArrangedByBookTitle() {
	BookShelf shelf = new BookShelf();
	shelf.add("Effective Java", "Code Complete","The Mythical Man-Month" );
	List<String> books = shelf.arrange();
	assertEquals(Arrays.asList("Code Complete", "Effective Java", "The Mythical Man-Month"), books, () -> "Books in a bookshelf should be arranged lexicographically by book title");
}


@Test
void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
	BookShelf shelf = new BookShelf();
	shelf.add("Effective Java", "Code Complete", "The Mythical Man-Month");
	shelf.arrange();
	List<String> books = shelf.books();
	assertEquals(Arrays.asList("Effective Java", "Code Complete", "The Mythical Man-Month"), books, () -> "Books in bookshelf are in insertion order");
}


}