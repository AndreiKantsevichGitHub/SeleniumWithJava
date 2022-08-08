package packageAndreiKantsevich.sizeLocation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ManageBrowserWindow {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // FullScreen and Maximize the Browser Window
//        driver.manage().window().fullscreen();
//        driver.manage().window().maximize();
//
        // set and get Position of browser window
//        driver.manage().window().setPosition(new Point(400, 200));
//
//        Point point = driver.manage().window().getPosition();
//        System.out.println(point);
//
        //get and set the size of browser window
        driver.manage().window().setSize(new Dimension(400, 200));

        Dimension dimension = driver.manage().window().getSize();
        System.out.println(dimension);
    }
}
