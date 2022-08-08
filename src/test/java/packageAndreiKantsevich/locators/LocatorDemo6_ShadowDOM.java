package packageAndreiKantsevich.locators;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class LocatorDemo6_ShadowDOM {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://books-pwakit.appspot.com/");
//        driver.manage().window().setSize(new Dimension(1200, 800));

        WebElement root = driver.findElement(By.tagName("book-app")); // Shadow Host

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);

        WebElement appHeader = shadowDom.findElement(By.tagName("app-header"));
        WebElement appToolBar = appHeader.findElement(By.tagName("app-toolbar.toolbar-bottom"));
        WebElement bookInputDecorator = appToolBar.findElement(By.tagName("book-input-decorator"));

        bookInputDecorator.findElement(By.cssSelector("input#input")).sendKeys("Testing");
    }
}
