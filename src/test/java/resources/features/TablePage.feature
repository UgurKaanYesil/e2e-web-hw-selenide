Feature: As a user I want to add and edit entries in the web table on Web tables section

  Scenario: Add a new entry and edit the newly added entry
    Given I open the web tables page
    When I add a new record
    Then I should see the newly added record in the table

  Scenario: Edit the newly added entry
    Given I open the web tables page
    Given I add a new record
    Given I should see the newly added record in the table
    When I clicked to edit button for new record
    Then I should be able to edit the record and save