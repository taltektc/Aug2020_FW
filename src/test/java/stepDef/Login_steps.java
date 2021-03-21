package stepDef;

import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObject.Login_page;

public class Login_steps extends Config {
    Login_page login = new Login_page(driver);

    @Given("I am at talentTEK Home Page")
    public void iAmAtTalentTEKHomePage() {
        // assertion - if i am actually came to login screen
        Assert.assertEquals(driver.getTitle(), "Sign In");
    }

    @And("I enter valid email address")
    public void iEnterValidEmailAddress() {
        //Old method: driver.findElement (By.name("email")).sendKeys("info@taltektc.com");
        login.enterEmail("info@taltektc.com");
    }

    @And("I enter valid password")
    public void iEnterValidPassword() {
        login.enterPassword("123456");
    }

    @When("I click on Log In button")
    public void iClickOnLogInButton() {
        login.clickOnLoginButton();
    }


    @And("I enter invalid email address")
    public void iEnterInvalidEmailAddress() {
        login.enterEmail("invalidEmail@gmail.com");
    }

    @Then("I will verify I didn't successfully logged into existing account")
    public void iWillVerifyIDidnTSuccessfullyLoggedIntoExistingAccount() {
        login.invalidErrorMessage();
    }
}
