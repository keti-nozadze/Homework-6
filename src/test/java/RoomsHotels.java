import Chrome.runner;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class RoomsHotels extends runner {
    @Test
    public void myFirstTest() throws InterruptedException {
        $(byText("Welcome to Georgia")).waitUntil(Condition.visible,3000);
        $(".header__top__nav" ).$(byText("Tbilisi")).click();
        String expectedResult = "Old City. New City.".toUpperCase();

        $(byText("Tbilisi")).shouldBe(Condition.visible);
        $(byText("Kazbegi")).shouldBe(Condition.visible);
        $(byText("Kokhta")).shouldBe(Condition.visible);

        $(".module-intro__headline").shouldHave(Condition.text("Old City. New City."));
        $(byText("#Tbilisi")).shouldBe(Condition.visible);

        $(byText("Kazbegi")).click();
        $(".module-intro__headline").shouldHave(Condition.text("I woke up like this"));
        $(".module-intro__text-container").$(By.tagName("h3")).shouldHave(Condition.text("#Kazbegi"));

        Assert.assertEquals("#Kazbegi", $(".module-intro__text-container").$(By.tagName("h3")).getText());
        $(byText("Kokhta")).hover();
        $(byText("Tbilisi")).shouldBe(Condition.visible);
        $(".header__top__submenu", 2).shouldHave(Condition.text("Rooms Overview"));
    }
}
