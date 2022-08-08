package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ToolTip {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://jqueryui.com/tooltip/");

        driver.switchTo().frame(0);
        WebElement inputBox = driver.findElement(By.xpath("//*[@id='age']"));
        String toolTipText = inputBox.getAttribute("title");
        System.out.println(toolTipText);
    }
}
