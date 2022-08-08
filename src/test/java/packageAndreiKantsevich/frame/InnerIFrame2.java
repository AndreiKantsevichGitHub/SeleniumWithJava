package packageAndreiKantsevich.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class InnerIFrame2 {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

        driver.switchTo().frame("iframeResult"); // switch to outer iframe
        driver.switchTo().frame(0);  // switch to inner iframe

        String innerIframeText = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Text present inside the inner frame: " + innerIframeText);

        driver.switchTo().parentFrame(); // go to parent frame/ outer frame
        String outerIframeText =
                driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]"))
                .getText();
        System.out.println("Text present in outer frame: " + outerIframeText);

    }
}
