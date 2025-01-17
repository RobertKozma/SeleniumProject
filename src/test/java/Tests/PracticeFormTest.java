package Tests;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        WebElement maleField=driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleField=driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherField=driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue="Other";
        /*if (genderValue.equals("Male")){
            maleField.click();
        } else if (genderValue.equals("Female")) {
            femaleField.click();
        } else if (genderValue.equals("Other")) {
            otherField.click();

        }*/

        if (maleField.getText().equals(genderValue)){
            maleField.click();
        } else if (femaleField.getText().equals(genderValue)) {
            femaleField.click();
        } else if (otherField.getText().equals("Other")) {
            otherField.click();

        }

        WebElement subjectsField=driver.findElement(By.id("subjectsInput"));
        String subjectsValue="Social Studies";
        subjectsField.sendKeys(subjectsValue);
        subjectsField.sendKeys(Keys.ENTER);

        WebElement stateField=driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();", stateField);
        stateField.sendKeys("NCR");
        stateField.sendKeys(Keys.ENTER);

        //react-select-4-input
        WebElement cityField=driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityField);
        cityField.sendKeys("Delhi");
        cityField.sendKeys(Keys.ENTER);

        WebElement submitField=driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitField);

        //Identificam coloanele tabelului dupa ce am dat submit la form

        List<WebElement> submitFormElementsLeft = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr/td[1]"));
        Integer submitFormSizeLeft=submitFormElementsLeft.size();
        String studentName=submitFormElementsLeft.get(0).getText();
//        System.out.println("Marime Tabel stanga este: "+submitFormSizeLeft);
//        System.out.println("Nume label stanga este: "+studentName);

        List<WebElement> submitFormElementsRight = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr/td[2]"));
        Integer submitFormSizeRight=submitFormElementsRight.size();
        String studentNameValue=submitFormElementsRight.get(0).getText();
//        System.out.println("Marime Tabel dreapta este: "+submitFormSizeRight);
        System.out.println("Valoare dreapta pentru rubrica '"+studentName+"' este: "+studentNameValue);




        Thread.sleep(1500);
        driver.close();


    }

}
