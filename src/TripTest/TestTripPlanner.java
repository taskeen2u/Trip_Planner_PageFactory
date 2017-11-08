package TripTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TripPlannerPckg.TripPlannerPage;

public class TestTripPlanner {
  
	public WebDriver driver;
	TripPlannerPckg.TripPlannerPage objTripPlanner;
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.get("https://transportnsw.info/trip#/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test
  	public void checkTrips() {
		
		  objTripPlanner = new TripPlannerPage(driver);
		  objTripPlanner.selectTrip("North Sydney", "Town Hall");
		  
				  
		  int trips = objTripPlanner.tripsList.size();
	      if (trips>0){
	        	Assert.assertTrue(trips>0,"Trips returned is more than 1");
	        }
	        	else
	        	{
	        		Assert.assertFalse(trips==0, "No trips returned");
	        }
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
