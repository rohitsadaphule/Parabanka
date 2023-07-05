package Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParaRegisterPage {
	
	WebDriver ldriver;
	public ParaRegisterPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath="//a[text()='Register']")
	WebElement Register;
	public void registerBtn() {
	Register.click();
}
	
	@FindBy(id="customer.firstName")
	WebElement  Fname ;
	public void fName(String name) {
		Fname.sendKeys(name);
	}
	
	@FindBy(id="customer.lastName")
	WebElement Lname  ;
	public void lName(String last)
	{
		Lname.sendKeys(last);
	}
	
	@FindBy(id="customer.address.street")
	WebElement  Street ;
	public void street(String addst )
	{
		Street.sendKeys(addst);
		}
	
	@FindBy(id="customer.address.city")
	WebElement  City ;
	public void city(String ccity)
	{
		City.sendKeys(ccity);
	}
	
	@FindBy(id="customer.address.state")
	WebElement State;
	public void state(String sstate)
	{
		State.sendKeys(sstate);
	}
	
	@FindBy(id="customer.address.zipCode")
	WebElement  Zipcode ;
	public void zip(String code)
	{
		Zipcode.sendKeys(code);
	}
	
	@FindBy(id="customer.phoneNumber")
	WebElement  Phone ;
	public void phone(String no)
	{
		Phone.sendKeys(no);
	}
	
	@FindBy(id="customer.ssn")
	WebElement  Ssn ;
	public void sSN(String ssn)
	{
		Ssn.sendKeys(ssn);
	}
	
	@FindBy(id="customer.username")
	WebElement Username  ;
	public void username(String user)
	{
		Username.sendKeys(user);
	}
	
	@FindBy(id="customer.password")
	WebElement  Password ;
	public void password(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	@FindBy(id="repeatedPassword")
	WebElement  RepeatPass ;
	public void repeatPass(String rpass)
	{
		RepeatPass.sendKeys(rpass);
	}
	
	@FindBy(xpath="//input[@value='Register']")
	WebElement Registerbtn;
	public void registerBtn1()
	{
		Registerbtn.click();
	}
	

}
