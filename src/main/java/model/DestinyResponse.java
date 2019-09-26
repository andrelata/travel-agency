package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DestinyResponse {

    private List<Reservation> reservations = new ArrayList<>();
    private List<Hotel> hotels = new ArrayList<>();

    /**
     * Add a list of reservations
     * @param reservations reservations
     */
    public void addReservations(final List<Reservation> reservations) {
        reservations.sort(Comparator.comparing(Reservation::getDate));
        this.reservations.addAll(reservations);
    }

    /**
     * Add a list of hotels
     * @param hotels hotels
     */
    public void addHotels(final List<Hotel> hotels) {
        this.hotels.addAll(hotels);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

}
