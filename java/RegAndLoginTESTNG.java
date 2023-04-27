import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class RegAndLoginTESTNG {
    WebDriver driver;
    @Test(priority = 1)
    void openBrowser() {

        System.out.println("Opening Browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void accountRegister() {
        System.out.println("Account Registering");
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Tejas");
        driver.findElement(By.id("LastName")).sendKeys("Patel");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")).sendKeys("7"); //Date of Birth Day
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]")).sendKeys("August");//Date of Birth Month
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]")).sendKeys("2000");//Date of Birth Year
        driver.findElement(By.id("Email")).sendKeys("TestNG123@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("TestNG123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("TestNG123");
        driver.findElement(By.id("register-button")).click();
    }
    @Test(priority = 3)
    void registerValidation() {
        String ExpectedPageURL = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
        if (ExpectedPageURL.equals(driver.getCurrentUrl())) {
            System.out.println("Registration Successful");
        } else {
            System.out.println("Registration Failed");
        }

    }
    @Test(priority = 4)
    void accountLogin() {
        System.out.println("Account Login");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("TestNG123@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test123");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click(); //Login Button
    }
    @Test(priority = 5)
    void loginValidation() {
        WebElement logoutElement = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        if (logoutElement.isDisplayed()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Unsuccessful");
        }
    }
    @Test(priority = 6)
    void accountLogout(){
        System.out.println("Account Logout");
        driver.findElement(By.className("ico-logout")).click();
    }
    @Test(priority = 7)
    void logoutValidation(){
        WebElement loginElement = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        if(loginElement.isDisplayed()) {
            System.out.println("Logout Successful");
        } else {
            System.out.println("Logout Unsuccessful");
        }
    }
    @Test(priority = 8)
    void closeBrowser(){
        System.out.println("Closing Browser");
        driver.close();
    }


}
