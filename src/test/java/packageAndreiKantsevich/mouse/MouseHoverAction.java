package packageAndreiKantsevich.mouse;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHoverAction {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        WebElement dropDownsMenu = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement macItem = driver.findElement(By.xpath("//a[text()='Mac (1)']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(dropDownsMenu).moveToElement(macItem).click().perform();

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.quit();
    }
}
