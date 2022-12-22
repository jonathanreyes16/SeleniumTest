package tests;

import org.testng.annotations.Test;
import pageobjects.PostsPage;
import steps.PostSteps;

import java.io.IOException;

public class PostsTests extends BaseTest{

    PostSteps postSteps = new PostSteps(driver);

    public PostsTests() throws IOException {
    }

    @Test
    public void CreatePosts() {
        postSteps.openNewPost();
        postSteps.fillPostCorrectly();
    }

    @Test
    public void testMissingTitlePost(){
        postSteps.openNewPost();
        postSteps.fillPostNoTitle();
        postSteps.verifyAlert();
    }

    @Test
    public void testMissingSubTitlePost(){
        postSteps.openNewPost();
        postSteps.fillPostNoSubtitle();
        postSteps.verifyAlert();
    }

    @Test
    public void testUpdateOnePost(){
        postSteps.openNewPost();
        postSteps.fillPostCorrectly();
        postSteps.updatePostCompletly();
    }

    @Test
    public void testPartialUpdatePost(){
        postSteps.openNewPost();
        postSteps.fillPostCorrectly();
        postSteps.partialUpdate();
    }

    @Test
    public void testUpdateAnotherUserPost(){
        postSteps.editAnotherUserPost();
    }

}
