package pageObject;

import base.Config;
import base.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Profile_page extends Config {
    public Profile_page (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    // ======================== Profile page WebElements ====================

    @FindBy(how = How.XPATH, using ="//*[@id='profile_form']/h5")
    public WebElement verifyProfilePageElement;
    // firstName Verify
    @FindBy(how = How.NAME, using ="firstName")
    public WebElement verifyFirstName;
    // lastName Verify
    @FindBy(how = How.NAME, using ="lastName")
    public WebElement verifyLastName;
    // email Verify
    @FindBy(how = How.NAME, using ="email")
    public WebElement verifyEmail;

    // ======================== Profile page Functions ====================
    public void verifyIamInProfilePage(){
        String expectedProfileText = "Update Profile";
        String actualProfileText = verifyProfilePageElement.getText();
        System.out.println(actualProfileText);
        Assert.assertEquals(actualProfileText, expectedProfileText);
    }

    public void verifyStudentInfo(){
        // firstname, lastname and email
        Assert.assertEquals(verifyFirstName.getAttribute("value"),TestData.global_studentFirstName);
        Assert.assertEquals(verifyLastName.getAttribute("value"),TestData.global_studentLastName);
        Assert.assertEquals(verifyEmail.getAttribute("value"),TestData.global_studentEmail);
    }
}
