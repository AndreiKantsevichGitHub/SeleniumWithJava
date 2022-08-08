package packageAndreiKantsevich.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorDemo1 {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1200, 800));

        // id & name locators
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("T-shirts");
        driver.findElement(By.name("submit_search")).click();

        // linkText
        driver.findElement(By.linkText("Printed Chiffon Dress")).click();
//        driver.findElement(By.partialLinkText("Chiffon Dress")).click();
    }
}
