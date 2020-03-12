package com.compareasiagroup.automation.component.MoneymaxComponent;
import com.compareasiagroup.automation.component.FindWebElementComponent;
import com.compareasiagroup.automation.component.InputComponent;
import com.compareasiagroup.automation.component.JavascriptExecutorComponent;
import com.compareasiagroup.automation.component.WaitComponent;
import com.compareasiagroup.automation.controller.Controller;
import com.compareasiagroup.automation.utilities.ConstantsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZenTestUpdateComponent {

    private final FindWebElementComponent findWebElementComponent;
    private final WaitComponent waitComponent;
    private final ConstantsUtility constantsUtility;
    private InputComponent inputComponent;
    private JavascriptExecutorComponent javascriptExecutorComponent;
    private Controller controller;

    public ZenTestUpdateComponent(FindWebElementComponent findWebElementComponent,
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

    public void updateDestination(String updatedDestination)
    {
        WebElement updatedDestinationTextbox = waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                (findWebElementComponent.findElement
                        (findWebElementComponent.findSelector
                                ("hotelDestination"))
                ), constantsUtility.TIMEOUT, constantsUtility.POLLING);

        updatedDestinationTextbox.sendKeys(Keys.CONTROL + "a");
        updatedDestinationTextbox.sendKeys(Keys.BACK_SPACE);
        inputComponent.input(updatedDestinationTextbox, updatedDestination);
        waitComponent.safeWait(3000);
        updatedDestinationTextbox.click();
        updatedDestinationTextbox.sendKeys(Keys.ARROW_DOWN);
        updatedDestinationTextbox.sendKeys(Keys.ENTER);
        waitComponent.safeWait(3000);
    }

    public void updateCheckInDateFrom(String[] updateCheckIn)
    {
        WebElement updateCheckInDate = waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                (findWebElementComponent.findElement
                        (findWebElementComponent.findSelector
                                ("checkInDate"))
                ), constantsUtility.TIMEOUT, constantsUtility.POLLING);

        for (String updatedcCeckinDatePicker: updateCheckIn) {
            javascriptExecutorComponent.executeScript("document.getElementById(\"" + updatedcCeckinDatePicker + "\").removeAttribute('readonly', 'readonly')", updateCheckIn);
        }
        System.out.print("checkInDatePicker value is: " + updateCheckInDate);
        updateCheckInDate.click();
        updateCheckInDate.sendKeys(Keys.CONTROL + "a");
        updateCheckInDate.sendKeys(Keys.DELETE);
        updateCheckInDate.sendKeys("25 April 2020");
        updateCheckInDate.sendKeys(Keys.TAB);
    }

    /*

    public boolean verifyUpdatedDestination()
    {
        WebElement verifyUpdatedDestinationTextbox = findWebElementComponent.findElement
                (findWebElementComponent.findSelector("hotelDestination"));

            verifyUpdatedDestinationTextbox.getText();

        System.out.println("value of string is: " + verifyUpdatedDestinationTextbox);

        return  verifyUpdatedDestinationTextbox.isDisplayed();

        Assert.assertEquals("Vigans City, Philippines", verifyUpdatedDestinationTextbox);
        } catch (Exception e) {
            Assert.fail("Actual and Expected text does not match" + e.getMessage());
        }
    }

     */

    public void updateRoom()
    {
        WebElement updateRoom = this.controller.getDriver().findElement
                (By.xpath("//*[@id=\"searchAdvanced\"]/div[3]/div[2]/span[1]"));

        updateRoom.click();
    }

    public void updateBookingDetails()
    {
        waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                (findWebElementComponent.findElement
                        (findWebElementComponent.findSelector
                                ("updateSearch")
                )
        ), constantsUtility.TIMEOUT, constantsUtility.POLLING).click();
    }
}
