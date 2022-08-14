package org.example.booking.query.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.booking.query.api.model.Room;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class RoomResponse extends BaseResponse {
    private List<Room> rooms;

    public RoomResponse(String message, List<Room> rooms) {
        super(message);
        this.rooms = rooms;
    }
}
