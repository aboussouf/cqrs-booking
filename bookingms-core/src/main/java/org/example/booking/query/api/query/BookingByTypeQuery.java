package org.example.booking.query.api.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingByTypeQuery {
    private String roomId;
    private String bookingType;
}
