@navigation
Feature: Navigation

  Background:
    Given I open the Ten10 website

  @test-1
  Scenario: I can search for an article and open a matching article
    When I search for academy using the search box
    Then the results contain academy
    And I click the first article
    Then I am on the first article page

  @test-2
  Scenario: I can navigate using the navbar
    When I click Home on the navbar
    Then I am on the Home page