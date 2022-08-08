package packageAndreiKantsevich.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorDemo2 {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1200, 800));

        // className
        int homeSlider = driver.findElements(By.className("homeslider-container")).size();
        System.out.println(homeSlider);

        // tagName
        int links = driver.findElements(By.tagName("a")).size();
        System.out.println(links);
    }
}
