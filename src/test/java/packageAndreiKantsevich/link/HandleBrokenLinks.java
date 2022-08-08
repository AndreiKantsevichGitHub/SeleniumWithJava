package packageAndreiKantsevich.link;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleBrokenLinks {

    public static void main(String[] args) throws IOException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        int brokenLinks = 0;
        for (WebElement element:links)
        {
            String url = element.getAttribute("href");
            if (url == null || url.isEmpty())
            {
                System.out.println("URL is empty");
                continue;
            }

            URL link = new URL(url);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() >= 400)
                {
                    System.out.println(httpURLConnection.getResponseCode() + url + " is" + " Broken link");
                    brokenLinks++;
                }
                else
                {
                    System.out.println(httpURLConnection.getResponseCode() + url + " is" + " Valid link");
                }

            } catch (Exception ignored) {
            }
        }

        System.out.println("Number of broken links: " + brokenLinks);
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        driver.quit();
    }
}
