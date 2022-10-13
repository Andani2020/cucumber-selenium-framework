package org.selenium.framework.webdrivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;

public class FirefoxDriverManager extends DriverManager{

    private static final Logger logger = LogManager.getLogger(FirefoxDriverManager.class.getName());

    private FirefoxOptions options = new FirefoxOptions();
    private final FirefoxProfile ffp = new FirefoxProfile();;
    private GeckoDriverService firefoxService;


    @Override
    protected void startService() {

    }

    @Override
    protected void stopService() {

    }

    @Override
    protected void createDriver() {

    }

    @Override
    protected void setOptions() {

    }
}
