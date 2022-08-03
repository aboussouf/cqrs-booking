package org.example.booking;

import org.example.booking.model.Booking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = Booking.class)
public class BookingMsCmdApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingMsCmdApiApplication.class, args);
    }

}
