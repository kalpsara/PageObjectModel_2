package testcase;

import org.testng.annotations.Test;

import base.SalesForceBase;
import screen.LoginScreen;

public class DeleteIndividualTC extends SalesForceBase{

	@Test
	public void runDelete() throws InterruptedException {
		
		new LoginScreen(driver).enterUsername().enterPassword().clickLogin().getIndividual().displayIndividual().deleteIndividual();
	}

}
