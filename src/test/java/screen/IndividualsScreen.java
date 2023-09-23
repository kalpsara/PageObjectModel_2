package screen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class IndividualsScreen  {
	
	private RemoteWebDriver driver;
	
	@FindBy(xpath ="//div[text()='New']")
	WebElement NewIndividual;
	@FindBy(xpath ="//input[contains(@class,'lastName compound')]")
	WebElement Lastname;
	@FindBy(xpath ="(//span[text()='Save'])[2]")
	WebElement Save;
	@FindBy(xpath ="//a[@title='Individuals']//span[1]")
	WebElement Individuals;
	
	
	public IndividualsScreen(WebDriver driver) {
		super();
		this.driver = (RemoteWebDriver) driver;
		PageFactory.initElements(driver, this);
	}
	@Test
	public IndividualPersonScreen displayIndividual() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.executeScript("arguments[0].click();", Individuals);	
		return new IndividualPersonScreen(driver);
	}

	@Test
	public IndividualsScreen createIndividual() {

		
		driver.executeScript("arguments[0].click();", NewIndividual);
		Lastname.sendKeys("Kumars");
		Save.click();
		return new IndividualsScreen(driver);
	}

}
