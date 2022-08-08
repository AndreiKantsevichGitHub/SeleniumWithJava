package packageAndreiKantsevich.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BootstrapDropDown {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.hdfcbank.com/");

        // Product type
        driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
        List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
        System.out.println("Number of options: " + productTypes.size());

        for (WebElement type : productTypes) {
            if (type.getText().equals("Accounts")) {
                type.click();
                break;
            }
        }

        // Product
        driver.findElement(By.xpath("//div[@class='drp2']")).click();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
        System.out.println("Number of options: " + products.size());
        selectOptionFromDropDown(products, "Salary Accounts");
    }


    public static void selectOptionFromDropDown(List<WebElement> options, String value) {

            for (WebElement option:options)
                if (option.getText().equals(value))
                {
                    option.click();
                    break;
                }
        }
    }

