
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class homePageTests {

    @BeforeClass
    public void setup(){
        Configuration.browser = "chrome";
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
