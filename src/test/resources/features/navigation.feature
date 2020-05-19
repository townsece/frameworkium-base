@navigation
Feature: Navigation

  @test-1
  Scenario: I can search for an article and open a matching article

  @test-2
  Scenario: I can navigate using the navbar
    When I click Home on the navbar
    Then I am on the Home page