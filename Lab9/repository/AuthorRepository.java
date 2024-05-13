package repository;

import model.AuthorsEntity;

public class AuthorRepository  extends AbstractRepository<AuthorsEntity, Integer> {
    public AuthorRepository() {
        super(EntityManagerFactorySingleton.getInstance().getEntityManagerFactory(), AuthorsEntity.class);
    }}

//package repository;
//
//import model.AuthorsEntity;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Query;
//import java.util.List;
//
//public class AuthorRepository {
//    private final EntityManagerFactory entityManagerFactory;
//
//    public AuthorRepository() {
//        entityManagerFactory = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory();
//    }
//
//    public void create(AuthorsEntity author) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(author);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    public AuthorsEntity findById(int id) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        AuthorsEntity author = em.find(AuthorsEntity.class, id);
//        em.close();
//        return author;
//    }
//
//    public List<AuthorsEntity> findByName(String namePattern) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        Query query = em.createNamedQuery("Author.findByName");
//        query.setParameter("name", "%" + namePattern + "%");
//        List<AuthorsEntity> authors = query.getResultList();
//        em.close();
//        return authors;
//    }
//}
