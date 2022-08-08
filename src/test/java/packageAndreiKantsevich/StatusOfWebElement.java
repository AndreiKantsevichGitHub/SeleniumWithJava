package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class StatusOfWebElement {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();

        // isDisplayed(), isEnabled() - search button
        WebElement searchStore = driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        System.out.println("Display status: " + searchStore.isDisplayed());
        System.out.println("Enable status: " + searchStore.isEnabled());

        // isSelected()
        WebElement male = driver.findElement(By.xpath("//*[@id='gender-male']"));
        WebElement female = driver.findElement(By.xpath("//*[@id='gender-female']"));

        male.click();
        System.out.println("Status of male: " + male.isSelected());

//        male.clear();

        female.click();
        System.out.println("Status of female: " + female.isSelected());
    }
}
