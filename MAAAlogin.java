package Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MAAAlogin {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practicesoftwaretesting.com/");
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")).click();
        driver.findElement(By.linkText("Register your account")).click();
        WebElement dropdown = driver.findElement(By.id("country"));
        Select CountryDropDownList = new Select(dropdown);
        CountryDropDownList.selectByValue("EG");




    }
}
