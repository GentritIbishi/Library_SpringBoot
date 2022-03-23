package com.gentritibishi.library.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Seat")
@Table(
        name = "Seat"
)
public class Seat {

    // NOTE: Automatik seats sbon me kon
    @Id
    @SequenceGenerator(
            name = "seat_id_sequence",
            sequenceName = "seat_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "seat_id_sequence"
    )
    @Column (
            name = "seat_id",
            nullable = false
    )
    private Long seat_id;

    // Kto dyja kan me kan foreign key Lexuesi me Vendet 1 me shume

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "first_name",
                    referencedColumnName = "first_name"
            ),
            @JoinColumn(
                    name = "last_name",
                    referencedColumnName = "last_name"
            )
    })
    private Reader full_name;

    // Kto dyja kan me kan foreign key Lexuesi me Vendet 1 me shume

    @Column (
            name = "date"
    )
    private Date date;

    @Column (
            name = "time_started"
    )
    private Time time_started;

    @Column (
            name = "time_finished"
    )
    private Time time_finished;

    @Enumerated(EnumType.STRING)
    private seat_status seat_status;
    public enum seat_status {
        free,
        busy,
        reserved;
    }


    //: - Constructor
    public Seat(Reader full_name, Date date, Time time_started, Time time_finished, Seat.seat_status seat_status) {
        this.full_name = full_name;
        this.date = date;
        this.time_started = time_started;
        this.time_finished = time_finished;
        this.seat_status = seat_status;
    }

    public Seat() {
    }
    //: - Constructor END

    //: - Getters and setters
    public Long getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Long seat_id) {
        this.seat_id = seat_id;
    }

    public Reader getFull_name() {
        return full_name;
    }

    public void setFull_name(Reader full_name) {
        this.full_name = full_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime_started() {
        return time_started;
    }

    public void setTime_started(Time time_started) {
        this.time_started = time_started;
    }

    public Time getTime_finished() {
        return time_finished;
    }

    public void setTime_finished(Time time_finished) {
        this.time_finished = time_finished;
    }

    public Seat.seat_status getSeat_status() {
        return seat_status;
    }

    public void setSeat_status(Seat.seat_status seat_status) {
        this.seat_status = seat_status;
    }

    //: - Getters and setters END
}
