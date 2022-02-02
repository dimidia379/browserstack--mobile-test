package helpers;

import config.RunConfig;

import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import drivers.RealMobileDriver;
import drivers.SelenoidMobileDriver;
import org.aeonbits.owner.ConfigFactory;

public class RunHelper {
    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        switch (config.deviceHost()) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "local":
                return LocalMobileDriver.class;
            case "real":
                return RealMobileDriver.class;
            case "selenoid":
                return SelenoidMobileDriver.class;
            default:
                throw new RuntimeException("Incorrect device host");
        }
    }
}
