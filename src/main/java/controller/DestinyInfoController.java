package controller;

import exception.TravelAgencyApiException;
import model.DestinyResponse;

import service.DestinyService;
import spark.Request;
import spark.Response;
import spark.utils.StringUtils;

public enum DestinyInfoController {

    INSTANCE;

    public DestinyResponse getInfo(final Request destinyInfoRequest, final Response response)
            throws TravelAgencyApiException {
        return DestinyService.INSTANCE.getDestinyInfo(getDestiny(destinyInfoRequest));
    }

    private String getDestiny(final Request destinyInfoRequest) throws TravelAgencyApiException {
        final String destiny = destinyInfoRequest.queryParams("destiny");
        if (StringUtils.isBlank(destiny)) {
                throw new TravelAgencyApiException("invalid_param", "destiny is required.", 404);
        }
        return destiny.toLowerCase();
    }
}
