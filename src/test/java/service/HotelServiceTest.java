package service;

import dto.HotelSearch;
import model.Hotel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import service.api.HotelAPI;
import spark.utils.IOUtils;
import utils.GsonWrapper;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.net.ssl.*"})
public class HotelServiceTest {

    @Before
    public void setup() {
        Mockito.reset();
    }

    @Test
    @PrepareForTest({HotelAPI.class})
    public void getHotels_ignoreInvalidHotel_isOk() throws IOException {
        final HotelAPI mockInstance = mock(HotelAPI.class);
        Whitebox.setInternalState(HotelAPI.class, "INSTANCE", mockInstance);
        final HotelSearch mockHotelSearch = GsonWrapper.GSON
                .fromJson(IOUtils.toString(getClass().getResourceAsStream("/hotelSearch/200_invalidHotel.json")), HotelSearch.class);
        final String destiny = "uruguay";
        when(mockInstance.getHotelSearch(destiny)).thenReturn(mockHotelSearch);

        final List<Hotel> hotels = HotelService.INSTANCE.getHotels(destiny);

        assertThat(hotels, hasSize(4));

    }
}
