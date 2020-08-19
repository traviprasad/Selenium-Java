package helpers;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    static Properties properties;

    static {
        try {
            properties = loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties loadProperties() throws IOException, FileNotFoundException {

        InputStream inputstream;
        String configFilePath = "config/configuration.properties"; //Mac

        // The below logic gets the file from src/test/resources/config/configuration.properties.
        inputstream = ConfigFileReader.class.getClassLoader().getResourceAsStream(configFilePath);

        properties = new Properties();
        try {
            properties.load(inputstream);
            inputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static EnvironmentType getEnvironmentType() {
        String envType;
        if(System.getProperty("ENVIRONMENT")!=null) envType = System.getProperty("ENVIRONMENT");
        else envType = properties.getProperty("environment");
        if (envType == null || envType.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if (envType.equalsIgnoreCase("grid")) return EnvironmentType.GRID;
        else
            throw new RuntimeException("Environment Name Key value in Configuration.properties is not matched : " + envType);
    }

    public static DriverType getBrowserType() {
        String browserName;
        if(System.getProperty("BROWSER")!=null) browserName = System.getProperty("BROWSER");
        else browserName = properties.getProperty("browserType");
        if (browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public static String getHubHost() {
        String hubHost;
        if(System.getProperty("HUB_HOST")!=null) hubHost = System.getProperty("HUB_HOST");
        else hubHost = properties.getProperty("HUB_HOST");
        if (hubHost == null ) return "localhost";
        if (hubHost != null ) return hubHost;
        else
            throw new RuntimeException("Hub Host value in Configuration.properties is missing or incorrect : " + hubHost);
    }

    public static String getHostPort() {
        String hostPort = properties.getProperty("hostPort");
        if (hostPort == null ) return "4444";
        if (hostPort != null ) return hostPort;
        else
            throw new RuntimeException("Host Port value in Configuration.properties is missing or incorrect : " + hostPort);
    }

    public static String getHomePageURL() {
        return properties.getProperty("homePageURL");
    }
}
