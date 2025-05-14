package Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class MAAATestViewCart {

    public static void main(String[] args) throws Exception {
        String text;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //open the web
        driver.get("https://practicesoftwaretesting.com/");
        boolean webOpened = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]/div[1]/img")).isDisplayed();
        if (webOpened){System.out.println("the website opened successfully" );}
        else{System.out.println("something went wrong ");}
        //select pliers
        driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]/div[1]/img")).click();
        boolean addPliersOption = driver.findElement(By.id("btn-add-to-cart")).isDisplayed();
        if(addPliersOption){System.out.println("the pliers has been selected");}
        else{System.out.println("something went wrong ");}
        //add pliers to the cart
        driver.findElement(By.id("btn-add-to-cart")).click();
        //passing the alert message
        text =driver.findElement(By.className("ng-star-inserted")).getText();
        System.out.println(text+" "+"(the pliers has been added to the cart)");
        driver.findElement(By.className("ng-star-inserted")).click();
        //open the cart from the product page
        driver.findElement(By.id("lblCartCount")).click();
        boolean Pliers = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[1]/span")).isDisplayed();
        if(Pliers){
            System.out.println("the cart list is opened successfully from the product page");
            System.out.println("the pliers is successfully added to the cart list ");}
        else {System.out.println("something went wrong ");}
        //return to the main page
        driver.findElement(By.id("Layer_1")).click();
        boolean OpenMainPage = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]/div[1]/img")).isDisplayed();
        if (OpenMainPage){System.out.println("returning to the main page successfully have been done" );}
        else{System.out.println("something went wrong ");}
        //open the cart from the main page
        driver.findElement(By.xpath("//*[@id=\"lblCartCount\"]")).click();
        boolean pliers = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[1]/span")).isDisplayed();
        if(pliers){System.out.println("cart list has been opened from the main list successfully ");}
        else {System.out.println("something went wrong ");}
        //return to the main page
        driver.findElement(By.id("Layer_1")).click();
        driver.quit();
        System.out.println("the program finished with exit code 0 :)");



    }
}
