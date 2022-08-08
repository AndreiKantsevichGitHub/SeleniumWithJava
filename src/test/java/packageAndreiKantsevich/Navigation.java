package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Navigation {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.snapdeal.com/"); /* get() is used to navigate particularURL(website)
                                                  and wait till page load.
                                                  get() - accepts only one string parameter */

        driver.navigate().to("https://www.amazon.com/"); /* navigate().to() is used to navigate to
        particular URL and does not wait to page load. It maintains browser history or coolies to navigate back
        or forward.
        navigate().to() - accepts String parameter and URL instance as parameter.
        */

        driver.navigate().back(); // snapdeal
        driver.navigate().forward(); // amazon
        driver.navigate().refresh(); // reload the page

    }
}
