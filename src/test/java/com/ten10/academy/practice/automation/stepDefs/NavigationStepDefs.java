package com.ten10.academy.practice.automation.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class NavigationStepDefs {

    @Step
    @When("^I click (.+) on the navbar$")
    public void iClickXOnTheNavbar(String navButton) {

    }

    @Step
    @Then("^I am on the (.+) page$")
    public void iAmOnTheXPage(String pageName) {

    }
}
