

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class BarnsAndNoble {

    public WebDriver driver;

    @Test
    public void automationMethod() throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://www.barnesandnoble.com");

        Thread.sleep(1000);

        driver.manage().window().maximize();

        Thread.sleep(1000);

        Actions actions=new Actions(driver);
        WebElement eBooksMenu = driver.findElement(By.id("rhfCategoryFlyout_eBooks"));
        System.out.println("ebook menu element is: "+eBooksMenu.getAriaRole());
        actions.moveToElement(eBooksMenu)
                .perform();

        List<WebElement> childHeadersList = driver.findElements(By.xpath("//*[a[@id='rhfCategoryFlyout_eBooks']]//div[@class='col-md-3 rhf_cat_item']//div[@class='child_header']"));

        for (int i=0;i<childHeadersList.size();i++){
            String childHeader = childHeadersList.get(i).getText();
            System.out.println("Child Headers for eBook are:"+childHeader);
        }

        List<WebElement> eBooksCatList = driver.findElements(By.xpath("//*[a[@id='rhfCategoryFlyout_eBooks']]//div[@class='col-md-3 rhf_cat_item']//dd[@role='list']"));

        for (int i=0;i<eBooksCatList.size();i++){
            String eBookCat = eBooksCatList.get(i).getText();
            System.out.println("Categories for eBooks by Headers are:"+eBookCat);
        }

        List<WebElement> eBooksList = driver.findElements(By.xpath("//*[a[@id='rhfCategoryFlyout_eBooks']]//div[@class='col-md-3 rhf_cat_item']//dd/a[@role='listitem']"));

        for (int i=0;i<eBooksList.size();i++){
            String eBooksCateg = eBooksList.get(i).getText();
            System.out.println("Categories for eBooks are:"+eBooksCateg);
        }



    }
}
