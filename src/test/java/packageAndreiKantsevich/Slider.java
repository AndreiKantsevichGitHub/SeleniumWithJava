package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        WebElement min_slider = driver.findElement(By.cssSelector("#slider-range > span:nth-child(2)"));
        System.out.println("Location of the min slider: " + min_slider.getLocation()); // (59, 250)
        System.out.println("Height & width of the element: " + min_slider.getSize()); // (22, 21)

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(min_slider, 100, 0).perform();
        System.out.println("Location of the min slider: " + min_slider.getLocation()); // (158, 250)
        System.out.println("Height & width of the element: " + min_slider.getSize());

        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
        actions.dragAndDropBy(max_slider, -100, 0).perform();
        System.out.println("Location of the max slider: " + max_slider.getLocation()); // (270, 250)
    }
}
