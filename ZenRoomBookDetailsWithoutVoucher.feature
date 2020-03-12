@Test @Zenrooms

Feature: Verify if the USER can successfully book a hotel without using Voucher Code

  Background:
    When the USER is redirected to Zenroom Website
    When the USER enter wants to visit "Cebu City, Philippines"
    And the USER sets check-in date to "7 April 2020"
    And the USER sets check-out date
    When the USER add number of guest
    And the USER add number of room
    And the USER click Find Rooms
    Then Verify if Update Search button is displayed

  Scenario: User is redirected to selected hotel destination
    When the USER updates destination to "Palawan, Philippines"
    And the USER updates his or her check-in date from "25 April 2020"
    And the USER sets check-out date
    And the USER updates his or her room
    And the USER Update his or her booking details
    And the USER sorted hotel to "Price, lowest to highest"
    And the USER selects his or her selected hotel
    Then Verify if the USER is in Selected Hotel Page

  Scenario: Verify if User is redirected to Personal Details Page
    When the USER updates destination to "Palawan, Philippines"
    And the USER updates his or her check-in date from "25 April 2020"
    And the USER sets check-out date
    And the USER updates his or her room
    And the USER Update his or her booking details
    And the USER sorted hotel to "Price, lowest to highest"
    And the USER selects his or her selected hotel
    And the USER book his or her selected hotel
    Then Verify if the USER is in Personal Details Page

  Scenario: User is provides his or her Personal Details
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
    Then Verify if Free Cancellation Feature Activates
    Then Click Continue Button

  Scenario: User selects "Pay at Hotel" as Payment Method without Voucher Code
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
    Then Verify if USER is redirected to Checkout Confirmation Page