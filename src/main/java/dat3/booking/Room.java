package dat3.booking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private ArrayList<Reservation> reservations;

    {
        this.reservations = new ArrayList<>();
    }

    public Room(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}