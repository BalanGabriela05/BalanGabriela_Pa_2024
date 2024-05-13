package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genres", schema = "db")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll",
                query = " SELECT e FROM GenresEntity e ORDER BY e.name"),
        @NamedQuery(name = "Genre.findByName",
                query = "SELECT a FROM GenresEntity a WHERE a.name LIKE :name")
})
public class GenresEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "book_genres",
            joinColumns = @JoinColumn(name = "genres_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<BooksEntity> books = new LinkedHashSet<>();

    public GenresEntity(String name) {
        this.name = name;
    }
    public GenresEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenresEntity that = (GenresEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
