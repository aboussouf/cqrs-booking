package org.example.booking.query.api;

import org.example.booking.query.api.aggregate.RoomAggregate;
import org.example.booking.query.api.command.CreateRoomCommand;
import org.example.booking.query.api.command.UpdateRoomCommand;
import org.example.booking.query.api.model.Booking;
import org.example.booking.query.api.model.Room;
import org.example.booking.query.api.model.RoomStatus;
import org.example.booking.query.api.projection.RoomProjection;
import org.example.booking.query.api.projector.RoomProjector;
import org.example.booking.query.api.query.BookingByTypeQuery;
import org.example.booking.query.api.repository.RoomReadRepository;
import org.example.booking.query.api.repository.RoomWriteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationUnitTest {
    private RoomWriteRepository roomWriteRepository;
    private RoomReadRepository roomReadRepository;
    private RoomProjector roomProjector;
    private RoomAggregate roomAggregate;
    private RoomProjection roomProjection;

    @BeforeEach
    void setUp() {
        roomWriteRepository = new RoomWriteRepository();
        roomReadRepository = new RoomReadRepository();
        roomProjector = new RoomProjector(roomReadRepository);
        roomAggregate = new RoomAggregate(roomWriteRepository);
        roomProjection = new RoomProjection(roomReadRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void should_query_return_result_when_command_run() throws Exception {
        Room room= null;
        CreateRoomCommand createRoomCommand = new CreateRoomCommand(1, RoomStatus.EMPTY,2,200, null);
        room = roomAggregate.handleCreateRoomCommand(createRoomCommand);
        roomProjector.project(room);

        UpdateRoomCommand updateRoomCommand = new UpdateRoomCommand(room.getRoomId().toString(), Stream.of(new Booking(123, "TEL","2022-08-15","2022-08-19", "C123",new Room(1, RoomStatus.EMPTY,2,200, null)))
                .collect(Collectors.toSet()));
        room = roomAggregate.handleUpdateRoomCommand(updateRoomCommand);
        roomProjector.project(room);

        BookingByTypeQuery bookingByTypeQuery = new BookingByTypeQuery("1","TEL");
        assertEquals(Stream.of(new Booking(123,"TEL","2022-08-15","2022-08-19", "C123",new Room(1, RoomStatus.EMPTY,2,200, null))).collect(Collectors.toSet()), roomProjection.handle(bookingByTypeQuery));
    }
}
