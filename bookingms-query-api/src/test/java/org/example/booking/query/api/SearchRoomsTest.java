package org.example.booking.query.api;

import org.assertj.core.api.Assertions;

import org.example.booking.query.api.model.Room;
import org.example.booking.query.api.model.RoomStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@DisplayName("cqrs booking: Show free rooms")
@DisplayNameGeneration(ReplaceUnderscoresAndOmitParameterTypes.class)
public class SearchRoomsTest {

    private final Collection<Room> initialRooms = Arrays.asList(
            new Room(1, RoomStatus.EMPTY,2,200, null),
            new Room(2,RoomStatus.EMPTY,1,300,null)
    );

    @Test
    public void should_find_no_room_when_searching_an_empty_location_catalog(){
        RoomReadRegistry roomReadRegistry = new RoomReadRegistry(initialRooms);
        LocalDate arrivalDate = LocalDate.of(2022,7,28);
        LocalDate departureDate = LocalDate.of(2022,7,31);
        Collection<Room> rooms = roomReadRegistry.freeRooms(arrivalDate, departureDate);
        Assertions.assertThat(rooms).describedAs("return free rooms").isEqualTo(Collections.emptyList());
    }

    @Test
    void should_get_free_rooms_when_finding_rooms_in_location_catalog() {
        RoomReadRegistry roomReadRegistry = new RoomReadRegistry(initialRooms);
        LocalDate arrivalDate = LocalDate.of(2022, 8, 2);
        LocalDate departureDate = LocalDate.of(2022, 8, 9);
        Collection<Room> rooms = roomReadRegistry.freeRooms(arrivalDate, departureDate);
        Assertions.assertThat(rooms).describedAs("return free rooms").isEqualTo(initialRooms);
    }

}
