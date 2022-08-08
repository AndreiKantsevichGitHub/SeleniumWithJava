package packageAndreiKantsevich.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorDemo3 {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().window().setSize(new Dimension(1200, 800));

        // Tag & ID
//        driver.findElement(By.cssSelector("input#email")).sendKeys("David");
//        driver.findElement(By.cssSelector("#email")).sendKeys("David");

        // Tag & Class
//        driver.findElement(By.cssSelector("input.inputtext")).sendKeys("John");
//        driver.findElement(By.cssSelector(".inputtext")).sendKeys("John");

        // Tag & attribute
//        driver.findElement(By.cssSelector("[data-testid='royal_email']")).sendKeys("Smith");
//        driver.findElement(By.cssSelector(".inputtext[data-testid='royal_email']")).sendKeys("Smith");

        // Tag, class & attribute
        driver.findElement(By.cssSelector("input.inputtext[data-testid='royal_email']")).sendKeys("Andy");
        driver.findElement(By.cssSelector("input.inputtext[data-testid='royal_pass']")).sendKeys("Andy");

    }
}
