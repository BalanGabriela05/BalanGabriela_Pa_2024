import model.AuthorsEntity;
import org.junit.Before;
import org.junit.Test;
import repository.AuthorRepository;

import java.util.List;

import static org.junit.Assert.*;

public class AuthorRepositoryTest {
    private AuthorRepository authorRepository;

    @Before
    public void setUp() {
        authorRepository = new AuthorRepository();
    }

    @Test
    public void testCreateAndFindById() {
        AuthorsEntity author = new AuthorsEntity("Mark Twain");
        authorRepository.create(author);

        AuthorsEntity foundAuthor = authorRepository.findById(author.getId());
        assertEquals(author, foundAuthor);
    }

    @Test
    public void testFindByName() {
        AuthorsEntity author1 = new AuthorsEntity("Mark Twain");
        AuthorsEntity author2 = new AuthorsEntity("Mark Antony");
        authorRepository.create(author1);
        authorRepository.create(author2);

        List<AuthorsEntity> authors = authorRepository.findByName("Mark");
        assertTrue(authors.contains(author1));
        assertTrue(authors.contains(author2));
    }
}
