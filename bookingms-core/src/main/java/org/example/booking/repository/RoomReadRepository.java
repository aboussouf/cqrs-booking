package org.example.booking.repository;

import org.example.booking.model.RoomBooking;

import java.util.HashMap;
import java.util.Map;

public class RoomReadRepository {
    private Map<String, RoomBooking> roomBooking = new HashMap<>();
    public void addRoomBooking(String id, RoomBooking booking) {
        roomBooking.put(id, booking);
    }

    public RoomBooking getRoomBooking(String id) {
        return roomBooking.get(id);
    }
}
