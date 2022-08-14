package org.example.booking.query.api.dto;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class BookingResponse extends BaseResponse{

    private UUID id;

    @Builder
    public BookingResponse(UUID id, String message) {
        super(message);
        this.id = id;
    }
}
