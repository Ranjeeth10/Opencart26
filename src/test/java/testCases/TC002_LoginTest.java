package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups= {"Sanity","Master"})
	public void verify_login() {
		
		logger.info("****Starting TC002_LoginTest*****");
		try
		{
			//Homepage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//login
			Loginpage lp = new Loginpage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage=macc.isMyAccountPageExist();
			Assert.assertTrue(targetpage);//Assert.assertEquals(targetPage,true,"Login failed");
			
			}
		    catch(Exception e) 
		    {
		    	
		    	Assert.fail();
		    }
		
		logger.info("****Finished TC_002_LoginTest*****");
		
		}
		
	}


