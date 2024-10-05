
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class homePageTests {

    @BeforeClass
    public void setup(){
        Configuration.browser = "chrome";
//        Configuration.headless = true; // Enable headless mode
        Configuration.browserSize = "1366x768"; // Set a specific window size
//        Configuration.remote = "http://localhost:4444/wd/hub"; // If using a remote WebDriver
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
        element(byText(" Login ")).shouldBe(Condition.appear, Duration.ofSeconds(10))
                .click();
    }
}
