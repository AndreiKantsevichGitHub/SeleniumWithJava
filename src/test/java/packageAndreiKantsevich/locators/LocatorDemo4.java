package packageAndreiKantsevich.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorDemo4 {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1200, 800));

        // Absolute path
//        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/input[4]"))
//                .sendKeys("T-shirts");
//        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]"))
//                .click();

        // Relative path
//        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-shirt");
//        driver.findElement(By.xpath("//button[@name='submit_search']")).click();

        //xPath with 'and' & 'or'
//        driver.findElement(By.xpath("//input[@id='search_query_top' and @name='search_query']"))
//                .sendKeys("T-shirt");
//        driver.findElement(By.xpath("//button[@name='submit_searchXXX' or @class='btn btn-default button-search']"))
//                .click();

        // xPath with contains()
//        driver.findElement(By.xpath("//input[contains(@id,'query_top')]"))
//                .sendKeys("T-shirt");
//        driver.findElement(By.xpath("//button[contains(@class,'button-search')]"))
//                .click();

        //xPath with 'starts-with'
//        driver.findElement(By.xpath("//input[starts-with(@id,'search_query')]"))
//                .sendKeys("T-shirt");
//        driver.findElement(By.xpath("//button[starts-with(@name,'submit_')]"))
//                .click();
//
        // xPath with text()
//        driver.findElement(By.xpath("//a[text()='Women']")).click();

        // chained xPath
        driver.findElement(By.xpath("//form[@id='searchbox']//input[@id='search_query_top']"))
                .sendKeys("T-shirt");
        driver.findElement(By.xpath("//form[@id='searchbox']//button[@name='submit_search'] "))
                .click();
    }
}
