package qa.run.pages;
import qa.run.SerenityProperties;
import net.thucydides.core.annotations.Step;
import java.sql.Timestamp;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;


public class Check24 extends BasicFunctions {

    @FindBy(css = ".c24-cookie-button")
    private static WebElement cookies_OK;
    
    @FindBy(css = "#okz")
    private static WebElement okz; 
    
    @FindBy(css = ".c24Button.js24LoadingToggle")
    private static WebElement tarifeVergleichen; 
    
    @FindBy(xpath = ".//*[@id='profileForm:accountId:inputId']")
    private static WebElement accountId;
  //*[contains(text(),'Versicherung wechseln')]
    
    public void IstartTarifevergleichen(){
        cookies_OK.click();
        System.out.println("IstartTarifevergleichen ");
        //okz.sendKeys("BN");
        tarifeVergleichen.submit();
    }
    
    
   
    
}
