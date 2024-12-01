package api.service;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;


/**
 * Base class for working with specific json documents
 */
public abstract class BaseJsonBuilder<SELF extends BaseJsonBuilder<SELF>> {

    private final DocumentContext document;
    private final Configuration configuration= getConfiguration();

    protected BaseJsonBuilder(String jsonText) {
        this.document = JsonPath.using(configuration).parse(jsonText);
    }

    @SneakyThrows
    protected BaseJsonBuilder(File file) {
        String jsonText = FileUtils.readFileToString(file, Charset.defaultCharset());
        this.document = JsonPath.using(configuration).parse(jsonText);
    }

    private static Configuration getConfiguration() {
        return Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
    }

    /**
     * Modify value of existing field in json
     *
     * @param path  jsonPath to the field
     * @param value new value for the field
     */
    public SELF modifyValue(String path, Object value) {
        document.set(path, value);
        return self();
    }

    /**
     * Add value of existing field in json
     *
     * @param path  jsonPath to the field
     * @param value new value for the field
     */
    public SELF addValue(String path, Object value) {
        document.add(path, value);
        return self();
    }

    /**
     * Delete a field in json
     *
     * @param path jsonPath for the field
     */
    public SELF deleteField(String path) {
        document.delete(path);
        return self();
    }

    @SuppressWarnings("unchecked")
    private SELF self() {
        return (SELF) this;
    }

    /**
     * Converts json document to String
     *
     * @return json as String
     */
    @Override
    public String toString() {
        return document.jsonString();
    }
}