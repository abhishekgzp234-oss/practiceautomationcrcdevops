package com.practiceautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidPasswordTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void invalidPassword() {

        // Enter username
        driver.findElement(By.id("username")).sendKeys("student");

        // Enter wrong password
        driver.findElement(By.id("password")).sendKeys("WrongPassword");

        // Click Submit
        driver.findElement(By.id("submit")).click();

        // Verify error message
        String errorMessage = driver.findElement(By.id("error")).getText();

        Assert.assertTrue(
            errorMessage.contains("Your password is invalid!"),
            "Invalid password error message not displayed"
        );
    }
}
