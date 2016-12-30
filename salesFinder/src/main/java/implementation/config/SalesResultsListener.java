package implementation.config;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class SalesResultsListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("SalesResultListener: onTestFailure");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("SalesResultListener: onTestSuccess");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SalesResultListener: onTestSkipped");
    }

}
