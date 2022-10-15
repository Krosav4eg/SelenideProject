package api.service;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Option;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.io.IOException;


/**
 * This class contains basic methods/helpers
 * for example: identifying properties information,
 * setting allure environment, modifying json file value.
 */

@Log4j2
public class BaseService {

	/**
	 * A method required for modifying string value of field json file.
	 *
	 * @param filePath json file path
	 * @param jsonObjPath path to modifying field
	 * @param value new value for json field
	 *
	 * @return Json file in string format with changed value for specific field
	 */
	protected static synchronized String modifyJsonFileValue(String filePath, String jsonObjPath, Object value) {
		return createBaseLogicForModifyingJsonFileValue(filePath).set(jsonObjPath, value).jsonString();
	}

	/**
	 * A method required for modifying any value type of field json file.
	 *
	 * @param filePath json file path
	 * @param jsonObjPath path to modifying field
	 * @param value new value for json field
	 *
	 * @return Json file in string format with changed value for specific field
	 */
	protected static synchronized Object modifyAnyTypeJsonFileValue(String filePath, String jsonObjPath, Object[] value) {
		return createBaseLogicForModifyingJsonFileValue(filePath).set(jsonObjPath, value).jsonString();
	}

	/**
	 * A method required to remove any field from json file.
	 *
	 * @param filePath json file path
	 * @param jsonObjPath path to deletion field
	 *
	 * @return Json file in string format with deleted field
	 */
	protected static synchronized Object deleteJsonFileValue(String filePath, String jsonObjPath) {
		return createBaseLogicForModifyingJsonFileValue(filePath).delete(jsonObjPath).jsonString();
	}

	/**
	 * A method describes base logic for modifying any  json field.
	 *
	 * @param filePath json file path
	 *
	 * @return DocumentContext format
	 */
	private static synchronized DocumentContext createBaseLogicForModifyingJsonFileValue(String filePath) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		DocumentContext documentContext = null;
		try {
			documentContext = com.jayway.jsonpath.JsonPath.using(configuration).parse(new File(filePath));
		}
		catch (IOException e) {
			log.error("****** JSON file " + filePath + " modification failure ******");
			log.error("\n " + ExceptionUtils.getStackTrace(e));
		}
		assert documentContext != null;
		return documentContext;
	}


	/**
	 * A method for generation random number.
	 *
	 * @return random number in integer format.
	 */
	protected static synchronized int getRandomNum() {
		return (int) (Math.random() * 10000);
	}
}