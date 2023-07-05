package TestCasefolder;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Webpages.ParaAcctServPage;
import Webpages.Para_LoginPage;

public class Para_TC003 extends  ParaBaseClass {
//OPEN NEW ACCOUNT
	@Test
	public void openNewAccount() throws InterruptedException
	{
	Para_LoginPage plogin=new Para_LoginPage(driver);
	plogin.getURL();
	ParaAcctServPage newac=new ParaAcctServPage(driver);
	
	Thread.sleep(2000);
	plogin.Username("testh");
	plogin.Password("testh");
	plogin.ClickBtn();
	newac.newAccLink();
	newac.dpdown();
	newac.submitBtn();
	//Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.textToBePresentInElement(By.id("rightPanel"), "Congratulations"));
			
	if(driver.getPageSource().contains("Congratulations"))
	{
		Assert.assertTrue(true);
		System.out.println(driver.findElement(By.id("rightPanel")).getText());
	}
	else
			{
			Assert.assertTrue(false);
			}
	}
}
