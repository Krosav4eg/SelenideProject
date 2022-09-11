import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.Arrays;

import static browserfactory.BrowserFactory.getDriver;


public class AllureListener implements ITestListener {


    @Attachment
    public byte[] saveFailureScreen() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        setTestStatus(iTestResult);

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        setTestStatus(iTestResult);
        saveFailureScreen();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        setTestStatus(iTestResult);

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    private synchronized void setTestStatus(ITestResult testResult) {
        findTestMethod(testResult);
    }

    @SneakyThrows
    private Method findTestMethod(ITestResult testResult) {
        String testMethodName = testResult.getMethod().getMethodName();
        Method[] methods = testResult.getMethod().getRealClass().getMethods();
        return Arrays.stream(methods).
                filter(method -> method.getName().equals(testMethodName))
                .findFirst()
                .orElseThrow(() -> new NoSuchMethodException("No such method: " + testMethodName));
    }
}