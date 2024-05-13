package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "books", schema = "db")
@NamedQueries({
        @NamedQuery(name = "Book.findAll",
                query = "SELECT e FROM BooksEntity e ORDER BY e.title "),
        @NamedQuery(name = "Book.findByTitle",
                query = "SELECT a FROM BooksEntity a WHERE a.title LIKE :title")
})

public class BooksEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "year")
    private Integer year;
    @Basic
    @Column(name = "language")
    private String language;
    @Basic
    @Column(name = "pages")
    private Integer pages;
    @Basic
    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "books")
    private Set<AuthorsEntity> authors = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<GenresEntity> books = new LinkedHashSet<>();

    public BooksEntity(String title, Integer page, String language, Integer year, Integer id) {
        this.title = title;
        this.pages = page;
        this.language = language;
        this.year = year;
        this.id = id;
    }
    public BooksEntity() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksEntity that = (BooksEntity) o;
        return id == that.id && Objects.equals(year, that.year) && Objects.equals(language, that.language) && Objects.equals(pages, that.pages) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, language, pages, title);
    }
}
