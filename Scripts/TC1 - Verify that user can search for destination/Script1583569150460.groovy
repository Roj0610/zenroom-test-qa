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

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

driver.navigate().to(GlobalVariable.URL)

driver.manage().window().maximize()

//user is in landing page

driver.findElement(By.id("searchText")).sendKeys("Cebu City, Philippines")

WebUI.delay(5)

driver.findElement(By.id("searchText")).sendKeys(Keys.ARROW_DOWN)

driver.findElement(By.id("searchText")).sendKeys(Keys.ENTER)

WebUI.executeJavaScript('document.getElementById("checkinDate").removeAttribute("readonly")', null)

WebUI.setText(findTestObject('Landing Page/checkinDate'), '7 April 2020')

WebUI.sendKeys(findTestObject('Landing Page/checkinDate'),Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('Landing Page/checkoutDate'),Keys.chord(Keys.TAB))

//verify if "-" button in [Guest] option is disabled

WebUI.verifyElementNotClickable(findTestObject('Landing Page/reduceGuest_button'))

WebUI.click(findTestObject('Landing Page/addGuest_button'))

//verify if "-" button in [Guest] option is enabled after adding guest

WebUI.verifyElementNotClickable(findTestObject('Landing Page/reduceRoom_button'))

WebUI.click(findTestObject('Landing Page/addRoom_button'))

//verify if "+" button in [Room] option is disabled

WebUI.verifyElementNotClickable(findTestObject('Landing Page/addRoom_button'))

//verify if "-" button in [Room] option is enabled

WebUI.verifyElementClickable(findTestObject('Landing Page/reduceRoom_button'))

WebUI.click(findTestObject('Landing Page/findRoom_button'))

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

//verify if user is in the results page

WebUI.verifyElementText(findTestObject('Landing Page/updateSearch_button'), 'Update Search')



