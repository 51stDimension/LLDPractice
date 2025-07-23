package org.dev.bookmyshow;

import java.util.List;

public abstract class SeatBookingFlow {

    private final PaymentGateway paymentGateway;
    private final SeatLockManager seatLockManager;

    public SeatBookingFlow(PaymentGateway paymentGateway, SeatLockManager seatLockManager) {
        this.paymentGateway = paymentGateway;
        this.seatLockManager = seatLockManager;
    }

    public final SeatBookingResponse bookSeat(String userId, String showId, List<String> seatIds) {
        try {
            validateInput(userId, showId, seatIds);

            lockSeats(userId, showId, seatIds);

            int totalCost = calculateCost(seatIds);

            collectPayment(userId, totalCost);

            return confirmBooking(userId, showId, seatIds, totalCost);

        } catch (BookingException e) {
            handleFailure(userId, showId, seatIds, e);
            throw e;
        }
    }

    protected void validateInput(String userId, String showId, List<String> seatIds) {

    }

    protected void lockSeats(String userId, String showId, List<String> seatIds) {

    }

    protected abstract int calculateCost(List<String> seatIds);

    protected abstract void collectPayment(String userId, int amount);

    protected abstract SeatBookingResponse confirmBooking(String userId, String showId, List<String> seatIds, int totalCost);

    protected void handleFailure(String userId, String showId, List<String> seatIds, BookingException e) {
        for (String seatId : seatIds) {
            seatLockManager.releaseSeat(showId, seatId, userId);
        }
    }
}
