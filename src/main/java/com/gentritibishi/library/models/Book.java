package com.gentritibishi.library.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Book")
@Table(
        name = "Book",
        uniqueConstraints = {
                @UniqueConstraint(name = "isbn_unique", columnNames = "ISBN")
        }
)
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_id_sequence"
    )
    @Column(
            name = "book_id",
            updatable = false
    )
    private Long book_id;

    @Column(
            name = "ISBN",
            nullable = false,
            length = 13
    )
    @NaturalId
    private Long ISBN;

    @Column(
            name = "book_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NaturalId
    private String book_name;

    @Column(
            name = "book_author",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NaturalId
    private String book_author;

    @Column(
            name = "book_quantity",
            nullable = false
    )
    private Integer book_quantity;

    //: - Constructor
    public Book() {
    }

    public Book(Long ISBN, String book_name, String book_author, Integer book_quantity) {
        this.ISBN = ISBN;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_quantity = book_quantity;
    }
    //: - Constructor END

    //: - Getter Setter

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public Integer getBook_quantity() {
        return book_quantity;
    }

    public void setBook_quantity(Integer book_quantity) {
        this.book_quantity = book_quantity;
    }

    //: - Getter Setter END

    //: - To string

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", ISBN=" + ISBN +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_quantity=" + book_quantity +
                '}';
    }


    //: - To string end
}
