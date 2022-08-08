package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVsActions {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

//span[2]        driver.get("http://automationpractice.com/index.php");

        WebElement feature = driver.findElement(By.xpath("//a[@title='Women']"));

        Actions actions = new Actions(driver);
//        actions.moveToElement(feature).perform();

        Action action = actions.moveToElement(feature).build();
        action.perform();

    }
}
