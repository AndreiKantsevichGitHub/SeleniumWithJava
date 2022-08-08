package packageAndreiKantsevich.screenshots;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ElementOnThePageScreenshots {

    public static void main(String[] args) throws IOException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        //***   Screenshot of element on the page   ***//

        WebElement element =  driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File source = element.getScreenshotAs(OutputType.FILE);
        File target = new File("screenshots/imagesLogo.png");
        FileUtils.copyFile(source, target);

        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        driver.close();
    }
}
