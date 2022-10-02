package org.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.security.PublicKey;
import java.text.MessageFormat;
import java.util.Locale;


public class homePageObjects {

     static final Logger logger = LogManager.getLogger(homePageObjects.class.getName());

     WebDriver driver;
     Wait<WebDriver> wait;
     int timeOut;

     public homePageObjects(){
          this.driver = null;
          this.wait =null;


     }

     By storeLocatorDropDown = By.xpath("//i[@class='shoprite-icon-dropdown-arrow']");
     By searchStoreText = By.xpath("//input[@id='storeFinderInput']");
     By firstStore = By.xpath("//a[@class='title js-view-store-details-btn']");
     By storePAnelHeader = By.xpath("//div[@class='panel-header']");
     By mondayTradingHours = By.xpath("//table/tbody/tr[@class='trading-hours-Mon']");


     public WebElement getWebElement(String elementName){

          return switch (elementName.toLowerCase()) {
               case "store_locator_drop_down" ->
                       this.wait.until(ExpectedConditions.visibilityOfElementLocated(storeLocatorDropDown));
               case "search_store_text" ->
                       this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchStoreText));
               case "first_store" -> this.wait.until(ExpectedConditions.visibilityOfElementLocated(firstStore));
               case "store_panel_header" ->
                       this.wait.until(ExpectedConditions.visibilityOfElementLocated(storePAnelHeader));
               case "monday_trading_hours" ->
                       this.wait.until(ExpectedConditions.visibilityOfElementLocated(mondayTradingHours));
               default -> null;
          };
     }


     public void clickWebElement(String elementName){

          WebElement webElement = this.getWebElement(elementName);
          assert webElement != null;
          webElement.click();

     }

     public void typeText(String elementName,String textContent){

          WebElement webElement = this.getWebElement(elementName);
          assert webElement != null;
          webElement.sendKeys(textContent);

     }
     public boolean verifyWebElementAttribute(String attributeName,String action,String expectedValue){

          WebElement element = this.getWebElement(attributeName);
          String actualValue = element.getText().trim();
          logger.debug("Actual value = "+ actualValue);
          logger.debug("Expected value = "+ expectedValue);

          if(action.equals("contains")){
               return actualValue.contains(expectedValue.trim());
          } else if (action.equals("is_equal_to")) {
               return actualValue.equals(expectedValue);
          }else {

               logger.error(MessageFormat.format("Comparison type {0} is unsupported",action));
          }
          return false;
     }




}
