package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

    public static void main(String[] args) {

        // Chrome browser
//        System.setProperty("webdriver.chrome.driver", "C:\\.........");
//        WebDriver driver = new ChromeDriver();

        // Firefox browser
//        System.setProperty("webdriver.gecko.driver", "C:\\.........");
//        WebDriver driver = new FirefoxDriver();

        // Edge browser
//        System.setProperty("webdriver.edge.driver", "C:\\.........");
//        WebDriver driver = new ChromeDriver();

                     // *** WebDriverManager *** //

        // Chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        // Firefox browser
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();

        // Edge browser
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://frontend.nopcommerce.com/");

        System.out.println("Title of web page is: " + driver.getTitle());
        System.out.println("Current URL of web page is: " + driver.getCurrentUrl());
        System.out.println("Page source of web page is: " + driver.getPageSource());
    }
}
