package model;

public final class ApiError {

    private final String message;
    private final String error;
    private final int status;

    public ApiError(final String message, final String error, final int status) {
        this.message = message;
        this.error = error;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
