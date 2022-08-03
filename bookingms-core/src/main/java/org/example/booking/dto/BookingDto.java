package org.example.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.booking.model.Booking;

public class BookingDto {
    private Integer bookingId;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String arrivalDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String departureDate;
    private String clientId;
    private Integer roomId;
    private String roomName;
    private Integer roomPrice;

    public BookingDto(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.arrivalDate = booking.getArrivalDate();
        this.departureDate = booking.getDepartureDate();
        this.clientId = booking.getClientId();
        if(booking.getRoom() !=null) {
            this.roomId = booking.getRoom().getRoomId();
            this.roomName = booking.getRoom().getRoomName();
            this.roomPrice = booking.getRoom().getRoomPrice();
        }
    }
}
