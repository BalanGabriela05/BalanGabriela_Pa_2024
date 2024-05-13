package repository;

import model.BooksEntity;

public class BookRepository  extends AbstractRepository<BooksEntity, Integer> {
    public BookRepository() {
        super(EntityManagerFactorySingleton.getInstance().getEntityManagerFactory(), BooksEntity.class);
    }}
//
//package repository;
//
//import model.BooksEntity;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Query;
//import java.util.List;
//
//
//public class BookRepository {
//
//    private final EntityManagerFactory entityManagerFactory;
//
//    public BookRepository(){
//        entityManagerFactory = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory();
//    }
//    public void create(BooksEntity book) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(book);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//
//    public BooksEntity findById(int id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        BooksEntity book = entityManager.find(BooksEntity.class, id);
//        entityManager.close();
//        return book;
//    }
//
//    public List<BooksEntity> findByTitle(String title) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Query query = entityManager.createNamedQuery("Book.findByTitle");
//        query.setParameter("title","%" + title + "%");
//        List<BooksEntity> books = query.getResultList();
//        entityManager.close();
//        return books;
//    }
//}
