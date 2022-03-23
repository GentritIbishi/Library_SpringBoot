package com.gentritibishi.library.models;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "BookHolder")
@Table(name = "BookHolder")
public class BookHolder {

    @Id
    @SequenceGenerator(
            name = "book_holder_sequence",
            sequenceName = "book_holder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_holder_sequence"
    )
    private Long holder_book_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ISBN", referencedColumnName = "ISBN"),
            @JoinColumn(name = "book_name", referencedColumnName = "book_name"),
            @JoinColumn(name = "book_author", referencedColumnName = "book_author")
    })
    private Book book_holder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "first_name", referencedColumnName = "first_name"),
            @JoinColumn(name = "last_name", referencedColumnName = "last_name")
    })
    private Reader reader_holder;

    //Dhe user mbetet mu kry

    //: - Getter and setter

    public Long getHolder_book_id() {
        return holder_book_id;
    }

    public void setHolder_book_id(Long holder_book_id) {
        this.holder_book_id = holder_book_id;
    }

    public Book getBook_holder() {
        return book_holder;
    }

    public void setBook_holder(Book book_holder) {
        this.book_holder = book_holder;
    }

    public Reader getReader_holder() {
        return reader_holder;
    }

    public void setReader_holder(Reader reader_holder) {
        this.reader_holder = reader_holder;
    }


    //: - Getter and setter END

    //: - Constructor

    public BookHolder(Book book_holder, Reader reader_holder) {
        this.book_holder = book_holder;
        this.reader_holder = reader_holder;
    }

    public BookHolder() {
    }

    //: - Constructor END
}
