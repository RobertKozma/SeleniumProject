package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.element.VariableElement;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.text.html.Option;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class TryOut {

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
        WebElement formField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formField.click();

        Thread.sleep(1000);

        WebElement practiceFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();

        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,400)");

        Thread.sleep(1000);


        WebElement dateOfBirthField = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dateOfBirthField.click();

        Thread.sleep(500);

        insertBirthDate("2003", "May", "14");

        Thread.sleep(500);

        String date = driver.findElement(By.id("dateOfBirthInput")).getAttribute("value");
        System.out.println("BDAY is: " + date);


        Thread.sleep(1500);
        driver.quit();

    }

    public void insertBirthDate(String yearOfBirth, String monthOfBirth, String dayOfBirth) {
        //Insert birth date
        String birthMonth = monthOfBirth;
        String birthYear = yearOfBirth;
        String birthDay = dayOfBirth;

        WebElement clickMonth = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        clickMonth.click();

        List<WebElement> monthFiled = driver.findElements(By.xpath("//select[@class='react-datepicker__month-select']//option"));
        Select month = new Select(clickMonth);
        month.selectByVisibleText(monthOfBirth);

//        Integer monthIndex = 0;
//        while (monthIndex < monthFiled.size()) {
//            WebElement selectMonth = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']//option[@value=" + monthIndex + "]"));
////            System.out.println("Index for " + monthFiled.get(monthIndex).getText() + " is: " + monthIndex);
////            System.out.println("Selected month is: " + selectMonth.getText());
//            Select month = new Select(clickMonth);
//            month.selectByVisibleText(birthMonth);
//            monthIndex++;
//        }

//        WebElement month = driver.findElement(month combo locator);
//        Select monthCombo = new Select(month);
//        monthCombo.selectByVisibleText("March");
//
//        WebElement year = driver.findElement(year combo locator);
//        Select yearCombo = new Select(year);
//        yearCombo.selectByVisibleText("2015");
//
//        driver.click(By.linkText("31"));


        WebElement clickYear = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        clickYear.click();

        List<WebElement> yearFiled = driver.findElements(By.xpath("//select[@class='react-datepicker__year-select']//option"));
        Select year = new Select(clickYear);
        year.selectByValue(yearOfBirth);
//            yearIndex++;
//        int yearIndex = 0;
//        while (yearIndex < yearFiled.size()) {
//            WebElement selectYear = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']//option[@value=" + yearFiled.get(yearIndex).getText() + "]"));
//            System.out.println("Index for " + yearFiled.get(yearIndex).getText() + " is: " + yearIndex);
//            System.out.println("Selected year is: " + selectYear.getText());
//            Select year = new Select(clickYear);
        //year.selectByVisibleText(birthYear);
//            year.selectByValue(yearOfBirth);
//            yearIndex++;

//        }

        List<WebElement> datePickerList = driver.findElements(By.xpath("//div[@class='react-datepicker__week']//div"));

        for (int i = 0; i < datePickerList.size(); i++) {
            String ariaLabel = datePickerList.get(i).getAttribute("aria-label");

            if (ariaLabel.contains(birthMonth + " " + birthDay + "th, " + birthYear)) {
                WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
                System.out.println("date picker aria label is " + ariaLabel);
                calendarField.click();
                break;
            } else if (ariaLabel.contains(birthMonth + " " + birthDay + "st, " + birthYear)) {
                WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
                System.out.println("date picker aria label is " + ariaLabel);
                calendarField.click();
                break;
            } else if (ariaLabel.contains(birthMonth + " " + birthDay + "nd, " + birthYear)) {
                WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
                System.out.println("date picker aria label is " + ariaLabel);
                calendarField.click();
                break;
            } else if (ariaLabel.contains(birthMonth + " " + birthDay + "rd, " + birthYear)) {
                WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
                System.out.println("date picker aria label is " + ariaLabel);
                calendarField.click();
                break;
            }
            System.out.println("End index is: " + i);
        }

//        int size = datePickerList.size();
//        System.out.println("Size = " + size);
//        int i = 0;
//        do {
//            String ariaLabel = datePickerList.get(i).getAttribute("aria-label");
//            i++;
//            if (i < datePickerList.size()) {
//                if (ariaLabel.contains(birthMonth + " " + birthDay + "th, " + birthYear)) {
//                    WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
//                    System.out.println("date picker aria label is " + ariaLabel);
//                    calendarField.click();
//                } else if (ariaLabel.contains(birthMonth + " " + birthDay + "st, " + birthYear)) {
//                    WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
//                    System.out.println("date picker aria label is " + ariaLabel);
//                    calendarField.click();
//                } else if (ariaLabel.contains(birthMonth + " " + birthDay + "nd, " + birthYear)) {
//                    WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
//                    System.out.println("date picker aria label is " + ariaLabel);
//                    calendarField.click();
//                } else if (ariaLabel.contains(birthMonth + " " + birthDay + "rd, " + birthYear)) {
//                    WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
//                    System.out.println("date picker aria label is " + ariaLabel);
//                    calendarField.click();
//                } else {
//                    //i++;
//                    System.out.println("index = "+i);
//                }
//
//            }


//            while (ariaLabel.contains("Choose Sunday, January 31st, 1982")){
//                WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='Choose Sunday, January 31st, 1982']"));
//                System.out.println("date picker aria label is " + ariaLabel);
//                calendarField.click();
//
//            }
//        } while (i <= datePickerList.size());
    }
}


//        Integer size = datePickerList.size();
//        System.out.println("Size is: "+size);
//        for (int i = 0; i < datePickerList.size(); ) {
//            String className = datePickerList.get(i).getAttribute("class");
//            String ariaLabel = datePickerList.get(i).getAttribute("aria-label");
//            System.out.println("date picker class name is " + className);
//            System.out.println("date picker aria label is " + ariaLabel);
//            if (ariaLabel.contains("Choose Sunday, January 31st, 1982")) {
//                WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='Choose Sunday, January 31st, 1982']"));
//                System.out.println("date picker aria label is " + ariaLabel);
//                calendarField.click();
//
//            } else {
//                WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, February 25th, 1982']"));
//                calendarField.click();
//            }
//            i++;
//        }

