package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;
public class MAAAtestAddToCart {
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
    void increaseQuantityButton () throws InterruptedException {
        //increase Value Button test
        driver.findElement(By.id("btn-increase-quantity")).click();
        driver.findElement(By.id("btn-add-to-cart")).click();
        Thread.sleep(100);
        driver.findElement(By.className("ng-star-inserted")).click();
        text = driver.findElement(By.id("lblCartCount")).getText();
        if(text.equals("3")){System.out.println("the increase quantity button did it's functionality successfully");}
        else {System.out.println("something went wrong ");}
    }
    @Test(priority = 6)
    void decreaseQuantityButton() throws InterruptedException {
        //decrease Value Button test
        Thread.sleep(100);
        driver.findElement(By.id("btn-decrease-quantity")).click();
        driver.findElement(By.id("btn-add-to-cart")).click();
        driver.findElement(By.className("ng-star-inserted")).click();
        text = driver.findElement(By.id("lblCartCount")).getText();
        if(text.equals("4")){System.out.println("the decrease quantity button did it's functionality successfully");}
        else {System.out.println("something went wrong ");}
    }
    @Test(priority = 7)
    void editInputQuantityFiled() throws InterruptedException {
        Thread.sleep(100);
        driver.findElement(By.id("quantity-input")).sendKeys(Keys.BACK_SPACE,"5");
        driver.findElement(By.id("btn-add-to-cart")).click();
        driver.findElement(By.className("ng-star-inserted")).click();
        text = driver.findElement(By.id("lblCartCount")).getText();
        if(text.equals("9")){System.out.println("the input filed did it's functionality successfully");}
        else {System.out.println("something went wrong ");}
        driver.quit();
    }
}