
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {

    private LoginPage loginPage;

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://my.asos.com/identity/login";
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void tearDown(){
        closeWebDriver();
    }

    @Test
    void showPasswordButtonFunctionality() {
        String expectedPassword = "123abc";
        String expectedHidePasswordButtonText = "HIDE";
        loginPage = open("/", LoginPage.class);
        loginPage.enterPassword(expectedPassword);
        loginPage.clickShowPasswordButton();
        String actualPassword = loginPage.getPasswordValue();
        String actualHidePasswordButtonText = loginPage.getHidePasswordButtonText();
        assertAll(
                () -> assertEquals(expectedPassword, actualPassword),
                () -> assertEquals(expectedHidePasswordButtonText, actualHidePasswordButtonText)
        );
    }

    @Test
    void enterWrongEmailFormat() {
        String expectedEmailErrorMessage = "Email fail! Please type in your correct email address";
        String wrongEmailFormat = "abc@";
        loginPage = open("/", LoginPage.class);
        loginPage.enterEmail(wrongEmailFormat);
        String actualEmailErrorMessage = loginPage.getEmailErrorMessage();
        assertEquals(expectedEmailErrorMessage, actualEmailErrorMessage);
    }

    @Test
    void loginWithEmptyEmailAndEmptyPassword() {
        String expectedEmailErrorMessage = "Oops! You need to type your email here";
        String expectedPasswordErrorMessage = "Hey, we need a password here";
        loginPage = open("/", LoginPage.class);
        loginPage.clickSignInButton();
        String actualEmailErrorMessage = loginPage.getEmailErrorMessage();
        String actualPasswordMessage = loginPage.getPasswordErrorMessage();
        assertAll(
                () -> assertEquals(expectedEmailErrorMessage, actualEmailErrorMessage),
                () -> assertEquals(expectedPasswordErrorMessage, actualPasswordMessage)
        );
    }
}
