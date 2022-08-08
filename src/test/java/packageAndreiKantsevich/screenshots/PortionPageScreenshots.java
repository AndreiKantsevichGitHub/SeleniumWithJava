package packageAndreiKantsevich.screenshots;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PortionPageScreenshots {

    public static void main(String[] args) throws IOException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        //***   Screenshot of section/portion of the page   ***//

        WebElement section =  driver.findElement(By.cssSelector("div.product-grid.home-page-product-grid"));
        File source = section.getScreenshotAs(OutputType.FILE);
        File target = new File("screenshots/featuredProducts.png");
        FileUtils.copyFile(source, target);

        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        driver.close();
    }
}
