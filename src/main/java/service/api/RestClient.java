package service.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public enum RestClient {

    INSTANCE;

    private Client client = ClientBuilder.newClient();

    //TODO catchear las excepciones y tirar una exception controlada
    public Response get(final String uri) {
        return client
                .target(uri)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }
}
