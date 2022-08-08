package packageAndreiKantsevich.alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class PermissionPopUpNotifications {

    public static void main(String[] args) {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options);

        driver.get("https://www.redbus.in/");

    }
}
