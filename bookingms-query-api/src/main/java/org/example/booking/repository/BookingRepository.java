package org.example.booking.repository;

import org.example.booking.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends PagingAndSortingRepository<Booking, Integer> {

    @Query("SELECT booking FROM Booking booking WHERE booking.arrivalDate >= ?1 AND booking.departureDate <= ?2")
    Page<Booking> findBookingsBetween(Date arrivalDate, Date departureDate, Pageable pageRequest);

    @Query("SELECT booking FROM Booking booking JOIN booking.room bookedRoom WHERE bookedRoom.id = ?1 AND booking.departureDate >= ?2 AND booking.departureDate <= ?3")
    List<Booking> findBookingsByRoomIdBetween(Integer roomId, Date arrivalDate, Date departureDate);


}
