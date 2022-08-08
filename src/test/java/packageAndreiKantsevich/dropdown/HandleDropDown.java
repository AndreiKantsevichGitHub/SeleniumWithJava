package packageAndreiKantsevich.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropDown {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.opencart.com/index.php?route=account/register");

        WebElement dropdownCountryList = driver.findElement(By.id("input-country"));
        Select countryList = new Select(dropdownCountryList);

        countryList.selectByVisibleText("Denmark");
        countryList.selectByValue("10"); // Argentina
        countryList.selectByIndex(13); /// Australia

        // Selecting option from dropdown without using method
        List<WebElement> allOptions = countryList.getOptions();
        for (WebElement option:allOptions)
        {
            if (option.getText().equals("Cuba"))
            {
                option.click();
                break;
            }
        }
    }
}
