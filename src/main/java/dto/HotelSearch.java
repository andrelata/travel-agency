package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelSearch {

    private Response response;

    public HotelSearch() {
    }

    public Response getResponse() {
        return response;
    }

}


