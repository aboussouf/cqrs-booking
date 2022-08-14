package org.example.booking.query.api.projection;

import org.example.booking.query.api.model.Booking;
import org.example.booking.query.api.model.RoomBooking;
import org.example.booking.query.api.query.BookingByTypeQuery;
import org.example.booking.query.api.repository.RoomReadRepository;

import java.util.Set;

public class RoomProjection {
    private RoomReadRepository roomReadRepository;
    public RoomProjection(RoomReadRepository roomReadRepository) {
        this.roomReadRepository=roomReadRepository;
    }

    public Set<Booking> handle(BookingByTypeQuery query) throws Exception {
        RoomBooking roomBooking = roomReadRepository.getRoomBooking(query.getRoomId());
        if (roomBooking == null)
            throw new Exception("Room does not exist.");
        return roomBooking.getBookingByType()
                .get(query.getBookingType());
    }
}
