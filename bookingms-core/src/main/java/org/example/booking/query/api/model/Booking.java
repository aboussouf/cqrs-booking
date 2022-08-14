package org.example.booking.query.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @Column(name= "id")
    @GeneratedValue()
    private Integer bookingId;

    private String arrivalDate;
    private String departureDate;
    private String clientId;
    private String bookingType;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
}
