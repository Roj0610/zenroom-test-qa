package com.compareasiagroup.automation.component.MoneymaxComponent;
import com.compareasiagroup.automation.component.*;
import com.compareasiagroup.automation.controller.Controller;
import com.compareasiagroup.automation.utilities.ConstantsUtility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ZenTestPaymentComponent {

    private final FindWebElementComponent findWebElementComponent;
    private final WaitComponent waitComponent;
    private final ConstantsUtility constantsUtility;
    private InputComponent inputComponent;
    private ActionBuilderComponent actionBuilderComponent;
    private Controller controller;

    public ZenTestPaymentComponent(FindWebElementComponent findWebElementComponent,
                                   WaitComponent waitComponent,
                                   ConstantsUtility constantsUtility,
                                   InputComponent inputComponent,
                                   ActionBuilderComponent actionBuilderComponent,
                                   Controller controller) {
        this.findWebElementComponent = findWebElementComponent;
        this.waitComponent = waitComponent;
        this.constantsUtility = constantsUtility;
        this.inputComponent = inputComponent;
        this.actionBuilderComponent = actionBuilderComponent;
        this.controller = controller;
    }

    public boolean verifyIfRedirectedToPaymentMethodPage(String paymentMethodPage)
    {
        WebElement verifyPaymentMethod = findWebElementComponent.findElement
                (findWebElementComponent.findSelector("paymentMethod"), paymentMethodPage);

        return verifyPaymentMethod.isDisplayed();
    }

    public void selectPaymentMethod(String paymentMethod)
    {
        WebElement seleectPaymentMethod = findWebElementComponent.findElement
                (findWebElementComponent.findSelector("paymentMethod"), paymentMethod);

        seleectPaymentMethod.click();
    }

    public boolean verifyIfRedirectedToCheckoutPage()
    {
        WebElement verifyCheckOutPagePresent = findWebElementComponent.findElement
                (findWebElementComponent.findSelector
                        ("checkoutConfirmation_cancelOrder"));

        return verifyCheckOutPagePresent.isDisplayed();
    }

    public void cancelBooking()
    {
        waitComponent.fluentWait(ExpectedConditions.elementToBeClickable(findWebElementComponent.findElement
                (findWebElementComponent.findSelector("checkoutConfirmation_cancelOrder"))
        ), constantsUtility.TIMEOUT, constantsUtility.POLLING).click();
    }

    public boolean verifyBookingIsCancelled(String cancelBooking)
    {
        WebElement bookingResponsePage =
                this.controller.getDriver()
                        .findElement
                                (By.xpath("//div[@class='status']//h1[contains(text(), '" + cancelBooking + "')]"));

        return bookingResponsePage.isDisplayed();
    }
}