package TestNG2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProPage {
    WebDriver driver;
    @FindBy(css = "h1") WebElement protitle;
    @FindBy(id = "btn-add-to-cart") WebElement addButton;
    @FindBy(xpath = "//*[contains(text(),'Product added')]")WebElement alertMessege;
    @FindBy(className = "mt-3")WebElement outOfStock;
    public ProPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String proname(){
        return protitle.getText();
    }
    public void AddToCart(){
        addButton.click();
    }
public String alertWords(){
        return alertMessege.getText();
}
public void alertSkip(){
        alertMessege.click();
}
public boolean outofstok(){
      return outOfStock.isDisplayed();
}

}
