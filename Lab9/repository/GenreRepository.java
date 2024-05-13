package repository;

import model.GenresEntity;

public class GenreRepository  extends AbstractRepository<GenresEntity, Integer> {
    public GenreRepository() {
        super(EntityManagerFactorySingleton.getInstance().getEntityManagerFactory(), GenresEntity.class);
    }}

//package repository;
//
//import model.GenresEntity;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Query;
//import java.util.List;
//
//
//public class GenreRepository {
//    private final EntityManagerFactory entityManagerFactory;
//
//    public GenreRepository(){
//        this.entityManagerFactory = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory();
//    }
//    public void create(GenresEntity genre) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(genre);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//
//    public GenresEntity findById(int id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        GenresEntity genre = entityManager.find(GenresEntity.class, id);
//        entityManager.close();
//        return genre;
//    }
//
//    public List<GenresEntity> findByName(String name) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Query query = entityManager.createNamedQuery("Genre.findByName");
//        query.setParameter("name", "%" + name + "%");
//        List<GenresEntity> genre = query.getResultList();
//        entityManager.close();
//        return genre;
//    }
//
//    public List<GenresEntity> findAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Query query = entityManager.createNamedQuery("Genre.findAll");
//        List<GenresEntity> genres = query.getResultList();
//        entityManager.close();
//        return  genres;
//    }
//
//}
