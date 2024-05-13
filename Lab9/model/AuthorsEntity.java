package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors", schema = "db")
@NamedQueries({
        @NamedQuery(name = "Author.findAll",
                query = "select e from AuthorsEntity e order by e.name"),
        @NamedQuery(name = "Author.findByName",
                query = "SELECT a FROM AuthorsEntity a WHERE a.name LIKE :name")
})
public class AuthorsEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "authors_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<BooksEntity> books = new LinkedHashSet<>();

    // Constructor care primește un șir de caractere pentru numele autorului
    public AuthorsEntity(String name) {
        this.name = name;
    }

    // Constructor gol necesar pentru JPA
    public AuthorsEntity() {
    }

    // Getters și setters pentru celelalte atribute

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

    // Metodele equals și hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorsEntity that = (AuthorsEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
