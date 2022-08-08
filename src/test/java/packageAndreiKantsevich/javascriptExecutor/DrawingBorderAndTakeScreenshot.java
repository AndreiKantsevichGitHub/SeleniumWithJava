package packageAndreiKantsevich.javascriptExecutor;

import Utils.JavascriptUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;

public class DrawingBorderAndTakeScreenshot {

    public static void main(String[] args) throws IOException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // Drawing border & take screenshot of the Element

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavascriptUtils.drawBorder(logo, driver);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("screenshots/logo.png");
        FileUtils.copyFile(source, target);
    }
}
