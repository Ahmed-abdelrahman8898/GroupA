package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends PageBase {

	public FirstPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	@FindBy(xpath="//*[@id='nav-link-accountList-nav-line-1']")
	WebElement sigin_element;
	
	@FindBy(id="createAccountSubmit")
	WebElement createaccount;
	
	@FindBy(id="ap_email")
	WebElement email_txt;
	@FindBy(id="continue")
	WebElement submit;
	
	
	public void open_sigin() {
		sigin_element.click();
	}
	

	
	
	public WebElement signin(){
		return sigin_element;
	}
	public WebElement createaccount_ele(){
		return createaccount;
	}
	
	public WebElement email(){
		return email_txt;
	}
	public WebElement submitbtn(){
		return submit;
	}
	
	
	
	

}
