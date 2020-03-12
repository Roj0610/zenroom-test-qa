package com.compareasiagroup.automation.component.MoneymaxComponent;

import com.compareasiagroup.automation.abstraction.BaseComponent;
import com.compareasiagroup.automation.component.FindWebElementComponent;
import com.compareasiagroup.automation.component.InputComponent;
import com.compareasiagroup.automation.component.JavascriptExecutorComponent;
import com.compareasiagroup.automation.component.WaitComponent;
import com.compareasiagroup.automation.controller.Controller;
import com.compareasiagroup.automation.utilities.ConstantsUtility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ZenTestSearchComponent extends BaseComponent
{
    private final FindWebElementComponent findWebElementComponent;
    private final WaitComponent waitComponent;
    private final ConstantsUtility constantsUtility;
    private InputComponent inputComponent;
    private JavascriptExecutorComponent javascriptExecutorComponent;
    private Controller controller;

    public ZenTestSearchComponent(FindWebElementComponent findWebElementComponent,
                                  WaitComponent waitComponent,
                                  ConstantsUtility constantsUtility,
                                  InputComponent inputComponent,
                                  JavascriptExecutorComponent javascriptExecutorComponent,
                                  Controller controller)

    {
        this.findWebElementComponent = findWebElementComponent;
        this.waitComponent = waitComponent;
        this.constantsUtility = constantsUtility;
        this.inputComponent = inputComponent;
        this.javascriptExecutorComponent = javascriptExecutorComponent;
        this.controller = controller;
    }

    public void enterDestination(String Destination)
    {
        WebElement destination = waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                (findWebElementComponent.findElement
                        (findWebElementComponent.findSelector
                                ("hotelDestination"))
                ), constantsUtility.TIMEOUT, constantsUtility.POLLING);

        inputComponent.input(destination, Destination);
        waitComponent.safeWait(3000);
        destination.sendKeys(Keys.ARROW_DOWN);
        destination.sendKeys(Keys.ENTER);
        waitComponent.safeWait(3000);
    }

    public void enterCheckInDate(String[] checkIn) {

//        for(String checkInDatePicker: checkIn) {
//            WebElement checkInDate = waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
//                    (findWebElementComponent.findElement
//                            (findWebElementComponent.findSelector
//                                    ("checkInDate"))
//                    ), constantsUtility.TIMEOUT, constantsUtility.POLLING);
//
//            javascriptExecutorComponent.executeScript("document.getElementById(\"" + checkInDatePicker + "\").removeAttribute('readonly', 'readonly');", checkInDate);
//            javascriptExecutorComponent.executeScript("document.getElementById(\"" + checkInDatePicker + "\").removeAttribute('value')", checkInDate);
//            System.out.print("checkInDatePicker value is: " + checkInDatePicker);
//            checkInDate.click();
//            checkInDate.sendKeys(Keys.CONTROL + "a");
//            checkInDate.sendKeys(Keys.DELETE);
//            checkInDate.sendKeys(checkIn);

        WebElement checkInDate = waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                    (findWebElementComponent.findElement
                            (findWebElementComponent.findSelector
                                    ("checkInDate"))
                    ), constantsUtility.TIMEOUT, constantsUtility.POLLING);

        for (String checkinDatePicker: checkIn) {
            javascriptExecutorComponent.executeScript("document.getElementById(\"" + checkinDatePicker + "\").removeAttribute('readonly', 'readonly')", checkIn);
        }
            System.out.print("checkInDatePicker value is: " + checkInDate);
            checkInDate.click();
            checkInDate.sendKeys(Keys.CONTROL + "a");
            checkInDate.sendKeys(Keys.DELETE);
            checkInDate.sendKeys("7 April 2020");
            checkInDate.sendKeys(Keys.TAB);
        }

    public void enterCheckOutDate() {

            waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                    (findWebElementComponent.findElement
                            (findWebElementComponent.findSelector
                                    ("checkOutDate"))
                    ), constantsUtility.TIMEOUT, constantsUtility.POLLING).sendKeys(Keys.TAB);
    }

    public boolean verifyDisabledReduceGuestButton()
    {
        WebElement reduceGuest = this.controller.getDriver().findElement
                        (By.xpath("//*[@id=\"search_advanced\"]/div/div[2]/span[1]/button"));

       return !reduceGuest.isEnabled();
    }

    public boolean verifyEnabledReduceGuestButton()
    {
        WebElement reduceGuest = this.controller.getDriver().findElement
                (By.xpath("//*[@id=\"search_advanced\"]/div/div[2]/span[1]/button"));

        return reduceGuest.isEnabled();
    }

    public void clickAddGuestButton()
    {
        WebElement addGuest = this.controller.getDriver().findElement
                (By.xpath("//*[@id=\"search_advanced\"]/div/div[2]/span[4]/button"));

        addGuest.click();
    }

    public boolean verifyDisabledReduceRoomButton()
    {
        WebElement reduceGuest = this.controller.getDriver().findElement
                (By.xpath("//*[@id=\"search_advanced\"]/div/div[3]/span[1]/button"));

        return !reduceGuest.isEnabled();
    }

    public boolean verifyEnabledReduceRoomButton()
    {
        WebElement reduceGuest = this.controller.getDriver().findElement
                (By.xpath("//*[@id=\"search_advanced\"]/div/div[2]/span[1]/button"));

        return reduceGuest.isEnabled();
    }

    public void clickAddRoomButton()
    {
        WebElement addGuest = this.controller.getDriver().findElement
                (By.xpath("//*[@id=\"search_advanced\"]/div/div[3]/span[4]/button"));

        addGuest.click();
    }

    public boolean verifyDisabledAddRoomButton()
    {
        WebElement addGuest = this.controller.getDriver().findElement
                (By.xpath("//*[@id=\"search_advanced\"]/div/div[3]/span[4]/button"));

        return !addGuest.isEnabled();
    }

    public void clickFindRooms()
    {
        waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                (findWebElementComponent.findElement
                        (findWebElementComponent.findSelector
                                ("find_room_button"))
                ), constantsUtility.TIMEOUT, constantsUtility.POLLING).click();
    }

    public boolean verifyUpdateSearch_isPresent()
    {
        WebElement updateSearchbtn = findWebElementComponent.findElement
                (findWebElementComponent.findSelector("updateSearch"));

        try {
            waitComponent.fluentWait(ExpectedConditions.textToBePresentInElement
                            (updateSearchbtn, "Update Search")
                    , constantsUtility.TIMEOUT, constantsUtility.POLLING);
        } catch (Exception e)
        {
            Assert.fail("Actual string is different from Expected String" + e.getMessage());
        }

        return updateSearchbtn.isDisplayed();
    }
}
