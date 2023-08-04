package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;


public class TransferPage {

    private final SelenideElement amount = $("[data-test-id = amount] input");
    private final SelenideElement from = $("[data-test-id = from] input");
    private final SelenideElement button = $("[data-test-id = action-transfer]");
    private final SelenideElement cancelButton = $("[data-test-id = action-cancel]");
    private final SelenideElement errorNotification = $("[data-test-id = error-notification]");
    private SelenideElement head = $(withText("Пополнение карты"));

    public TransferPage() {
        head.shouldBe(visible);
    }

    public DashboardPage transferForm(String sum, DataHelper.CardNumber cardNumber) {
        amount.setValue(sum);
        from.setValue(String.valueOf(cardNumber));
        button.click();
        return new DashboardPage();

    }

    public void findErrorMessage(String errorText) {
        errorNotification.shouldBe(visible).shouldHave(exactText(errorText), Duration.ofSeconds(15));
    }

    public DashboardPage cancelButton() {
        cancelButton.click();
        return new DashboardPage();
    }
}
