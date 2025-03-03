package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage_Stepdef {

		WebDriver driver;
		LoginPage loginpage;
		
        
	@Given("I am  on the OpenCart login page")
	public void i_am_on_the_open_cart_login_page() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();	  // class level driver
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		 driver.manage().window().maximize();
		  // Create LoginPage object
		     loginpage = new LoginPage(driver);
		
	}

	@Given("I have entered a valid email and password")
	public void i_have_entered_a_valid_username_and_password() {
		loginpage.enterEmail("qatestertest@gmail.com");
		loginpage.enterPassword("Test@123");
	}

	@When("I  click on the login button")
	public void i_click_on_the_login_button() {
		loginpage.clickLoginButton();
	}

	@Then("I should  be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		  
		  // Make sure driver is not null before proceeding
        if (driver != null) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("My Account")); // Check for title after login
            System.out.println("Page title is: " + driver.getTitle());
        } else {
            System.out.println("Driver is not initialized.");
        }
        
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
	
	@Given("I have entered a invalid {string} and {string}")
	public void i_have_entered_a_invalid_and(String email, String password) {
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();
	}

	@Then("I should  see the error message indicating {string}")
	public void i_should_see_the_error_message_indicating(String error_message) {
		 String actualErrorMessage = loginpage.getErrorMessage();
	        Object expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
			assertEquals(expectedErrorMessage, actualErrorMessage);

			loginpage.logout();
	    } 
	
	@When("I  click on the {string} link")
	public void i_click_on_the_link(String string) {
		loginpage.getForgotPasswordlink();
		
	}

	
	@Then("I should  redirect to the forgot password page")
	public void i_should_redirect_to_the_forgot_password_page() {
	    loginpage.getForgotPasswordtitle();
	    loginpage.logout();
	}
	

}
