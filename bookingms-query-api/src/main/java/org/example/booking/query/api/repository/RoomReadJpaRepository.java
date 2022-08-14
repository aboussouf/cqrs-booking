package org.example.booking.query.api.repository;

import org.example.booking.query.api.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface RoomReadJpaRepository extends PagingAndSortingRepository<Room, Integer> {

    @Query("SELECT room FROM Room room WHERE room not in ( SELECT bookedRoom FROM Booking book JOIN book.room bookedRoom, Room room "+
    "WHERE ?1 beetween book.arrivalDate and book.departureDate OR ?2 between book.arrivalDate and book.departureDate) AND roomPrice BETWEEN ?3 AND ?4 AND room.roomCapacity >= ?5")
    Page<Room> getFreeRooms(Date arrivalDate, Date departureDate, Integer roomMinPrice, Integer roomMaxPrice, Integer roomCapacity, Pageable pageRequest);
}
