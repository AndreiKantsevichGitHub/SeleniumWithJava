package packageAndreiKantsevich.cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Set;

public class HandlingCookies {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // How to capture cookies from browser
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies: " + cookies.size());

        // how to print cookies from browser?
        for (Cookie cookie:cookies) /* Cookie cookie -
                                    pre-defined class and type of variable.
       All the functionality of java comes from these predefined classes only.
       These classes provide functionality like scanner, buffered reader , arraylist etc.*/
        {
            System.out.println(cookie.getName()+ " : " + cookie.getValue());
        }

        // How to add cookie to browser?
        Cookie cookieObj = new Cookie("MyCookie123", "123456");
        driver.manage().addCookie(cookieObj);
        cookies = driver.manage().getCookies();
        System.out.println("Size of cookies after adding: " + cookies.size());

        // How to delete specific Cookie from the browser?
//        driver.manage().deleteCookie(cookieObj);
        driver.manage().deleteCookieNamed("MyCookie123");
        cookies = driver.manage().getCookies();
        System.out.println("Size of cookies after deletion : " + cookies.size());

        // How to delete all cookies from the browser?
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        System.out.println("Size of cookies after all deletion : " + cookies.size());
    }
}
