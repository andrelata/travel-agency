package controller;

import exception.TravelAgencyApiException;
import model.DestinyResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import service.DestinyService;
import spark.Request;
import spark.Response;
import spark.utils.IOUtils;
import utils.GsonWrapper;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.net.ssl.*"})
public class DestinyInfoControllerTest {

    @Before
    public void setup() {
        Mockito.reset();
    }

    @Test
    @PrepareForTest({DestinyService.class})
    public void getInfo_withValidDestiny_isOk() throws IOException {
        try {
            final DestinyService mockInstance = mock(DestinyService.class);
            Whitebox.setInternalState(DestinyService.class, "INSTANCE", mockInstance);
            final DestinyResponse mockDestinyResponse = GsonWrapper.GSON
                    .fromJson(IOUtils.toString(getClass().getResourceAsStream("/destinyResponse/200.json")), DestinyResponse.class);
            final String destiny = "buenos aires";
            when(mockInstance.getDestinyInfo(destiny)).thenReturn(mockDestinyResponse);
            Request request = mock(Request.class);
            when(request.queryParams("destiny")).thenReturn(destiny);
            Response response = mock(Response.class);

            DestinyResponse destinyResponse = DestinyInfoController.INSTANCE.getInfo(request, response);

            assertThat(destinyResponse, is(mockDestinyResponse));

        } catch (TravelAgencyApiException e) {
            fail("Should not have thrown any exception");
        }


    }

}