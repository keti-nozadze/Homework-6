import Chrome.runner;
import org.testng.annotations.Test;
import org.testng.Assert;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class RoomsHotelCalendar extends runner {
    @Test
    public void mySecondTest () throws InterruptedException {
        $(".menu-toggler__icon").click();
        $(byText("Events Calendar")).click();
        $("#type-button").click();
        $("#ui-id-2").click();
        $("#from").click();
        $(".ui-datepicker-next").scrollIntoView(false).click();
        $(byLinkText("30")).click();
        Assert.assertEquals($("#from").getValue(), "30/06/21");
    }


}
