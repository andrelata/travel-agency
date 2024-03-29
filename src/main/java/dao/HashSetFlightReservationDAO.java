package dao;

import dto.FlightReservation;
import spark.utils.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum HashSetFlightReservationDAO implements FlightReservationDAO {

    INSTANCE;

    private final Set<FlightReservation> set;

    HashSetFlightReservationDAO() {
        set = new HashSet<>();
    }

    @Override
    public void save(final List<FlightReservation> flightReservations) {
        set.addAll(flightReservations.stream()
                .filter(f -> !StringUtils.isBlank(f.getReservationId()) &&
                        !StringUtils.isBlank(f.getDestination()) &&
                        f.getDate() != null)
                .collect(Collectors.toList()));
    }

    @Override
    public List<FlightReservation> findForDestiny(final String destiny) {
        return set.stream()
                .filter(f -> f.getDestination() != null &&
                        (destiny.equalsIgnoreCase(f.getDestination()) || f.getDestination().toLowerCase().contains(destiny)))
                .collect(Collectors.toList());
    }
}
