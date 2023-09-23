package screen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class IndividualPersonScreen {
	private RemoteWebDriver driver;

	@FindBy(xpath = "//input[@name='Individual-search-input']")
	WebElement SearchInput;
	@FindBy(xpath = "//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']")
	WebElement SelectionButton;
	@FindBy(xpath = "//a[@title='Edit']/div")
	WebElement Edit;

	@FindBy(xpath = "//a[@class='select']")
	WebElement Select;
	@FindBy(xpath = "//a[text()='Mr.']")
	WebElement Mr;
	@FindBy(xpath = "//input[contains(@class,'firstName')]")
	WebElement FirstName;
	@FindBy(xpath = "(//span[text()='Save'])[2]")
	WebElement Save;
	@FindBy(xpath = "//a[@title='Delete']/div")
	WebElement Delete;
	@FindBy(xpath = "//span[text()='Delete']")
	WebElement ConfirmDelete;
	@FindBy(xpath = "//span[contains(@class,'toastMessage')]")
	WebElement ToastMessage;
	
	@FindBy(xpath = "//span[text()='No items to display.']")
	WebElement NoItemsTodisplay;
	// a[@role='menuitem']/div[@title='Delete']

	public IndividualPersonScreen(WebDriver driver) {
		super();
		this.driver = (RemoteWebDriver) driver;
		PageFactory.initElements(driver, this);
	}

	@Test
	public IndividualPersonScreen editIndividual() throws InterruptedException {

		SearchInput.sendKeys("Kumars");
		SearchInput.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", SelectionButton);
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", Edit);
		Select.click();
		Mr.click();

		FirstName.sendKeys("Ganesh");
		Save.click();
		Thread.sleep(2000);
		String msg = ToastMessage.getText();
		return new IndividualPersonScreen(driver);

	}

	@Test(priority = 2)
	public IndividualsScreen deleteIndividual() throws InterruptedException {
		WebElement clk = driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
		driver.executeScript("arguments[0].click();", clk);
		Thread.sleep(2000);
		SearchInput.sendKeys("Kumars");
		SearchInput.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.executeScript("arguments[0].click();", SelectionButton);
		// Thread.sleep(2000);

		driver.executeScript("arguments[0].click();", Delete);
		Thread.sleep(3000);
		ConfirmDelete.click();
		String msg = ToastMessage.getText();
		System.out.println(msg);
		WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
		search.clear();
		search.sendKeys("Kumars", Keys.ENTER);
		Thread.sleep(3000);
		String verify = NoItemsTodisplay.getText();
		System.out.println(verify);
		// assertEquals(verify.equals("Individual \"Ganesh Kumars\" was deleted.
		// Undo\r\n"
		// + "No items to display."), true);
		return new IndividualsScreen(driver);
	}

}
