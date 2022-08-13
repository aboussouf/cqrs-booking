package org.example.booking.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
public class RoomBooking {
    private Map<String, Set<Booking>> bookingByType = new HashMap<>();
}
