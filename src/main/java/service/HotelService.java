package service;

import model.Hotel;
import dto.HotelSearch;
import service.api.HotelAPI;
import spark.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public enum HotelService {

    INSTANCE;

    private HotelAPI hotelAPI = HotelAPI.INSTANCE;

    public List<Hotel> getHotels(final String destiny) {
        final HotelSearch hotelSearch = hotelAPI.getHotelSearch(destiny);
        return hotelSearch.getResponse().getVenues().stream()
                .filter(v -> !StringUtils.isBlank(v.getName())
                        && v.getLocation() != null && !StringUtils.isBlank(v.getLocation().getAddress()))
                .map(v -> new Hotel(v.getName(), v.getLocation().getAddress()))
                .collect(Collectors.toList());
    }

}
