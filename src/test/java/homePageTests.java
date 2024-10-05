
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class homePageTests {

    @BeforeClass
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.setCapability("platformName", "LINUX");
        options.setCapability("browserName", "chrome");

        // Set Selenoid options
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        options.setCapability("selenoid:options", selenoidOptions);

        // Set Selenide configuration
        Configuration.browser = "chrome";
        Configuration.remote = "http://localhost:4444/wd/hub"; // URL of your Selenoid server
        Configuration.headless = false; // Set to true if you want headless mode
        Configuration.browserSize = "1366x768"; // Optional, set browser size
        Configuration.browserCapabilities = options;
        Configuration.browserVersion = "128.0";
        // Your test code here
        open("https://opensource-demo.orangehrmlive.com/auth/login");
    }

    @Test
    public void loginTest(){
        open("https://opensource-demo.orangehrmlive.com/auth/login");
        element(byName("username")).shouldBe(Condition.appear, Duration.ofSeconds(10))
                .setValue("Admin");

        element(byName("password")).shouldBe(Condition.appear, Duration.ofSeconds(10))
                .setValue("admin123");

        element(byText("Login")).shouldBe(Condition.appear, Duration.ofSeconds(10))
                .click();
        element(byText(" Login ")).shouldBe(Condition.appear, Duration.ofSeconds(5))
                .click();
    }

    @AfterClass
    public void tearDown(){

    }
}
