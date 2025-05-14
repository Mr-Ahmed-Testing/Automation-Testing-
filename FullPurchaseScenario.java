package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;
public class FullPurchaseScenario {
    public static final WebDriver driver = new EdgeDriver();
    String text;
    @BeforeSuite
    void setup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
        //open the web
        driver.get("https://practicesoftwaretesting.com/");}
    @Test(priority = 1)
    void open() {
        boolean webOpened = driver.findElement(By.id("Layer_1")).isDisplayed();
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
        text = driver.findElement(By.xpath("//*[contains(text(),'Product added')]")).getText();
        System.out.println(text + " " + "(the product has been added to the cart)");
        driver.findElement(By.xpath("//*[contains(text(),'Product added')]")).click();
    }
    @Test(priority = 5)
    void addAnotherProducts() throws InterruptedException {
        // Bolt Cutters
        driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[2]/div/div/a[2]/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("quantity-input")).sendKeys(Keys.BACK_SPACE,"3");
        driver.findElement(By.id("btn-add-to-cart")).click();
        Thread.sleep(1500);
        text =driver.findElement(By.id("lblCartCount")).getText();
//        System.out.println(text);
        if(text.equals("4")){System.out.println("the Bolt Cutters is in the cart ");}
        else {System.out.println("something went wrong ");}
        //passing the alert message
        text = driver.findElement(By.xpath("//*[contains(text(),'Product added')]")).getText();
        System.out.println(text + " " + "(the product has been added to the cart)");
        driver.findElement(By.xpath("//*[contains(text(),'Product added')]")).click();
        // Slip_Joint_Pliers
        driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[2]/div/div/a[4]/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("btn-decrease-quantity")).click();
        driver.findElement(By.id("btn-decrease-quantity")).click();
        driver.findElement(By.id("btn-add-to-cart")).click();
        Thread.sleep(1500);
        text =driver.findElement(By.id("lblCartCount")).getText();
//        System.out.println(text);
        if(text.equals("5")){System.out.println("the Slip Joint Pliers is in the cart ");}
        else {System.out.println("something went wrong ");}
        //passing the alert message
        text = driver.findElement(By.xpath("//*[contains(text(),'Product added')]")).getText();
        System.out.println(text + " " + "(the product has been added to the cart)");
        driver.findElement(By.xpath("//*[contains(text(),'Product added')]")).click();
    }
    @Test(priority = 6)
    void openCartFromTheProductPage() throws InterruptedException {
        driver.findElement(By.id("lblCartCount")).click();
        boolean Pliers = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[1]/span")).isDisplayed();
        if (Pliers) {
            System.out.println("the pliers is successfully added to the cart list ");
        }else {
            System.out.println("something went wrong ");
        }
        boolean Bolt_Cutters = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr[2]/td[1]/span")).isDisplayed();
        if (Bolt_Cutters) {
            System.out.println("the Bolt_Cutters is successfully added to the cart list ");
        }else {
            System.out.println("something went wrong ");
        }
        boolean Slip_Joint_Pliers = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr[3]/td[1]/span")).isDisplayed();
        if (Slip_Joint_Pliers) {
            System.out.println("the Slip_Joint_Pliers is successfully added to the cart list ");
        } else {
            System.out.println("something went wrong ");
        }
    }
    @Test(priority = 7)
    void CheckoutButton(){
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div/button")).click();
    }
    @Test(priority = 8)
    void RegisterAccount() throws InterruptedException {
        driver.findElement(By.linkText("Register your account")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first_name")).sendKeys("Ahmed");
        driver.findElement(By.id("last_name")).sendKeys("Sami");
        driver.findElement(By.id("dob")).sendKeys("12032006");
        driver.findElement(By.id("street")).sendKeys("Eltalbeia Main Street");
        driver.findElement(By.id("postal_code")).sendKeys("022503");
        driver.findElement(By.id("state")).sendKeys("El-gharbeia");
        driver.findElement(By.id("city")).sendKeys("Tanta");
        WebElement dropdown = driver.findElement(By.id("country"));
        Select CountryDropDownList = new Select(dropdown);
        CountryDropDownList.selectByValue("EG");
        driver.findElement(By.id("phone")).sendKeys("01092062260");
        driver.findElement(By.id("email")).sendKeys("Medo123123@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Medos@mi123456");
        driver.findElement(By.className("btnSubmit")).click();
    }
    @Test(priority = 9)
    void Login() throws InterruptedException {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/div/div/h3")));
        driver.findElement(By.id("email")).sendKeys("Medo123123@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Medos@mi123456");
        driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")).click();
    }
    @Test(priority =10)
    void Checkout() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"menu\"]")).isDisplayed();
        driver.findElement(By.id("lblCartCount")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div/button")).click();
        WebElement dropdown1 = driver.findElement(By.id("payment-method"));
        Select payment_method_dropdown =new Select(dropdown1);
        payment_method_dropdown.selectByValue("buy-now-pay-later");
        WebElement dropdown2 = driver.findElement(By.id("monthly_installments"));
        Select monthly = new Select(dropdown2);
        monthly.selectByValue("3");
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div/button")).click();
        driver.findElement(By.cssSelector(".alert-success")).isDisplayed();
        boolean sucsses = driver.findElement(By.cssSelector(".alert-success")).isDisplayed();
        if(sucsses){
            System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
        }
        else {
            System.out.println("something went wrong");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}