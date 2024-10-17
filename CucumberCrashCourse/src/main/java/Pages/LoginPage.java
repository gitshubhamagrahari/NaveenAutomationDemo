package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;

    // By locators
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@type='submit']");
    private By errorMessageLocator = By.xpath("//*[@id=\"account-login\"]/div[1]");
    private By ForgotPasswordLocator = By.linkText("Forgotten Password");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = driver.findElement(loginButtonLocator);
        loginBtn.click();
    }

    public String getErrorMessage()  {
    	WebElement errorMsg = driver.findElement(errorMessageLocator);
    return errorMsg.getText();

    }
    public void getForgotPasswordlink() {
    	WebElement link =driver.findElement(ForgotPasswordLocator);
    	link.click();
    }
    public void getForgotPasswordtitle() {
    	String title = driver.getTitle();

    	System.out.println("The page title is: " + title);
    }
    
    public void logout() {
    	
    	driver.quit();
    }
}
