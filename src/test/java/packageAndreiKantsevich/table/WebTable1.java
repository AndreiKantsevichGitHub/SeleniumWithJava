package packageAndreiKantsevich.table;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class WebTable1 {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

        // 1. How many rows in table
        int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
        System.out.println("Total number of rows in table: " + rows);

        // 2. How many columns in a table
        int columns = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th")).size();
        System.out.println("Total number of columns in table: " + columns);

        // 3. Retrieve the specific row/column data
        String specificLanguage = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[2]/td[1]")).getText();
        System.out.println("The specific language is: " + specificLanguage);

        // 4. Retrieve all the data from the table
        for (int r = 1; r <= rows; r++)
        {
            for (int c = 1; c <= columns; c++)
            {
                String data = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td["+c+"]")).getText();
                System.out.print(data + " | ");
            }
            System.out.println();
        }

        // 5. Print Release Data, VersionNumber of Java Language of Selenium
        for (int r = 1; r <= rows; r++)
        {
            String language = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[1]")).getText();
            if (language.equals("Java"))
            {
                String releaseData = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[2]/td[3]")).getText();
                String betaVersion = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[2]/td[4]")).getText();
                System.out.println(language + " | " + releaseData + " | " + betaVersion);
            }
        }

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.quit();
    }
}
