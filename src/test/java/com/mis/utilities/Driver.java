package com.mis.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;
import java.util.Collections;

public class Driver {

    private Driver() {}

    public static WebDriver driver;
    //private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver get() {

        if(driver == null) {

            String browser = ConfigurationReader.get("browser" );

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                 //  driver = new ChromeDriver();

                    ChromeOptions options1 = new ChromeOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    //driver = new ChromeDriver(options1);


                    /* Location   */
                    options1.addArguments("start-maximized");
                    options1.addArguments("test-type");
                    options1.addArguments("enable-strict-powerful-feature-restrictions");
                    options1.addArguments("disable-geolocation");
                 //   cap.setCapability(ChromeOptions.CAPABILITY, options);
                   // cap = cap.merge(DesiredCapabilities.chrome());
                    driver = new ChromeDriver(options1);

                   break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");  //should be edited for new chrome version
                   // options.addArguments("--headless");
                    options.addArguments("--headless=new");


                    /* Location   */
                    options.addArguments("start-maximized");
                    options.addArguments("test-type");
                    options.addArguments("enable-strict-powerful-feature-restrictions");
                    options.addArguments("disable-geolocation");

                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

            }
        }

        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }


}
