package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public enum GsonWrapper {

    ;

    public static final Gson GSON;

    static {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        GSON = gsonBuilder.create();
    }

}
