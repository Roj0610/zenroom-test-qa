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

public class ZenTestBookDetailsComponent {

    private final FindWebElementComponent findWebElementComponent;
    private final WaitComponent waitComponent;
    private final ConstantsUtility constantsUtility;
    private InputComponent inputComponent;
    private ActionBuilderComponent actionBuilderComponent;
    private Controller controller;

    public ZenTestBookDetailsComponent(FindWebElementComponent findWebElementComponent,
                                       WaitComponent waitComponent,
                                       ConstantsUtility constantsUtility,
                                       InputComponent inputComponent,
                                       ActionBuilderComponent actionBuilderComponent,
                                       Controller controller)
    {
        this.findWebElementComponent = findWebElementComponent;
        this.waitComponent = waitComponent;
        this.constantsUtility = constantsUtility;
        this.inputComponent = inputComponent;
        this.actionBuilderComponent = actionBuilderComponent;
        this.controller = controller;
    }

    public void selectHotelDestination() {
        WebElement selectHotel = this.controller.getDriver().findElement
                (By.xpath("//*[@id=\"roomsDisplay\"]/span[1]"));

        selectHotel.click();
        waitComponent.safeWait(5000);

// Switch to new window opened
        for (String winHandle : this.controller.getDriver().getWindowHandles()) {
            this.controller.getDriver().switchTo().window(winHandle);
        }
    }

    public void sortHotelDestination(String selectedHotelDestination)
    {
       WebElement clickSortByOption = waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
               (findWebElementComponent.findElement
                       (findWebElementComponent.findSelector
                               ("sortByOption")
                )), constantsUtility.TIMEOUT, constantsUtility.POLLING);

       clickSortByOption.click();

        WebElement sortByOptions =
                this.controller.getDriver()
                        .findElement
                                (By.xpath("//span[contains(text(), '" + selectedHotelDestination + "')]"));

        sortByOptions.click();
        waitComponent.safeWait(2000);
    }

    public void bookSelectedHotel() {
        waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                (findWebElementComponent.findElement
                        (findWebElementComponent.findSelector
                                ("bookSelectedHotel")
                        )), constantsUtility.POLLING, constantsUtility.TIMEOUT).click();
    }

    public boolean verifyIfRedirectedToSelectedHotel()
    {
        WebElement policiesLabel =
                this.controller.getDriver()
                        .findElement
                                (By.xpath("//*[@id=\"room-details\"]/div/div[1]/div[1]/div[3]/div/ul/li[2]/a"));

        return policiesLabel.isDisplayed();
    }
    public boolean verifyIfRedirectedToPersonalDetails()
    {
        WebElement personalDetailsLabel =
                this.controller.getDriver()
                        .findElement
                                (By.xpath("//*[@id=\"customer_form\"]/span"));

        return personalDetailsLabel.isDisplayed();
    }
}
