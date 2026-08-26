import org.junit.After;
import org.junit.Before;
import org.testng.annotations.BeforeClass;

import com.flipkartstepdefinition.AutomationExerciseSetup;

public class Hooks extends Commonaction {
	
	long StartTime;
	Long endTime;
	
	@Before
	public void launchsetup() {
		
		StartTime = System.currentTimeMillis();
		System.out.println("Scenario Execution Started");
		launchApplication("https://www.automationexercise.com/");
	}
	
	@After
	public void exitsetup() {
		endTime = System.currentTimeMillis();
		long executiontime = endTime - StartTime;
		System.out.println("Execution completed");
		System.out.println("Execution Time:"+(executiontime/1000)+"seconds");
		closebrowser();
		
		
	}

}
