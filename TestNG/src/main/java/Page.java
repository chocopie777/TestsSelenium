import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Page {
    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();

    private By choice1 = By.xpath("//a[text()='Инструкция по выполнению']");
    private By choice2 = By.xpath("//a[text()=\"Рекомендованное питание\"]");
    private By choice3 = By.xpath("//a[text()=\"Тренировки\"]");
    private By btnStartTrain = By.xpath("//button[@name='sent']");
    private By btnTrainReg = By.xpath("//a[text()='Зарегистрируйтесь']");
    private By btnTrainLog = By.xpath("//a[text()='Войдите']");
    private By btnCheckBox = By.xpath("//input[@type='checkbox']");
    private By btnCheckBox2 = By.xpath("//*[.='Прыг']//input");
    private By btnCheckBox1 = By.xpath("//*[.='Бег']//input");
    private By btnComplete = By.xpath("//a[text()='Завершить']");
    private By mainMenu = By.xpath("//div[@class=\"logo\"]");
    //селекторы для авторизации
    private By inputLogin = By.xpath("//input[@name=\"_user_name\"]");
    private By inputPassword = By.xpath("//input[@name=\"_password\"]");
    private By btnBurger = By.cssSelector(".dropbtn");
    private By btnVhod = By.xpath("//a[text()='Вход']");
    private By btnLogin = By.xpath("//input[@name='Vhod']");
    private By btnExit = By.xpath("//a[text()=\"Выйти\"]");

    @Test(priority = 2)
    public void noAuthPage() throws InterruptedException {
        driver.get(getDate.getUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(btnBurger).click();
        driver.findElement(choice1).click();
        driver.findElement(btnBurger).click();
        driver.findElement(choice2).click();
        driver.findElement(btnBurger).click();
        driver.findElement(choice3).click();
        driver.findElement(btnStartTrain).click();
        driver.findElement(btnTrainReg).click();
        driver.findElement(mainMenu).click();
        driver.findElement(btnBurger).click();
        driver.findElement(choice3).click();
        driver.findElement(btnStartTrain).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", driver.findElement(btnTrainLog));
        driver.findElement(mainMenu).click();
        driver.quit();
    }
    @Test(priority = 1)
    public void authPage() throws InterruptedException {
        driver.get(getDate.getUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(btnBurger).click();
        driver.findElement(btnVhod).click();
        driver.findElement(inputLogin).sendKeys(getDate.login);
        driver.findElement(inputPassword).sendKeys(getDate.password);
        driver.findElement(btnLogin).click();
        driver.findElement(btnBurger).click();

        driver.findElement(choice1).click();
        driver.findElement(btnBurger).click();
        driver.findElement(choice2).click();
        driver.findElement(btnBurger).click();
        driver.findElement(choice3).click();
        driver.findElement(btnStartTrain).click();
        driver.findElement(mainMenu).click();
        driver.findElement(btnBurger).click();
        driver.findElement(choice3).click();
        driver.findElement(btnCheckBox).click();
        driver.findElement(btnStartTrain).click();
        driver.findElement(btnCheckBox1).click();
        driver.findElement(btnCheckBox2).click();
        driver.findElement(btnComplete).click();
        driver.findElement(mainMenu).click();
        driver.findElement(btnBurger).click();
        driver.findElement(btnExit).click();
    }
}
