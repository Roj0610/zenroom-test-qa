package com.compareasiagroup.automation.steps.moneymax;
import com.compareasiagroup.automation.component.MoneymaxComponent.ZenTestBookDetailsComponent;
import com.compareasiagroup.automation.component.UrlNavigationComponent;
import com.compareasiagroup.automation.component.WaitComponent;
import com.compareasiagroup.automation.controller.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ZenroomBookDetailsSteps {
    private ZenTestBookDetailsComponent zenTestBookDetailsComponent;
    private WaitComponent waitComponent;
    private UrlNavigationComponent urlNavigationComponent;
    private Config config;

    public ZenroomBookDetailsSteps(ZenTestBookDetailsComponent zenTestBookDetailsComponent,
                              WaitComponent waitComponent,
                              UrlNavigationComponent urlNavigationComponent,
                              Config config)
    {
        this.zenTestBookDetailsComponent = zenTestBookDetailsComponent;
        this.waitComponent = waitComponent;
        this.urlNavigationComponent = urlNavigationComponent;
        this.config = config;
    }

    @And("the USER selects his or her selected hotel")
    public void selectHotelDestination()
    {
        zenTestBookDetailsComponent.selectHotelDestination();
    }

    @And("the USER sorted hotel to {string}")
    public void sortBySelectedHotelDestination(String selectedHotelDestination)
    {
        zenTestBookDetailsComponent.sortHotelDestination(selectedHotelDestination);
    }

    @And("the USER book his or her selected hotel")
    public void bookSelectedHotel()
    {
        zenTestBookDetailsComponent.bookSelectedHotel();
    }

    @Then("Verify if the USER is in Selected Hotel Page")
    public void verifyIfRedirectedToSelectedHotel()
    {
        Assert.assertTrue("Policies tab is displayed", zenTestBookDetailsComponent.verifyIfRedirectedToSelectedHotel());
    }

    @Then("Verify if the USER is in Personal Details Page")
    public void verifyIfRedirectedToPersonalDetails()
    {
        Assert.assertTrue("Personal Details Label is displayed", zenTestBookDetailsComponent.verifyIfRedirectedToPersonalDetails());
    }



}
