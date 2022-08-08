package packageAndreiKantsevich.dropdown;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoSuggestDropDown_GoogleSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("java tutorial");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        List<WebElement> list = driver.findElements(By.xpath("//*[@class='sbct']//*[@role='option']//span"));
        System.out.println("Size of Auto suggestions: " + list.size());

        for (WebElement listItem : list)
        {
            if (listItem.getText().contains("beginners"))
            {
                listItem.click();
                break;
            }
        }
    }
}
