package org.selenium.framework.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.text.MessageFormat;


public class HomePageObjects {

     static final Logger logger = LogManager.getLogger(HomePageObjects.class.getName());

     WebDriver driver;
     Wait<WebDriver> wait;
     int timeOut;

     public HomePageObjects(){
          this.driver = null;
          this.wait =null;


     }
     By searchTextbox = By.xpath("//input[@id='js-site-search-input']");
     By searchButton = By.xpath("//button[@class='js_search_button search-component__btn-search']");
     By ramaWebElement =By.xpath("//a[contains(@href,'Rama-37%25-Fat-Spread-1kg/p/10370401EA')]");
     By productName =By.xpath("//h1[@class='pdp__name']");
     By productPrice = By.xpath("//div[@class='special-price__price']");



     public WebElement getWebElement(String elementName){

          return switch (elementName.toLowerCase()) {
               case "search_text_box" ->
                       this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextbox));
               case "search_button" ->
                       this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
               case "rama_product" -> this.wait.until(ExpectedConditions.visibilityOfElementLocated(ramaWebElement));
               case "product_name" ->
                       this.wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
               case "product_price" ->
                       this.wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
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
