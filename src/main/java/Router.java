import controller.DestinyInfoController;
import exception.TravelAgencyApiException;
import model.ApiError;
import spark.Spark;
import spark.servlet.SparkApplication;

import static spark.Spark.*;
import static utils.GsonWrapper.GSON;

public class Router implements SparkApplication {

    private static final String JSON = "json";

    @Override
    public void init() {

        path("/travel_agency", () -> {
            after("/*", (request, response) -> {
                response.type(JSON);
            });
            get("/info", DestinyInfoController.INSTANCE::getInfo, GSON::toJson);
        });

        Spark.exception(TravelAgencyApiException.class, ((exception, request, response) -> {
            response.status(exception.getStatusCode());
            response.type(JSON);
            response.body(GSON.toJson(exception.toApiError()));
        }));

        Spark.exception(Exception.class, (((exception, request, response) -> {
            response.status(500);
            response.type(JSON);
            response.body(GSON.toJson(new ApiError("internal error", "internal_error", 500)));
        })));
    }

}
