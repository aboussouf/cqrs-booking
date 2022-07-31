package org.example.booking.dto;

public class Room {

    private String roomName;

    private boolean isFree;

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public Room(String roomName, boolean isFree) {
        this.roomName = roomName;
        this.isFree = isFree;
    }
}
