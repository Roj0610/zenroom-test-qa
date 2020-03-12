package com.compareasiagroup.automation.steps.moneymax;
import com.compareasiagroup.automation.component.MoneymaxComponent.ZenTestPersonalDetailsComponent;
import com.compareasiagroup.automation.component.UrlNavigationComponent;
import com.compareasiagroup.automation.component.WaitComponent;
import com.compareasiagroup.automation.controller.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ZenroomPersonalDetailsSteps {
    private ZenTestPersonalDetailsComponent zenTestPersonalDetailsComponent;
    private WaitComponent waitComponent;
    private UrlNavigationComponent urlNavigationComponent;
    private Config config;

    public ZenroomPersonalDetailsSteps(ZenTestPersonalDetailsComponent zenTestPersonalDetailsComponent,
                                       WaitComponent waitComponent,
                                       UrlNavigationComponent urlNavigationComponent,
                                       Config config) {
        this.zenTestPersonalDetailsComponent = zenTestPersonalDetailsComponent;
        this.waitComponent = waitComponent;
        this.urlNavigationComponent = urlNavigationComponent;
        this.config = config;
    }

    @And("the USER set First Name to {string}")
    public void setFirstName(String firstName)
    {
        zenTestPersonalDetailsComponent.enterFirstName(firstName);
    }

    @And("the USER set Last Name to {string}")
    public void setLastName(String lastName)
    {
        zenTestPersonalDetailsComponent.enterLastName(lastName);
    }

    @And("the USER set Phone Number to {string}")
    public void setPhoneNumber(String phoneNumber)
    {
        zenTestPersonalDetailsComponent.enterPhoneNumber(phoneNumber);
    }

    @And("the USER set Email Address to {string}")
    public void setEmailAddress(String emailAddress)
    {
        zenTestPersonalDetailsComponent.enterEmailAdd(emailAddress);
    }

    @When("the USER activates Free Cancellation Feature")
    public void activateFreeCancellation()
    {
        zenTestPersonalDetailsComponent.activateFreeCancellation();
    }

    @Then("Verify if Free Cancellation Feature Activates")
    public void verifyFreeCancellation()
    {
        Assert.assertTrue(zenTestPersonalDetailsComponent.verifyFreeCancellationActivation());
    }

    @And("the USER set his voucher code to {string}")
    public void setVoucherCode(String voucherCode)
    {
        zenTestPersonalDetailsComponent.enterVoucherCode(voucherCode);
    }

    @And("the USER applies the Voucher Code")
    public void applyVoucherCode()
    {
        zenTestPersonalDetailsComponent.clickApplyVoucher();
        waitComponent.safeWait(3000);
    }

    @And("Verify if Voucher is activated")
    public void verifyIfVoucherActivated()
    {
        zenTestPersonalDetailsComponent.verifyIfVoucherActivated();
    }

    @Then("Click Continue Button")
    public void clickContinue()
    {
        zenTestPersonalDetailsComponent.clickContinue();
        waitComponent.safeWait(5000);
    }


}

