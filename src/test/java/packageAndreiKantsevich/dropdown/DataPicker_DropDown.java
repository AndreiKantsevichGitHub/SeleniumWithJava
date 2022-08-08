package packageAndreiKantsevich.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DataPicker_DropDown {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");

        driver.findElement(By.xpath("//*[@id='dob']")).click(); // Open the date picker

        // Month & year selection
        Select monthDropDown = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")));
        monthDropDown.selectByVisibleText("Oct");

        Select yearDropDown = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")));
        yearDropDown.selectByVisibleText("1990");

        // Date selection
        String day = "15";
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
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
