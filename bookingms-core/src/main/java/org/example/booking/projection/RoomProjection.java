package org.example.booking.projection;

import org.example.booking.model.Booking;
import org.example.booking.model.RoomBooking;
import org.example.booking.query.BookingByTypeQuery;
import org.example.booking.repository.RoomReadRepository;

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
