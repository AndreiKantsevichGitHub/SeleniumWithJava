package packageAndreiKantsevich.dataPickers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DataPickerDropDown {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");

        driver.findElement(By.id("dob")).click();

        Select monthDropDown = new Select(driver.findElement(By.cssSelector("select.ui-datepicker-month")));
        monthDropDown.selectByVisibleText("Mar");

        Select yearDropDown = new Select(driver.findElement(By.cssSelector("select.ui-datepicker-year")));
        yearDropDown.selectByVisibleText("2022");

        String date = "15";
        List<WebElement> allDates = driver.findElements(By.cssSelector("table.ui-datepicker-calendar tbody tr td"));
        for (WebElement dateElement : allDates)
        {
            String day = dateElement.getText();
            if (day.equalsIgnoreCase(date))
            {
                dateElement.click();
                break;
            }
        }
    }
}
