import model.AuthorsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

import java.util.List;

public class JpaTest {

    @Test
    public void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        List<AuthorsEntity> authors = em.createQuery(
                        "select e from AuthorsEntity e where e.name='Mark Twain'")
                .getResultList();

        if (authors.size() != 1) {
            throw new IllegalStateException("Mai mult de un autor cu numele 'Mark Twain' a fost găsit!");
        }

        AuthorsEntity a = authors.get(0);
        a.setName("Samuel Langhorne Clemens");

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}

