package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {
    public WebDriver driver;
    @Test
    public void automationMethod() throws InterruptedException {

        // deschidem un browser de Chrome
        driver = new ChromeDriver();

        // accesam o pagina web
        driver.get("https://demoqa.com/");

        Thread.sleep(1000);

        // punem browser-ul in modul maximize
        driver.manage().window().maximize();

        Thread.sleep(1000);

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        // declaram un element
        WebElement formField=driver.findElement(By.xpath("//h5[text()='Forms']"));
        formField.click();

        Thread.sleep(1000);

        WebElement practiceFormField=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();

        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,400)");

        Thread.sleep(1000);

        WebElement firstNameField=driver.findElement(By.id("firstName"));
        String firstNameValue="Jon";
        firstNameField.sendKeys(firstNameValue);

        Thread.sleep(500);

        WebElement lastNameField=driver.findElement(By.id("lastName"));
        String lastNameValue="Doe";
        lastNameField.sendKeys(lastNameValue);

        Thread.sleep(500);

        WebElement emailField=driver.findElement(By.id("userEmail"));
        String emailNameValue="mail@mail.com";
        emailField.sendKeys(emailNameValue);

        Thread.sleep(500);

        WebElement mobileNumberField=driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue="0741356169";
        mobileNumberField.sendKeys(mobileNumberValue);

        Thread.sleep(500);

        WebElement pictureField=driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/download.jpg");
        pictureField.sendKeys(file.getAbsolutePath());


    }

}
