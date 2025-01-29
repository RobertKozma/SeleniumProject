package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod() throws InterruptedException {

        // deschidem un browser de Chrome
        driver=new ChromeDriver();

        // accesam o pagina web
        driver.get("https://demoqa.com/");

        Thread.sleep(2000);

        // punem browser-ul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        // declaram un element
        WebElement ElementsField=driver.findElement(By.xpath("//h5[text()='Elements']"));

        //dam click pe sectiunea elements
        ElementsField.click();

        Thread.sleep(2000);

        WebElement WebTableField=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        WebTableField.click();

        Thread.sleep(2000);

        List<WebElement> tableElements=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize=tableElements.size();

        WebElement AddField=driver.findElement(By.id("addNewRecordButton"));
        AddField.click();

        Thread.sleep(1000);

        WebElement FirstNameField=driver.findElement(By.id("firstName"));
        String FirstNameValue="John";
        FirstNameField.sendKeys(FirstNameValue);

        Thread.sleep(500);

        WebElement LastNameField=driver.findElement(By.id("lastName"));
        String LastNameValue="Doe";
        LastNameField.sendKeys(LastNameValue);

        Thread.sleep(500);

        WebElement EmailField=driver.findElement(By.id("userEmail"));
        String EmailValue="mail@mail.com";
        EmailField.sendKeys(EmailValue);

        Thread.sleep(500);

        WebElement AgeField=driver.findElement(By.id("age"));
        String AgeValue="25";
        AgeField.sendKeys(AgeValue);

        Thread.sleep(500);

        WebElement SalaryField=driver.findElement(By.id("salary"));
        String SalaryValue="1000";
        SalaryField.sendKeys(SalaryValue);

        Thread.sleep(500);

        WebElement DepartmentField=driver.findElement(By.id("department"));
        String DepartmentValue="ICE";
        DepartmentField.sendKeys(DepartmentValue);

        Thread.sleep(1000);

        WebElement SubmitField=driver.findElement(By.id("submit"));
        SubmitField.click();

        Thread.sleep(2000);

        WebElement EditField=driver.findElement(By.id("edit-record-4"));
        EditField.click();

        Thread.sleep(2000);

        WebElement Salary2Field=driver.findElement(By.id("salary"));
        String Salary2Value="2000";
        Salary2Field.clear();
        Salary2Field.sendKeys(Salary2Value);

        Thread.sleep(500);

        WebElement Department2Field=driver.findElement(By.id("department"));
        String Department2Value="NICE";
        Department2Field.clear();
        Department2Field.sendKeys(Department2Value);

        Thread.sleep(1000);

        WebElement Submit2Field=driver.findElement(By.id("submit"));
        Submit2Field.click();

        Thread.sleep(2000);

//        WebElement DeleteField=driver.findElement(By.id("delete-record-4"));
//        DeleteField.click();

        List<WebElement> expecedTableElements=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer finalTableSize=expecedTableElements.size();
        Integer expectedTableSize=actualTableSize+1;

        Assert.assertEquals(expecedTableElements.size(),expectedTableSize);
        System.out.println("Final table size is: "+ finalTableSize);
        System.out.println("Expected table size is: "+ expectedTableSize);

        String actualTableValue=expecedTableElements.get(3).getText();
        Assert.assertTrue(actualTableValue.contains(FirstNameValue));
        Assert.assertTrue(actualTableValue.contains(LastNameValue));
        Assert.assertTrue(actualTableValue.contains(EmailValue));
        Assert.assertTrue(actualTableValue.contains(Salary2Value));
        Assert.assertTrue(actualTableValue.contains(DepartmentValue));
        Assert.assertTrue(actualTableValue.contains(AgeValue));


    }

}
