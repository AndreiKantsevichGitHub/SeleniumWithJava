package packageAndreiKantsevich.link;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class HandleLinks {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://amazon.in/");
        driver.manage().window().maximize();

        // linkText() & partialLinkText()
//        driver.findElement(By.linkText("Today's Deals")).click();
//        driver.findElement(By.partialLinkText("Deals")).click();

        // How to capture all the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links present: " + links.size());

        // Normal for  loop
//        for (int i = 0; i < links.size(); i++)
//        {
//            System.out.print(links.get(i).getText());
//            System.out.println(links.get(i).getAttribute("href"));
//        }

        for (WebElement link : links) {
            System.out.print(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }
}
