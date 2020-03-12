package com.compareasiagroup.automation.steps.moneymax;
import com.compareasiagroup.automation.component.MoneymaxComponent.*;
import com.compareasiagroup.automation.component.UrlNavigationComponent;
import com.compareasiagroup.automation.component.WaitComponent;
import com.compareasiagroup.automation.controller.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ZenroomSearchSteps
{
    private ZenTestSearchComponent zenTestSearchComponent;
    private WaitComponent waitComponent;
    private UrlNavigationComponent urlNavigationComponent;
    private Config config;

    public ZenroomSearchSteps(ZenTestSearchComponent zenTestSearchComponent,
                              WaitComponent waitComponent,
                              UrlNavigationComponent urlNavigationComponent,
                              Config config)
    {
        this.zenTestSearchComponent = zenTestSearchComponent;
        this.waitComponent = waitComponent;
        this.urlNavigationComponent = urlNavigationComponent;
        this.config = config;
    }

    @When("the USER is redirected to Zenroom Website")
    public void navigateToZenroomPage()
    {
        urlNavigationComponent.navigateTo(config.getEnvironment("BASE_URL"));
    }

    @When("the USER enter wants to visit {string}")
    public void enterDestination(String Destination)
    {
        zenTestSearchComponent.enterDestination(Destination);
    }

    @And("the USER sets check-in date to {string}")
    public void enterCheckInDate(String checkIn)
    {
        String[] checkInDatePicker = new String[1];
        checkInDatePicker[0] = "checkinDate";
        waitComponent.safeWait(2000);
        zenTestSearchComponent.enterCheckInDate(checkInDatePicker);

    }

    @And("the USER sets check-out date")
    public void enterCheckOutDate()
    {
        zenTestSearchComponent.enterCheckOutDate();
    }

    @Then("Verify if the - button for Guest is disabled")
    public void verifyDisabledReduceGuest()
    {
        Assert.assertTrue("Button is disabled", zenTestSearchComponent.verifyDisabledReduceGuestButton());
    }

    @Then("Verify if the - button for Guest is enabled")
    public void verifyEnabledReduceGuest()
    {
        Assert.assertTrue("Button is disabled", zenTestSearchComponent.verifyEnabledReduceGuestButton());
    }

    @Then("the USER add number of guest")
    public void addGuest()
    {
        zenTestSearchComponent.clickAddGuestButton();
    }

    @Then("Verify if the - button for Room is disabled")
    public void verifyDisabledReduceRoomGuest()
    {
        Assert.assertTrue("Button is disabled", zenTestSearchComponent.verifyDisabledReduceRoomButton());
    }

    @Then("Verify if the - button for Room is enabled")
    public void verifyEnabledReduceRoomGuest()
    {
        Assert.assertTrue("Button is enabled", zenTestSearchComponent.verifyEnabledReduceRoomButton());
    }

    @Then("the USER add number of room")
    public void addRoom()
    {
        zenTestSearchComponent.clickAddRoomButton();
    }


    @Then("Verify if the + button for Room is disabled")
    public void verifyDisabledAddRoomGuest()
    {
        Assert.assertTrue("Button is disabled", zenTestSearchComponent.verifyDisabledAddRoomButton());
    }

    @Then("the USER click Find Rooms")
    public void clickFindRoom()
    {
        zenTestSearchComponent.clickFindRooms();
    }

    @Then("Verify if Update Search button is displayed")
    public void verifyUpdateSearch()
    {
        Assert.assertTrue(zenTestSearchComponent.verifyUpdateSearch_isPresent());
    }


}

