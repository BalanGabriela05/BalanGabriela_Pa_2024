import model.AuthorsEntity;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthorsEntityTest {

    @Test
    public void testAuthorsEntityCreation() {
        AuthorsEntity author = new AuthorsEntity("Mark Twain");
        assertEquals("Mark Twain", author.getName());
    }

    @Test
    public void testSetName() {
        AuthorsEntity author = new AuthorsEntity();
        author.setName("Samuel Langhorne Clemens");
        assertEquals("Samuel Langhorne Clemens", author.getName());
    }



}
