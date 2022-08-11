package org.example.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rooms")
public class Room {

    @Id
    @Column(name="id")
    //@GeneratedValue()
    private Integer roomId;

    @Column(name="status")
    private RoomStatus roomStatus;

    @Column(name="capacity")
    private Integer roomCapacity;

    @Column(name="price")
    private Integer roomPrice;
}
