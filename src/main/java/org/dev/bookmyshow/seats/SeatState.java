package org.dev.bookmyshow.seats;

public interface SeatState {
    void onRelease(Seat seat);
    void onLock(Seat seat);
    void onBook(Seat seat);
}
