package org.example.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.booking.model.Room;
import org.example.booking.model.RoomStatus;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Integer roomId;

    private RoomStatus roomStatus;

    private Integer roomCapacity;

    private Integer roomPrice;

    public RoomDto(Room room) {
        this.roomId = room.getRoomId();
        this.roomStatus = room.getRoomStatus();
        this.roomCapacity = room.getRoomCapacity();
        this.roomPrice = room.getRoomPrice();
    }
}
