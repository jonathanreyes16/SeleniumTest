package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.LoginSteps;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BaseTest {


    public WebDriver driver = getDriver();
    LoginSteps loginSteps= PageFactory.initElements(driver,LoginSteps.class);

    public BaseTest() throws IOException {
    }

    private WebDriver getDriver(){
        setupDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://sheltered-mesa-19374.herokuapp.com/");
        return driver;
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException, IOException {

        String Username = "JonathanReyes2";
        String Password = "Dexcom123";
        loginSteps.CompleteLogin(Username, Password);
    }

    private void setupDriver(String browserName) {
        switch(browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Web Driver was not found in directory");
        }
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }


}
