package com.compareasiagroup.automation.component.MoneymaxComponent;
import com.compareasiagroup.automation.component.*;
import com.compareasiagroup.automation.controller.Controller;
import com.compareasiagroup.automation.utilities.ConstantsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZenTestPersonalDetailsComponent {

    private final FindWebElementComponent findWebElementComponent;
    private final WaitComponent waitComponent;
    private final ConstantsUtility constantsUtility;
    private InputComponent inputComponent;
    private ActionBuilderComponent actionBuilderComponent;
    private Controller controller;

    public ZenTestPersonalDetailsComponent(FindWebElementComponent findWebElementComponent,
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

    public void enterFirstName(String firstName)
    {
        WebElement firstNameTextBox = findWebElementComponent.findElement
                (findWebElementComponent.findSelector
                        ("personalDetails_firstName"));

        inputComponent.input(firstNameTextBox, firstName);
    }

    public void enterLastName(String lastName)
    {
        WebElement lastNameTextBox = findWebElementComponent.findElement
                (findWebElementComponent.findSelector
                        ("personalDetails_lastName"));

        inputComponent.input(lastNameTextBox, lastName);
    }

    public void enterPhoneNumber(String phoneNumber)
    {
        WebElement phoneNumberTextBox = findWebElementComponent.findElement
                (findWebElementComponent.findSelector
                        ("personalDetails_phoneNumber"));

        inputComponent.input(phoneNumberTextBox, phoneNumber);
    }

    public void enterEmailAdd(String emailAdd)
    {
        WebElement emailAddTextBox = findWebElementComponent.findElement
                (findWebElementComponent.findSelector
                        ("personalDetails_emailAddress"));

        inputComponent.input(emailAddTextBox, emailAdd);
    }

    public void enterVoucherCode(String voucherCode)
    {
        WebElement voucherCodeTextBox = findWebElementComponent.findElement
                (findWebElementComponent.findSelector
                        ("personalDetails_voucherCode"));

        inputComponent.input(voucherCodeTextBox, voucherCode);
    }

    public void clickApplyVoucher()
    {
        waitComponent.fluentWait(ExpectedConditions.elementToBeClickable
                (findWebElementComponent.findElement
                        (findWebElementComponent.findSelector
                                ("personalDetails_applyVoucherCode")
                        )
                ), constantsUtility.TIMEOUT, constantsUtility.POLLING).click();
    }

    public boolean verifyIfVoucherActivated()
    {
        WebElement verifyVoucher = findWebElementComponent.findElement(findWebElementComponent.findSelector
                ("personalDetails_verifyVoucher"));

        return verifyVoucher.isDisplayed();
    }

    public void activateFreeCancellation()
    {
        WebElement freeCancellationCheckbox = findWebElementComponent.findElement
                (findWebElementComponent.findSelector
                        ("personalDetails_checkBox_freeCancellation"));

        freeCancellationCheckbox.click();
    }

    public boolean verifyFreeCancellationActivation()
    {
        WebElement activationMessage = findWebElementComponent.findElement
                (findWebElementComponent.findSelector
                        ("personalDetails_paymentRefund"));

        return activationMessage.isDisplayed();
    }

    public void clickContinue()
    {
        WebElement personalDetails_continueButton =
                this.controller.getDriver()
                        .findElement
                                (By.xpath("//*[@id=\"booking_optionals_form\"]/div[6]/button[1]"));

        personalDetails_continueButton.click();
    }




}
