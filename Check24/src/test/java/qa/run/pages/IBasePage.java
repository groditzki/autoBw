package qa.run.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class IBasePage extends PageObject {

        long vorher;

        private long timeoutInSeconds = 25;
        private WebDriver driver;
        boolean present;
        
        // variable for hpbx-test, set with the first login
        public String Ta;
        



        @FindBy(xpath = ".//*[@id='pi-overlay-0']/div[1]")
        private static WebElement weiterKaufenDlg;

        @FindBy(xpath = ".//a[.='OK']")
        private static WebElement weiterEinKaufenBtn;

        @FindBy(xpath = ".//*[@class='LPMimage']")
        private static WebElement chat;

        @FindBy(xpath = ".//*[@class='LPMcloseButton']")
        private static WebElement closeChatbtn;

        @FindBy(tagName = "html")
        private static WebElement htmlTag;

        @FindBy(css = "div.gfkButtonNo")
        private static WebElement Nobtn;

        @FindBy(xpath = "//iframe[contains(@src,'https://www.telekom-geschaeftskunden-cloud.de/171215_1Euro_Aktion.php')]")
        private static WebElement advertiser;

        @FindBy(xpath = ".//*[@id='plan-a-layer']/div/a")
        private static WebElement closebtn;
 

        @Step
        public void i_report(String message, String str) {

        }

        // used for GKP wating till the new page is loaded and check if correct page it is
        public void i_seePage(String classAsStr, String title) throws IOException {
                // calling checkPageIsReady() method to check page loaded status.
                // checkPageIsReady();
                classAsStr = classAsStr.replace("Steps", "");
                check_page(classAsStr, title);               
        }



        private void check_page(String classAsStr, String ptitle) throws IOException {
                // used for GKP this.waitTillLoadingImageIsInvisible();
               
                        waitForTitleToBe(ptitle);
                        // this.waitTillLoadingImageIsInvisible();
                        // this.waitForTitleToAppear(ptitle);
                        waitForTitleToBe(ptitle);
                        // WebDriverWait wait = new WebDriverWait(this.getDriver(), 30);
                        // wait.until(ExpectedConditions.titleContains(ptitle));
                        Assert.assertTrue(this.getDriver().getTitle() + " check title " + ptitle,
                                        this.getDriver().getTitle().contains(ptitle));
                }
        
        // Neu eingefügt für hPBX-Test: create WP etc wird damit per url aufgerufen  
        public void goes_to_Page(String path) throws Throwable {
            long vorher = new Timestamp(new java.util.Date().getTime()).getTime();
            System.out.println("open url : ..... " + path);
            this.getDriver().get(path);
            
            System.out.println("***** open url " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));

    }
        
        
        public String getUrl(String link) throws Throwable {         
            String base_url;
            switch (link) {
            case "1":
                    base_url = "http://qde8tm.de.t-internal.com:21780/";
                    break;
            case "2":
                    base_url = "http://qde8tl.de.t-internal.com:21780/";
                    break;
            case "3":
                    base_url = "http://qde8tn.de.t-internal.com:21780/";
                    break;
            case "4":
                    base_url = "http://qde8tp.de.t-internal.com:21780/";
                    break;

            default:
                    base_url = "http://qde8tn.de.t-internal.com:21780/";
                    break;
            } 
            return base_url;
    }
        

        public String getTarget(String link) throws Throwable {                      
            String target;
            switch (link) {
            case "Arbeitsplatz_einrichten":
                    target = "hpbx/workplaceConfiguration.xhtml";
                    break;
            case "Arbeitsplaetze_verwalten":
                    target = "hpbx/company/workplace/workplaceManagement.xhtml";
                    break;
            case "Kontingente_und_Auftragsstatus":
                    target = "hpbx/orderManagement.xhtml";
                    break;
                    
            default:
                target = "hpbx/workplaceConfiguration.xhtml";
                break;

            } 
            return target;
    }
        
        
        public void go_to_Page(String url_ta,String targetpage) throws Throwable {
            String url = url_ta + targetpage; 
            System.out.println("try open url : ..... " + url);
            this.getDriver().get(url);
            System.out.println("open url : ..... " + url);
    }
        
    // zum auslesen von dropdown / select - hat nie funktiert..    
    public void select_hpbx(String list_id, String value) throws Throwable {
    System.out.println("****  select_hpbx 1****" );
    WebElement selectBox1 =  this.getDriver().findElement(By.xpath("//*[@id='employeeDataForm:employeeDataSect:employeeSalutation:selectId']"));
    selectBox1.click();
    WebElement selectBox = this.getDriver().findElement(By.xpath("//*[@id='employeeDataForm:employeeDataSect:employeeSalutation:selectId_input']"));

     System.out.println("selectBox.toString() : ..... " + selectBox.toString());
     Select drpSelect = new Select(selectBox);
     drpSelect.selectByIndex(2);
     
     System.out.println("****  drpSelect.getAllSelectedOptions() ****" +drpSelect.getFirstSelectedOption());
    }
    
    //zum Auslesen von Dropdownfeldern
    public void  ul_hpbx (String name_list, String value) throws Throwable {
    //<div> das angeklickt wird zum öffnen der Liste
    /*WebDriverWait wait = new WebDriverWait(this.getDriver(), 15);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='"+ name_list +"']")));
    */
        Thread.sleep(500);
     WebElement selectItem = this.getDriver().findElement(By.xpath(".//*[@id='"+ name_list +"']"));
     //waitForElement(selectItem);
     Thread.sleep(500);
     selectItem.click();
     System.out.println("ul_hpbx Liste geöffnet");
    //<ul> wird aus dem <div> oben abgeleitet
    WebElement groupUL= this.getDriver().findElement(By.xpath(".//*[@id='"+ name_list +"_items']"));
    //Listenelemente werden duchsucht nach dem List-Eintrag, der geklickt werden soll
    List<WebElement> groupsList=groupUL.findElements(By.tagName("li"));
    for (int i = 0; i < groupsList.size(); i++) {
        if (groupsList.get(i).getAttribute("id").toUpperCase().contains(value.toUpperCase())) {
            //waitForElement(groupsList.get(i));
            Thread.sleep(1000);
            groupsList.get(i).click();
            Thread.sleep(100);
            System.out.println("ul_hpbx if: Option gewählt mit id = "+"||"+groupsList.get(i).getAttribute("id"));
            break;
            }
    }
    }
    
   // fÜR CREATE WORKPLACE - Um den Weiter-Button in jeder Sektion zu klicken
   public void clickWeiter(String section)  throws Throwable {
    //Thread.sleep(1000);
    WebElement button = this.getDriver().findElement(By.xpath("//*[contains(@id,'" + section + ":submitBtn')]"));
    //Thread.sleep(1000);
    waitForElement(button);
    button.click();
    System.out.println("weiter in Sektion"+section);
    
    
    }

public void nextSection (String section)  throws Throwable {
    
    WebElement next = this.getDriver().findElement(By.xpath(section));
    //waitForElement(next);
    Thread.sleep(500);
    next.click();
    Thread.sleep(200);
    
    }

  public String selectAnsicht (String select_Ansicht)throws Throwable {
  //select_Ansicht can be "Zur Expertenansicht" or "Zur Standardansicht" = button.getText()
  WebElement button = this.getDriver().findElement(By.xpath("//*[contains(@id,'expertModeForm:button')]"));
  String link_text =button.getText();
  if (link_text.equals(select_Ansicht)){
      button.click();
      return button.getText();
  }
  else
  return button.getText();
      
  }
  
  public boolean isExpert(){
  WebElement button = this.getDriver().findElement(By.xpath("//*[contains(@id,'expertModeForm:button')]"));
  String link_text =button.getText();
  if (link_text.equals("Zur Standardansicht")){
      //Vergleich klappt nur mit equals(); == geht nicht
      System.out.println("isExpert");
    return true;

  }
  else return false;
      
  }
      
        

        public void waitForElement (WebElement element) {
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                // this.waitTillLoadingImageIsInvisible();
                //WebDriver driver = this.getDriver();
                WebDriverWait wait = new WebDriverWait(this.getDriver(), 5);
                element = wait.until(ExpectedConditions.visibilityOf(element));
                
                
                System.out.println("***** waiting for element  ****** : "
                        + element.getAttribute("id")+(int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));

                     
        }
        
        public void waitForTitleToBe(String PageTitle) {
            vorher = new Timestamp(new java.util.Date().getTime()).getTime();
            // this.waitTillLoadingImageIsInvisible();
            Wait<WebDriver> titleWait = new FluentWait<WebDriver>(this.getDriver()).withTimeout(Duration.ofSeconds(25))
                            .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

            titleWait.until(ExpectedConditions.titleContains(PageTitle));
            System.out.println("***** waiting for title  ****** : "
                            + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher) + "  -> " + PageTitle);
    }

        private void check_progress_bar(String ptitle) {
                // progressbar is available only on checkout pages
                Assert.assertTrue(true);

        }

        public Screenshot i_screenshot(WebElement element) {
                Screenshot elementScreenShot = new AShot().takeScreenshot(this.getDriver(), element);
                return elementScreenShot;
        }

        /*
         * Method to wait till the loading image is invisible
         */
        public void waitTillLoadingImageIsInvisible() {
                JavascriptExecutor jse = (JavascriptExecutor) this.getDriver();
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                WebDriver driver = this.getDriver();
                WebDriverWait wait = new WebDriverWait(this.getDriver(), timeoutInSeconds);
                List<WebElement> piLoader = this.getDriver().findElements(By.xpath("//div[@class='pi-loader']"));
                if (piLoader.size() != 0) {

                        // new WebDriverWait(driver,
                        // timeoutInSeconds).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='pi-loader']")));
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='pi-loader']")));

                        System.out.println("***** waitTillLoadingImageIsInvisible  ****** : "
                                        + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));
                        waitTillLoadingImageIsInvisible();
                } else {
                        System.out.println("No waiting image");
                        System.out.println("***** waitTillLoadingImageIsInvisible IN NOT THERE  ****** : "
                                        + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));
                }
        }

        // TODO: is this still needed?
        /*
         * Method to get the innerAttribute
         */
        public String i_attribute(String pInnereAttribute) {
                String innereAttribute;
                innereAttribute = pInnereAttribute.replaceAll("\\<.*?>", "");
                innereAttribute = innereAttribute.trim();
                innereAttribute = innereAttribute.replaceAll("\\r|\\n", "").trim();
                // System.out.println("innereAttribute : " + innereAttribute);
                return innereAttribute;
        }

        /*
         * i_select with webelement
         */
        public void i_select(WebElement wElement, String value) {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();

                Select select = new Select(wElement);
                select.selectByValue(value);

                System.out.println(
                                "***** i_select  ****** : " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher)
                                                + "  -> " + wElement.toString());
        }

        /*
         * i_select only label and call method "i_select"
         */
        public void i_select(String label) {
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                WebDriverWait wait = new WebDriverWait(this.getDriver(), timeoutInSeconds);
                // comment next line because it may cause problems in headless?
                // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'"
                // + label + "')]")));
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'" + label + "')]")));
                WebElement we = element(By.xpath("//label[contains(.,'" + label + "')]"));
                i_select(we);

                System.out.println("***** i_select 2  ****** : "
                                + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher) + "  -> " + label);
        }

        // Gregor testing porpuse..
        public void i_select(String label, String waitForText) {
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                WebDriverWait wait = new WebDriverWait(this.getDriver(), timeoutInSeconds);
                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'" + waitForText + "')]")));
                WebElement we = element(By.xpath("//label[contains(.,'" + label + "')]"));
                i_select(we);

                System.out.println("***** i_select   ****** : "
                                + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher) + "  -> " + label);
        }

        // TODO: modify it... maybe call i_click instead of .click() and program
        // only on i_select method
        /*
         * i_select with exceptions in case of popups so on
         */
        public void i_select(WebElement wElement) {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();

                // Waiting 30 seconds for an element to be present on the page, checking
                // for its presence once every 500 milliseconds.
                Wait<WebDriver> wait = new FluentWait<WebDriver>(this.getDriver()).withTimeout(Duration.ofSeconds(10))
                                .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

                WebElement element = wait.until(new Function<WebDriver, WebElement>() {

                        public WebElement apply(WebDriver driver) {
                                WebElement element = wElement;
                                if (element.isDisplayed()) {
                                        System.out.println("Visible");
                                        return element;
                                } else {
                                        System.out.println("FluentWait Failed");
                                        return null;
                                }
                        }
                });
                try {
                        System.out.println("try i_select");
                        // wElement.click();
                        i_click(element);
                } catch (Exception e) {
                        System.out.println("Cacht i_select");
                        waitTillLoadingImageIsInvisible();
                        // wElement.click();
                        i_click(element);

                }

                System.out.println(
                                "***** i_select 3  ****** : " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher)
                                                + "  -> " + wElement.toString());

        }

        /*
         * i_type
         */
        public void i_type(WebElement wElement, String text) {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                Wait<WebDriver> wait = new FluentWait<WebDriver>(this.getDriver()).withTimeout(Duration.ofSeconds(5))
                                .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

                WebElement element = wait.until(new Function<WebDriver, WebElement>() {

                        public WebElement apply(WebDriver driver) {
                                WebElement element = wElement;
                                if (element.isDisplayed()) {
                                        System.out.println("Visible1");
                                        return element;
                                } else {
                                        System.out.println("FluentWait Failed");
                                        return null;
                                }
                        }
                });
                element.clear();
                element.sendKeys(text);

                System.out.println(
                                "***** i_type  ****** : " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher)
                                                + "  -> " + wElement.toString());
        }

        public boolean element_clickable(WebElement wElement) {
                boolean clickable = wElement.isDisplayed();
                System.out.println("isEnabled?: " + wElement.isEnabled());
                System.out.println("isDisplayed?: " + wElement.isDisplayed());
                System.out.println("check if element is clickable");
                try {

                        // clickable = true;
                        // wElement.click();
                        // wElement.getText();
                        // wElement.clear();
                } catch (ElementNotVisibleException e) {
                        System.out.println("ElementNotVisibleException block: " + e.toString());
                        clickable = false;
                } catch (ElementNotInteractableException e) {
                        System.out.println("ElementNotVisibleException block: " + e.toString());
                        clickable = false;
                } catch (Exception e) {
                        System.out.println("Exception block: " + e.toString());
                        clickable = false;
                }
                System.out.println("Clickable?: " + clickable);
                return clickable;
        }

        /*
         * Method that returns xpath of an WebElement but not realy helpful since
         * WebElement can be on another place when page is reloaded
         */
        private String generateXPATH(WebElement childElement, String current) {
                String childTag = childElement.getTagName();
                if (childTag.equals("html")) {
                        return "/html[1]" + current;
                }
                WebElement parentElement = childElement.findElement(By.xpath(".."));
                List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
                int count = 0;
                for (int i = 0; i < childrenElements.size(); i++) {
                        WebElement childrenElement = childrenElements.get(i);
                        String childrenElementTag = childrenElement.getTagName();
                        if (childTag.equals(childrenElementTag)) {
                                count++;
                        }
                        if (childElement.equals(childrenElement)) {
                                return generateXPATH(parentElement, "/" + childTag + "[" + count + "]" + current);
                        }
                }
                return null;
        }

        /*
         * i_click
         */
        public void i_click(WebElement wElement) {
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                waitTillLoadingImageIsInvisible();
                WebDriverWait wait = new WebDriverWait(this.getDriver(), 5);
                // wait.until(ExpectedConditions.visibilityOf(wElement));
                // Gregor 20190215 comment because next line causes problems?!
                wait.until(ExpectedConditions.elementToBeClickable(wElement));
                // scrollUntilElementInView(wElement);
                // jse.executeScript("arguments[0].style.border='3px dashed blue'",
                // wElement);
                // jse.executeScript("arguments[0].click();", wElement);
                try {
                        wElement.click();

                } catch (Exception e) {
                        closePopups();
                        scrollUntilElementInView(wElement);
                        wait.until(ExpectedConditions.visibilityOf(wElement));
                        waitTillLoadingImageIsInvisible();
                        try {
                                wElement.click();
                        } catch (Exception e1) {
                                System.out.println("Exception2: " + e1);
                                scrollUntilElementInView(wElement);
                                wait.until(ExpectedConditions.elementToBeClickable(wElement));
                                wElement.click();
                        }
                }

        }

        public void i_click_fluent(WebElement wElement) {
                // waitTillLoadingImageIsInvisible();

                /*
                 * Wait<WebDriver> wait = new
                 * FluentWait<WebDriver>(this.getDriver()).withTimeout(Duration.
                 * ofSeconds(2)).pollingEvery(Duration.ofMillis(500)).ignoring(
                 * NoSuchElementException.class); WebElement element = wait.until(new
                 * Function<WebDriver, WebElement>() { public WebElement apply(WebDriver
                 * driver) { return wElement; } });
                 */

                try {
                        wElement.click();

                } catch (Exception e) {
                        System.out.println("exception i_click_fluent");
                        closePopups();
                        scrollUntilElementInView(wElement);
                        waitTillLoadingImageIsInvisible();
                        wElement.click();
                }

        }

        /*
         * i_click
         */
        public void i_click_old(WebElement wElement) {
                // String xpath = generateXPATH(wElement, "");
                // System.out.println(xpath);

                // this.getDriver().manage().timeouts().implicitlyWait(10,
                // TimeUnit.SECONDS);
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();

                // waitTillLoadingImageIsInvisible();

                // WebDriverWait wait = new WebDriverWait(this.getDriver(), 15);
                // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'"
                // + waitForText + "')]")));

                /*
                 * Wait<WebDriver> wait = new
                 * FluentWait<WebDriver>(this.getDriver()).withTimeout(Duration.
                 * ofSeconds(30))
                 * .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException
                 * .class);
                 * 
                 * WebElement fluentElement = wait.until(new Function<WebDriver,
                 * WebElement>() {
                 * 
                 * public WebElement apply(WebDriver driver) { WebElement fluentElement
                 * = wElement; if(fluentElement.isDisplayed()){
                 * System.out.println("Visible");
                 * wait.until(ExpectedConditions.elementToBeClickable(fluentElement));
                 * return fluentElement; }else{ System.out.println("FluentWait Failed");
                 * return null; } } });
                 * 
                 */

                // WebDriverWait wait1 = new WebDriverWait(this.getDriver(), 1);
                // scrollUntilElementInView(wElement);
                try {
                        jse.executeScript("arguments[0].style.border='3px dashed blue'", wElement);
                        System.out.println("Try click ele: " + wElement.getText());
                        wElement.click();
                        // JavascriptExecutor executor = (JavascriptExecutor)driver;
                        // executor.executeScript("arguments[0].click();", wElement);
                        // wait.until(ExpectedConditions.elementToBeClickable(wElement)).click();
                        // waitTillLoadingImageIsInvisible();
                        // wElement.click();
                } catch (ElementNotVisibleException e) {
                        System.out.println("ElementNotVisibleException block: " + e.toString());
                        jse.executeScript("arguments[0].style.border='3px dashed red'", wElement);
                        scrollUntilElementInView(wElement);
                        i_click(wElement);
                        waitTillLoadingImageIsInvisible();
                } catch (Exception e) {
                        System.out.println("Exception block: " + e.toString());
                        closePopups();
                        waitTillLoadingImageIsInvisible();
                        // wait1.until(ExpectedConditions.refreshed((ExpectedConditions.visibilityOf(wElement))));
                        // jse.executeScript("arguments[0].style.border='3px dashed green'",
                        // wElement);
                        i_click(wElement);

                        // wait.until(ExpectedConditions.refreshed((ExpectedConditions.presenceOfElementLocated(By.xpath(".//input[@id='forwardButton']")))));
                        // scrollUntilElementInView(this.getDriver().findElement(By.xpath(".//input[@id='forwardButton']")));
                        // i_click(this.getDriver().findElement(By.xpath(".//input[@id='forwardButton']")));
                        // wait.until(ExpectedConditions.refreshed((ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))));
                        // scrollUntilElementInView(this.getDriver().findElement(By.xpath(xpath)));
                        // i_click(this.getDriver().findElement(By.xpath(xpath)));

                }

                System.out.println(
                                "***** i_click  ****** : " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher)
                                                + "  -> " + wElement.toString());

        }

        /*
         * i_click via xpath argument since problems when page was refreshed or new
         * elements
         */
        public void i_click(String xpath) {

                WebDriverWait wait = new WebDriverWait(this.getDriver(), timeoutInSeconds);
                try {
                        System.out.println("try xpath iClick");
                        waitTillLoadingImageIsInvisible();
                        this.getDriver().findElement(By.xpath(xpath)).click();
                } catch (Exception e) {
                        System.out.println("Exception is: " + e.toString());
                        closePopups();
                        scrollUntilElementInView(this.getDriver().findElement(By.xpath(xpath)));
                        waitTillLoadingImageIsInvisible();
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                        this.getDriver().findElement(By.xpath(xpath)).click();
                }
        }

        /*
         * i_click via xpath argutment since problems when page was refreshed or new
         * elements
         */
        public void i_click_old(String xpath) {

                WebDriverWait wait = new WebDriverWait(this.getDriver(), timeoutInSeconds);
                // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                WebElement wElement = this.getDriver().findElement(By.xpath(xpath));

                // scrollUntilElementInView(wElement);
                try {
                        jse.executeScript("arguments[0].style.border='3px dashed blue'", wElement);
                        System.out.println("Try click ele: " + wElement.getText());
                        wElement.click();
                } catch (ElementNotVisibleException e) {
                        System.out.println("ElementNotVisibleException block: " + e.toString());
                        scrollUntilElementInView(wElement);
                        i_click(xpath);
                        waitTillLoadingImageIsInvisible();
                } catch (Exception e) {
                        System.out.println("Exception block: " + e.toString());
                        closePopups();
                        waitTillLoadingImageIsInvisible();
                        System.out.println("Refreshing....XXXXX");
                        wait.until(ExpectedConditions.refreshed((ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))));
                        // scrollUntilElementInView(this.getDriver().findElement(By.xpath(xpath)));
                        i_click(this.getDriver().findElement(By.xpath(xpath)));
                }

                System.out.println(
                                "***** i_click  ****** : " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher)
                                                + "  -> " + wElement.toString());

        }

        /*
         * i_click
         */
        public void i_click(List<WebElement> wElements) {
                System.out.println("***** iClick mutliple webelements *******");
                for (WebElement wElement : wElements) {
                        // scrollUntilElementInView(wElement);
                        // wenn nicht auf dem bildschirm sichtbar dann fehler!!
                        // if (wElement.isDisplayed()) {
                        System.out.println("Element visible?: " + isWebElementVisible(wElement));
                        // if(isWebElementVisible(wElement) && wElement.isDisplayed()){
                        if (isWebElementVisible(wElement)) {
                                i_click(wElement);
                                break;
                        } else {
                                System.out.println("Element not visible WebElements i_click");
                        }
                }
        }

        boolean isWebElementVisible(WebElement w) {
                Dimension weD = w.getSize();
                Point weP = w.getLocation();
                Dimension d = this.getDriver().manage().window().getSize();
                boolean tmp = false;

                int x = d.getWidth();
                int y = d.getHeight();
                int x2 = weD.getWidth() + weP.getX();
                int y2 = weD.getHeight() + weP.getY();
                System.out.println("X: " + x + " Y: " + y + " X2: " + x2 + " Y2: " + y2);
                if (x2 == 0 || y2 == 0) {
                        System.out.println("Element not visible!");
                        tmp = false;
                }
                /*
                 * else if(((x2 <= x && y2 <= y)) && (x2!=0 || y2!=0)){
                 * System.out.println("Element is visible in view"); tmp = true; }
                 */
                else if (y2 <= y) {
                        System.out.println("Element in view must scroll");
                        scrollUntilElementInView(w);
                        tmp = true;
                } else if (y2 > y) {
                        System.out.println("Element in view must scroll2");
                        // closePopups();
                        scrollUntilElementInView(w);
                        tmp = true;
                }
                // return (x2 <= x && y2 <= y) && (x2!=0 || y2!=0);
                return tmp;

        }

        // TODO Try catch block
        /*
         * i_click2 is needed for javascript elements... like in customer dashboard
         * to click on "Abmelden"
         */
        public void i_click2(WebElement wElement) {
                // System.out.println("i_click2 Method");
                wElement.click();
                waitTillLoadingImageIsInvisible();
        }

        /*
         * Methdo to move the Mouse Pointer to the webElement
         */
        public void i_mousePointer(WebElement wElement) throws AWTException, InterruptedException {
                // Further information according window and position:
                // http://www.software-testing-tutorials-automation.com/2015/02/how-to-setget-window-position-and-size.html
                // System.out.println("Position of X: " +
                // this.getDriver().manage().window().getPosition().getX());
                // System.out.println("Position of Y: " +
                // this.getDriver().manage().window().getPosition().getY());
                Point classname = wElement.getLocation();

                int xcordi = classname.getX();
                int ycordi = classname.getY();

                Point coordinates = wElement.getLocation();
                Robot robot = new Robot();
                // robot.mouseMove(coordinates.x+8,coordinates.y+80);
                robot.mouseMove(xcordi + this.getDriver().manage().window().getPosition().getX() + 18,
                                ycordi + this.getDriver().manage().window().getPosition().getY() + 110);

                // Actions action = new Actions(this.getDriver());
                // action.moveToElement(wElement).click(wElement).build().perform();

                // action.moveToElement(wElement);
                // action.perform();

                // JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
                // js.executeScript("arguments[0].mouseOver()", wElement);

                Thread.sleep(3000);
        }

        /*
         * Move the mouse pointer to some coordinates
         */
        public void i_moveMousePointer(int x, int y) throws AWTException, InterruptedException {
                // Point coordinates = wElement.getLocation();
                // Robot robot = new Robot();
                // robot.mouseMove(coordinates.getX(),coordinates.getY()-10);

                Robot robot = new Robot();
                // robot.mouseMove(coordinates.x+8,coordinates.y+80);
                robot.mouseMove(this.getDriver().manage().window().getPosition().getX() + 10,
                                this.getDriver().manage().window().getPosition().getY() + 10);

                // Thread.sleep(3000);
        }

        /*
         * Method to scroll to the webelement if it not in the view
         */
        public void scrollUntilElementInView(WebElement element) {
                WebDriverWait wait = new WebDriverWait(this.getDriver(), 4);
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                driver = this.getDriver();
                System.out.println("Scrollen????");
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                // action
                Actions actions = new Actions(driver);
                actions.moveToElement(element);

                try {
                        // wait.until(ExpectedConditions.visibilityOf(element));
                        wait.until(ExpectedConditions.elementToBeClickable(element));
                } catch (Exception e) {
                        closePopups();
                        // actions.moveToElement(element);
                        jse.executeScript("arguments[0].scrollIntoView(true);", element);
                        // wait.until(ExpectedConditions.visibilityOf(element));
                        wait.until(ExpectedConditions.elementToBeClickable(element));
                }

        }

        public void i_dropdown_blbla(String select, String choose) {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();

                WebElement mySelectElement = null;
                if (mySelectElement == null
                                && containsElements(By.xpath(".//*[@id='" + select + "']//following-sibling::div[@id]"))) {
                        mySelectElement = element(By.xpath(".//*[@id='" + select + "']//following-sibling::div[@id]"));
                }
                // This is needed for MultiSIM
                else if (mySelectElement == null && containsElements(By.xpath(".//*[@id='" + select + "']"))) {
                        mySelectElement = element(By.xpath(".//*[@id='" + select + "']"));
                } else {
                        mySelectElement = element(By.xpath("//label[contains(.,'" + select + "')]//following-sibling::div"));
                }
                scrollUntilElementInView(mySelectElement);
                mySelectElement.click();
                boolean choose_found = false;
                WebElement ul_list = element(By.id(mySelectElement.getAttribute("id") + "-list"));
                List<WebElement> li_list = ul_list.findElements(By.tagName("li"));
                for (int i = 0; i < li_list.size(); i++) {

                        if (li_list.get(i).getText().toUpperCase().contains(choose.toUpperCase())) {
                                choose_found = true;
                                li_list.get(i).click();
                                break;
                        }
                }
                if (!choose_found) {
                        System.out.println("Choose: " + choose + "is not found. Default value is used!");
                        Assert.fail("Element: " + choose + " do not exists in drop down");
                }

                System.out.println("***** i_dropdown  ****** : "
                                + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));
        }

        // drop&down for select boxes in ADBC pages
        public void i_dropdown1(String element, String choose) {

                try {
                        Select select = new Select(this.getDriver().findElement(By.id(element)));
                        select.selectByVisibleText(choose);
                } catch (Exception e) {
                        throw new AssertionError("Element: " + choose + " is not in the list");
                }
        }

        /*
         * Drop&Down per id and value that have to be selected
         */
        public void i_dropdown(String select, String choose) {
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                System.out.println("**** drop&down *** select: " + select + " choose: " + choose);
                List<WebElement> selectElements = null; 
                WebElement webElement;
                //get ROOT Element of dropdown by id or text
                selectElements = this.getDriver().findElements(By.xpath("//select[contains(@id, '" + select + "')]//parent::select"));
                if(selectElements.size()==0){
                        selectElements = this.getDriver().findElements(By.xpath("//label[contains(.,'" + select + "')]//following-sibling::select"));
                }
                if(selectElements.size()==0){
                        selectElements = this.getDriver().findElements(By.xpath("//select[contains(@name, '" + select + "')]//parent::select"));
                }
                if(selectElements.size()!=0)
                        System.out.println("selectElements is: " + selectElements.get(0));
                
                //try to select directly the selection should work for phantom js
                try {
                        System.out.println("****  Try block  ****");
                        //WebDriverWait wait = new WebDriverWait(driver, 10);
                        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("locationForm:locationSect:groupList:groupSlctId_input")));
                        WebElement element = selectElements.get(0);
                        
                        //Select drpCompany = new Select(this.getDriver().findElement(By.name("locationForm:locationSect:groupList:groupSlctId_input")));
                        System.out.println("selectElements.get(0) " +element);
                        //drpCompany.selectByVisibleText("Soest Ahnering");
                        //drpCompany.selectByVisibleText("Bitte wäh12len");
                        Select drpSelect = new Select(element);
                        System.out.println("Select drpSelect  " +drpSelect);
                        System.out.println("****  Try block  ****");
                        //webElement = this.getDriver().findElement(By.xpath("//select[contains(@id, 'groupList')]//option[2]"));
                        Thread.sleep(5000);
                        //drpCompany.click();
                        drpSelect.selectByVisibleText("Bitte wählen");
                        drpSelect.selectByVisibleText("Filiale_1");
                        //selectElements.get(0).click();
                        //Select dropDownMenu = new Select(selectElements.get(0));
                        //dropDownMenu.selectByVisibleText(choose);
                        //selectElements.get(2).click();
                }
                //not in phantom than use the ul li list by html
                catch (Exception e) {
                        System.out.println("exeption: " + e.toString());
                        System.out.println("Continue....");
                        boolean choose_found = false;
                        JavascriptExecutor jse = (JavascriptExecutor) this.getDriver();

                        WebElement mySelectElement = null;
                        if (mySelectElement == null
                                        && containsElements(By.xpath(".//label[@for='" + select + "']//following-sibling::div[@id]"))) {
                                System.out.println("if.....");
                                mySelectElement = element(By.xpath(".//label[@for='" + select + "']//following-sibling::div[@id]"));
                        }
                        else if (mySelectElement == null
                                        && containsElements(By.xpath(".//*[@id='" + select + "']//following-sibling::div[@id]"))) {
                                System.out.println("else if 1.....");
                                mySelectElement = element(By.xpath(".//*[@id='" + select + "']//following-sibling::div[@id]"));
                        }
                        // This is needed for MultiSIM
                        else if (mySelectElement == null && containsElements(By.xpath(".//*[@id='" + select + "']"))) {
                                System.out.println("MSTNV IBASE");
                                mySelectElement = element(By.xpath(".//*[@id='" + select + "']"));
                        } 
                        else {
                                System.out.println("Else.....");
                                mySelectElement = element(By.xpath("//label[contains(.,'" + select + "')]//following-sibling::div"));
                        }
                        System.out.println("MySelectedElement: " + mySelectElement);

                        WebDriverWait wait = new WebDriverWait(this.getDriver(), timeoutInSeconds);
                        wait.until(ExpectedConditions.visibilityOf(mySelectElement));
                        scrollUntilElementInView(mySelectElement);
                        System.out.println("Scrollen");
                        jse.executeScript("window.scrollBy(0, 200)", "");
                        wait.until(ExpectedConditions.elementToBeClickable(mySelectElement));
                        mySelectElement.click();

                        WebElement ul_list = element(By.id(mySelectElement.getAttribute("id") + "-list"));
                        List<WebElement> li_list = ul_list.findElements(By.tagName("li"));
                        System.out.println("Ul Liste: " + li_list.size());
                        for (int i = 0; i < li_list.size(); i++) {
                                if (li_list.get(i).getText().toUpperCase().contains(choose.toUpperCase())) {
                                        choose_found = true;
                                        li_list.get(i).click();
                                        // when changing value in drop&down the page is loading..
                                        waitTillLoadingImageIsInvisible();
                                        break;
                                }
                        }
                        if (!choose_found) {
                                System.out.println("Choose: " + choose + " is not found. Default value is used!");
                                Assert.fail("Element: " + choose + " do not exists in drop down");
                        }

                        System.out.println("***** i_dropdown  ****** : "
                                        + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher) + "  -> "
                                        + select.toString());
                }
        }

        /*
         * More than one drop downs like for Multisim
         */
        public void i_dropdown2(String select, String choose) {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();

                List<WebElement> mySelectElements = null;
                mySelectElements = this.getDriver()
                                .findElements(By.xpath("//label[contains(.,'" + select + "')]//following-sibling::div"));

                for (WebElement ele : mySelectElements) {
                        scrollUntilElementInView(ele);
                        ele.click();

                        boolean choose_found = false;
                        WebElement ul_list = element(By.id(ele.getAttribute("id") + "-list"));
                        // System.out.println("Id des select : " + ul_list);
                        List<WebElement> li_list = ul_list.findElements(By.tagName("li"));
                        // System.out.println("Anzahl elmente is liste: " + li_list.size());
                        for (int i = 0; i < li_list.size(); i++) {

                                // System.out.println("aktuelles element in der List: " +
                                // li_list.get(i).getText());
                                if (li_list.get(i).getText().toUpperCase().equals(choose.toUpperCase())) {
                                        choose_found = true;
                                        li_list.get(i).click();
                                        waitTillLoadingImageIsInvisible();
                                        // break needed to stop because : "Stale element reference
                                        // exception: Element not found in the cache "
                                        break;
                                }
                        }
                        if (!choose_found) {
                                System.out.println("Choose: " + choose + "is not found. Default value is used!");
                                Assert.fail("Element: " + choose + " do not exists in drop down");
                        }
                }

                System.out.println("***** i_dropdown  2 ****** : "
                                + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher) + "  -> "
                                + select.toString());

        }

        /*
         * Method is used for changing MC on the ATG Checkout pages (Kundenstatus
         * pages)
         */
        public boolean i_dropdown3(String select, String choose) {
                List<WebElement> mySelectElements = null;
                boolean choose_found = false;
                // System.out.println("suche: " + select + " Was auswÃ¤hlen: " + choose);
                mySelectElements = this.getDriver()
                                .findElements(By.xpath("//label[contains(.,'" + select + "')]//following-sibling::div"));
                // System.out.println("Anzahl: " + mySelectElements.size());
                for (WebElement ele : mySelectElements) {
                        if (ele.isDisplayed()) {
                                String id = "";
                                id = ele.getAttribute("id");
                                // System.out.println("ID ist: " + id);
                                if (!id.isEmpty()) {
                                        // scrollUntilElementInView(ele);
                                        ele.click();

                                        WebElement ul_list = element(By.id(ele.getAttribute("id") + "-list"));
                                        // System.out.println("Id des select : " + ul_list);
                                        List<WebElement> li_list = ul_list.findElements(By.tagName("li"));
                                        // System.out.println("Anzahl elmente is liste: " +
                                        // li_list.size());
                                        for (int i = 0; i < li_list.size(); i++) {
                                                // System.out.println("aktuelles element in der List: "
                                                // +
                                                // li_list.get(i).getText());
                                                // System.out.println("aktuelles element in der List
                                                // (Data-Value): " +
                                                // li_list.get(i).getAttribute("data-value"));
                                                if (li_list.get(i).getText().toUpperCase().equals(choose.toUpperCase())
                                                                || li_list.get(i).getAttribute("data-value").equals(choose)) {
                                                        choose_found = true;
                                                        li_list.get(i).click();
                                                        // break needed to stop because : "Stale element
                                                        // reference exception: Element not found in the
                                                        // cache "
                                                        break;
                                                }
                                        }
                                }
                                if (!choose_found) {
                                        System.out.println("Choose: " + choose + "is not found. Default value is used!");
                                        // Assert.fail("Element: " + choose + " do not exists in
                                        // drop down");
                                }
                        }
                }
                return choose_found;
        }

        public void i_dropdown_MBM(String select, String choose) {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();

                WebElement mySelectElement = null;
                if (mySelectElement == null) {
                        mySelectElement = element(By.xpath("//span[contains(.,'" + select + "')]//following-sibling::div"));
                }

                scrollUntilElementInView(mySelectElement);
                mySelectElement.click();
                boolean choose_found = false;
                WebElement ul_list = element(By.id(mySelectElement.getAttribute("id") + "-list"));
                List<WebElement> li_list = ul_list.findElements(By.tagName("li"));
                for (int i = 0; i < li_list.size(); i++) {
                        // System.out.println("aktuelles element in der List: " +
                        // li_list.get(i).getText());
                        // System.out.println("aktuelles element in der List (DATA-Value: "
                        // + li_list.get(i).getAttribute("data-value"));
                        if (li_list.get(i).getText().toUpperCase().contains(choose.toUpperCase())) {
                                choose_found = true;
                                li_list.get(i).click();
                                // when changing value in drop&down the page is loading..
                                waitTillLoadingImageIsInvisible();
                                // break needed to stop because : "Stale element reference
                                // exception: Element not found in the cache "
                                break;
                        }
                }
                if (!choose_found) {
                        System.out.println("Choose: " + choose + "is not found. Default value is used!");
                        Assert.fail("Element: " + choose + " do not exists in drop down");
                }

                System.out.println(
                                "***** i_dropdown  ****** : " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher)
                                                + "  -> " + select.toString());
        }

        /*
         * Method to close the MagentaEins advertising
         */
        public void closeMagentaEinsWerbung() {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                if (this.getDriver().findElements(By.xpath("//*[@class='js-close-layer close-icon']")).size() > 0) {
                        this.getDriver().findElement(By.xpath("//*[@class='js-close-layer close-icon']")).click();
                        this.getDriver().switchTo().defaultContent();
                }

                System.out.println("***** closeMagentaEinsWerbung ****** : "
                                + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));
        }

        /*
         * Method to cloase all popups like visitor interrogation, Magenta Eins....
         */
        public void closePopups() {
                WebDriverWait wait = new WebDriverWait(this.getDriver(), 2);
                // wait.until(ExpectedConditions.titleContains(ptitle));
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                if (this.getDriver().findElements(By.xpath("//*[@class='js-close-layer close-icon']")).size() > 0) {
                        this.getDriver().findElement(By.xpath("//*[@class='js-close-layer close-icon']")).click();
                        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='js-close-layer
                        // close-icon']")));
                        this.getDriver().switchTo().defaultContent();
                }
                if (this.getDriver().findElement(By.tagName("html")).getText().contains("Telekom Besucherbefragung")) {
                        // System.out.println("Keine Besucherbefragung");
                        // } else {
                        System.out.println("Besucherbefragung");
                        this.getDriver().findElement(By.cssSelector("div.gfkButtonNo")).click();
                        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.gfkButtonNo")));
                }

                if (this.getDriver().findElements(By.xpath("//div[contains(@id, 'LPMcontainer')]")).size() > 0) {

                        System.out.println("********************* Chat Popup ****************************");
                        this.getDriver().findElement(By.xpath("//img[contains(@id, 'LPMcloseButton')]")).click();
                        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[contains(@id,
                        // 'LPMcloseButton')]")));
                        this.getDriver().switchTo().defaultContent();

                }
                if (this.getDriver().findElements(By.xpath("//div[contains(@class, 'pi-overlay')]//a[text()='OK']"))
                                .size() > 0) {
                        i_click(this.getDriver().findElement(By.xpath("//div[contains(@class, 'pi-overlay')]//a[text()='OK']")));
                        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,
                        // 'pi-overlay')]//a[text()='OK']")));
                        waitTillLoadingImageIsInvisible();
                        this.getDriver().switchTo().defaultContent();
                }
                // System.out.println("cookies? : " +
                // this.getDriver().findElements(By.xpath("//div[contains(@class,
                // 'cookie')]//following::span")).size());
                // close the cookies information popup
                if (this.getDriver().findElements(By.xpath("//div[contains(@class, 'cookie')]//following::span")).size() > 0) {
                        System.out.println("Close Cookies!");
                        i_click(this.getDriver().findElement(By.xpath("//div[contains(@class, 'cookie')]//following::span")));
                        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,
                        // 'cookie')]//following::span")));
                        this.getDriver().switchTo().defaultContent();
                }
                // close the Mobilfunk Mastercontract price information popup
                // System.out.println("Mobilfunk? : " +
                // this.getDriver().findElements(By.xpath("//div[@class='pi-notification']//following::span")).size());
                if (this.getDriver().findElements(By.xpath("//div[@class='pi-notification']//following::span")).size() > 0
                                && this.getDriver().findElement(By.xpath("//div[@class='pi-notification']//following::span"))
                                                .isDisplayed()) {
                        System.out.println("Close Mobilfunk!");
                        this.getDriver().findElement(By.xpath("//div[@class='pi-notification']//following::span")).click();
                        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='pi-notification']//following::span")));
                        this.getDriver().switchTo().defaultContent();
                }

                System.out.println("***** closePopups ****** : "
                                + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));
        }

        /*
         * Method to check if the correct page is shown
         */
        public boolean isPage(String isText) {
                boolean val = false;
                // Gregor 20190203
                // this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                // System.out.println(this.getDriver().getPageSource());
                val = this.getDriver().getPageSource().contains(isText);

                System.out.println("***** Checking if the to be " + isText + "  value is: " + val + "  ****** : "
                                + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));

                return val;
        }

        /*
         * Method to check if the correct page Title is shown
         */
        public boolean isTitle(String isText) {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                boolean val = false;
                val = this.getDriver().getTitle().contains(isText);

                System.out.println(
                                "***** isTitle ****** : " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));
                return val;
        }

        /*
         * Method to check if the correct page is shown with time to wait till the
         * text appeared
         */
        public boolean isPage(String isText, long timeTowait) {

                vorher = new Timestamp(new java.util.Date().getTime()).getTime();
                this.waitForTextToAppear(isText, timeTowait);
                boolean val = false;
                val = this.getDriver().getPageSource().contains(isText);

                System.out.println(
                                "***** isPage 2 ****** : " + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));
                return val;
        }

        // TODO: check if this still needed
        /*
         * Method to check if page is loaded
         */
        public void checkPageIsReady() {
                System.out.println("************   check page is ready  ***********");
                vorher = new Timestamp(new java.util.Date().getTime()).getTime();

                JavascriptExecutor js = (JavascriptExecutor) this.getDriver();

                // Initially bellow given if condition will check ready state of page.
                if (js.executeScript("return document.readyState").toString().equals("complete")) {
                        System.out.println("Page Is loaded.");
                        return;
                }

                // This loop will rotate for 25 times to check If page Is ready after
                // every 1 second.
                // You can replace your value with 25 If you wants to Increase or
                // decrease wait time.
                for (int i = 0; i < 25; i++) {
                        try {
                                System.out.println("Loop:" + i);
                                System.out.println("*****  LOOP  *****");
                                Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        // To check page ready state.
                        if (js.executeScript("return document.readyState").toString().equals("complete")) {
                                break;
                        }
                }

                System.out.println("***** checkPageIsReady ****** : "
                                + (int) (new Timestamp(new java.util.Date().getTime()).getTime() - vorher));
        }

        // Method to check element is shown/exists on the view
        public boolean nameExists(String name) {
                // System.out.println("Name is: " + name);
                boolean tmp = false;
                if (this.getDriver().findElements(By.xpath("//*[text()='" + name + "']")).size() != 0)
                        tmp = true;
                return tmp;
        }
}
