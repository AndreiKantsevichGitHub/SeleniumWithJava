package packageAndreiKantsevich.table;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class DynamicWebTableWithPagination {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.opencart.com/admin/");

        // Login
        WebElement username = driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//*[@id='input-password']"));
        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[@type='submit']/i")).click();

        // Sales --> Orders
        driver.findElement(By.xpath("//*[@id='menu-sale']")).click();
        driver.findElement(By.xpath("//a[text()='Orders']")).click();

        // Table
        // 1. Find total number of pages in table
        String text = driver.findElement(By.xpath("//*[@class='col-sm-6 text-right']")).getText();
        System.out.println(text); // Showing 1 to 20 of 9088 (455 Pages)

        /*
        Parses the string argument as a signed decimal integer
        */
        int totalPages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
        System.out.println("Total number of pages: " + totalPages);

        // 2. How many rows exist in each pages
        for (int p = 1; p <= 3; p++)
        {
            WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
            System.out.println("Active page: " + activePage.getText());
            activePage.click();

            int rows = driver.findElements(By.xpath("//*[@id='form-order']/table/tbody/tr")).size();
            System.out.println("Number of rows: " + rows);

//            String pageNumber = Integer.toString(p + 1);
//            driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='"+pageNumber+"']")).click();

            // 3. Read all the rows from each page
            for (int r = 1; r <= rows; r++)
            {
                String orderID = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
                String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
                String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();

                if (status.equals("Pending"))
                {
                    System.out.println(orderID + " | " + customerName + " | " + status + " | ");
                }
            }

            String pageNumber = Integer.toString(p + 1);
            driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='"+pageNumber+"']")).click();
        }
    }
}
