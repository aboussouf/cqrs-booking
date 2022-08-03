package org.example.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.booking.model.Room;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Integer roomId;

    private String roomName;

    private Integer roomCapacity;

    private Integer roomPrice;

    public RoomDto(Room room) {
        this.roomId = room.getRoomId();
        this.roomName = room.getRoomName();
        this.roomCapacity = room.getRoomCapacity();
        this.roomPrice = room.getRoomPrice();
    }
}
