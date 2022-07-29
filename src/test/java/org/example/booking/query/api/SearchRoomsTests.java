package org.example.booking.query.api;

import org.example.booking.ReplaceUnderscoresAndOmitParameterTypes;
import org.example.booking.dto.Room;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@DisplayName("cqrs booking")
@DisplayNameGeneration(ReplaceUnderscoresAndOmitParameterTypes.class)
public class SearchRoomsTests {

    private final Collection<Room> initialRooms = Arrays.asList(
            new Room("LUNA"),
            new Room("MAGIC")
    );
    private Collection<Room> freeRooms(LocalDate arrivalDate, LocalDate departureDate) {
        if((LocalDate.of(2022,8,1)).isBefore(departureDate)) {
            return initialRooms;
        } else {
            return null;
        }
    }

    @Test
    public void should_find_no_room_when_searching_an_empty_location_catalog(){
        assertThat(freeRooms(LocalDate.of(2022,7,28),LocalDate.of(2022,7,31))).describedAs("return free rooms").isEqualTo(Collections.emptyList());
    }



}
