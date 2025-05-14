import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practicesoftwaretesting.com/");
        List<WebElement> proimg=driver.findElements(By.className("card-img-top"));
        System.out.println(proimg.size());
        for(int i = 0 ;i<proimg.size();i++){
            Thread.sleep(1000);
            proimg.get(i).click();
            Thread.sleep(1000);
            try{
                driver.findElement(By.id("btn-add-to-cart")).click();
                driver.findElement(By.xpath("//*[contains(text(),'Product added')]")).click();
                driver.navigate().back();
            } catch (Exception e) {
               System.out.println("the pro is " +driver.findElement(By.className("mt-3")).getText());
                driver.navigate().back();
            }
            proimg = driver.findElements(By.className("card-img-top"));

        }
    }
}
