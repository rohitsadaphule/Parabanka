package Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ParaAcctServPage {

	WebDriver ldriver;
	
	public ParaAcctServPage(WebDriver rdriver)
	{
	  ldriver = rdriver;
	 PageFactory.initElements(rdriver, this);
	 }


   @FindBy(xpath="//a[text()='Open New Account']")
   WebElement newacctlink;
   public void newAccLink()
   {
	   newacctlink.click();
   }
   
   	@FindBy(id="type")
   	WebElement accttype;
   public void dpdown()
   {
	  Select dpdown= new Select (accttype);
	  dpdown.selectByIndex(1);
   }

   @FindBy(xpath="//input[@type='submit']")
   WebElement submitbtn;
   public void submitBtn()
   {
	submitbtn.click(); 
   }
   
}