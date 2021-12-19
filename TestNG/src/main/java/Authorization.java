import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Authorization {
    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();

    private By inputLogin = By.xpath("//input[@name=\"_user_name\"]");
    private By inputPassword = By.xpath("//input[@name=\"_password\"]");
    private By btnBurger = By.cssSelector(".dropbtn");
    private By btnVhod = By.xpath("//a[text()='Вход']");
    private By btnLogin = By.xpath("//input[@name='Vhod']");
    private By btnExit = By.xpath("//a[text()=\"Выйти\"]");
    private By dangerAlert = By.xpath("//div[@class=\"alert alert-danger\"]");


    @Test(priority = 1)
    public void auth(){
        driver.get(getDate.getUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(btnBurger).click();
        driver.findElement(btnVhod).click();
        driver.findElement(inputLogin).sendKeys(getDate.login);
        driver.findElement(inputPassword).sendKeys(getDate.password);
        driver.findElement(btnLogin).click();
        driver.findElement(btnBurger).click();
        Assert.assertEquals(driver.findElement(btnExit).getText(), "Выйти");
        driver.findElement(btnExit).click();
    }
    @Test(priority = 2)
    public void negAuth(){
        driver.get(getDate.getUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(btnBurger).click();
        driver.findElement(btnVhod).click();
        driver.findElement(inputLogin).sendKeys(getDate.negLogin);
        driver.findElement(inputPassword).sendKeys(getDate.negPassword);
        driver.findElement(btnLogin).click();
        driver.findElement(dangerAlert);
        driver.quit();
    }
}
