package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PostsPage extends BasePage{
    public PostsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "//a[text()='New Post']")
    private WebElement NewPostOption;

    public WebElement getNewPostOption(){
        return NewPostOption;
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Posts']")
    private WebElement Posts;

    public WebElement getPosts(){
        return Posts;
    }

    @FindBy(how = How.ID ,using = "id_title")
    private WebElement TextboxPostTitle;

    public WebElement getTextboxPostTitle(){
        return TextboxPostTitle;
    }

    @FindBy(how = How.ID ,using = "id_subtitle")
    private WebElement TextboxPostSubTitle;

    public WebElement getTextboxPostSubTitle(){
        return TextboxPostSubTitle;
    }

    @FindBy(how = How.ID ,using = "id_body")
    private WebElement TextboxPostBody;

    public WebElement getTextboxPostBody(){
        return TextboxPostBody;
    }

    @FindBy(how = How.XPATH ,using = "//input[@value='Create']")
    private WebElement btnCreate;

    public WebElement getBtnCreate(){
        return btnCreate;
    }

    @FindBy(how = How.XPATH ,using = "//div[@class='container']//h1")
    private WebElement txtPostTitle;

    public WebElement getTxtPostTitle(){
        return txtPostTitle;
    }

    @FindBy(how = How.XPATH ,using = "//div[@class='container']//h5")
    private WebElement txtPostSubTitle;

    public WebElement getTxtPostSubTitle(){
        return txtPostSubTitle;
    }

    @FindBy(how = How.XPATH ,using = "//div[@class='container']//p")
    private WebElement txtPostBody;

    public WebElement getTxtPostBody(){
        return txtPostBody;
    }

    @FindBy(how = How.XPATH ,using = "//div[@class='container']//small")
    private WebElement txtPostDate;

    public WebElement getTxtPostDate(){
        return txtPostDate;
    }

    @FindBy(how = How.XPATH ,using = "//*[text()='Please fill out this field.']")
    private WebElement txtAlertNoTitle;

    public WebElement getTxtAlert(){
        return txtAlertNoTitle;
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Read more']")
    private WebElement LatestPost;

    public WebElement getLatestPosts(){
        return LatestPost;
    }


    @FindBy(how = How.XPATH, using = "//a[@class=btn-outline-primary]")
    private WebElement EditPostButton;

    public WebElement getEditPostsButton(){
        return EditPostButton;
    }

    @FindBy(how = How.XPATH ,using = "//input[@value='Edit']")
    private WebElement btnEdit;

    public WebElement getBtnEdit(){
        return btnEdit;
    }
}
