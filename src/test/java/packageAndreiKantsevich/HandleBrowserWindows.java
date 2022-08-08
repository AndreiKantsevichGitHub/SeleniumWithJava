package packageAndreiKantsevich;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleBrowserWindows {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // 1. getWindowHandle()
//        String windowID = driver.getWindowHandle(); // Return ID of the single browser window
//        System.out.println(windowID);

        // 2. getWindowHandles()
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); // Open another browser window - child window
        Set<String> windowIDs = driver.getWindowHandles(); // Return ID of the multiple browser windows

        // First method - Iterator()
//        Iterator<String> it = windowIDs.iterator();
//
//        String parentWindowID = it.next();
//        String childWindowID = it.next();
//
//        System.out.println("Parent window ID: " + parentWindowID);
//        System.out.println("Child window ID: " + childWindowID);

        // Second method - using List/ArrayList
        List<String> windowIDsList = new ArrayList<>(windowIDs); // Converting Set --> List

        String parentWindowID = windowIDsList.get(0); // Parent window ID
        String childWindowID = windowIDsList.get(1); // Child window ID

        System.out.println("Parent window ID: " + parentWindowID);
        System.out.println("Child window ID: " + childWindowID);

        // How to use window ID's for switching
        driver.switchTo().window(parentWindowID);
        System.out.println("Parent window title: " + driver.getTitle()); // OrangeHRM

        driver.switchTo().window(childWindowID);
        System.out.println("Child window title: " + driver.getTitle()); //  HR Management System | HR Management Software | OrangeHRM

        // For...each loop
//        for (String windowID:windowIDsList)
//        {
//            String title = driver.switchTo().window(windowID).getTitle();
//            System.out.println(title);
//        }
//        driver.close(); // Close single browser window driver which pining
//        driver.quit(); // close all the browser windows

        for (String windowID:windowIDsList)
        {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("HR Management System | HR Management Software | OrangeHRM"))
            {
                driver.close();
            }
        }
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.quit();
    }
}
