
import model.BooksEntity;
import org.junit.Before;
import org.junit.Test;
import repository.BookRepository;

import java.awt.print.Book;
import java.util.List;

import static org.junit.Assert.*;

public class BookRepositoryTest {
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testCreateAndFindById() {
        BooksEntity bookEntity = new BooksEntity("Test Title" , 9,"En_Test",2003,6015);
        bookRepository.create(bookEntity);

        BooksEntity foundBook = bookRepository.findById(bookEntity.getId());
        assertEquals(bookEntity, foundBook);
    }
    @Test
    public void testFindByName() {
        BooksEntity book1 = new BooksEntity("Test Title1" , 9,"En_Test",2003,6011);
        BooksEntity book2 = new BooksEntity("Test Title2" , 9,"En_Test",2003,6012);
        bookRepository.create(book1);
        bookRepository.create(book2);

        List<BooksEntity> books = bookRepository.findByName("Test1");
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }
}
