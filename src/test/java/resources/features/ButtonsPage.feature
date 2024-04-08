Feature: As a user I want to click buttons on the Buttons

  Scenario: Click on "Click Me" button and see the message
    Given I open the elements page
    Given I click on Buttons button
    When I click on the click me button
    Then I should see the message