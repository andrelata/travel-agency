package model;

import java.util.Date;

public final class Reservation {

    private String id;
    private Date date;

    public Reservation(final String id, final Date date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}
