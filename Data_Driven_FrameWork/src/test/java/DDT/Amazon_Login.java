package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import lib.ExcelDataConfig;
import lib.Log;


public class Amazon_Login {

	WebDriver driver;
	
	@Test(dataProvider = "TestData")
	public void login_Amazon (String username, String password) {
		ChromeDriverManager.getInstance().setup();
		WebDriver driver = new ChromeDriver();
		Log.info("Browser Open");
		driver.get("https://www.amazon.com/");
		Log.info("Navigate to Application");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys(username);
		Log.info("UserName Entered");
		driver.findElement(By.id("ap_password")).sendKeys(password);
		Log.info("Password Entered");
		driver.findElement(By.id("signInSubmit")).click();
		driver.quit();
		Log.info("Browser Quit");
	}

/*	@DataProvider (name = "TestData")
	public Object [][] passData() {
		Object [][] data = new Object [3][2];
		data[0][0] = "debazroy@yahoo.com";
		data[0][1] = "nidhiroy";
		data[1][0] = "debaroy@gmail.com";
		data[1][1] = "Nabonita2";
		data[2][0] = "debazzroy@yahoo.in";
		data[2][1] = "Nabonita2";

		return data;
	}*/

	@DataProvider (name = "TestData")
	public Object[][] passData() {
		ExcelDataConfig config = new ExcelDataConfig("C:\\EclipseJava\\javaworkspace\\Data_Driven_FrameWork\\src\\test\\java\\DDT_testData\\TestData.xlsx");
		int rows = config.getRowCount(0);
		Object[][] data = new Object[rows][2];
		for (int i=0; i<rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}
		return data;
	}


}
