import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.TimeUnit
import com.kms.katalon.core.webui.driver.DriverFactory;
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testdata.TestData as TestData
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.ChromeDriver
import org.junit.After
import org.openqa.selenium.By

WebUI.callTestCase(findTestCase('TC2 - Verify if the USER can update his or her Booking Details before making reservation'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Landing Page/sortByOption'))

WebUI.click(findTestObject('Landing Page/priceAscendingOption'))

TestObject selectedHotel = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="roomsDisplay"]/span[1]')

WebUI.click(selectedHotel)

//User redirects to new tab
//Details of selectedHotel and Booking Details are displayed

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

WebUI.switchToWindowIndex(1)

WebUI.delay(2)

//verify if user is in selected hotel's page

WebUI.verifyElementPresent(findTestObject('Landing Page/bookNow_button'), 20)

WebUI.verifyElementPresent(findTestObject('Landing Page/policies_tab'), 20)

WebUI.click(findTestObject('Landing Page/bookNow_button'))

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

//verify if user is in personal details tab

WebUI.verifyElementPresent(findTestObject('Checkout Page/personalDetails_label'), 20)

WebUI.setText(findTestObject('Checkout Page/firstName_textbox'), 'Rogie')

WebUI.setText(findTestObject('Checkout Page/lastName_textbox'), 'Acuna')

WebUI.setText(findTestObject('Checkout Page/phoneNumber_textbox'), '09175991997')

WebUI.setText(findTestObject('Checkout Page/emailAdd_textbox'), 'it.rogieacuna@gmail.com')

WebUI.click(findTestObject('Checkout Page/freeCancellation_checkbox'))

//verify if add-on is successfully added on booking details

WebUI.verifyElementVisible(findTestObject('Checkout Page/verifyAddOn'))

WebUI.click(findTestObject('Checkout Page/continue_button'))

WebUI.delay(3)

WebUI.click(findTestObject('Checkout Page/onlineBanking_label'))

WebUI.delay(5)

//verify if the user redirects to payment gateway page

WebUI.verifyElementPresent(findTestObject('Payment Gateway Page/paymentGateway_continueButton'), 0)

WebUI.click(findTestObject('Payment Gateway Page/paymentMethod_PSBank'))

WebUI.delay(5)

//verify if user hotel reservation is unsuccessful

WebUI.verifyElementPresent(findTestObject('Booking Response Page/paymentResponse_failedLabel'), 10)

