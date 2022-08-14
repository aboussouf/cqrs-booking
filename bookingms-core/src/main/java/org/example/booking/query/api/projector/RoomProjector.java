package org.example.booking.query.api.projector;

import org.example.booking.query.api.model.Room;
import org.example.booking.query.api.repository.RoomReadRepository;

public class RoomProjector {
    private RoomReadRepository roomReadRepository;
    public RoomProjector(RoomReadRepository roomReadRepository) {
        this.roomReadRepository = roomReadRepository;
    }

    public void project(Room room) {
    }
}
