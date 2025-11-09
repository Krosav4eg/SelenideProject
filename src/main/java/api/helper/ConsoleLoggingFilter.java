package api.helper;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConsoleLoggingFilter implements Filter {
    private static final ThreadLocal<Boolean> active = ThreadLocal.withInitial(() -> false);
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        // защищаемся от двойного вызова (RestAssured иногда вызывает фильтр повторно)
        if (active.get()) {
            return ctx.next(requestSpec, responseSpec);
        }
        active.set(true);

        try {
            log.info(GREEN + "*******************************API REQUEST*****************************************" + RESET);
            String requestBody = requestSpec.getBody() != null ? requestSpec.getBody().toString() : "(empty)";
            log.info("\n=== [REQUEST] ===\n{} {}\nHeaders: {}\nBody: {}\n",
                    requestSpec.getMethod(),
                    requestSpec.getURI(),
                    requestSpec.getHeaders(),
                    prettyJson(requestBody));

            log.info(YELLOW + "*******************************API RESPONSE****************************************" + RESET);

            Response response = ctx.next(requestSpec, responseSpec);

            log.info("\n=== [RESPONSE] ===\nStatus Code: {}\nBody:\n{}\n",
                    response.getStatusCode(),
                    prettyJson(response.getBody().asString()));

            return response;
        } finally {
            active.set(false);
        }
    }

    // Метод для "красивого" форматирования JSON
    private String prettyJson(String json) {
        try {
            if (json == null || json.isEmpty()) return "(empty)";
            // Используем Gson для форматирования
            com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
            com.google.gson.JsonElement el = parser.parse(json);
            return new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(el);
        } catch (Exception e) {
            // Если не JSON — выводим как есть
            return json;
        }
    }
}