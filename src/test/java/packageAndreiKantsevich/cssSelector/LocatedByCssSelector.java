package packageAndreiKantsevich.cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatedByCssSelector {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.hugedomains.com/payment-plan-login.cfm");
        driver.manage().window().maximize();

        int size = driver.findElements(By.cssSelector("*")).size(); /*This is a wildcard ('*'),
                                                        which will select all elements in the DOM.*/
        System.out.println("The total number of element found in above cssSelector are " + size);

        driver.findElement(By.cssSelector("#hdv3CheckoutFormDomainID")).sendKeys("a@a.com"); /*This ('#') refers to
                                                                    'Id', which will select all element
                                                                    which is having 'Id' Attribute in the DOM.*/

        int sizeRow = driver.findElements(By.cssSelector(".input-row")).size();
        System.out.println(sizeRow);

        WebElement email = driver.findElement(By.cssSelector("input[name='d']"));
                email.sendKeys("b@b.com");

    }
}
