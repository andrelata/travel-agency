package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private List<Venue> venues;

    public Response() {
    }

    public List<Venue> getVenues() {
        return venues;
    }
}
