package dao;

import dto.FlightReservation;
import org.junit.Before;
import org.junit.Test;
import spark.utils.IOUtils;

import java.io.IOException;

import java.util.List;

import utils.GsonWrapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static utils.TestHelper.FLIGHT_RESERVATION_LIST_TYPE;

public class HashSetFlightReservationDAOTest {

    private FlightReservationDAO flightReservationDAO;

    @Before
    public void setup() {
        flightReservationDAO = HashSetFlightReservationDAO.INSTANCE;
    }

    @Test
    public void findForDestiny_checkNotRepeated_isOk() throws IOException {
        final List<FlightReservation> flightReservationsList = GsonWrapper.GSON
                .fromJson(IOUtils.toString(getClass().getResourceAsStream("/flightReservation/200_responseWithRepeated.json")), FLIGHT_RESERVATION_LIST_TYPE);

        flightReservationDAO.save(flightReservationsList);
        final List<FlightReservation> flightReservationsResult = flightReservationDAO.findForDestiny("china");

        assertThat(flightReservationsResult, hasSize(2));
    }

    @Test
    public void findForDestiny_ignoreInvalidReservation_isOk() throws IOException {
        final List<FlightReservation> flightReservationsList = GsonWrapper.GSON
                .fromJson(IOUtils.toString(getClass().getResourceAsStream("/flightReservation/200_otherResponse.json")), FLIGHT_RESERVATION_LIST_TYPE);

        flightReservationDAO.save(flightReservationsList);
        final List<FlightReservation> flightReservationsResult = flightReservationDAO.findForDestiny("india");

        assertThat(flightReservationsResult, hasSize(1));
    }
}