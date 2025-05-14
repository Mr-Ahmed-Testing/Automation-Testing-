package TestNG2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MainPage {
    WebDriver driver;
@FindBy(className = "card-img-top") List<WebElement> proimg;
@FindBy(xpath = "//*[@id=\"filters\"]/div[1]/ngx-slider/span[6]")WebElement source;
@FindBy(xpath = "/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")WebElement aim;
@FindBy(xpath = "/html/body/app-root/div/app-overview/div[3]/div[2]/div[2]/app-pagination/nav/ul/li[8]/a")WebElement NextCollectionButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 public List<WebElement> getProList(){
   return  proimg;

}

public void selectPro(int i){

        proimg.get(i).click();
}

public void PriceSlider(){
    Actions action =new Actions(driver);
    action.clickAndHold(source).moveToElement(aim).release().build().perform();
}

public void pagelist(int x) throws InterruptedException {
    switch (x){
        case(1):
            NextCollectionButton.click();
            Thread.sleep(1500);
            break;
        case (2):
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2500);
            break;
        case (3):
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2500);
            break;
        case (4):
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2500);
            break;
        case (5):
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(2000);
            NextCollectionButton.click();
            Thread.sleep(3000);
            break;
    }
}
}
