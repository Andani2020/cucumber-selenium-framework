package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageObjects.homePageObjects;

import static org.junit.Assert.assertEquals;

public class WebActionStepDefs {
    WebDriver  driver;
    homePageObjects hpo ;

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

    @And("the user navigates to \"([^\"]*)\" url")
    public void theUserNavigatesToUrl(String url) {
        driver.get(url);
    }

    @And("the user taps \"([^\"]*)\" page element")
    public void theUserTapsPageElement(String elementName) {
        hpo.clickWebElement(elementName);
        
    }

    @And("the user types \"([^\"]*)\" into \"([^\"]*)\" page element")
    public void theUserTypesIntoPageElement(String textContent, String element) {

        hpo.typeText(textContent,element);
    }

    @And("the user verifies that the text content of attribute of \"([^\"]*)\" page element \"([^\"]*)\" \"([^\"]*)\"$")
    public void theUserVerifiesThatTheTextContentOfAttributeOfPageElement(String element, String action, String expectedValue) {
       hpo.verifyWebElementAttribute(element,action,expectedValue);


    }
}
