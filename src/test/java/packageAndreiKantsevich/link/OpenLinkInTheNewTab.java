package packageAndreiKantsevich.link;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenLinkInTheNewTab {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        String tab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.cssSelector("div.header-links > ul > li:nth-child(1) > a")).sendKeys(tab);

    }
}
