package packageAndreiKantsevich.downloadUploadFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile {

    public static void main(String[] args) throws AWTException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.monsterindia.com/");
        driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();

        // Using sendKeys(
//        driver.findElement(By.xpath("//*[@id='file-upload']"))
//                .sendKeys("C:\\Users\\PC A\\IdeaProjects\\SeleniumWithJava\\downloads_uploads\\file-sample_100kB.doc");

        // Using Robot class methods
        WebElement button = driver.findElement(By.xpath("//*[@id='file-upload']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button); /* JS approach.
                                                             Click action (post-parameter) on the button */
        /*
        1. Copy the path
        2. CTRL + V
        3. Enter
         */
        Robot robot = new Robot();
        robot.delay(2000);
        // Put path to file in a clipboard
        StringSelection stringSelection = new StringSelection("C:\\Users\\PC A\\IdeaProjects\\SeleniumWithJava" +
                "\\downloads_uploads\\file-sample_100kB.doc");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        // CTRL + V
        robot.keyPress((KeyEvent.VK_CONTROL));
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        // ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
