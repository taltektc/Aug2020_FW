package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Profile_page {
    public Profile_page (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // ele
    @FindBy(how = How.XPATH, using ="//*[@id='profile_form']/h5")
    public WebElement verifyProfilePageElement;

    public void verifyIamInProfilePage(){
        String expectedProfileText = "Update Profile";
        String actualProfileText = verifyProfilePageElement.getText();
        System.out.println(actualProfileText);
        Assert.assertEquals(actualProfileText, expectedProfileText);
    }
}
