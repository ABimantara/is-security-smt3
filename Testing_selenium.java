package testing_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class Testing_selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
            "C:\\iss_tk3\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);
            System.out.println("Login berhasil!");

            
            List<WebElement> scripts = driver.findElements(By.tagName("script"));
            System.out.println("\n=== File JavaScript dari <script src> ===");
            int i = 1;
            for (WebElement s : scripts) {
                String src = s.getAttribute("src");
                if (src != null && !src.isBlank()) {
                    System.out.println((i++) + ". " + src);
                }
            }

            
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("\n=== Link yang Ditemukan ===");
            int j = 1;
            for (WebElement link : links) {
                String href = link.getAttribute("href");
                if (href != null && !href.isBlank()) {
                    System.out.println((j++) + ". " + href);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

