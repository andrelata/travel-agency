package model;

import org.junit.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static utils.TestHelper.FORMATTER;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class DestinyResponseTest {

    @Test
    public void addReservations_orderByDate_isOk() {

        try {
            List<Reservation> reservations = Arrays.asList(
                    new Reservation("5d838ba6-1015-4dd0-86aa-29a50ce636a7", FORMATTER.parse("2019-11-28T11:28:23.602288")),
                    new Reservation("c19d7788-c3ff-4048-a55b-0a83464058aa", FORMATTER.parse("2019-11-07T20:49:46.602344")),
                    new Reservation("cccdaf8d-20c5-4ebf-a57f-6297ca85f3a0", FORMATTER.parse("2019-10-27T11:38:50.602449"))
            );

            final DestinyResponse destinyResponse = new DestinyResponse();
            destinyResponse.addReservations(reservations);

            final List<Reservation> reservationList = destinyResponse.getReservations();
            assertThat(reservationList.size(), is(3));
            assertThat(reservationList.get(0).getId(), is("cccdaf8d-20c5-4ebf-a57f-6297ca85f3a0"));
            assertThat(reservationList.get(1).getId(), is("c19d7788-c3ff-4048-a55b-0a83464058aa"));
            assertThat(reservationList.get(2).getId(), is("5d838ba6-1015-4dd0-86aa-29a50ce636a7"));
        } catch (ParseException e) {
            fail("Should not have thrown any exception");
        }
    }

}