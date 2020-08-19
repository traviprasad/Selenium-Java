package managers;

import enums.DriverType;
import enums.EnvironmentType;
import helpers.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import java.io.IOException;
import java.net.URL;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    public ITestContext iTestContext;

    public DriverManager() throws IOException {
        driverType = ConfigFileReader.getBrowserType();
        environmentType = ConfigFileReader.getEnvironmentType();
    }

    public WebDriver getDriver() throws IOException {
        if (driver.get() == null)
            createDriver();
        return driver.get();
    }

    private void createDriver() throws IOException {
        switch (environmentType) {
            case LOCAL:
                createLocalDriver();
                break;
            case GRID:
                createGridDriver(iTestContext);
                break;
        }
    }

    private void createLocalDriver() throws IOException {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                chromeOptions.addArguments("--no-sandbox");
                driver.set(new ChromeDriver(chromeOptions));
//                driver.get().manage().window().maximize();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver.set(new FirefoxDriver(firefoxOptions));
                driver.get().manage().window().maximize();
                break;
        }
    }

    private void createGridDriver(ITestContext cxt) throws IOException {
        switch (driverType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                driver.set(new RemoteWebDriver(new URL(buildHubURL()), chromeOptions));
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                driver.set(new RemoteWebDriver(new URL(buildHubURL()), firefoxOptions));
                break;
        }
    }

    private String buildHubURL() throws IOException {
        String host = ConfigFileReader.getHubHost();
        String hostPort = ConfigFileReader.getHostPort();
        return "http://" + host + ":" + hostPort + "/wd/hub"; //http://localhost:4444/wd/hub
    }

    public void quit() {
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.quit();
            driver.set(null);
        }
    }
}
