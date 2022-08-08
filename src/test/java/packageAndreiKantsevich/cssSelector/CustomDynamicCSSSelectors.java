package packageAndreiKantsevich.cssSelector;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class CustomDynamicCSSSelectors {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://app.hubspot.com/login");
        driver.manage().window().setSize(new Dimension(1200, 800));

        // 1. id --> htmlTag #id, 2. htmlTag [id='value']
        driver.findElement(By.cssSelector("#username")).sendKeys("a@a.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("1234");

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);

        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);


        // 3. class --> htmlTag .className
        driver.findElement(By.cssSelector(".login-email")).sendKeys("b@b.com");
        WebElement enterPassword = driver.findElement(By.cssSelector(".login-password"));
        enterPassword.sendKeys("999");

        // 4. css with two attribute
        driver.findElement(By.cssSelector("*[id='username'][type='email']"))
                .sendKeys(Keys.CONTROL +"A", Keys.BACK_SPACE);

        // 5. contains the text in css
        driver.findElement(By.cssSelector("input[id*='pass']")).sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);

        // 6. starting the text in css
        driver.findElement(By.cssSelector("*[id^='user']")).sendKeys("c@c.com");

        // 7. ending the text in css
        driver.findElement(By.cssSelector("*[id$='word']"))
                .sendKeys("888");

        // 8. comma in css
//        driver.findElement(By.cssSelector("div.private-form__input-wrapper, input#username"));


//        -- New address
        driver.get("https://guide.blazemeter.com/hc/en-us");

        // 9. first-of-type in class
        driver.findElement(By.cssSelector("ul#categories>li:first-of-type"));

        // 10. last-of-type in class
        driver.findElement(By.cssSelector("ul#categories>li:last-of-type")).click();

        // 11. nth-of-type in class
        driver.findElement(By.cssSelector("ul#categories>li:nth-of-type(12)")).click();
        driver.findElement(By.cssSelector("ul#categories>li:nth-of-type(n)")).click(); //-- all

        // 12. sibling of element
        driver.findElement(By.cssSelector("ul#categories>li:nth-of-type(12) + li")).click();

        // 13. not operator in css
        driver.get("https://app.hubspot.com/login"); //-- New address
        driver.findElement(By.cssSelector("input.form-control.private-form__control:not(.login-password)"))
                .sendKeys("d@d.com");

    }
}
