package service.api;

import dto.HotelSearch;

import javax.ws.rs.core.UriBuilder;

public enum HotelAPI {

    INSTANCE;

    private static final String URI = "https://api.foursquare.com/v2/venues/search";

    private static final String CLIENT_ID = "HACVIHTUOMFKVK5HWQ0J0JCOKQAA2CSAVFS0LFQVN14EESS2";
    private static final String CLIENT_SECRET = "50ITRVSKRB1GH2YWOBBQWZS5BEDVEIWN3Z2YABJEI454V2JZ";

    public HotelSearch getHotelSearch(final String destiny) {
        return RestClient.INSTANCE.get(getUri(destiny))
                .readEntity(HotelSearch.class);
    }

    private String getUri(final String destiny) {
        return UriBuilder.fromUri(URI)
                .queryParam("near", destiny)
                .queryParam("intent", "browse")
                .queryParam("query", "hotel")
                .queryParam("client_id", CLIENT_ID)
                .queryParam("client_secret", CLIENT_SECRET)
                .queryParam("v", "20190709")
                .toString();
    }
}
