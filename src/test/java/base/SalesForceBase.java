package base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class SalesForceBase {

	public   RemoteWebDriver driver;

	@BeforeClass
	protected void setup() {
		System.out.println("@BeforeTest");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterClass
	protected void postConditions() {
		System.out.println("@@AfterTest");
		driver.close();
	}

	/*
	 * @BeforeClass protected void setup1() { System.out.println("@BeforeClass");
	 * 
	 * }
	 * 
	 * @AfterClass protected void postConditions1() {
	 * 
	 * System.out.println("@@AfterClass"); }
	 * 
	 * @BeforeMethod protected void setup2() { System.out.println("@Beforemethod");
	 * 
	 * }
	 * 
	 * @AfterMethod protected void postConditions2() {
	 * 
	 * System.out.println("@@Aftermethod"); }
	 */

}
