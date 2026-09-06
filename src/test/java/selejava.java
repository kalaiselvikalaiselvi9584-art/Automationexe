import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class selejava {
	
	
		WebDriver driver;
		long startTime;
		String mobile = "vivo T5x 5G (Cyber Green, 128 GB)";
		String mobile1 = "OPPO K13 Turbo Pro 5G (Midnight Maverick, 256 GB)";
		String mobile2 = "KARBONN Titanium Jumbo (Black, 16 GB)";
		
		@DataProvider
		public Object[][] MobilesData(){
			return new Object[][] {
				//{"vivo T5x 5G (Cyber Green, 128 GB)"},
				{"OPPO K13 Turbo Pro 5G (Midnight Maverick, 256 GB)"},
				//{"KARBONN Titanium Jumbo (Black, 16 GB)"}
			};
			
			
		}
		
		@BeforeClass
		public void Urllaunch() {
			driver=new ChromeDriver();
		}
		@BeforeMethod
		
		public void openamazapplication() throws InterruptedException {
			startTime=System.currentTimeMillis();
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com");
			Thread.sleep(3000);
		
			try {
				driver.findElement(By.xpath("//span[@role=\"button\"]"));
			} catch (Exception e) {
				System.out.println("pop not handles");
			}finally {
				System.out.println("pop successfully handled");
			}
		}
		
		@Test(priority=3,dependsOnMethods="verifymobile1searchresult",timeOut=2000)
		public void verifymobilesearchresult() {
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys("vivo",Keys.ENTER);
			String Actualmobile = driver.findElement(By.xpath("//div[text()='"+mobile+"']")).getText();
			Assert.assertEquals(Actualmobile, mobile,"Expected vivo mobile was not displayed");
			System.out.println("vivo mobile  successfuly displayed");
			
		}
		@Test(priority=2,invocationCount=1,timeOut=9000,dataProvider="MobilesData",enabled=false)
		public void verifymobile1searchresult(String MobilesData) {
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys("OPPO",Keys.ENTER);
			String Actualmobile = driver.findElement(By.xpath("//div[text()='"+mobile1+"']")).getText();
			Assert.assertEquals(Actualmobile, mobile1,"Expected OPPO mobile was not displayed");
			System.out.println("OPPO mobile  successfuly displayed");
			
		}
		@Test(priority=1,enabled=false,timeOut=7000)
		public void verifymobile2searchresult() {
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys("KARBONN",Keys.ENTER);
			String Actualmobile = driver.findElement(By.xpath("//div[text()='"+mobile2+"']")).getText();
			Assert.assertEquals(Actualmobile, mobile2,"Expected KARBONN mobile was not displayed");
			System.out.println("KARBONN mobile  successfuly displayed");
			
		}
		@AfterMethod
		public void overalltestcasecalcuationtime() {
			long endTime=System.currentTimeMillis();
			long excutionTime= endTime-startTime;
			System.out.println("Test execution time:"+excutionTime+"ms");
		}
		
		@AfterClass
		public void closeapplication() {
			driver.quit();
		}
		
		
		
	

}
