package dao;

import dto.FlightReservation;

import java.util.List;

public interface FlightReservationDAO {

    void save(final List<FlightReservation> flightReservations);

    List<FlightReservation> findForDestiny(final String destiny);
}
