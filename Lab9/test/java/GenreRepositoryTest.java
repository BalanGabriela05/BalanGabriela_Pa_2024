import model.GenresEntity;
import org.junit.Before;
import org.junit.Test;
import repository.GenreRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GenreRepositoryTest {
    private GenreRepository genreRepository;

    @Before
    public void setUp() {
        genreRepository = new GenreRepository();
    }

    @Test
    public void testCreateAndFindById() {
        GenresEntity genreEntity = new GenresEntity("Test Gen");
        genreRepository.create(genreEntity);

        GenresEntity genreFound = genreRepository.findById(genreEntity.getId());
        assertEquals(genreEntity, genreFound);
    }
    @Test
    public void testFindByName() {
        GenresEntity genre1 = new GenresEntity("Test Gen1");
        GenresEntity genre2 = new GenresEntity("Test Gen2");
        genreRepository.create(genre1);
        genreRepository.create(genre2);

        List<GenresEntity> books = genreRepository.findByName("Test");
        assertTrue(books.contains(genre1));
        assertTrue(books.contains(genre2));
    }
}
