package org.example.booking.repository;

import org.example.booking.model.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomWriteRepository {

    private Map<String, Room> store = new HashMap<>();

    public void addRoom(String roomId, Room room) {
        store.put(roomId, room);
    }

    public Room getRoom(String roomId) {
        return store.get(roomId);
    }

}
