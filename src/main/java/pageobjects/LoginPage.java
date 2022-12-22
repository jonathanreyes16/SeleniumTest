package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.ID, using = "id_username")
    private WebElement textboxUsername;

    @FindBy(how = How.ID, using = "id_password")
    private WebElement textboxPassword;

    @FindBy(how = How.XPATH, using = "//input[@value='Log In']")
    private WebElement LoginButton;


    public WebElement getTextboxPassword() {
        return textboxPassword;
    }

    public WebElement getTextboxUsername() {
        return textboxUsername;
    }

    public WebElement getLoginButton(){
        return LoginButton;
    }
}
