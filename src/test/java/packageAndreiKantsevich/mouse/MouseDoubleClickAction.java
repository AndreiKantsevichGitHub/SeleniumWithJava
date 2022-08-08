package packageAndreiKantsevich.mouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClickAction {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");

       driver.switchTo().frame("iframeResult");
       WebElement field1 = driver.findElement(By.xpath("//*[@id='field1']"));
       field1.clear();
       field1.sendKeys("Welcome to Selenium!");

       WebElement button =  driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
       Actions actions = new Actions(driver);
       actions.doubleClick(button).perform(); // Perform the double click action
    }
}
