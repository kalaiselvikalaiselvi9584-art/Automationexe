import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Commonaction {
	
	public static WebDriver driver;
	public static WebDriver wait;
	
	public void launchApplication(String URL) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);	
	}
	
	
	public void closebrowser() {
		
		driver.quit();
		
	}

}
