package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String address;

    public Location() {
    }

    public String getAddress() {
        return address;
    }
}
