package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


@Tag("browserstack")
public class AndroidSearchTests extends TestBase {

    @Test
    void searchBrowserStackTest() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void searchJavaTest() {
        step("Поиск статьи про Java", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });
        step("Проверка, что хотя бы одна статья есть", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Переход к первой статье", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        step("Проверка, что тест Java есть на странице", () ->
                $(AppiumBy.accessibilityId("Java")));

    }

}