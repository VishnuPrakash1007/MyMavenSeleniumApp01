package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {

    public static void main(String[] args) {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Configure Chrome for Jenkins (headless mode)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");   // modern headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            // Perform login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Small validation (optional but good practice)
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("inventory")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always quit driver
            driver.quit();
        }
    }
}
