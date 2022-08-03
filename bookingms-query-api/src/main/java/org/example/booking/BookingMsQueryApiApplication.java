package org.example.booking;

import org.example.booking.model.Booking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = Booking.class)
public class BookingMsQueryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingMsQueryApiApplication.class, args);
    }

}
