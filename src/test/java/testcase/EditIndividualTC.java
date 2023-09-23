package testcase;

import org.testng.annotations.Test;

import base.SalesForceBase;
import screen.LoginScreen;

public class EditIndividualTC extends SalesForceBase {

	@Test
	public void runEdit() throws InterruptedException {

		new LoginScreen(driver).enterUsername().enterPassword().clickLogin().getIndividual().displayIndividual().editIndividual();
	}

}
