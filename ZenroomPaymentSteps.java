package com.compareasiagroup.automation.steps.moneymax;
import com.compareasiagroup.automation.component.MoneymaxComponent.ZenTestBookDetailsComponent;
import com.compareasiagroup.automation.component.MoneymaxComponent.ZenTestPaymentComponent;
import com.compareasiagroup.automation.component.UrlNavigationComponent;
import com.compareasiagroup.automation.component.WaitComponent;
import com.compareasiagroup.automation.controller.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ZenroomPaymentSteps {
    private ZenTestPaymentComponent zenTestPaymentComponent;
    private WaitComponent waitComponent;
    private UrlNavigationComponent urlNavigationComponent;
    private Config config;

    public ZenroomPaymentSteps(ZenTestPaymentComponent zenTestPaymentComponent,
                               WaitComponent waitComponent,
                               UrlNavigationComponent urlNavigationComponent,
                               Config config)
    {
        this.zenTestPaymentComponent = zenTestPaymentComponent;
        this.waitComponent = waitComponent;
        this.urlNavigationComponent = urlNavigationComponent;
        this.config = config;
    }

    @And("Verify if {string} is displayed")
    public void verifyIfRedirectedToPaymentMethodPage(String paymentMethodPage)
    {
        Assert.assertTrue(zenTestPaymentComponent.verifyIfRedirectedToPaymentMethodPage(paymentMethodPage));
    }

    @And("USER selects {string} as payment method")
    public void selectPaymentMethod(String paymentMethod)
    {
       zenTestPaymentComponent.selectPaymentMethod(paymentMethod);
    }

    @Then("Verify if USER is redirected to Checkout Confirmation Page")
    public void verifyIfRedirectedToCheckOutPage()
    {
        zenTestPaymentComponent.verifyIfRedirectedToCheckoutPage();
    }

    @And("USER Cancels his or her booking")
    public void cancelBooking()
    {
        zenTestPaymentComponent.cancelBooking();
    }

    @Then("Verify if {string}")
    public void verifyCancelBooking(String cancelBooking)
    {
        Assert.assertTrue(zenTestPaymentComponent.verifyBookingIsCancelled(cancelBooking));
    }


}
