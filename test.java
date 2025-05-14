package TestNG2.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import TestNG2.pages.MainPage;
import TestNG2.base.Base;
import TestNG2.pages.ProPage;

public class test extends Base{


    @Test
    public void testadd() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        ProPage proPage = new ProPage(driver);
        mainPage.PriceSlider();

        for(int x=0;x<6;x++) {
            System.out.println("========================================================= LIST ("+(x+1)+") ========================================================= ");
            mainPage.pagelist(x);
            System.out.println("Number Of Products To Test: "+mainPage.getProList().size());
            for (int i = 0; i < mainPage.getProList().size(); i++) {
                mainPage.selectPro(i);
                System.out.println("PRODUCT NUMBER" + "(" + (i + 1) + ")" + " IS: " + proPage.proname());
                System.out.println("Has Been Selected Successfully");
                try {
                    proPage.AddToCart();
                    System.out.println("Alert Says: " + proPage.alertWords());
                    proPage.alertSkip();
                    System.out.println();
                    System.out.println("====================================");
                    driver.navigate().back();
                    mainPage.PriceSlider();
                    mainPage.pagelist(x);
                } catch (Exception e) {
                    System.out.println("PRODUCT NAMED : " + proPage.proname());
                    System.out.println("============= IS OUT OF STOCK =============");
                    System.out.println();
                    System.out.println("====================================");
                    driver.navigate().back();
                    mainPage.PriceSlider();
                    mainPage.pagelist(x);
                }

            }

        }
    }
}