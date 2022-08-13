package org.example.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.booking.dto.BookingDto;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rooms")
public class Room {

    @Id
    @Column(name="room_id")
    //@GeneratedValue()
    private Integer roomId;

    @Column(name="status")
    private RoomStatus roomStatus;

    @Column(name="capacity")
    private Integer roomCapacity;

    @Column(name="price")
    private Integer roomPrice;

    @OneToMany
    @Column(name="bookings")
    private Set<Booking> bookings;
}
