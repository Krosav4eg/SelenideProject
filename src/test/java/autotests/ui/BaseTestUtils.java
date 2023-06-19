package autotests.ui;

import com.github.rsheremeta.AllureEnv;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import utils.PropsConfig;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class BaseTestUtils {

    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);

    /**
     * Current method necessary for setting up information about testing environment.
     */

    @Step("Set all detailed information about Environment")
    protected static synchronized void setEnvironmentValuesForAllure() {
        Map<String, String> envData = new HashMap<>();
        envData.put("Browser", PROPS.BASE_BROWSER());
        envData.put("Browser.Version", "111.0, (64 bit)");
        envData.put("Base UI URL", PROPS.BASE_URL());
        envData.put("Base API URL", PROPS.BASE_API_URL());
        AllureEnv.createAllureEnvironmentFile(envData);
        envData.clear();
        log.info("***** Allure environmental data has been gathered successfully *****");
    }
}