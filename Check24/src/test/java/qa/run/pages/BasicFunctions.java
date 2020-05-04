package qa.run.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import qa.run.SerenityProperties;
import net.thucydides.core.annotations.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import org.junit.Test;
import static org.junit.Assert.*;



public class BasicFunctions extends PageObject {
	
    long vorher;
    private WebDriver driver;
	
    @FindBy(css = ".c24-cookie-button")
    private static WebElement cookies_OK;

    
    public WebElement findElementByLabel(String label){    
    WebElement elementByLabel = this.getDriver().findElement(By.xpath("//*[contains(text(),'" + label + "')]"));
    return elementByLabel;
    }
    
    public void acceptCookies(){
    cookies_OK.click();
    }
    
    public void clickLink(String linktext){
    WebElement we = findElementByLabel(linktext);
    we.click();
    }
    
    public void clickRadio(String radiotext){
    WebElement radio =this.getDriver().findElement(By.xpath("//span[contains(text(),'" + radiotext + "')]"));
    radio.click();
    }
    
    public void clickButton(String buttontext){
    WebElement button = this.getDriver().findElement(By.xpath("//button[contains(text(),'" + buttontext + "')]"));
    button.click();
    }
    
    public void enterValue(String value,String fieldlabel){
        
    WebElement we = this.getDriver().findElement(By.xpath("//*[contains(text(),'" + fieldlabel + "')]//following::input[1]"));
    we.sendKeys(value);
    }
    
    //helpers
    
    public void pageIsShown(String expected)  throws Exception{

        String actualTitle = this.getDriver().getTitle();
        String expectedTitle = expected;
        assertEquals(expectedTitle,actualTitle);
        }
    
    
    public void elementIsShown(String label)  throws Exception{
    	WebElement element = this.getDriver().findElement(By.xpath("//*[contains(text(),'" + label + "')]"));
    	element.isDisplayed();

        }
    
    public void scrollUntilElementInView(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 4);
        vorher = new Timestamp(new java.util.Date().getTime()).getTime();
        driver = this.getDriver();
        System.out.println("Scrollen????");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        actions.moveToElement(element);

        try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
                //closePopups();
                jse.executeScript("arguments[0].scrollIntoView(true);", element);
                wait.until(ExpectedConditions.elementToBeClickable(element));
        }

}
    
    public void waitForElement (WebElement element) {
        vorher = new Timestamp(new java.util.Date().getTime()).getTime();
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 5);
        element = wait.until(ExpectedConditions.visibilityOf(element));
        
        
        System.out.println("***** waiting for element  ****** : "
                + element.getAttribute("id")+(int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));

             
}

}
