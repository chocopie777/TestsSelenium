import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registration {
    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();

    private By btnBurger = By.cssSelector(".dropbtn");
    private By btnIn = By.xpath("//a[text()='Регистрация']");
    private By inputLogin = By.xpath("//input[@name=\"_user_name\"]");
    private By inputName = By.xpath("//input[@name=\"_name\"]");
    private By inputGender = By.xpath("//input[@name=\"_gender\"]");
    private By inputAge = By.xpath("//input[@name=\"_age\"]");
    private By inputWeight = By.xpath("//input[@name=\"_weight\"]");
    private By inputHeight = By.xpath("//input[@name=\"_height\"]");
    private By inputEmail = By.xpath("//input[@name=\"_email\"]");
    private By inputPassword = By.xpath("//input[@name=\"_password\"]");
    private By btnReg = By.xpath("//input[@name='registr']");
    private By successAlert = By.xpath("//div[@class='alert alert-success']");
    private By dangerAlert = By.xpath("//div[@class='alert alert-danger']");
    @Test(priority = 1)
    public void registration(){
        driver.get(getDate.getUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(btnBurger).click();
        driver.findElement(btnIn).click();
        driver.findElement(inputLogin).sendKeys(getDate.loginReg);
        driver.findElement(inputName).sendKeys(getDate.nameReg);
        driver.findElement(inputGender).sendKeys(getDate.genderReg);
        driver.findElement(inputAge).sendKeys(getDate.ageReg);
        driver.findElement(inputWeight).sendKeys(getDate.weightReg);
        driver.findElement(inputHeight).sendKeys(getDate.heightReg);
        driver.findElement(inputEmail).sendKeys(getDate.emailReg);
        driver.findElement(inputPassword).sendKeys(getDate.passwordReg);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", driver.findElement(btnReg));
        Assert.assertEquals(driver.findElement(successAlert).getText(), "Вы успешно зарегистрировались");
    }
    @Test(priority = 2)
    public void negRegistration(){
        driver.get(getDate.getUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(btnBurger).click();
        driver.findElement(btnIn).click();
        driver.findElement(inputLogin).sendKeys(getDate.loginNegReg);
        driver.findElement(inputName).sendKeys(getDate.nameNegReg);
        driver.findElement(inputGender).sendKeys(getDate.genderNegReg);
        driver.findElement(inputAge).sendKeys(getDate.ageNegReg);
        driver.findElement(inputWeight).sendKeys(getDate.weightNegReg);
        driver.findElement(inputHeight).sendKeys(getDate.heightNegReg);
        driver.findElement(inputEmail).sendKeys(getDate.emailNegReg);
        driver.findElement(inputPassword).sendKeys(getDate.passwordNegReg);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", driver.findElement(btnReg));
        driver.findElement(dangerAlert);
        driver.quit();
    }
}
