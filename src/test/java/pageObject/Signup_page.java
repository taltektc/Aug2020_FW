package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Signup_page {
    public Signup_page (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
