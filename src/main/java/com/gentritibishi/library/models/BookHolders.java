package com.gentritibishi.library.models;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "BookHolders")
@Table(name = "BookHolders")
public class BookHolders {

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


    //: - Getter and setter END
}
