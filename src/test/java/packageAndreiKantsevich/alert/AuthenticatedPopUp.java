package packageAndreiKantsevich.alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
/*
This is a Basic authentication window used to accept the username and password
with browser alert popup.
We will get this popup when we try access a server resource which requires
authentication.
This popup appears the moment we enter the url in the address bar.
*/
public class AuthenticatedPopUp {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        // Syntax - https://user:password@URL

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
