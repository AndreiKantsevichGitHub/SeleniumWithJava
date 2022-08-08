package packageAndreiKantsevich.javascriptExecutor;

import Utils.JavascriptUtils;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class GenerateAlert {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // Generate alert

        JavascriptUtils.generateAlert(driver, "This is my alert...");
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.switchTo().alert().accept();
    }
}
