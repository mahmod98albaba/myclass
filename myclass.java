import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class myclass {

    WebDriver driver = new ChromeDriver();
    SoftAssert myAssertion = new SoftAssert();
    String expectedCurrency = "SAR";
    String expectedLang = "العربية";

    @BeforeTest
    public void setup() {
    }

    @Test
    public void testAlmosaferWebsite() {
        driver.get("https://www.almosafer.com/en");
        driver.findElement(By.className("cta__button")).click();

        String ActualCurrency = driver.findElement(By.className("fPnvOO")).getText();
        myAssertion.assertEquals(ActualCurrency, expectedCurrency, "Currency  match");

        String ActualLang = driver.findElement(By.className("jJNggu")).getText();
        myAssertion.assertEquals(ActualLang, expectedLang, "Language  match");

        WebElement flightsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-flights"));
        boolean isFlightsTabSelected = flightsTab.getAttribute("aria-selected").equals("true");

        myAssertion.assertTrue(isFlightsTabSelected, "Flights tab is selected by default");

        myAssertion.assertAll();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
