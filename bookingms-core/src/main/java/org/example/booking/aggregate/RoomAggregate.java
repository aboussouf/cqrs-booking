package org.example.booking.aggregate;

import org.example.booking.command.CreateRoomCommand;
import org.example.booking.command.UpdateRoomCommand;
import org.example.booking.model.Room;
import org.example.booking.repository.RoomWriteRepository;

public class RoomAggregate {
    private RoomWriteRepository roomWriteRepository;
    public RoomAggregate(RoomWriteRepository roomWriteRepository) {
        this.roomWriteRepository = roomWriteRepository;
    }

    public Room handleCreateRoomCommand(CreateRoomCommand createRoomCommand) {

        Room room = new Room(createRoomCommand.getRoomId(), createRoomCommand.getRoomStatus(), createRoomCommand.getRoomCapacity(),createRoomCommand.getRoomPrice(), createRoomCommand.getBookings());

        roomWriteRepository.addRoom(room.getRoomId().toString(), room);
        return room;
    }

    public Room handleUpdateRoomCommand(UpdateRoomCommand updateRoomCommand) {
        Room room = roomWriteRepository.getRoom(updateRoomCommand.getRoomId());
        room.setBookings(updateRoomCommand.getBookings());
        roomWriteRepository.addRoom(room.getRoomId().toString(), room);
        return room;
    }
}
