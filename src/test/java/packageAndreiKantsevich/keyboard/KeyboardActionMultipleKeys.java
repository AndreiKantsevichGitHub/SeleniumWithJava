package packageAndreiKantsevich.keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionMultipleKeys {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://text-compare.com/");

        WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

        input1.sendKeys("Welcome to selenium!");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys( "a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys( "c").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").perform();


        // Compare text
        if (input1.getAttribute("value").equals(input2.getAttribute("value")))
            System.out.println("Text copied");
        else
            System.out.println("Text not copied");
    }
}
