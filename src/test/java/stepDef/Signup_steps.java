package stepDef;

import base.Config;
import base.TestData;
import io.cucumber.datatable.DataTable;
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

    @And("I filled out the form using the following data table")
    public void iFilledOutTheFormUsingTheFollowingDataTable(DataTable table) {

            signUp.firstName.sendKeys(table.cell(0, 0));
            signUp.lastName.sendKeys(table.cell(0,1));
            signUp.email.sendKeys(table.cell(0,2));
            signUp.enterPasswordfromTable(table.cell(0,3));
            signUp.enterConfirmPasswordfromTable(table.cell(0,4));


    }

    @And("^I filled out the form using the following ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void iFilledOutTheFormUsingTheFollowingFNameLNameEmailPasswordConfirmPasswordMonthDayYearGender(String fName, String lName, String Email, String Password, String ConfirmPassword, String Month,String Day, String Year, String Gender) {
        signUp.firstName.sendKeys(fName);
        signUp.lastName.sendKeys(lName);
        signUp.email.sendKeys(Email);
        signUp.enterPasswordfromTable(Password);
        signUp.enterConfirmPasswordfromTable(ConfirmPassword);
        signUp.month.sendKeys(Month);
        signUp.day.sendKeys(Day);
        signUp.year.sendKeys(Year);
        if(Gender.equalsIgnoreCase("Male")) {
            signUp.male.click();
        }else if(Gender.equalsIgnoreCase("Female") ){
            signUp.female.click();
        }else{
            System.out.println("Gender not recognized Please select either 'Male' or 'Female'");
        }

    }
}
