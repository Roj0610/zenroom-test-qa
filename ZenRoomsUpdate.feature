@Test @Zenrooms

Feature: Verify if the USER can update his/her Booking Details before making reservation

  Background:
    When the USER is redirected to Zenroom Website
    When the USER enter wants to visit "Cebu City, Philippines"
    And the USER sets check-in date to "7 April 2020"
    And the USER sets check-out date
    When the USER add number of guest
    And the USER add number of room
    And the USER click Find Rooms
    Then Verify if Update Search button is displayed

   Scenario: User Updates his/her Booking Details
     When the USER updates destination to "Vigan City, Philippines"
     And the USER updates his or her check-in date from "25 April 2020"
     And the USER sets check-out date
     And the USER updates his or her room
     And the USER Update his or her booking details
#     Then Verify if Destination is updated