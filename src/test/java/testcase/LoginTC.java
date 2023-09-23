package testcase;

import org.testng.annotations.Test;

import base.SalesForceBase;
import screen.LoginScreen;

public class LoginTC extends SalesForceBase{

	@Test
	public void runLogin() {
		new LoginScreen(driver).enterUsername().enterPassword().clickLogin();

	}
}
