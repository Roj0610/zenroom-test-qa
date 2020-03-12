@Test @Zenrooms

Feature: Verify that USER can search for Destination

  Background:
    When the USER is redirected to Zenroom Website
    When the USER enter wants to visit "Manila, Philippines"
    And the USER sets check-in date to "7 April 2020"
    And the USER sets check-out date

  Scenario: Verify if add and reduce button behavior for Guests section
    Then Verify if the - button for Guest is disabled
    And the USER add number of guest
    Then Verify if the - button for Guest is enabled

  Scenario: Verify if add and reduce button behavior for Room section
    When the USER add number of guest
    Then Verify if the - button for Room is disabled
    When the USER add number of room
    Then Verify if the - button for Room is enabled

  Scenario: Verify if the User successfully find
    When the USER add number of guest
    And the USER add number of room
    And the USER click Find Rooms
    Then Verify if Update Search button is displayed