package ru.netology.web.data;

import lombok.Value;
import org.checkerframework.checker.units.qual.C;

import java.util.Random;

public class DataHelper {
  private DataHelper() {}

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  public static AuthInfo getAuthInfo() {
    return new AuthInfo("vasya", "qwerty123");
  }

  public static AuthInfo getOtherAuthInfo(AuthInfo original) {
    return new AuthInfo("petya", "123qwerty");
  }

  @Value
  public static class VerificationCode {
    private String code;
  }

  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
    return new VerificationCode("12345");
  }

  @Value
  public static class CardNumber {
    private String cardNumber;
  }

  public static CardNumber getFirstCardNumber() {
    return new CardNumber("5559 0000 0000 0001");
  }

  public static CardNumber getSecondCardNumber() {
    return new CardNumber("5559 0000 0000 0002");
  }

  @Value
  public static class TransferAmount {
    private String amount;
  }

  public static int generateValidAmount(int balance) {
    return new Random().nextInt(balance) + 1;
  }

  public static int generateInvalidAmount(int balance) {
    return Math.abs(balance) + new Random().nextInt(10000);
  }
}
