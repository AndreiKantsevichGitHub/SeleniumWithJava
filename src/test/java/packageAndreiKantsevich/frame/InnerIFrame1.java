package packageAndreiKantsevich.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class InnerIFrame1 {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("http://demo.automationtesting.in/Frames.html");

        driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();

        WebElement outerFrame = driver.findElement(By.xpath("//div[@id='Multiple']/iframe"));
        driver.switchTo().frame(outerFrame);

        WebElement innerFrame = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(innerFrame);

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        textBox.sendKeys("Welcome!");
    }
}
