package qa.run;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import net.thucydides.core.webdriver.DriverSource;

public class MyDriver implements DriverSource {
        WebDriver driver;
        static String DRIVER_DEFAULT = "Galaxy S III";

        public WebDriver newDriver() {
                System.out.println("maven Browser is: " + System.getProperty("browser"));
                String webdriver_current = SerenityProperties.getProperty("webdriver.browser").toLowerCase().trim();

                if (System.getProperty("browser") != null) {
                        webdriver_current = System.getProperty("browser");
                }

                switch (webdriver_current) {
                case "firefox":
                        driver = getFireFoxDriver();
                        break;
                case "firefox_headless":
                        driver = getFireFoxHeadlessDriver();
                        break;
                case "chrome":
                        driver = getChromeDriver(webdriver_current);
                        break;
                case "chrome_headless":
                        driver = getChromeHeadlessDriver(webdriver_current);
                        break;
                case "phantomjs":
                        driver = getPhantomJsDriver();
                        break;
                default:
                        driver = getFireFoxDriver();
                        break;
                }
                driver.manage().window().maximize();
                return driver;
        }

        public void closeChromeBrowser() {
                try {
                        System.out
                                       .println("****************************lets kill old browser instance****************************");
                        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }

        public static void main(String[] args) {
                MyDriver d = new MyDriver();
                WebDriver driver = d.newDriver();
                driver.get("http://www.google.es");

        }

        public WebDriver getPhantomJsDriver() {
                System.setProperty("phantomjs.binary.path", SerenityProperties.getProperty("webdriver.phantomjs_bin"));
                driver = new PhantomJSDriver();
                return driver;
        }

        public WebDriver getFireFoxDriver() {
                System.setProperty("webdriver.gecko.driver", SerenityProperties.getProperty("webdriver.gecko.driver"));
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary(SerenityProperties.getProperty("webdriver.firefox_bin"));
                driver = new FirefoxDriver(options);
                return driver;
        }

        public WebDriver getFireFoxHeadlessDriver() {
                System.out.println("Firefox headless");
                System.setProperty("webdriver.gecko.driver", SerenityProperties.getProperty("webdriver.gecko.driver"));
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1366,768");
                options.setBinary(SerenityProperties.getProperty("webdriver.firefox_bin"));
                driver = new FirefoxDriver(options);
                return driver;
        }

        public WebDriver getChromeDriver(String webdriver_current) {
                closeChromeBrowser();
                ChromeOptions chromeOptions = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", SerenityProperties.getProperty("webdriver.chrome.driver"));
                chromeOptions = new ChromeOptions();
                chromeOptions.setBinary(SerenityProperties.getProperty("webdriver.chrome_bin"));
                chromeOptions.addArguments("start-maximized"); // open Browser in
                chromeOptions.addArguments("disable-infobars"); // disabling
                chromeOptions.setExperimentalOption("detach", false);
                Map<String, String> mobileEmulation = new HashMap<>();
                if (webdriver_current.contains(".")) {
                        System.out.println("... mobile Emulation.........");
                        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                        String[] list = webdriver_current.split("\\.");
                        if (list.length > 2) {
                                String mobileDevice = webdriver_current.split("\\.")[2];
                                mobileEmulation.put("deviceName", mobileDevice);
                        } else {
                                mobileEmulation.put("deviceName", DRIVER_DEFAULT);
                        }
                }
                driver = new ChromeDriver(chromeOptions);
                return driver;
        }

        public WebDriver getChromeHeadlessDriver(String webdriver_current) {
                // closeChromeBrowser();
                ChromeOptions chromeOptions = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", SerenityProperties.getProperty("webdriver.chrome.driver"));
                chromeOptions = new ChromeOptions();
                chromeOptions.setBinary(SerenityProperties.getProperty("webdriver.chrome_bin"));
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--lang=en-US");
                chromeOptions.addArguments("--window-size=1920,1200");
                chromeOptions.addArguments("start-maximized"); // open Browser in
                driver = new ChromeDriver(chromeOptions);
                return driver;
        }

        public void windows_size() throws Throwable {
                // change the browser size
                String viewport = "FULLSIZE";
                switch (viewport.toUpperCase()) {
                case "FULLSIZE":
                        driver.manage().window().maximize();
                        break;
                case "DESKTOP":
                        driver.manage().window().setSize(new Dimension(1224, 768));
                        break;
                case "MOBILE":
                        driver.manage().window().setSize(new Dimension(375, 667));

                        break;
                default:
                        driver.manage().window().maximize();
                        break;
                }
        }

        public boolean takesScreenshots() {
                return true;
        }

}
