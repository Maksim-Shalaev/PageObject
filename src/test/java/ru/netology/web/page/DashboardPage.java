package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private final String balanceFinish = " р.";
  private SelenideElement head = $("[data-test-id = dashboard]");
  private SelenideElement firstCard = $$(".list__item").first();
  private SelenideElement secondCard = $$(".list__item").last();
  private SelenideElement firstCardButton = $$("[data-test-id = action-deposit]").first();
  private SelenideElement secondCardButton = $$("[data-test-id = action-deposit]").last();
  private String balanceStart = "баланс: ";

  public DashboardPage() {
    head.shouldBe(visible);
  }

  public TransferPage firstCardButton() {
    firstCardButton.click();
    return new TransferPage();
  }

  public TransferPage secondCardButton() {
    secondCardButton.click();
    return new TransferPage();
  }

  private int extractBalanceCard(String text) {
    val start = text.indexOf(balanceStart);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);
  }

  public int getFirstCardBalance() {
    val text = firstCard.text();
    return extractBalanceCard(text);
  }

  public int getSecondCardBalance() {
    val text = secondCard.text();
    return extractBalanceCard(text);
  }
}
