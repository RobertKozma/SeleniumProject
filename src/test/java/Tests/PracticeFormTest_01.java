package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PracticeFormTest_01 {

    public WebDriver driver;

    @Test
    public void automationMethod() throws InterruptedException, ParseException {

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

        //declaram un element
        WebElement formField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formField.click();

        Thread.sleep(1000);

        WebElement practiceFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();

        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,400)");

        Thread.sleep(1000);

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Jon";
        firstNameField.sendKeys(firstNameValue);

        Thread.sleep(500);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Doe";
        lastNameField.sendKeys(lastNameValue);

        Thread.sleep(500);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailNameValue = "mail@mail.com";
        emailField.sendKeys(emailNameValue);

        WebElement maleField = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleField = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherField = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Other";

        if (maleField.getText().equals(genderValue)) {
            maleField.click();
        } else if (femaleField.getText().equals(genderValue)) {
            femaleField.click();
        } else if (otherField.getText().equals("Other")) {
            otherField.click();

        }

        Thread.sleep(500);

        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "0741356169";
        mobileNumberField.sendKeys(mobileNumberValue);

        Thread.sleep(500);

        //Alegem data de nastere
//        insertBirthDate("2003", "May", "14");

        //Insert birth date
        String birthMonth = "August";
        String birthYear = "1975";
        String birthDay = "15";

        WebElement dateOfBirthField = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dateOfBirthField.click();

        WebElement clickMonth = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        clickMonth.click();

//        List<WebElement> monthFiled = driver.findElements(By.xpath("//select[@class='react-datepicker__month-select']//option"));
        Select month = new Select(clickMonth);
        month.selectByVisibleText(birthMonth);

        WebElement clickYear = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        clickYear.click();

//        List<WebElement> yearFiled = driver.findElements(By.xpath("//select[@class='react-datepicker__year-select']//option"));
        Select year = new Select(clickYear);
        year.selectByValue(birthYear);

        List<WebElement> datePickerList = driver.findElements(By.xpath("//div[@class='react-datepicker__week']//div"));

        for (int i = 0; i < datePickerList.size(); i++) {
            String ariaLabel = datePickerList.get(i).getAttribute("aria-label");

            if (ariaLabel.contains(birthMonth + " " + birthDay + "th, " + birthYear) || ariaLabel.contains(birthMonth + " " + birthDay + "st, " + birthYear) || ariaLabel.contains(birthMonth + " " + birthDay + "nd, " + birthYear) || ariaLabel.contains(birthMonth + " " + birthDay + "rd, " + birthYear)) {
                WebElement calendarField = driver.findElement(By.xpath("//div[@aria-label='" + ariaLabel + "']"));
                System.out.println("Datepicker label is " + "'"+ariaLabel+"'");
                calendarField.click();
                break;
            }
        }

        Thread.sleep(500);
        //Get chosen Birth Date

        String date = driver.findElement(By.id("dateOfBirthInput")).getAttribute("value");
        System.out.println("Birth Date is: " + date);

        //Parse Birth Date for latter assert

        SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMM yyyy");
        Date submittedBirthDate = formatter1.parse(date);
        System.out.println("Submitted Birth Date is: " + submittedBirthDate);

        Thread.sleep(500);

        //Upload picture

        WebElement pictureField = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/download.jpg");
        pictureField.sendKeys(file.getAbsolutePath());
        String filename = file.getName();
//        System.out.println("Uploaded file name is: "+filename);

        Thread.sleep(500);

        //Subject field selection

        WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
        String subjectsValue = "Social Studies";
        subjectsField.sendKeys(subjectsValue);
        subjectsField.sendKeys(Keys.ENTER);
//        WebElement recordedSubject=driver.findElement(By.xpath("//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label']"));
//        String recSubj=recordedSubject.getText();
//        System.out.println("Recoderd subject is: "+recSubj);

        Thread.sleep(500);

        //Choose state

        WebElement stateField = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();", stateField);
        stateField.sendKeys("NCR");
        stateField.sendKeys(Keys.ENTER);

        Thread.sleep(500);

        //Choose city

        WebElement cityField = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityField);
        cityField.sendKeys("Delhi");
        cityField.sendKeys(Keys.ENTER);

        //Check chosen state and city

        WebElement currentState = driver.findElement(By.xpath("//div[@id='state']//div[@class=' css-1uccc91-singleValue']"));
        WebElement currentCity = driver.findElement(By.xpath("//div[@id='city']//div[@class=' css-1uccc91-singleValue']"));
        String state = currentState.getText();
        String city = currentCity.getText();
//        System.out.println("State and City are: "+state+" and "+city);

        Thread.sleep(500);

        //Submit form

        WebElement submitField = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitField);

        //Identificam coloanele tabelului dupa ce am dat submit la form (List)

//        List<WebElement> formLabels = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr/td[1]"));

        //Identificam valorile din coloana Values

        List<WebElement> formValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr/td[2]"));

//        int indexLabel = 0;
//        int indexValue = 0;
//        while (indexLabel < formLabels.size() || indexValue < formValues.size()) {
//            System.out.println("Labelul si Valoare pt indexul " + indexLabel + " este " + formLabels.get(indexLabel).getText() + " - " + formValues.get(indexValue).getText());
//            indexLabel++;
//            indexValue++;
//        }


        String fullName = firstNameValue + " " + lastNameValue;
        String stateCity = state + " " + city;
        String birthDate = formValues.get(4).getText();
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
        Date recordedBirthDate = formatter2.parse(birthDate);
        System.out.println("Recorded Birth Date is: " + recordedBirthDate);

        //Asserts on the submited data

        Assert.assertEquals(formValues.get(0).getText(), fullName);
        Assert.assertEquals(formValues.get(1).getText(), emailNameValue);
        Assert.assertEquals(formValues.get(2).getText(), genderValue);
        Assert.assertEquals(formValues.get(3).getText(), mobileNumberValue);
        Assert.assertEquals(recordedBirthDate, submittedBirthDate);
        //  DateFormat newDate = formValues.get(4).getText(),dateOfBirth);
        Assert.assertEquals(formValues.get(5).getText(), subjectsValue);
        Assert.assertEquals(formValues.get(6).getText(), "");
        Assert.assertEquals(formValues.get(7).getText(), filename);
        Assert.assertEquals(formValues.get(8).getText(), "");
        Assert.assertEquals(formValues.get(9).getText(), stateCity);

        Thread.sleep(1500);
        driver.quit();

    }
}