package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Recursivitate {

    public WebDriver driver;

    @Test
    public void parcurgereListe() throws InterruptedException {

        // deschidem un browser de Chrome
        driver = new ChromeDriver();

        // accesam o pagina web
        driver.get("https://demoqa.com/sortable");

        // punem browser-ul in modul maximize
        driver.manage().window().maximize();

        Thread.sleep(1000);

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");

        Thread.sleep(1000);

        Actions actions=new Actions(driver);
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i=0; i<list.size()-1;i++){

            WebElement webElement=list.get(i);
            WebElement urmatorulElement=list.get(i+1);
            //System.out.println("Numarul elementului este " +webElement.getText());
            System.out.println("urmatorul Webelement este "+urmatorulElement.getText());

            actions.clickAndHold(webElement)
                    .moveToElement(urmatorulElement)
                    .release()
                    .build()
                    .perform();

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
