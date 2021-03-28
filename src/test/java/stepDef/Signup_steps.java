package stepDef;

import base.Config;
import base.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Signup_page;

public class Signup_steps extends Config {
    Signup_page signUp = new Signup_page(driver);

    @And("I filled out the form with valid information")
    public void iFilledOutTheFormWithValidInformation() {
        signUp.enterFirstName();
        signUp.enterLastName();
        signUp.enterEmail();
        signUp.enterPassword();
        signUp.enterConfirmPassword();
        signUp.enterDOB();
        signUp.pickFemale();
    }

    @And("I clicked on agree checkbox")
    public void iClickedOnAgreeCheckbox() {
        signUp.checkAgree();
    }

    @When("I click Create My Account button")
    public void iClickCreateMyAccountButton() {
        signUp. clickCreateMyAccountButton();
    }

    @Then("I will verify Thank you message")
    public void iWillVerifyThankYouMessage() {
        signUp.verifyThankYouMsg();
    }

    @And("I click on Login Link")
    public void iClickOnLoginLink() {
        signUp.clickOnSignInLinkFromGNB();
    }

    @And("I will store the dynamic studentId")
    public void iWillStoreTheDynamicStudentId() {
        signUp.getStudentId();
        System.out.println ("Ensure studentId got stored inside the TestData ==>" + TestData.global_studentId);
    }
}
