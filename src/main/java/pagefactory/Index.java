package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static reportutil.ExtenReport.extentPass;
import static reportutil.ExtenReport.extentFail;


public class Index {
	
	WebDriver driver;
	
	@FindBy(linkText="Women")
	WebElement Women_tab;
	
	@FindBy(xpath="//h5[@itemprop='name']/a[@class='product-name']")
	List<WebElement> Woman_items_lists;
	
	@FindBy(xpath = "//a[@title='Add to cart']")
	WebElement addToCart_button;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement Proceed_to_checkout;
	
	public Index(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void addItemIntoCart(){
		try{
		Women_tab.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(Woman_items_lists.get(0)).perform();
		addToCart_button.click();
		Proceed_to_checkout.click();
		extentPass("addItemIntoCart");
		}
		catch(Exception e){
			extentFail("addItemIntoCart");
			e.printStackTrace();
			
		}
	}

}
