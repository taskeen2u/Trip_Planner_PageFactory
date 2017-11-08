package TripPlannerPckg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TripPlannerPage {
 
	WebDriver driver;
	
	@FindBy(id = "search-input-From")
	WebElement fromTextBox;

	@FindBy(id = "search-input-To")
	WebElement toTextBox;
	
	@FindBy(id = "search-button")
	WebElement goButton;
	
	@FindBy(css = ".row")
	public List<WebElement> tripsList;  
	
	public TripPlannerPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectLocation(String location){
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#suggestion-"+ location +"-0"))).click();
	}	    
	
	public void setFromBox(String strFrom) {
      fromTextBox.sendKeys(strFrom);
      selectLocation("From");
      
	}
	
	public void setToxBox(String strTo){
		toTextBox.sendKeys(strTo);
		selectLocation("To");
	}
	
	public void clickGo(){
		goButton.click();
	}

	public void selectTrip(String strFrom,  String strTo){
		this.setFromBox(strFrom);
		this.setToxBox(strTo);
		this.clickGo();
		}
}
