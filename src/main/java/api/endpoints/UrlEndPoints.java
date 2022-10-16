package api.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UrlEndPoints {

    CREATE_BOOKING("/booking"),
    UPDATE_BOOKING("/booking/");

    private final String data;
}