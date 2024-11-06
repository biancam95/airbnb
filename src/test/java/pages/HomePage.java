package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

import static utils.Utils.getCurrentDateInMMDDYYYY;

public class HomePage {
    WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(60));
    }

    // Test data
    public String checkinDateFormatter = getCurrentDateInMMDDYYYY(LocalDate.now().plusDays(7));
    public String checkoutDateFormatted = getCurrentDateInMMDDYYYY(LocalDate.now().plusDays(14));
    String desiredDestination = "Rome";

    // Selectors
    By destinationField = By.xpath("//input[contains(@class, 'i18z192n')]");
    By datesField = By.xpath("//div[contains(@class,'c1ddhymz atm_am_16wc86f')][1]");
    By checkInField = By.xpath("//div[@data-testid='" + checkinDateFormatter + "']");
    By checkOutFiled = By.xpath("//div[@data-testid='" + checkoutDateFormatted + "']");
    By guestField = By.xpath("//div[contains(@class,'c1ddhymz atm_h_1h6ojuz')]");
    By adultsIncreaseButton = By.xpath("//div[contains(@class, 'cnhxj7b')][1]//button[contains(@class, \"bv4zwx4\") and contains(@aria-label, \"increase value\")]");
    By childrenIncreaseButton = By.xpath("//div[contains(@class, 'cnhxj7b')][2]//button[contains(@class, \"bv4zwx4\") and contains(@aria-label, \"increase value\")]");
    By searchButton = By.xpath("//span[contains(@class, 't1ng71ne')]");

    public void searchFunctionality() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(destinationField)));

        driver.findElement(destinationField).sendKeys(desiredDestination);
        driver.findElement(datesField).click();
        driver.findElement(checkInField).click();
        driver.findElement(checkOutFiled).click();
        driver.findElement(guestField).click();
        driver.findElement(adultsIncreaseButton).click();
        driver.findElement(adultsIncreaseButton).click();
        driver.findElement(childrenIncreaseButton).click();
        driver.findElement(searchButton).click();
    }
}
