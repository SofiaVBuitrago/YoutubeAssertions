package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YoutubeSearch {

    WebDriver driver = new ChromeDriver();
    @Given("the user is on youtube page")
    public void the_user_is_on_youtube_page() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sofia.buitrago\\Documents\\YoutubeSearchAssertions\\src\\test\\resources\\Drivers\\msedgedriver.exe");
        driver.navigate().to("https://www.youtube.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @When("the user searchs for TestNG")
    public void the_user_searchs_for_test_ng() {
        driver.findElement(By.name("search_query")).sendKeys("TestNG");
        driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);


    }
    @Test
    @Then("the youtube results for TestNG are displayed")
    public void the_youtube_results_for_test_ng_are_displayed() throws InterruptedException {

        WebElement first = driver.findElement(By.xpath("//h3[@class='style-scope ytd-promoted-sparkles-web-renderer yt-simple-endpoint']"));
        String firstSearch= first.getText();
        System.out.println(firstSearch);
        Assert.assertTrue(firstSearch.contains("TestNG"));

        List<WebElement> results = driver.findElements(By.xpath("//span[@id='video-title']"));
        for (WebElement resultsList : results) {
            System.out.println(resultsList.getText());
        }

        Assert.assertEquals(21,results.size());

        Thread.sleep(3000);
        driver.close();
        driver.quit();


    }



}
