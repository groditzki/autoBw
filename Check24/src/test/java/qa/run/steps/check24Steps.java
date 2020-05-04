package qa.run.steps;

import org.junit.Assert;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.*;
import qa.run.pages.*;


public class check24Steps {
    
    Check24 check24;

    
    @Given ("^I go to page \"([^\"]*)\"$")
    public void go_to_page (String url) throws Throwable {
    check24.getDriver().get(url);
    }
    
    @Then("^page with title \"([^\"]*)\" is shown$")
    public void expected_page_title_is_shown(String expectedTitle) throws Throwable{
    check24.pageIsShown(expectedTitle);
    }
    
    @Then("^element with label \"([^\"]*)\" is shown$")
    public void expected_element_is_shown(String expectedElement) throws Throwable{
    check24.elementIsShown(expectedElement);
    }
    
    
    @When("^I accept cookies$")
    public void i_accept_cookies() throws Throwable{
    check24.acceptCookies();
    }
    
    @When("^I start Tarife vergleichen$")
    public void i_start_tarife_vergleichen() throws Throwable{
    check24.IstartTarifevergleichen();
    }
    
    @When("^I click link \"([^\"]*)\"$")
    public void i_click_link(String linktext) throws Throwable{
    check24.clickLink(linktext);
    }
    
    @When("^I click radio \"([^\"]*)\"$")
    public void i_click_radio(String radiotext) throws Throwable{
    check24.clickRadio(radiotext);
    }
    
    @When("^I click button \"([^\"]*)\"$")
    public void i_click_button(String buttontext) throws Throwable{
    check24.clickButton(buttontext);
    }
    
    @When("^I enter \"([^\"]*)\" in field \"([^\"]*)\"$")
    public void i_enter_value_in_field(String value, String fieldlabel) throws Throwable{
    check24.enterValue(value, fieldlabel);
    }
    
}
