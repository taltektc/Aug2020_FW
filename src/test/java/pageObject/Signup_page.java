package pageObject;

import base.Config;
import base.TestData;
import base.Util;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Signup_page extends Config {
    Faker faker = new Faker();
    Util util = new Util();

    public Signup_page (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // ======================== Signup page WebElements ====================

    // firstName edit box
    @FindBy(how = How.NAME, using ="firstName")
    public WebElement firstName;
    // lastName edit box
    @FindBy(how = How.NAME, using ="lastName")
    public WebElement lastName;
    // email edit box
    @FindBy(how = How.NAME, using ="email")
    public WebElement email;
    // password edit box
    @FindBy(how = How.NAME, using ="password")
    public WebElement password;
    // confirm password edit box
    @FindBy(how = How.NAME, using ="confirmPassword")
    public WebElement confirmPassword;
    // Month drop down
    @FindBy(how = How.NAME, using ="month")
    public WebElement month;
    // Day drop down
    @FindBy(how = How.NAME, using ="day")
    public WebElement day;
    // Year drop down
    @FindBy(how = How.NAME, using ="year")
    public WebElement year;
    // radio button
    @FindBy(how = How.XPATH, using ="//input[@type='radio']")
    public WebElement radioButton;
    // male radio button
    @FindBy(how = How.ID, using ="male")
    public WebElement male;
    // female radio button
    @FindBy(how = How.ID, using ="female")
    public WebElement female;
    // agree checkbox
    @FindBy(how = How.ID, using ="defaultCheck1")
    public WebElement agreeCheckBox;
    // Create My Account button
    @FindBy(how = How.XPATH, using ="//button[@type='submit']")
    public WebElement createMyAccountButton;
    // Thank you message
    @FindBy(how = How.XPATH, using ="//*[@id='success_message']/div")
    public WebElement thankYouMsg;
    // Get Student Id
    @FindBy(how = How.XPATH, using ="//*[@id='success_message']/div")
    public WebElement studentId;
    // Sign in Link from Global Navigation Bar
    @FindBy(how = How.XPATH, using ="//li[2]/a")
    public WebElement signInLinkFromGNB;

// ======================== Signup page functions ====================

    public void enterFirstNamefromTable(String fName){
        firstName.sendKeys(fName);
        System.out.println("Student firstName ==>" + fName);
    }
    public void enterLastNamefromTable(String lName){
        lastName.sendKeys(lName);
        System.out.println("Student Last Name ==>" + lName);
    }
    public void enterEmailfromTable(String Email){
        email.sendKeys(Email);
        System.out.println("Student Email; ==>" + Email);
    }
    public void enterPasswordfromTable(String Password){
        password.sendKeys(Password);
        System.out.println("Student Password; ==>" + Password);
    }
    public void enterConfirmPasswordfromTable(String Cpassword){
        confirmPassword.sendKeys(Cpassword);
        System.out.println("Student Confirm Password; ==>" + Cpassword);
    }

    public void enterFirstName(){
        TestData.global_studentFirstName = faker.name().firstName();
        firstName.sendKeys(global_studentFirstName);
        System.out.println("Student firstName ==>" + global_studentFirstName);
    }
    public void enterLastName(){
        TestData.global_studentLastName = faker.name().lastName();
        lastName.sendKeys(global_studentLastName);
        System.out.println("Student lastName ==>" + global_studentLastName);
    }
    public void enterEmail(){
        TestData.global_studentEmail = faker.internet().emailAddress();
        email.sendKeys(global_studentEmail);
        System.out.println("Student email ==>" + global_studentEmail);
    }
    public void enterPassword(){
       password.sendKeys(global_studentPassword);
    }
    public void enterConfirmPassword(){
        confirmPassword.sendKeys(global_studentConfirmPassword);
    }
    public void enterDOB(){
        util.dropdownByVisibleText(month, "Nov");
        util.dropdownByVisibleText(day, "30");
        util.dropdownByValue(year,"1986");
    }
    public void pickFemale(){
       female.click();
    }
    public void checkAgree(){
        agreeCheckBox.click();
    }
    public void clickCreateMyAccountButton(){
        createMyAccountButton.click();
    }
    public void verifyThankYouMsg(){
        String exp = "Thank you for sign up";
        String act = thankYouMsg.getText().substring(0,21);
        System.out.println("act message is ==>" + act);
        Assert.assertEquals(act, exp);
    }
    public void getStudentId(){
        TestData.global_studentId = studentId.getText().substring(38);
    }

    public void clickOnSignInLinkFromGNB(){
        signInLinkFromGNB.click();
    }
}
