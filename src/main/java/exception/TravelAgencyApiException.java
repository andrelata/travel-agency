package exception;

import model.ApiError;

public class TravelAgencyApiException extends Exception {

    private final String code;
    private final String description;
    private final int statusCode;

    public TravelAgencyApiException(final String code, final String description, final int statusCode) {
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ApiError toApiError() {
        return new ApiError(description, code, statusCode);
    }
}
