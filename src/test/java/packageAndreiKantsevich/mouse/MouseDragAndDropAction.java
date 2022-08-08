package packageAndreiKantsevich.mouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropAction {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement rome = driver.findElement(By.xpath("//*[@id='box6']"));
        WebElement italy = driver.findElement(By.id("box106"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(rome, italy).perform();

    }
}
