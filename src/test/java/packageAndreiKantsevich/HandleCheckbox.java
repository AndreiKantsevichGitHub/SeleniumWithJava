package packageAndreiKantsevich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleCheckbox {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://itera-qa.azurewebsites.net/home/automation");

        // 1. Select specific check box
//        driver.findElement(By.id("monday")).click(); // Monday

        // 2. Select all checkbox
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("Total Number of checkboxes: " + checkboxes.size());

        // Using for loop
//        for (int i = 0; i < checkboxes.size(); i++)
//        {
//            checkboxes.get(i).click();
//        }

        // Using for...each loop
//        for (WebElement checkbox:checkboxes)
//        {
//            checkbox.click();
//        }

        // 3. Selecting multiple check boxes by choice (Monday & Sunday)
//        for (WebElement checkbox:checkboxes)
//        {
//            String checkboxName = checkbox.getAttribute("id");
//            if (checkboxName.equals("monday") || checkboxName.equals("sunday"))
//            {
//                checkbox.click();
//            }
//        }

        // 4. Select last 2 check boxes
        // (7 -2 = 5 : Total number of check boxes - Number of check boxes want to select = Starting index)
        int totalCheckboxes = checkboxes.size();
//        for (int i = totalCheckboxes - 2; i < totalCheckboxes; i++)
//        {
//            checkboxes.get(i).click();
//        }

        // 5. select first 3 check boxes
        for (int i = 0; i < totalCheckboxes; i++)
        {
            if (i < 3)
            {
                checkboxes.get(i).click();
            }
        }
    }
}
