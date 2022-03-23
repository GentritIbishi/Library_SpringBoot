package com.gentritibishi.library.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "User")
@Table(
        name = "UserInfo",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_name_unique", columnNames = "user_name"),
                @UniqueConstraint(name = "user_email_unique", columnNames = "user_email")
        }
)
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    private Long user_id;

    @Column(
            nullable = false,
            unique = true,
            updatable = false
    )
    @NaturalId
    private String user_name;

    @Column(
            nullable = false
    )
    private String user_pass;

    @Column(
            nullable = false,
            unique = true
    )
    @NaturalId
    private String user_email;

    @Column(
            name = "user_role"
    )
    @Enumerated(EnumType.STRING)
    private user_role user_role;
    public enum user_role {
        admin,
        user
    }

    //: - Getters and setters

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public User.user_role getUser_role() {
        return user_role;
    }

    public void setUser_role(User.user_role user_role) {
        this.user_role = user_role;
    }
    //: - Getters and setters

    //: - Constructor
    public User() {
    }

    public User(String user_name, String user_pass, String user_email, User.user_role user_role) {
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_email = user_email;
        this.user_role = user_role;
    }
    //: - Constructor END

}
