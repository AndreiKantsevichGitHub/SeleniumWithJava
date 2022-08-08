package packageAndreiKantsevich.mouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropImages {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement item1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
        WebElement item2 = driver.findElement(By.cssSelector("[alt='The chalet at the Green mountain lake']"));
        WebElement trash = driver.findElement(By.id("trash"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(item1, trash).perform();
        actions.dragAndDrop(item2, trash).perform();
    }
}
