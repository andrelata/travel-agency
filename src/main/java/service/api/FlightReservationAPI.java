package service.api;

import dto.FlightReservation;

import javax.ws.rs.core.GenericType;
import java.util.List;

public enum FlightReservationAPI {

    INSTANCE;

    private static final String URI = "https://brubank-flights.herokuapp.com/flight-reservations";

    public List<FlightReservation> getFlightReservation() {
        return RestClient.INSTANCE.get(URI)
                .readEntity(new GenericType<List<FlightReservation>>() {
                });
    }
}
