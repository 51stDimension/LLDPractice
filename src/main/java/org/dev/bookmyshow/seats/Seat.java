package org.dev.bookmyshow.seats;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seat {
    private SeatState seatState;
}
