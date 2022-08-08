package packageAndreiKantsevich.keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAction {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(Keys.SPACE).perform();
        actions.sendKeys(Keys.ESCAPE).perform();
    }
}
