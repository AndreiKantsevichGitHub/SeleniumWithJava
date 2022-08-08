package packageAndreiKantsevich.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class  HandleIFrame {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");

        // First frame
        driver.switchTo().frame("packageListFrame"); // Name of frame
        driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();

        // Second frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();

        // Third frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("//a[normalize-space()='Help']")).click();
    }
}
