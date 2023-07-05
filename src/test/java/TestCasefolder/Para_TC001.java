package TestCasefolder;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ParaExcelUtils;
import Webpages.Para_LoginPage;

public class Para_TC001 extends ParaBaseClass{
	//Login - Pass
	
	@Test(dataProvider="loginddt")
	public void Login(String user, String pwd)
	{
		
		Para_LoginPage pl= new Para_LoginPage(driver);
		pl.getURL();
		pl.Username(user);
		pl.Password(pwd);
		pl.ClickBtn();
	
		if(driver.getPageSource().contains("Accounts Overview"))
		{
			Assert.assertTrue(true);
			pl.logOut();
		}
		else
		{
			Assert.assertTrue(false);
			
		}
		
	}
	
		@DataProvider(name="loginddt")
		public Object[][] getData() throws IOException
		{
			
			String path= System.getProperty("user.dir")+"\\TestData\\Paradata.xlsx";
			int rowcount= ParaExcelUtils.getRowcount(path, "Sheet1");
			int colcount= ParaExcelUtils.getColcount(path, "Sheet1", rowcount);
			Object data[][]= new Object [rowcount][colcount];
			for(int i=1; i<=rowcount; i++)
			{
				for (int j=0; j<colcount; j++)
				{
					data[i-1][j]=ParaExcelUtils.getCellData(path,"Sheet1", i, j);
				}
			}
			return data;
			 
		}
		
		
	}

	
	
	
	


