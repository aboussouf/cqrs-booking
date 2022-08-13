package org.example.booking.projector;

import org.example.booking.model.Room;
import org.example.booking.repository.RoomReadRepository;

public class RoomProjector {
    private RoomReadRepository roomReadRepository;
    public RoomProjector(RoomReadRepository roomReadRepository) {
        this.roomReadRepository = roomReadRepository;
    }

    public void project(Room room) {
    }
}
