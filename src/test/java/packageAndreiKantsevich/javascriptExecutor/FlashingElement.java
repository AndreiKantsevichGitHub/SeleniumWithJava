package packageAndreiKantsevich.javascriptExecutor;

import Utils.JavascriptUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FlashingElement {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // Syntax

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(script, args);

        // Flashing Element

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavascriptUtils.flash(logo, driver);
    }
}
