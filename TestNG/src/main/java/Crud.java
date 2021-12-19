import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Crud {
    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();

    private By inputLogin = By.xpath("//input[@name=\"_user_name\"]");
    private By inputPassword = By.xpath("//input[@name=\"_password\"]");
    private By choice3 = By.xpath("//a[text()=\"Тренировки\"]");
    private By btnBurger = By.cssSelector(".dropbtn");
    private By btnVhod = By.xpath("//a[text()='Вход']");
    private By btnLogin = By.xpath("//input[@name='Vhod']");
    private By btnExit = By.xpath("//a[text()=\"Выйти\"]");
    private By inputTypeTrain = By.xpath("//input[@name='Name_Training']");
    private By inputNameExercises = By.xpath("//input[@name='Name_Exercises']");
    private By btnCreateTypeTrain = By.xpath("//input[@name='create1']");
    private By btnCreateName =  By.xpath("//input[@name='create2']");
    private By tableType = By.xpath(String.format("//tr//td[text()='%s']", getDate.typeTrain));
    private By tableName = By.xpath(String.format("//tr//td[text()='%s']", getDate.nameExercises));
    private By nameTrain = By.xpath(String.format("//h1[text()='%s']", getDate.typeTrain));
    private By nameExercise = By.xpath(String.format("//li[text()='%s']", getDate.nameExercises));
    private By btnPanelAdmin = By.xpath("//a[text()='Панель администратора']");
    private By selectTrainings = By.xpath("//select[@name='Name_Trainings']");
    private By selectExercises = By.xpath("//select[@name='Name_Exercisess']");
    private By btnCreateTrain = By.xpath("//input[@name='create3']");

    @Test
    public void adminPanel() throws InterruptedException {
        driver.get(getDate.getUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(btnBurger).click();
        driver.findElement(btnVhod).click();
        driver.findElement(inputLogin).sendKeys(getDate.login);
        driver.findElement(inputPassword).sendKeys(getDate.password);
        driver.findElement(btnLogin).click();
        driver.findElement(btnBurger).click();
        Assert.assertEquals(driver.findElement(btnExit).getText(), "Выйти");
        driver.findElement(btnPanelAdmin).click();
        driver.findElement(inputTypeTrain).sendKeys(getDate.typeTrain);
        driver.findElement(btnCreateTypeTrain).click();
        driver.findElement(inputNameExercises).sendKeys(getDate.nameExercises);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", driver.findElement(btnCreateName));
        Assert.assertEquals(driver.findElement(tableType).getText(), getDate.typeTrain);
        Assert.assertEquals(driver.findElement(tableName).getText(), getDate.nameExercises);
        Select selectObject = new Select(driver.findElement(selectTrainings));
        selectObject.selectByVisibleText(getDate.typeTrain);
        Select selectObject1 = new Select(driver.findElement(selectExercises));
        selectObject1.selectByVisibleText(getDate.nameExercises);
        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
        jse1.executeScript("arguments[0].click()", driver.findElement(btnCreateTrain));
        driver.findElement(btnBurger).click();
        driver.findElement(choice3).click();
        Assert.assertEquals(driver.findElement(nameTrain).getText(), getDate.typeTrain);
        Assert.assertEquals(driver.findElement(nameExercise).getText(), getDate.nameExercises);
        driver.findElement(btnBurger).click();
        driver.findElement(btnExit).click();
        driver.quit();
    }
}
