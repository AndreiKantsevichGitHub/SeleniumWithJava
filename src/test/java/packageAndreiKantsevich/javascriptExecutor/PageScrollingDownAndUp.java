package packageAndreiKantsevich.javascriptExecutor;

import Utils.JavascriptUtils;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class PageScrollingDownAndUp {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // Scrolling Down and Up page

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        JavascriptUtils.scrollPageDown(driver);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        JavascriptUtils.scrollPageUp(driver);

    }
}
