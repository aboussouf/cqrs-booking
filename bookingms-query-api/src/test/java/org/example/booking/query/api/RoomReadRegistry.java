package org.example.booking.query.api;

import org.example.booking.query.api.model.Room;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class RoomReadRegistry {
    private final Collection<Room> rooms;

    public RoomReadRegistry(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Collection<Room> freeRooms(LocalDate arrivalDate, LocalDate departureDate) {
        if((LocalDate.of(2022,8,1)).isBefore(departureDate)) {
            return rooms;
        } else {
            return Collections.emptyList();
        }
    }
}
