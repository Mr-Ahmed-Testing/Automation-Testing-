package Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MAAAtestEditCart {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]/div[1]/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"btn-add-to-cart\"]")).click();
        Thread.sleep(8000);
        driver.findElement(By.id("lblCartCount")).click();
        Thread.sleep(2000);
        //make the value of the produc 14
        driver.findElement(By.cssSelector(".quantity")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.cssSelector(".quantity")).sendKeys("14");
        //delete the product from the cart list
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[5]/a")).click();













        // driver.quit();
    }
}
