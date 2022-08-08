package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class getTextVsgetAttributeValue {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://admin-demo.nopcommerce.com/login");

        WebElement emailInputBox = driver.findElement(By.id("Email"));
        emailInputBox.clear();
        emailInputBox.sendKeys("admin123@gmail.com");

        // Capturing text from inputBox
        System.out.println("Result from getAttribute() method: " + emailInputBox.getAttribute("value")); /* The getAttribute() method
        fetches the text contained by an attribute in a html document. */
        System.out.println("Result from getText() method: " + emailInputBox.getText()); /* Necessarily presence
        of inner text. the getText() method returns the innerText of an element.*/

        // Login button
        WebElement button = driver.findElement(By.xpath("//button[text()='Log in']"));

        System.out.println(button.getAttribute("type"));
        System.out.println(button.getAttribute("class"));
        System.out.println(button.getText());

        String title = driver.findElement(By.tagName("h1")).getText();
        System.out.println(title);
    }
}
