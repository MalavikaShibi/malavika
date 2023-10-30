package Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.ProjectPage;

public class ProjectTest {
WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get( "https://www.neogenhomehealth.com/");
		
	}
	@Test
	public void test1()throws IOException
	{
		ProjectPage ob=new ProjectPage(driver);
		
		
		ob.mousehover();
		ob.scrolldown();
		ob.Contentvarification();
		ob.titletvarification();
		ob.logindatadriven();
		ob.fiilcontinue("9936478254");
		ob.buttonvarify();
	    ob.datepick();
	
	}}



