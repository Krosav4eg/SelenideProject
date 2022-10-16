package data;

public enum CommonData {

    NOTE_BOOK_PAGE_TITLE("Ноутбуки - ROZETKA | Купити ноутбук в Києві: ціна, відгуки, продаж, вибір ноутбуків в Україні"),
    SEARCH_WORLD("Ноутбук");

    private final String data;

    CommonData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}