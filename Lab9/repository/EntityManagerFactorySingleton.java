package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static final EntityManagerFactorySingleton instance = new EntityManagerFactorySingleton();
    private final EntityManagerFactory entityManagerFactory;

    private EntityManagerFactorySingleton() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
    }

    public static EntityManagerFactorySingleton getInstance() {
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
