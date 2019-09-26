package router;

import controller.DestinyInfoController;
import exception.TravelAgencyApiException;
import io.restassured.response.Response;
import model.ApiError;
import model.DestinyResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import spark.Request;
import spark.utils.IOUtils;
import utils.GsonWrapper;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.net.ssl.*"})
public class DestinyInfoRoute {

    @Before
    public void setup() {
        Mockito.reset();
    }

    @Test
    public void travelAgencyInfo_withoutDestiny_invalidParam() {
        final Response response = get("http://localhost/travel_agency/info");

        final ApiError responseBody = GsonWrapper.GSON
                .fromJson(response.prettyPrint(), ApiError.class);

        assertThat(response.getStatusCode(), is(404));
        assertThat(responseBody.getError(), is("invalid_param"));
        assertThat(responseBody.getMessage(), is("destiny is required."));
        assertThat(responseBody.getStatus(), is(404));
    }

    @Test
    @PrepareForTest({DestinyInfoController.class})
    public void travelAgencyInfo_withDestiny_isOk() {
        try {
            final DestinyInfoController mockInstance = mock(DestinyInfoController.class);
            Whitebox.setInternalState(DestinyInfoController.class, "INSTANCE", mockInstance);
            final DestinyResponse destinyResponse = GsonWrapper.GSON
                    .fromJson(IOUtils.toString(getClass().getResourceAsStream("/destinyResponse/200.json")), DestinyResponse.class);
            when(mockInstance.getInfo(any(Request.class), any(spark.Response.class))).thenReturn(destinyResponse);
            final Response response = get("http://localhost/travel_agency/info?destiny=china");

            assertThat(response.getStatusCode(), is(200));

        } catch (TravelAgencyApiException | IOException e) {
            fail("Should not have thrown any exception");
        }
    }
}
