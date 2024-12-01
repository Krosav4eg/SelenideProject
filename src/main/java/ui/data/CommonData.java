package ui.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonData {

    NOTE_BOOK_BRAND("ASUS"),
    SEARCH_WORLD("LAPTOP");

    private final String data;
}