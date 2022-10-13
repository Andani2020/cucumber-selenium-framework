package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.framework.pageobjects.HomePageObjects;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.MessageFormat;
public class WebActionStepDefs {

    private static final Logger logger = LogManager.getLogger(WebActionStepDefs.class);
    WebDriver  driver;
    HomePageObjects hpo ;


    public WebActionStepDefs() {
        this.driver = null;
    }
    @Given("^the user opens \"([^\"]*)\" browser$")
    public void userOpenBrowser(){

        // creating object of ChromeDriver
         driver = new ChromeDriver();
        // to configure the path of the chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver\n");
    }
    @And("^the user navigates to \"([^\"]*)\" url")
    public void theUserNavigatesToUrl(String url) {
        driver.get(url);
    }

    @And("^the user taps \"([^\"]*)\" page element")
    public void theUserTapsPageElement(String elementName) {
        try{
        hpo.clickWebElement(elementName);
        } catch (Exception e) {
            logger.error(MessageFormat.format("An unexpected exception occurred while attempting to tap web element \"{0}\"", elementName));
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }
    }
    @And("^the user types \"([^\"]*)\" into \"([^\"]*)\" page element")
    public void theUserTypesIntoPageElement(String textContent, String element) {
       try {
           hpo.typeText(textContent, element);
       } catch (Exception e) {
           logger.error(MessageFormat.format("An unexpected exception occurred while attempting to type text into page element\"{0}\"", element));
           logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
           logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
           logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
           e.printStackTrace();
       }
    }
    @And("^the user verifies that the text content of attribute of \"([^\"]*)\" page element \"([^\"]*)\" \"([^\"]*)\"$")
    public void theUserVerifiesThatTheTextContentOfAttributeOfPageElement(String element, String action, String expectedValue) {
        try{
        assertThat(hpo.verifyWebElementAttribute(element,action,expectedValue)).isTrue();
        } catch (Exception e) {
            logger.error(MessageFormat.format("An unexpected exception occurred while attempting to verify the attributes of page element\"{0}\"", element));
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }

    }
}
