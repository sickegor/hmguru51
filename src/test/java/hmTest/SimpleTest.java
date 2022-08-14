package hmTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.collections.ItemWithText;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {
    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void openHover () {
        open("https://github.com/");
        $(byText("Pricing")).hover();
        $(byText("Compare plans")).click();
        $("h1.h2-mktg").shouldHave(text("Choose the plan that’s right for you."));

    }

    @Test
    void useDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // перенести прямоугольник А на место В
        //sleep(5000);
        $("#column-a").dragAndDropTo("#column-b");

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        //sleep(5000);
    }

    @AfterAll
    static void closing() {
        closeWebDriver();
    }
}
