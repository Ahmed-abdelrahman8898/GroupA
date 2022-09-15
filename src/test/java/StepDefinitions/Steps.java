package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	static ChromeDriver driver;
	static Pages.FirstPage firstpage;
	public static WebDriverWait wait ;
	
	
	@Before()
	public void startdriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		firstpage =new Pages.FirstPage(driver);
		
	}
	
	
	@Given("the user navigate to the registration page")
	public void the_user_navigate_to_the_registration_page() {
		
		
		wait.until(ExpectedConditions.visibilityOf(firstpage.signin())).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(firstpage.createaccount_ele())).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='a-box a-spacing-extra-large']/div/h1")).getText().trim(), "Konto erstellen");
	    
	}
	@When("the user type wrong email and click submit")
	public void the_user_type_wrong_email_and_click_submit() {
		firstpage.email().sendKeys("dddddddddddddddddddd");
		firstpage.submitbtn().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	

	@Then("the error msg appear {string}")
	public void the_error_msg_appear(String string) {
		Assert.assertEquals(driver.findElement(By.id("auth-email-invalid-claim-alert")).getText().trim(),string);
		 
	}




	
	@When("the user type  username {string} type password {string} and  click submit")
	public void the_user_type_username_type_password_and_click_submit(String string, String string2) {
		System.out.println( "this is username "+string);
		System.out.println( "this is password "+string2);
		//.sendkey(string)
		//.sendkey(string2)
	}
	@Then("this error msg {string} appear")
	public void this_error_msg_appear(String string) {
		System.out.println( "this is error "+string);
	}








	
	@After()
	public void takeScreenshotOnFailure(Scenario scenario) {

		if (scenario.isFailed()) {
			
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png","");
		}
		//try remove the wait to check the error of socet
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		driver.quit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}







}
