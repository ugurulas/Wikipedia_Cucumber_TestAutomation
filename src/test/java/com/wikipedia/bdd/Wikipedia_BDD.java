package com.wikipedia.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class Wikipedia_BDD extends BaseClass {

    @Given("The Visitor is on the wikipedia home page")
    public void a_Visitor_is_on_the_wikipedia_home_page() {
        //Firefox's geckodriver requires you to specify its location.
        System.setProperty(BASE_DRIVER_INFO, BASE_GECKODRIVER);
        browser = new FirefoxDriver();
        browser.get(BASE_ENDPOINT);
        browser.manage().window().setSize(new Dimension(957, 576));
    }

    @When("The visitor searches for ‘furry rabbits’")
    public void the_visitor_searches_for_furry_rabbits() {
        // Write code here that turns the phrase above into concrete actions
        browser.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
        browser.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("furry rabbits");
        browser.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
    }


    @Then("A ‘did you mean’ suggestion is displayed")
    public void a_did_you_mean_suggestion_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        browser.findElement(By.xpath("//*[@class=\"searchdidyoumean\"]")).isDisplayed();
        browser.findElement(By.xpath("//*[@id=\"mw-search-DYM-suggestion\"]")).isDisplayed();
        browser.quit();
    }


    @When("The visitor searches for ‘furry rabbits’ for case")
    public void the_visitor_searches_for_furry_rabbits_for_case() {
        browser.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
        browser.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("furry rabbits");
        browser.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
    }

    @Then("The visitor can see 20 results")
    public void the_visitor_can_see_results() {
        List<WebElement> buttons = browser.findElements(By.cssSelector(".mw-search-results li"));
        System.out.println("List :" + buttons.size()); // Just I wanted to show count detail on the console. It is Not required.
        assertEquals(buttons.size(),20);
        browser.quit();

    }

    @Given("A visitor is on the search result page for ‘furry rabbits’")
    public void a_visitor_is_on_the_search_result_page_for_furry_rabbits() {
        System.setProperty("webdriver.gecko.driver", BASE_GECKODRIVER);
        browser = new FirefoxDriver();
        browser.get(BASE_ENDPOINT);
        browser.manage().window().setSize(new Dimension(957, 576));
        browser.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
        browser.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("furry rabbits");

    }

    @When("The visitor uses the “Did you mean” feature to correct his search  And select the first entry")
    public void the_visitor_uses_the_Did_you_mean_feature_to_correct_his_search_And_select_the_first_entry() {
        browser.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
        browser.findElement(By.xpath("//*[@id=\"mw-search-DYM-suggestion\"]")).click();
        String first_hit = browser.findElement(By.cssSelector("li.mw-search-result:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).getText();
        System.out.println(first_hit);// It is not mandatory

    }

    @Then("The visitor is on the article page of the first hit")
    public void the_visitor_is_on_the_article_page_of_the_first_hit() {
        String first_hit = browser.findElement(By.cssSelector("li.mw-search-result:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).getText();
        System.out.println(first_hit);// It is not mandatory
        browser.findElement(By.cssSelector("li.mw-search-result:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).click();
        String check_correct_page_is_opened = browser.findElement(By.xpath("//*[@id=\"firstHeading\"]")).getText();
        assertEquals(first_hit,check_correct_page_is_opened);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        browser.quit();

    }



}
