package com.ten10.academy.practice.automation.stepDefs;

import com.ten10.academy.practice.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;

public class NavigationStepDefs {

    Pages pages;

    public NavigationStepDefs(Pages pages) {
        this.pages = pages;
    }

    @Given("^I open the ?T?e?n?1?0? website$")
    public void iOpenTheTenWebsite() {
        pages.homePage = new HomePage().open();
    }

    @Step
    @When("^I click (.+) on the navbar$")
    public void iClickXOnTheNavbar(String navButton) {

    }

    @Step
    @Then("^I am on the (.+) page$")
    public void iAmOnTheXPage(String pageName) {
        Assert.assertTrue(true);
    }
}
