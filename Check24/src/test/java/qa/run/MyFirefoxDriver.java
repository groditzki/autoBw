package qa.run;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

public class MyFirefoxDriver implements DriverSource {
	WebDriver driver;
    public WebDriver newDriver() {
        //EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        //String appiumDriverType = variables.getProperty("serenity.project.name");
        
    	//Mustapha 
    	//System.setProperty("webdriver.firefox.bin", "C:\\DEV\\tools\\Firefox-45\\autoupd\\FirefoxPortable.exe");
		//System.setProperty("webdriver.firefox.marionette","C:\\DEV\\tools\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		//Gregor
    	 System.setProperty("webdriver.firefox.bin", "C:\\Users\\eclipse_cucumber\\DEV\\FirefoxPortable45\\FirefoxPortable.exe");
         System.setProperty("webdriver.firefox.marionette","C:\\Users\\eclipse_cucumberDEV\\geckodriver\\geckowd.exe");
		//Khalid
    	//System.setProperty("webdriver.firefox.bin", "C:\\Users\\A1173104\\AppData\\Local\\Downloaded Apps\\Firefox\\autoupd\\FirefoxPortable.exe");
        //System.setProperty("webdriver.firefox.marionette","C:\\DEV\\geckodriver.exe");

    	driver=  new FirefoxDriver();
		 driver.manage().window().maximize();
		 return driver;
		 
    }
      public boolean takesScreenshots() {
        	return true;
    }

}