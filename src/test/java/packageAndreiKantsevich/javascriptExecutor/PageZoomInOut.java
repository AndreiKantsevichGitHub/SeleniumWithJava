package packageAndreiKantsevich.javascriptExecutor;

import Utils.JavascriptUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PageZoomInOut {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // Zoom-In Zoom-Out page

        JavascriptUtils.zoomPageByJS(driver);
    }
}
