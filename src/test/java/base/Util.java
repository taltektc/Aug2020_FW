package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Util extends Config{
    // write selenium func that can be re-used


    // ============ drop-down
    public void dropdownByXpathUsingValue(String loc, String value) {
        Select se = new Select(driver.findElement(By.xpath(loc)));
        se.selectByValue(value);
    }
    public void dropdownByValue(WebElement element, String value) {
        Select se = new Select(element);
        se.selectByValue(value);
    }
    public void dropdownByVisibleText(WebElement element, String value) {
        Select se = new Select(element);
        se.selectByVisibleText(value);
    }
    public void dropdownByIndex(WebElement element, int indexNum) {
        Select se = new Select(element);
        se.selectByIndex(indexNum);
    }

    // ============== radio-button
//    public void radioButton (String locator, int x){
//        List<WebElement> radioButtons = driver.findElements (By.xpath(locator));
//        radioButtons.get(x).click();
//    }

}
