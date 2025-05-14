package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class ViewCartWithTestNG {
    public static final     WebDriver driver = new EdgeDriver();
    String text;
    @BeforeSuite
    void setup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        //open the web
        driver.get("https://practicesoftwaretesting.com/");}

    @Test(priority = 1)
    void open() {
        boolean webOpened = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]/div[1]/img")).isDisplayed();
        if (webOpened) {
            System.out.println("the website opened successfully");
        } else {
            System.out.println("something went wrong ");
        }
    }
    @Test (priority = 2)
    void SelectaProduct() {
        //select pliers
        driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]/div[1]/img")).click();
        boolean addPliersOption = driver.findElement(By.id("btn-add-to-cart")).isDisplayed();
        if (addPliersOption) {
            System.out.println("the pliers has been selected");
        } else {
            System.out.println("something went wrong ");
        }
    }
    @Test (priority = 3)
    void AddProduct () {
        //add pliers to the cart
        driver.findElement(By.id("btn-add-to-cart")).click();

    }
    @Test(priority = 4)
    void aletrPass() {
        //passing the alert message
        text = driver.findElement(By.className("ng-star-inserted")).getText();
        System.out.println(text + " " + "(the pliers has been added to the cart)");
        driver.findElement(By.className("ng-star-inserted")).click();
    }
    @Test(priority = 5)
    void openCartFromTheProductPage() {
        //open the cart from the product page
        driver.findElement(By.id("lblCartCount")).click();
        boolean Pliers = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[1]/span")).isDisplayed();
        if (Pliers) {
            System.out.println("the cart list is opened successfully from the product page");
            System.out.println("the pliers is successfully added to the cart list ");
        } else {
            System.out.println("something went wrong ");
        }
    }
    @Test (priority = 6)
    void MainPageReturn() {
        //return to the main page
        driver.findElement(By.id("Layer_1")).click();
        boolean OpenMainPage = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]/div[1]/img")).isDisplayed();
        if (OpenMainPage) {
            System.out.println("returning to the main page successfully have been done");
        } else {
            System.out.println("something went wrong ");
        }
    }
    @Test (priority = 7)
    void openCartFromTheMainPage() {
        //open the cart from the main page
        driver.findElement(By.xpath("//*[@id=\"lblCartCount\"]")).click();
        boolean pliers = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[1]/span")).isDisplayed();
        if (pliers) {
            System.out.println("cart list has been opened from the main list successfully ");
        } else {
            System.out.println("something went wrong ");
        }
    }
    @Test (priority = 8)
    void MainPageReturn2() {
        //return to the main page
        driver.findElement(By.id("Layer_1")).click();
        driver.quit();
        System.out.println("the program finished with exit code 0 :)");
    }
}