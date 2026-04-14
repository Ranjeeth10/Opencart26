package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.Dataproviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class,groups="Datadriven")//getting data provider from different class
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException {
		
		logger.info("***Starting TC_003_LoginDDT****");
		
		try {
			//Homepage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//login
			Loginpage lp = new Loginpage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExist();
			
			if(exp.equalsIgnoreCase("Valid")) {
				if (targetPage==true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
				
			}
			if(exp.equalsIgnoreCase("InValid")) {
				if (targetPage==true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
				
			
		}
		
		
		
	}catch(Exception e ) {
		Assert.fail();
	}
		Thread.sleep(3000);
		logger.info("****Finished TC_003_LoginDDT");
	}

}
