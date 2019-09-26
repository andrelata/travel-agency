package dto;

import java.util.Date;
import java.util.Objects;

public class FlightReservation {

    private Date date;
    private String destination;
    private String reservationId;

    public FlightReservation() {
    }

    public Date getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public String getReservationId() {
        return reservationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightReservation that = (FlightReservation) o;
        return Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, destination, reservationId);
    }
}
