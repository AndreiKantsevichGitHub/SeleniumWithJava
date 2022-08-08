package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class FindElementVsFindElements {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        /*
        SearchContext interface has only two methods
        - findElement()
        - findElements()
        These methods will be abstract as SearchContext is an interface.
        SearchContext interface is inherited by WebElement and WebDriver
        */

        /*
        - findElement() method returns the first matching element  on current page.
        - By - The locating mechanism.
        - If the element is not found then it throws NoSuchElementFoundException
        */

        // findElement() --> Return the single element
        // 1.
        WebElement searchStore = driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        searchStore.sendKeys("XYZ");

        // 2.
        WebElement element = driver.findElement(By.xpath("//*[@class='footer-upper']//a"));
        System.out.println(element.getText());

        // 3.
        WebElement searchButton = driver.findElement(By.xpath("//*[text()='Log in']"));
        searchButton.click();

        /*
         findElements() method returns all the matching elements on the current page,
         and it doesn't throw any exception if the element is not found, instead it will
         return zero elements.
         */

        //findElements() --< Return multiple web elements
        // 1.
        List<WebElement> links = driver.findElements(By.xpath("//*[@class='footer-upper']//a"));
        System.out.println("Number of elements captured: " + links.size()); // Number of links

        for (WebElement link:links) // Name of links
        {
            System.out.println(link.getText());
        }

        // 2.
        List<WebElement> logo = driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println(logo.size()); // 1

        // 3.
        List<WebElement> elements = driver.findElements(By.xpath("//img[contains(title,'Electronics')]"));
        System.out.println(elements.size()); // 0
    }
}
