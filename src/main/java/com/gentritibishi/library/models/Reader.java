package com.gentritibishi.library.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Reader")
@Table(
        name = "Reader",
        uniqueConstraints = {
                @UniqueConstraint(name = "reader_email_unique", columnNames = "email")
        }
)
public class Reader {

    //: - BASIC INFORMATION

    @Id
    @SequenceGenerator(
            name = "reader_sequence",
            sequenceName = "reader_sequence",
            allocationSize = 1
            // allocationSize i bjen starto prej numrit 1 edhe per qdo rresht rritu ka 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "reader_sequence"
    )
    @Column(
            name = "readerID",
            updatable = false
    )
    private Long readerID;

    @Column(
            name = "first_name",
            nullable = false
    )
    @NaturalId
    private String first_name;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NaturalId
    private String last_name;

    @Column(
            name = "profession",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String profession;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    @Column(
            name = "date_of_birth",
            nullable = false
    )
    private Date date_of_birth;

    // FOR TEST not necessary

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    // FOR TEST

    //: - TECHNICAL INFORMATION

    @Column (
            name = "registration_date"
    )
    private Date registration_date;

    @Column (
            name = "expiration_date"
    )
    private Date expiration_date;

    @Column (
            name = "isPaid"
    )
    private Boolean isPaid;

    @Column (
            name = "reading_sector"
    )
    private String reading_sector;

    @Enumerated(EnumType.STRING) // per me ru si string vleren
    private account_status account_status;
    public enum account_status {
        active,
        non_active,
        suspended;
    }

    @Column (
            name = "price_for_subscription"
    )
    private int price;

    //: - CONSTRUCTORS BEGIN
    public Reader() {
    }

    public Reader(String first_name, String last_name, String profession, String address, Date date_of_birth, String email, Date registration_date, Date expiration_date, Boolean isPaid, String reading_sector, Reader.account_status account_status, int price) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.profession = profession;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.registration_date = registration_date;
        this.expiration_date = expiration_date;
        this.isPaid = isPaid;
        this.reading_sector = reading_sector;
        this.account_status = account_status;
        this.price = price;
    }

    //: - CONSTRUCTORS END

    //: - GETTER AND SETTER BEGIN

    public Long getReaderID() {
        return readerID;
    }

    public void setReaderID(Long readerID) {
        this.readerID = readerID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public String getReading_sector() {
        return reading_sector;
    }

    public void setReading_sector(String reading_sector) {
        this.reading_sector = reading_sector;
    }

    public Reader.account_status getAccount_status() {
        return account_status;
    }

    public void setAccount_status(Reader.account_status account_status) {
        this.account_status = account_status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    //: - GETTER AND SETTER END

    //: - TO STRING METHOD BEGIN

    @Override
    public String toString() {
        return "Reader{" +
                "readerID=" + readerID +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", email='" + email + '\'' +
                ", registration_date=" + registration_date +
                ", expiration_date=" + expiration_date +
                ", isPaid=" + isPaid +
                ", reading_sector='" + reading_sector + '\'' +
                ", account_status=" + account_status +
                ", price=" + price +
                '}';
    }


    //: - TO STRING METHOD END
}
