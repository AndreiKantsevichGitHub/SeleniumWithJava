package packageAndreiKantsevich.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class LocatorDemo7_ShadowDOM {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://shop.polymer-project.org/");
//        driver.manage().window().setSize(new Dimension(1200, 800));

        WebElement root = driver.findElement(By.tagName("shop-app")); // Shadow Host
        WebElement shadowDom1 = getShadowDOM(root, driver);
        WebElement ironPages = shadowDom1.findElement(By.tagName("iron-pages"));
        WebElement shopHome = ironPages.findElement(By.tagName("home"));

        WebElement shadowDom2 = getShadowDOM(shopHome, driver);

        shadowDom2.findElement(By.cssSelector("div:nth-child(3) > shop-button > a")).click();
    }

    static WebElement getShadowDOM(WebElement element, WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement shadowDom1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", element);
        return shadowDom1;
    }
}
