package com.practiceautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptyUsernameTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void emptyUsername() {

        // Username empty chhodna
        driver.findElement(By.id("username")).clear();

        // Password enter karna
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Submit
        driver.findElement(By.id("submit")).click();

        // Error message verify
        String errorMessage = driver.findElement(By.id("error")).getText();
        System.out.println("ACTUAL ERROR: " + errorMessage);

        Assert.assertTrue(
                errorMessage.contains("Your username is invalid!"),
                "Username error message not displayed"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
