package utils;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/**
 * RetryAnalyzer class is implementing Interface IRetryAnalyzer to be able to have a chance to retry a failed test.
 */
@Log4j2
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    /**
     * Returns true if the test method has to be retried, false otherwise.
     *
     * @param result – The result of the test method that just ran
     * @return true if the test method has to be retried, false otherwise
     */

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            log.error("Test " + result.getMethod().getMethodName() + " has been failed. Rerunning once more");
            retryCount++;
            return true;
        }
        return false;
    }
}