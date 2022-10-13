package org.selenium.framework.webdrivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{


    private static final Logger logger = LogManager.getLogger(ChromeDriverManager.class.getName());
    //private final SystemProperties se;
    ChromeOptions options;
    private ChromeDriverService chromeService;

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
