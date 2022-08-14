package org.example.booking.query.api.repository;

import org.example.booking.query.api.model.Room;

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
