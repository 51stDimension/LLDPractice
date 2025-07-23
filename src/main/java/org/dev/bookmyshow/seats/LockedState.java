package org.dev.bookmyshow.seats;

public class LockedState implements SeatState{

    @Override
    public void onRelease(Seat seat) {
        seat.setSeatState(new ReleasedState());
    }

    @Override
    public void onLock(Seat seat) {
        throw new IllegalStateException("Seat already locked.");
    }

    @Override
    public void onBook(Seat seat) {

    }
}
