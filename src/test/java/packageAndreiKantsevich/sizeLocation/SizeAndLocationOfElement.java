package packageAndreiKantsevich.sizeLocation;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class SizeAndLocationOfElement {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement logo = driver.findElement(By.xpath("//*[@id='divLogo']//img"));

        // Location - method1
        System.out.println("Location(x,y): " + logo.getLocation());
        System.out.println("Location(x): " + logo.getLocation().getX());
        System.out.println("Location(y): " + logo.getLocation().getY());

        // Location - method2
        System.out.println("Location(x): " + logo.getRect().getX());
        System.out.println("Location(y): " + logo.getRect().getY());

        // Size - method1
        System.out.println("Size(Width,Height): " + logo.getSize());
        System.out.println("Size(Width): " + logo.getSize().getWidth());
        System.out.println("Size(Height): " + logo.getSize().getHeight());

        // Size - method2
        System.out.println("Size(Width): " + logo.getRect().getDimension().getWidth());
        System.out.println("Size(Height): " + logo.getRect().getDimension().getHeight());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.close();
    }
}
