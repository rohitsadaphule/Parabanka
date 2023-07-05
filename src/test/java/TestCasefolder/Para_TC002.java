package TestCasefolder;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ParaExcelUtils;
import Webpages.ParaRegisterPage;
import Webpages.Para_LoginPage;

public class Para_TC002 extends ParaBaseClass {
//Register-Pass
	
	@Test(dataProvider="Registerdata")
	public void TestRegister(String fname, String lname, String stt, String cty, String sta, String zcde,
			String ph,	String ssn, String user, String pwd, String rePass  ) throws InterruptedException {
		
	Para_LoginPage pl= new Para_LoginPage(driver);
	pl.getURL();
	Thread.sleep(2000);
	ParaRegisterPage reg=new ParaRegisterPage(driver);
	reg.registerBtn();
	reg.fName(fname);
	reg.lName(lname);
	reg.street(stt);
	reg.city(cty);
	reg.state(sta);
	reg.zip(zcde);
	reg.phone(ph);
	reg.sSN(ssn);
	reg.username(user);
	reg.password(pwd);
	reg.repeatPass(rePass);
	reg.registerBtn1();
	
	if(driver.getPageSource().contains("Welcome"))
	{
		Assert.assertTrue(true);
		System.out.println("success");
	}
	else
	{
		Assert.assertTrue(false);
		System.out.println("fail");
	}
	
	}
	
	@DataProvider(name="Registerdata")
	public Object[][] getRData() throws IOException
	{
		String path= System.getProperty("user.dir")+"\\TestData\\Paradata.xlsx";
		int rowcount= ParaExcelUtils.getRowcount(path, "Sheet2");
		int colcount= ParaExcelUtils.getColcount(path, "Sheet2", rowcount);
		Object[][] dataa= new Object[rowcount][colcount];
		for(int i=1; i<=rowcount; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				dataa[i-1][j]=ParaExcelUtils.getCellData(path, "Sheet2", i, j);
			}
		}
		return dataa;
		
	}
}
	


