package dat3.booking;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Group group;
    private Room room;

    public Reservation(LocalDateTime startDate, int length, Group group, Room room) throws IllegalArgumentException {
        if (startDate.toLocalTime().isBefore(LocalTime.of(8, 0)) || startDate.toLocalTime().isAfter(LocalTime.of(17, 0)))
            throw new IllegalArgumentException("Start time is not within bounds");
        
        this.startDate = startDate;

        if (length > 120) length = 120;
        else if (length > 90) length = 90;
        else if (length > 60) length = 60;
        else length = 30;

        this.endDate = startDate.plusMinutes(length);

        if (endDate.toLocalTime().isBefore(LocalTime.of(8, 0)) || endDate.toLocalTime().isAfter(LocalTime.of(17, 0)))
            throw new IllegalArgumentException("End time is not within bounds");

        boolean hasOverlap = room.getReservations().stream().filter(reservation -> {
            return reservation.reservationOverlaps(startDate, endDate);
        }).toArray().length > 0;

        if (hasOverlap) throw new IllegalArgumentException("Reservation is overlapping with another");

        this.group = group;
        this.room = room;
    }

    private boolean reservationOverlaps(LocalDateTime startDate, LocalDateTime endDate) {
        // If start date is within start and end for THIS reservation
        if (this.startDate.isBefore(startDate) && this.endDate.isAfter(startDate)) {
            return true;
        }

        // If end date date is within start and end for THIS reservation
        if (this.startDate.isBefore(endDate) && this.endDate.isAfter(endDate)) {
            return true;
        }

        return false;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public Group getGroup() {
        return this.group;
    }
}