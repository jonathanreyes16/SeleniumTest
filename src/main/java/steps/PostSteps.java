package steps;

import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pageobjects.PostsPage;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class PostSteps extends BaseSteps{
    public PostSteps(WebDriver webDriver) {
        super(webDriver);
    }
    PostsPage postsPage = PageFactory.initElements(webDriver,PostsPage.class);

    public void openNewPost(){
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        postsPage.getNewPostOption().click();
    }

    public void VerifyPostData(String title,String subtitle, String Body){
        Assert.assertEquals(postsPage.getTxtPostTitle().getText(), title,"Titles are different");
        Assert.assertEquals(postsPage.getTxtPostSubTitle().getText(),subtitle, "The subtitles are different");
        Assert.assertEquals(postsPage.getTxtPostBody().getText(),Body, "The Body are different");
    }

    public void VerifyPostDate(){
        SimpleDateFormat DateFormat = new SimpleDateFormat("MMM. dd, yyyy");
        String date = DateFormat.format(new Date());
        Assert.assertTrue(postsPage.getTxtPostDate().getText().contains(date),
                "Actual String: "+postsPage.getTxtPostDate().getText().toString() +"/n"+
                        "Expected String: "+ date);
    }

    public void VerifyUsername()  {

        Assert.assertTrue(postsPage.getTxtPostDate().getText().contains("JonathanReyes2"),
                "The Username doesn't match");
    }

    public void fillPostCorrectly()  {
        String Title, Subtitle, Body;
        Title = "Title example " + new Timestamp(System.currentTimeMillis());
        Subtitle = "Subtitle Example " + new Timestamp(System.currentTimeMillis());
        Body = "Body Example " + new Timestamp(System.currentTimeMillis());

        postsPage.getTextboxPostTitle().sendKeys(Title);
        postsPage.getTextboxPostSubTitle().sendKeys(Subtitle);
        postsPage.getTextboxPostBody().sendKeys(Body);
        postsPage.getBtnCreate().click();
        VerifyPostData(Title,Subtitle,Body);
        VerifyUsername();
        VerifyPostDate();

    }
    public void fillPostNoTitle(){
        postsPage.getTextboxPostSubTitle().sendKeys("Subtitle Example"+ new Timestamp(System.currentTimeMillis()));
        postsPage.getTextboxPostBody().sendKeys("Body Example"+ new Timestamp(System.currentTimeMillis()));
        postsPage.getBtnCreate().click();
    }
    public void fillPostNoSubtitle(){
        postsPage.getTextboxPostTitle().sendKeys("Title example" + new Timestamp(System.currentTimeMillis()));
        postsPage.getTextboxPostBody().sendKeys("Body Example"+ new Timestamp(System.currentTimeMillis()));
        postsPage.getBtnCreate().click();
    }

    public void verifyAlert(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(postsPage.getTxtAlert()));
        String alertMessage = postsPage.getTxtAlert().getText();
        Assert.assertEquals(postsPage.getTxtAlert().getText(),alertMessage,
                "Actual: " + postsPage.getTxtAlert().getText() + "\n" + " Expected : Please fill out this field'");
    }

    public void updatePostCompletly() {
        postsPage.getPosts().click();
        postsPage.getLatestPosts().click();
        postsPage.getEditPostsButton().click();
        postsPage.getTextboxPostTitle().sendKeys(" post updated");
        String Title = postsPage.getTextboxPostTitle().getAttribute("value");
        postsPage.getTextboxPostSubTitle().sendKeys(" Subtitle updated");
        String Subtitle = postsPage.getTextboxPostSubTitle().getAttribute("value");
        postsPage.getTextboxPostBody().sendKeys("body Updated");
        String body = postsPage.getTextboxPostBody().getAttribute("value");
        postsPage.getBtnEdit().click();
        VerifyPostData(Title,Subtitle,body);
        VerifyUsername();
    }


    public void partialUpdate(){
        postsPage.getPosts().click();
        postsPage.getLatestPosts().click();
        postsPage.getEditPostsButton().click();
        String Title = postsPage.getTextboxPostTitle().getAttribute("value");
        postsPage.getTextboxPostSubTitle().sendKeys(" Subtitle updated");
        String Subtitle = postsPage.getTextboxPostSubTitle().getAttribute("value");
        postsPage.getTextboxPostBody().sendKeys("body Updated");
        String body = postsPage.getTextboxPostBody().getAttribute("value");
        postsPage.getBtnEdit().click();
        VerifyPostData(Title,Subtitle,body);
        VerifyUsername();
    }



    public void editAnotherUserPost() {
        webDriver.get("https://sheltered-mesa-19374.herokuapp.com/posts/209/edit/");
        Assert.assertEquals(webDriver.getTitle(),"403 Forbidden",
                "The pages are different");
    }
}
