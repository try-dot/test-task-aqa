package pages;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement emailInput = $x("//input[@id = 'EmailAddress']");
    private final SelenideElement passwordInput = $x("//input[@id = 'Password']");
    private final SelenideElement signInButton = $x("//input[@id = 'signin']");
    private final SelenideElement showPasswordButton = $x("//button[@id = 'signin-show-me']");
    private final SelenideElement hidePasswordButton = $x("//button[@id = 'signin-hide-me']");
    private final SelenideElement emailErrorMessage = $x("//span[@id = 'EmailAddress-error']");
    private final SelenideElement passwordErrorMessage = $x("//span[@id = 'Password-error']");

    public void enterEmail(String email) {
        emailInput.shouldBe(visible).setValue(email).pressEnter();
    }

    public void enterPassword(String password) {
        passwordInput.shouldBe(visible).setValue(password).pressEnter();
    }

    public void clickSignInButton() {
        signInButton.shouldBe(visible).click();
    }

    public void clickShowPasswordButton() {
        showPasswordButton.shouldBe(visible).click();
    }

    public String getHidePasswordButtonText() {
        return hidePasswordButton.shouldBe(visible).getText();
    }

    public String getPasswordValue() {
        return passwordInput.shouldBe(visible).getValue();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.shouldBe(visible).getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.shouldBe(visible).getText();
    }

}
