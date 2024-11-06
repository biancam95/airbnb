package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResultsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(60));
    }

    // Selectors
    By filterButton = By.xpath("//button[@data-testid='category-bar-filter-button']");
    By bedroomsIncreaseButton = By.xpath("//button[@data-testid='stepper-filter-item-min_bedrooms-stepper-increase-button']");
    By showMoreButton = By.xpath("//span[contains(@class, 'lsqfxex')]");
    By poolButton = By.xpath("//span[contains(text(), 'Pool')]");
    By applyButton = By.xpath("//div[contains(@class, 'ptiimno')]");
    By firstCardContainer = By.xpath("(//div[@data-testid=\"card-container\"])[1]");
    By appliedGuests = By.xpath("//li[contains(@class, 'l7n4lsf')]");
    By appliedLocation = By.className("f16sug5q");
    By showMoreAmenities = By.xpath("//button[contains(text(), 'amenities')]");
    By appliedPool = By.xpath("//div[contains(text(), 'pool')]");
    By mapElement = By.cssSelector("[data-testid='map/GoogleMap']");

    // Test data
    String expectedLocation = "Rome";

    public void checkAppliedFilters() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(firstCardContainer)));

        WebElement location = driver.findElement(appliedLocation);
        String actualLocation = location.getText();

        assertEquals(expectedLocation, actualLocation);
    }

    public void checkAppliedFiltersDetails() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(firstCardContainer)));

        List<WebElement> elements = driver.findElements(By.cssSelector("[data-testid='property-card']"));
        for (WebElement element : elements) {
            element.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebElement guests = driver.findElement(appliedGuests);
            int actualGuests = Integer.parseInt(guests.getText());
            assertTrue(actualGuests >= 3);
        }

    }

    public void applyAdvancedFilters() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(filterButton)));
        driver.findElement(filterButton).click();
        driver.findElement(filterButton).click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(bedroomsIncreaseButton)));
        driver.findElement(bedroomsIncreaseButton).click();
        driver.findElement(showMoreButton).click();
        driver.findElement(poolButton).click();
        driver.findElement(applyButton).click();
    }

    public void checkAppliedFiltersFirstProperty() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(firstCardContainer)));
        driver.findElement(firstCardContainer).click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(showMoreAmenities)));

        driver.findElement(showMoreAmenities).click();
        WebElement poolOption = driver.findElement(appliedPool);
        assertTrue(poolOption.isDisplayed());
    }

    public void hoverOverFirstProperty() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(firstCardContainer)));

        WebElement firstCard = driver.findElement(firstCardContainer);
        WebElement map = wait.until(ExpectedConditions.visibilityOfElementLocated(mapElement));
        assertTrue(map.isDisplayed());

        // Hover over first card
        Actions actions = new Actions(driver);
        actions.moveToElement(firstCard).perform();

        // Check highlighted item by its background color
        String backgroundColor = (firstCard).getCssValue("background-color");
        String expectedBackgroundColor = "rgba(0, 0, 0, 0)";
        assertEquals(expectedBackgroundColor, backgroundColor);
    }

}
