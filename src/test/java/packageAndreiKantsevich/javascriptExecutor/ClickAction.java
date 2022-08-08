package packageAndreiKantsevich.javascriptExecutor;

import Utils.JavascriptUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ClickAction {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // Click action

        WebElement link = driver.findElement(By.xpath("//a[text()='Register']"));
        JavascriptUtils.clickElementByJS(link, driver);
    }
}
