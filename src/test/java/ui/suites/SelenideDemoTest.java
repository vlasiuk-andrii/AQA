package ui.suites;

//import com.codeborne.selenide.Configuration;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static com.codeborne.selenide.CollectionCondition.texts;
//import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Selenide.*;
//
//public class SelenideDemoTest {
//
//    @Test
//    public void test1(){
//        Configuration.browser = "ie";
//
//        open("https://www.lambdatest.com/");
//        $(".nav>li.login>a").click();
//        Assert.assertEquals("Sign up for free | Cross Browser Testing Tool | LambdaTest - LambdaTest", title());
//        $(".signup-titel").shouldHave(text("SIGN UP"));
//        $(By.name("organization_name")).val("org");
//        $(By.name("name")).sendKeys("Name");
//        $(By.name("email")).sendKeys("test@gmail.com");
//        $(By.name("password")).sendKeys("test1234");
//        $(By.name("phone")).val("13452").pressEnter();
//        $$(".error-mass").shouldHave(
//                texts("This email is already registered",
//                        "Please enter a valid Phone number",
//                        "To proceed further you must agree to our Terms of Service and Privacy Policy"));
//    }
//}
