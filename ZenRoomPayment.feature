@Test @Zenrooms

Feature: Verify if the USER can cancel his

  Background:
    When the USER is redirected to Zenroom Website
    When the USER enter wants to visit "Cebu City, Philippines"
    And the USER sets check-in date to "7 April 2020"
    And the USER sets check-out date
    When the USER add number of guest
    And the USER add number of room
    And the USER click Find Rooms
    When the USER updates destination to "Palawan, Philippines"
    And the USER updates his or her check-in date from "25 April 2020"
    And the USER sets check-out date
    And the USER updates his or her room
    And the USER Update his or her booking details
    And the USER sorted hotel to "Price, lowest to highest"
    And the USER selects his or her selected hotel
    And the USER book his or her selected hotel
    And the USER set First Name to "Rogie"
    And the USER set Last Name to "Acuna"
    And the USER set Phone Number to "09175991997"
    And the USER set Email Address to "it.rogieacuna@gmail.com"
    When the USER activates Free Cancellation Feature
    Then Click Continue Button
    And Verify if "payAtHotel" is displayed
    When USER selects "payAtHotel" as payment method

   Scenario: Verify if the USER can cancel booking order
     Given Verify if USER is redirected to Checkout Confirmation Page
     And USER Cancels his or her booking
     Then Verify if "Booking cancelled"
