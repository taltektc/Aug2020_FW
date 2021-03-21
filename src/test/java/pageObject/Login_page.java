package pageObject;

import base.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_page{

    public Login_page (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // email edit box
    @FindBy(how = How.NAME, using ="email")
    public WebElement emailOrId;
    // password edit box
    @FindBy(how = How.NAME, using ="password")
    public WebElement password;
    // Login button
    @FindBy(how = How.XPATH, using ="//input[@value='Log In']")
    public WebElement loginButton;
    // error message
    @FindBy(how = How.XPATH, using ="//*[@id='error_message']/div/h5")
    public WebElement invalidEmailOrIdErrorMsg;


    public void enterEmail(String studentEmail){
        emailOrId.sendKeys(studentEmail);
    }
    public void enterPassword(String studentPassword){
        password.sendKeys(studentPassword);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
    public void invalidErrorMessage(){
        String exp = "You have entered an incorrect email or student Id.";
        String act = invalidEmailOrIdErrorMsg.getText();
        Assert.assertEquals(act, exp);

    }

}
