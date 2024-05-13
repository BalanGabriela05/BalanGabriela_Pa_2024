package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publishing_house", schema = "db")
@NamedQueries({
        @NamedQuery(name = "Publish.findAll",
                query = "SELECT e FROM PublishingHouseEntity e ORDER BY e.name "),
        @NamedQuery(name = "Publish.findByLabelName",
                query = "SELECT a FROM PublishingHouseEntity a WHERE a.name LIKE :labelName")
})
public class PublishingHouseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BooksEntity book;

    public PublishingHouseEntity(String labelName) {
        this.name = labelName;
    }
    public PublishingHouseEntity() {
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

        PublishingHouseEntity that = (PublishingHouseEntity) o;

        if (id != that.id) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
