package tests.browserstack;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("browserstack_android")
public class WikipediaTest extends TestBase {

    @Test
    @DisplayName("Ненулевой результат выдачи при поиске")
    void searchTest() {

        step("Переходим в строку поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });

        step("Вводим запрос", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("В выдаче более чем 0 результатов", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @DisplayName("Прочитанная статья добавляется в Историю")
    void historyTest() {

        final String[] article = {new String()};

        step("Открываем статью дня", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_featured_article_card_image")).click();
        });

        step("Сохраняем название статьи", () -> {
            article[0] = $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).text();
        });

        step("Закрываем статью дня", () -> {
            $(byClassName("android.widget.ImageButton")).click();
        });

        step("Открываем Историю", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/icon")).get(2).click();
        });

        step("Просмотренная статья присутствует в Истории", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(size(1));
            $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(Condition.text(article[0]));
        });
    }
}