package org.example.booking.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.booking.model.Booking;
import org.example.booking.model.RoomStatus;

import java.util.Set;

@Data
@AllArgsConstructor
public class CreateRoomCommand {
    private Integer roomId;

    private RoomStatus roomStatus;

    private Integer roomCapacity;

    private Integer roomPrice;

    private Set<Booking> bookings;
}
