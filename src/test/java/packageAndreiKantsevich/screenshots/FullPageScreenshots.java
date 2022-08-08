package packageAndreiKantsevich.screenshots;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FullPageScreenshots {

    public static void main(String[] args) throws IOException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        //***   Full page screenshot   ***//

       TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("screenshots/homepage.png");
        FileUtils.copyFile(source, target);

        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        driver.close();
    }
}
