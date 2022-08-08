package packageAndreiKantsevich.dataPickers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class DataPicker {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.redbus.in/");

        driver.findElement(By.xpath("//input[@id='onward_cal']")).click(); // Open the date picker

        String year = "2022";
        String month = "Dec";
        String day = "10";
        while(true)
        {
            String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
            String[] arr = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equals(year))
                break;
            else
                driver.findElement(By.cssSelector("td.next button")).click();
        }

        // Date selection
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
        for (WebElement element:allDates)
        {
            String date = element.getText();
            if (date.equals(day))
            {
                element.click();
                break;
            }
        }
    }
}
