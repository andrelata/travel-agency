package service;

import dao.FlightReservationDAO;
import dao.HashSetFlightReservationDAO;
import dto.FlightReservation;
import model.Reservation;
import service.api.FlightReservationAPI;

import java.util.List;
import java.util.stream.Collectors;

public enum FlightReservationService {

    INSTANCE;

    private FlightReservationDAO flightReservationDAO = HashSetFlightReservationDAO.INSTANCE;
    private FlightReservationAPI flightReservationAPI = FlightReservationAPI.INSTANCE;

    public List<Reservation> getFlightReservation(final String destiny) {
        flightReservationDAO.save(flightReservationAPI.getFlightReservation());
        final List<FlightReservation> flightReservations = flightReservationDAO.findForDestiny(destiny);
        return flightReservations.stream()
                .map(f -> new Reservation(f.getReservationId(), f.getDate()))
                .collect(Collectors.toList());
    }
}
