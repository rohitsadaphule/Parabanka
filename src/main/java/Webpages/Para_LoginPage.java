package Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction.Button;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Para_LoginPage {
	WebDriver ldriver;
	public Para_LoginPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	public void getURL() {
		ldriver.get("https://parabank.parasoft.com/parabank/lookup.htm");
		ldriver.manage().window().maximize();
	}
	
    @FindBy(name="username")
    WebElement username;
    public void Username(String uname)
    {
    	username.sendKeys(uname);
    }
    
    @FindBy(name="password")
    WebElement password ;
    public void Password(String pwd)
    {
    	password.sendKeys(pwd);
    }
    
    @FindBy(xpath="//input[@class='button']")
    WebElement button;
    public void ClickBtn()
    {
    	button.click();
    }
    
    @FindBy(xpath="//a[text()='Log Out']")
    WebElement logout;
    public void logOut()
    {
    	logout.click();
    }
}
