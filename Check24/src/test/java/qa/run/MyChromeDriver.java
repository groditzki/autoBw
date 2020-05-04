package qa.run;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

	public class MyChromeDriver implements DriverSource {
		WebDriver driver;

		public WebDriver newDriver() {
			
			try {
				Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Gregor
			//works so far
			//System.setProperty("webdriver.chrome.driver", "C:\\DEV\\chromedriver_win32_236\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\eclipse_cucumber\\DEV\\67\\App\\Chrome-bin\\chrome.exe");
			
			//System.setProperty("webdriver.chrome.driver", "C:\\DEV\\chromedriver_win32\\chromedriver.exe");

			System.setProperty("webdriver.chrome.logfile", "C:\\Users\\eclipse_cucumber\\DEV\\chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			
			
			
			ChromeOptions chromeOptions = new ChromeOptions();
			 chromeOptions.setBinary("C:\\Users\\eclipse_cucumber\\DEV\\67\\App\\Chrome-bin\\chrome.exe");
			 //chromeOptions.setBinary("C:\\Users\\A1180435\\AppData\\Local\\Downloaded Apps\\GoogleChrome\\57\\GoogleChromePortable.exe");
			 chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
			 chromeOptions.addArguments("disable-infobars"); // disabling infobars
			 //chromeOptions.addArguments("--disable-extensions"); // disabling extensions
			 //chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
			 //chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			 //chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
			 //chromeOptions.setExperimentalOption("useAutomationExtension", false);
			 //chromeOptions.addArguments("--headless");
			 driver = new ChromeDriver(chromeOptions);
			return driver;

		}
	
	public boolean takesScreenshots() {
		return true;
	}

}