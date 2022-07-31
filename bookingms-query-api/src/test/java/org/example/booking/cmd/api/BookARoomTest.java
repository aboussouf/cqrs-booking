package org.example.booking.cmd.api;

import org.assertj.core.api.Assertions;
import org.example.booking.ReplaceUnderscoresAndOmitParameterTypes;
import org.example.booking.dto.Room;
import org.example.booking.query.api.ReadRegistry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("cqrs booking: Book a free room")
@DisplayNameGeneration(ReplaceUnderscoresAndOmitParameterTypes.class)
public class BookARoomTest {

    private final Collection<Room> initialRooms = Arrays.asList(
            new Room("LUNA", true),
            new Room("MAGIC", false)
    );
    @Test
    public void should_return_notfound_error_when_no_free_room_in_location_catalog(){
        ReadRegistry readRegistry = new ReadRegistry(initialRooms);
        LocalDate arrivalDate = LocalDate.of(2022,7,28);
        LocalDate departureDate = LocalDate.of(2022,7,31);
        Collection<Room> rooms = readRegistry.freeRooms(arrivalDate, departureDate);
        Assertions.assertThat(rooms).describedAs("return free rooms").isEqualTo(Collections.emptyList());
    }

    @Test
    void should_get_free_rooms_when_finding_rooms_in_location_catalog() {
        ReadRegistry readRegistry = new ReadRegistry(initialRooms);
        LocalDate arrivalDate = LocalDate.of(2022, 8, 2);
        LocalDate departureDate = LocalDate.of(2022, 8, 9);
        Collection<Room> rooms = readRegistry.freeRooms(arrivalDate, departureDate);
        Assertions.assertThat(rooms).describedAs("return free rooms").isEqualTo(initialRooms);
    }
}
