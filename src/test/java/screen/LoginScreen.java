package screen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen {

	private WebDriver driver;
	// Page Factory
	@FindBy(id = "username")
	WebElement Username;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(id = "Login")
	WebElement Login;

	public LoginScreen(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginScreen enterUsername() {
		Username.sendKeys("kalpsara@testleaf.com");
		return this;
	}

	public LoginScreen enterPassword() {
		Password.sendKeys("Welcome@123");
		return this;
	}

	public HomeScreen clickLogin() {
		Login.click();
		return new HomeScreen(driver);
	}

}
