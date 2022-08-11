package org.example.booking.cmd.api;

import org.example.booking.ReplaceUnderscoresAndOmitParameterTypes;

import org.example.booking.model.Room;
import org.example.booking.model.RoomStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import java.util.Arrays;
import java.util.Collection;

@DisplayName("cqrs booking: Book a free room")
@DisplayNameGeneration(ReplaceUnderscoresAndOmitParameterTypes.class)
public class BookARoomTest {

    private final Collection<Room> initialRooms = Arrays.asList(
            new Room(1, RoomStatus.EMPTY,2,200),
            new Room(2,RoomStatus.EMPTY,1,300)
    );
}
