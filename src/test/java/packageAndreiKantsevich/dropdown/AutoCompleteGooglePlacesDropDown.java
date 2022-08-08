package packageAndreiKantsevich.dropdown;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoCompleteGooglePlacesDropDown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();

        WebElement searchBox = driver.findElement(By.id("autocomplete"));
        searchBox.clear();
        searchBox.sendKeys("Toronto");

        String text;
        do
        {
            searchBox.sendKeys(Keys.ARROW_DOWN);
            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

            text = searchBox.getAttribute("value");

            if (text.equals("Toronto, OH, USA"))
            {
                searchBox.sendKeys(Keys.ENTER);
                break;
            }
        }
        while (!text.isEmpty());
    }
}
