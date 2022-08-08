package packageAndreiKantsevich.javascriptExecutor;

import Utils.JavascriptUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PageRefreshing {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // Refreshing the page

        JavascriptUtils.refreshBrowserByJS(driver);
    }
}
