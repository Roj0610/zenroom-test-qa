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
import org.openqa.selenium.By

WebUI.callTestCase(findTestCase('TC1 - Verify that user can search for destination'), [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver() 

WebUI.executeJavaScript('document.getElementById("searchText").removeAttribute("value")', null)

driver.findElement(By.id("searchText")).sendKeys("")

driver.findElement(By.id("searchText")).sendKeys('Vigan City, Philippines')

WebUI.delay(5)

driver.findElement(By.id("searchText")).sendKeys(Keys.ARROW_DOWN)

driver.findElement(By.id("searchText")).sendKeys(Keys.ENTER)

WebUI.executeJavaScript('document.getElementById("checkinDate").removeAttribute("readonly")', null)

WebUI.setText(findTestObject('Landing Page/checkinDate'), '25 April 2020')

WebUI.executeJavaScript('document.getElementById("rooms").removeAttribute("readonly")', null)

driver.findElement(By.id("rooms")).sendKeys("1 Rooms")

driver.findElement(By.xpath('//*[@id="searchAdvanced"]/div[3]/div[2]/span[1]')).click()

WebUI.delay(2)

WebUI.click(findTestObject('Landing Page/updateSearch_button'))

//Verify if booking details is updated

WebUI.verifyElementAttributeValue(findTestObject('Landing Page/result_destinationTextbox'), 'value', 'Vigan City, Philippines', 20)
