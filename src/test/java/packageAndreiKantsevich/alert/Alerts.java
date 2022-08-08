package packageAndreiKantsevich.alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Alert window with input box, capture text from alert
        driver.findElement(By.xpath("//button[text()=\"Click for JS Prompt\"]")).click();

        Alert alertWindow = driver.switchTo().alert();
        System.out.println("The message display on alert: " + alertWindow.getText());

        alertWindow.sendKeys("Welcome!");
        alertWindow.accept();
        String result = driver.findElement(By.id("result")).getText();
        System.out.println(result);

    }
}
