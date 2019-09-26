package utils;

import com.google.gson.reflect.TypeToken;
import dto.FlightReservation;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public final class TestHelper {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

    public static final Type FLIGHT_RESERVATION_LIST_TYPE = new TypeToken<ArrayList<FlightReservation>>() {
    }.getType();

}
