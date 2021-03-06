package com.gentritibishi.library;

import com.gentritibishi.library.models.*;
import com.gentritibishi.library.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.util.Date;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ReaderRepository readerRepository,
                                        SeatRepository seatRepository,
                                        BookHolderRepository bookHolderRepository,
                                        BookRepository bookRepository,
                                        UserRepository userRepository) {
        return args -> {


            User admin = new User(
                    "admin",
                    "admin",
                    "admin@gmail.com",
                    User.user_role.admin
            );

            User user = new User(
                    "user",
                    "user",
                    "user@gmail.com",
                    User.user_role.user
            );

            userRepository.save(admin);
            userRepository.save(user);

            Book book = new Book(
                    Long.valueOf(123456789102L),
                    "Lulet e veres",
                    "Naim Frasheri",
                    10
            );

            bookRepository.save(book);


            Reader gentrit = new Reader(
                    "Gentrit",
                    "Ibishi",
                    "Computer Engineer",
                    "Deshmoret e kombit, Vushtrri 42000",
                    new Date(),
                    "gentritibishi@gmail.com",
                    new Date(),
                    new Date(),
                    true,
                    "Kati i pare",
                    Reader.account_status.active,
                    10

            );

            //TST

            Reader gentrit1 = new Reader(
                    "Test",
                    "Ibishi",
                    "Computer Engineer",
                    "Deshmoret e kombit, Vushtrri 42000",
                    new Date(),
                    "gentritibishi1@gmail.com",
                    new Date(),
                    new Date(),
                    true,
                    "Kati i pare",
                    Reader.account_status.active,
                    10

            );

            //TST


            readerRepository.save(gentrit1);
            readerRepository.save(gentrit);

            Seat seat = new Seat(
                    gentrit1,
                    new Date(),
                    new Time(Long.valueOf("222")),
                    new Time(Long.valueOf("2222")),
                    Seat.seat_status.busy
            );

            Seat seat1 = new Seat(
                    gentrit,
                    new Date(),
                    new Time(Long.valueOf("222")),
                    new Time(Long.valueOf("2222")),
                    Seat.seat_status.busy
            );

            seatRepository.save(seat);
            seatRepository.save(seat1);


            BookHolder bookHolder = new BookHolder(
                    book,
                    gentrit
            );

            bookHolderRepository.save(bookHolder);




        };
    }

}
