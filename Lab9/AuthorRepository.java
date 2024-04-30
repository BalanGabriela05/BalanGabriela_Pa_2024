package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorRepository {
    private EntityManager entityManager;

    public AuthorRepository() {
        entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
    }

    public void create(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    public Author findById(Integer id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> findByName(String name) {
        TypedQuery<Author> query = entityManager.createNamedQuery("Author.findByName", Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
