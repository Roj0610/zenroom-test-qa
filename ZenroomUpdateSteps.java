package com.compareasiagroup.automation.steps.moneymax;
import com.compareasiagroup.automation.component.MoneymaxComponent.ZenTestUpdateComponent;
import com.compareasiagroup.automation.component.UrlNavigationComponent;
import com.compareasiagroup.automation.component.WaitComponent;
import com.compareasiagroup.automation.controller.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ZenroomUpdateSteps {
    private ZenTestUpdateComponent zenTestUpdateComponent;
    private WaitComponent waitComponent;
    private UrlNavigationComponent urlNavigationComponent;
    private Config config;

    public ZenroomUpdateSteps(ZenTestUpdateComponent zenTestUpdateComponent,
                              WaitComponent waitComponent,
                              UrlNavigationComponent urlNavigationComponent,
                              Config config)
    {
        this.zenTestUpdateComponent = zenTestUpdateComponent;
        this.waitComponent = waitComponent;
        this.urlNavigationComponent = urlNavigationComponent;
        this.config = config;
    }

    @When("the USER updates destination to {string}")
    public void updateDestination(String updatedDestination)
    {
        zenTestUpdateComponent.updateDestination(updatedDestination);
    }

    @And("the USER updates his or her room")
    public void updateRoom()
    {
        zenTestUpdateComponent.updateRoom();
        waitComponent.safeWait(2000);
    }

    @And("the USER updates his or her check-in date from {string}")
    public void updateCheckInFrom(String checkInUpdated)
    {
        String[] updateCheckInDatePicker = new String[1];
        updateCheckInDatePicker[0] = "checkinDate";
        waitComponent.safeWait(2000);
        zenTestUpdateComponent.updateCheckInDateFrom(updateCheckInDatePicker);
    }

    @And("the USER Update his or her booking details")
    public void updateBookingDetails()
    {
        zenTestUpdateComponent.updateBookingDetails();
        waitComponent.safeWait(2000);
    }

    /*

    @Then("Verify if Destination is updated")
    public void verifyUpdatedDestination()
    {
        Assert.assertEquals("Vigan City, Philippines", zenTestUpdateComponent.verifyUpdatedDestination());
    }

     */
}
