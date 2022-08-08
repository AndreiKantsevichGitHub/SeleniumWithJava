package packageAndreiKantsevich.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleMultipleDropDown {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

        // Approach 1
//        Select dropdownNoOfEmployees = new Select(driver.findElement(By.name("NoOfEmployees")));
//        dropdownNoOfEmployees.selectByVisibleText("16 - 20");
//        Select dropdownIndustry = new Select(driver.findElement(By.name("Industry")));
//        dropdownIndustry.selectByVisibleText("Aerospace");
//        Select dropdownCountry = new Select(driver.findElement(By.name("Country")));
//        dropdownCountry.selectByVisibleText("Canada");


        // Approach 2
        WebElement noOfEmployees = driver.findElement(By.name("NoOfEmployees"));
        selectOptionFromDropDown(noOfEmployees, "21 - 25");
        WebElement industry = driver.findElement(By.name("Industry"));
        selectOptionFromDropDown(industry, "Automotive");
        WebElement country = driver.findElement(By.name("Country"));
        selectOptionFromDropDown(country, "Australia");
    }

    public static void selectOptionFromDropDown(WebElement element, String value)
    {
        Select dropDown = new Select(element);

        List<WebElement> allOptions = dropDown.getOptions();
        for (WebElement option:allOptions)
        {
            if (option.getText().equals(value))
            {
                option.click();
                break;
            }
        }
    }
}
