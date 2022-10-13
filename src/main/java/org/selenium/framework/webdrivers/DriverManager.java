package org.selenium.framework.webdrivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {


    private static final Logger LOGGER = LogManager.getLogger(DriverManager.class.getName());

    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();
    protected abstract void setOptions();

    public void quitDriver(){

        LOGGER.debug("Quiting driver +" +driver.toString());
        if (null !=driver){

            driver.quit();
            LOGGER.debug("stopping driver service" +driver.toString());
            stopService();
            driver = null;

        }
    }

    public WebDriver getDriver() {

        if (null==driver) {
            startService();
            createDriver();
        }
        LOGGER.debug("Launched driver + " + driver.toString());
        return driver;
    }
}
