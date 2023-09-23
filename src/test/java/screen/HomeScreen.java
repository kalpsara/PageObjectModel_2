package screen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomeScreen  {

	private RemoteWebDriver driver;
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	WebElement WaffleIcon;
	@FindBy(xpath = "//button[text()='View All']")
	WebElement ViewAll;
	@FindBy(xpath = "//p[text()='Party Consent']")
	WebElement PartyConsent;
	@FindBy(xpath = "//p[text()='Individuals']")
	WebElement Individuals;

	public HomeScreen(WebDriver driver) {
		super();
		this.driver = (RemoteWebDriver) driver;
		PageFactory.initElements(driver, this);
	}

	@Test
	public IndividualsScreen getIndividual() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		WaffleIcon.click();
		wait.until(ExpectedConditions.elementToBeClickable(ViewAll));
		ViewAll.click();
		System.out.println("view all");
		wait.until(ExpectedConditions.visibilityOf(PartyConsent));
		driver.executeScript("arguments[0].scrollIntoView();", PartyConsent);

		wait.until(ExpectedConditions.elementToBeClickable(Individuals));
		driver.executeScript("arguments[0].click();", Individuals);
		return new IndividualsScreen(driver);
	}

}
