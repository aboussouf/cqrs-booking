package org.example.booking.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.booking.model.Booking;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class UpdateRoomCommand {
    private String roomId;
    private Set<Booking> bookings = new HashSet<>();
}
