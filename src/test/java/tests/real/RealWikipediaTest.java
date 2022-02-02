package tests.real;

import io.appium.java_client.MobileBy;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

@Tag("real_android")
public class RealWikipediaTest extends RealTestBase {

    @Test
    @DisplayName("При старте приложения отображаются 4 экрана Getting started")
    void gettingStartedScreens() {
        final String firstScreenTitleName = "The Free Encyclopedia …in over 300 languages";
        final String secondScreenTitleName = "New ways to explore";
        final String thirdScreenTitleName = "Reading lists with sync";
        final String fourthScreenTitleName = "Send anonymous data";

        WebElement firstScreenTitle = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"));
        WebElement secondScreenDotNavigation = $(MobileBy.id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).$$(MobileBy.className("android.widget.LinearLayout")).get(1);
        WebElement thirdScreenDotNavigation = $(MobileBy.id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).$$(MobileBy.className("android.widget.LinearLayout")).get(2);
        WebElement fourthScreenDotNavigation = $(MobileBy.id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).$$(MobileBy.className("android.widget.LinearLayout")).get(3);

        WebElement secondScreenTitle = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"));
        WebElement thirdScreenTitle = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"));
        WebElement fourthScreenTitle = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"));

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(firstScreenTitle.getText().equals(firstScreenTitleName));
        secondScreenDotNavigation.click();
        softly.assertThat(secondScreenTitle.getText().equals(secondScreenTitleName));
        thirdScreenDotNavigation.click();
        softly.assertThat(thirdScreenTitle.getText().equals(thirdScreenTitleName));
        fourthScreenDotNavigation.click();
        softly.assertThat(fourthScreenTitle.getText().equals(fourthScreenTitleName));
        softly.assertAll();
    }
}