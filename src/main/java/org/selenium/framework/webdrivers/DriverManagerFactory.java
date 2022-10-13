package org.selenium.framework.webdrivers;

import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {


    DriverManager driverManager;
    String webDriver;

    public DriverManagerFactory(){
        this.driverManager = null;
    }

    public DriverManagerFactory(String webDriverType) {
        this();
        this.webDriver = webDriverType;
    }

    private void setManager(DriverType type) {
        switch (type) {
            case CHROME:
                this.driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                this.driverManager = new FirefoxDriverManager();
                break;
            default:

        }
    }

    public WebDriver getDriver() {
        switch (this.webDriver.toLowerCase().trim()){
            case "firefox":
                this.setManager(DriverType.FIREFOX);
                break;
            case "opera":
                this.setManager(DriverType.OPERA);
                break;
            case "edge":
                this.setManager(DriverType.EDGE);
                break;
            case "chrome":
                this.setManager(DriverType.CHROME);
                break;

            default:
                this.driverManager = null;
        }
        assert this.driverManager != null;
        return this.driverManager.getDriver();
    }

    public void quitDriver() {
        this.driverManager.quitDriver();
    }
}



