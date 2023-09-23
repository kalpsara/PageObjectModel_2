package testcase;

import org.testng.annotations.Test;

import base.SalesForceBase;
import screen.LoginScreen;

public class CreateIndividualTC extends SalesForceBase {

	@Test
	public void runCreate() {

		//new LoginScreen(driver).enterUsername().enterPassword().clickLogin().createIndividual();
	new LoginScreen(driver).enterUsername().enterPassword().clickLogin().getIndividual().createIndividual();
		
	}

}
