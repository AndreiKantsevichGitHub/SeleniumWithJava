package packageAndreiKantsevich.locators;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class LocatorDemo5_XPathAxes {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://money.rediff.com/gainers/bse/daily/group");
        driver.manage().window().setSize(new Dimension(1200, 800));

                                     /* xPath Axes */
        // self
        String text = driver.findElement(By.xpath("//a[contains(text(),'India Tourism De')]/self::a")).getText();
        System.out.println(text);

        // parent
        String textP = driver.findElement(By.xpath("//a[contains(text(),'India Tourism De')]/parent::td")).getText();
        System.out.println(textP);

        // child
        List<WebElement> sizeChild = driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/child::td"));
        System.out.println("Number of child elements: " + sizeChild.size());

        // ancestor
        String textA = driver.findElement(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr")).getText();
        System.out.println(textA);

        // descendant
        List<WebElement> descendants = driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/descendant::*"));
        System.out.println("Number of descendants nodes: " + descendants.size());

        // following - Select everything in the document after the closing tag if the current node
        List<WebElement> followingNodes = driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/following::*"));
        System.out.println("Number of following nodes: " + followingNodes.size());

        // preceding - Select all nodes that appear before the current node in the document
        List<WebElement> precedingNodes = driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/preceding::tr"));
        System.out.println("Number of preceding nodes: " + precedingNodes.size());

        // preceding-sibling  - Selects all siblings before the current node
        List<WebElement> precedingSiblingNodes = driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/preceding-sibling::tr"));
        System.out.println("Number of preceding-sibling nodes: " + precedingSiblingNodes.size());

        // close tab
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
        driver.close();

        // New Address
        driver.get("https://www.facebook.com/r.php");
        driver.manage().window().setSize(new Dimension(1200, 800));

        // 1. Find the sign-up button from the registration form present in the Facebook application. (child)
        driver.findElement(By.xpath("//div[@id='reg_form_box']/child::div[10]/button"));

        // 2. Locate Firstname field from SignUp button in facebook (parent)
        driver.findElement(By.xpath("//button[@id='u_0_10_kX']/parent::*/parent::*/child::div[1]/div/div[1]"));

        // 3. Identify the Password from Mobile number filed in facebook (following)
        driver.findElement(By.xpath("//input[@id='u_0_o_yv']/following::div[8]"));

        // 4. Locate 'Mobile number' field from 'New password' field in facebook (preceding)
        driver.findElement(By.xpath("//input[@id='password_step_input']/preceding::input[2]"));

        // 5. Locate surname from female radio button in facebook (ancestor)
        driver.findElement(By.xpath("//label[@for='u_0_6_be']/ancestor::div[2]/div[1]/div/div[2]"));
        driver.findElement(By.xpath("//label[@for='u_0_6_be']/ancestor::div[2]//input[@id='u_0_l_uh']"));

        // 6. Identify the search text box from the Google search button present in the Google search home page (parent)
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']/parent::*/parent::*/parent::*/div[1]"));

        // 7. Identify the Today's Deal link from the amazon search test box present in the amazon home page
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/following::a[normalize-space()='Today's Deals']"));

        // 8. Identify the Hello, Sign in link from the amazon search test box present in the amazon home page
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/following::span[@id='nav-link-accountList-nav-line-1']"));

        // 9. Identify Mobile link which is part of Menu bar - Amazon (descendant)
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//div[@id='nav-xshop']/descendant::a[2]")); // v.1
        driver.findElement(By.xpath("//div[@id='nav-xshop']/descendant::a[contains(text(),'Mobiles')]")); // v.2
    }
}
