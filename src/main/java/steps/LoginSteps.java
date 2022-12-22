package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pageobjects.LoginPage;

import java.time.Duration;

public class LoginSteps extends BaseSteps{

    public LoginSteps(WebDriver webDriver) {
        super(webDriver);
    }

    LoginPage loginPage = PageFactory.initElements(webDriver,LoginPage.class);

    public void CompleteLogin(String Username, String Password) throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginButton()));
        loginPage.getTextboxUsername().sendKeys(Username);
        loginPage.getTextboxPassword().sendKeys(Password);
        loginPage.getLoginButton().click();

    }

}
