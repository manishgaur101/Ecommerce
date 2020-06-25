package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import static reportutil.ExtenReport.extentPass;
import static reportutil.ExtenReport.extentFail;

import reportutil.ExtenReport;

public class Login {

	
	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement sign_in_button;
	
	@FindBy(id = "email")
	WebElement email_text_box;
	
	@FindBy(id = "passwd")
	WebElement password_text_box;
	
	@FindBy(name = "SubmitLogin")
	WebElement submit_button;
	
	public Login(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public void loginApp(String userName, String password){
		
		sign_in_button.click();
		email_text_box.sendKeys(userName);
		password_text_box.sendKeys(password);
		submit_button.click();
		extentPass("LoginApp");
	}
	
	
}
