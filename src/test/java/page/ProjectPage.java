package page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProjectPage {
	
	WebDriver driver;

	By Name = By.xpath("//*[@id=\"form-field-name\"]");
	By email =By.xpath("//*[@id=\"form-field-email\"]");
	By phone=By.xpath("//*[@id=\"form-field-phone\"]");
	By services = By.xpath("//*[@id=\"form-field-services\"]");
	By Time =By.xpath("//*[@id=\"form-field-time\"]");
	By makeappoinment=By.xpath("//*[@id=\"appointment\"]/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/form/div/div[8]/button");
    By date = By.xpath("//*[@id=\"form-field-date\"]");
	
	public  ProjectPage(WebDriver driver)
	{
	this.driver=driver;
	}
	
            
            
            public void mousehover()
       	 {
       		 
       	 Actions act=new Actions(driver);
         WebElement src=driver.findElement(By.xpath("//*[@id=\"menu-item-212\"]"));
       	act.moveToElement(src).perform();//PLACE THE MOUSEHOVER
       	
       	 }
       	 
            
        	public void scrolldown()
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().window().maximize();
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				
			}
        	
       	 public void titletvarification()
    	 
    	 {
    		 String actualtitle=driver.getTitle();
    			System.out.println(actualtitle);
    			String expectedtitle="neogenhomehealth";
    			if (actualtitle.equals(expectedtitle))
    			{
    				System.out.println("pass");
    				
    			}
    			else
    			{
    				System.out.println("fail");
    		}}
    	 
    			
    			
       	 public void Contentvarification()
    			{
    				String content=driver.getPageSource();
    				
    				if(content.contains("PROGRAMS"))
    				{
    					System.out.println("pass");
    				}
    				else
    				{
    					System.out.println("fail");
    				}
    			}
        	
        	
        	
       	 
       	 
       	 
     	public void logindatadriven() throws IOException  
    	{
    		
    		driver.findElement(By.xpath("//*[@id=\"elementor-popup-modal-8247\"]/div/a")).click();
    		File f=new File("D:\\homeo.xlsx");
    		FileInputStream fi=new FileInputStream(f);
    		XSSFWorkbook wb=new XSSFWorkbook(fi);
    		XSSFSheet sh=wb.getSheet("Sheet1");
    		for(int i=1;i<=sh.getLastRowNum();i++)
    		{
    			String usname=sh.getRow(i).getCell(0).getStringCellValue();
    			System.out.println("Name---"+usname);
    			
    			String mail=sh.getRow(i).getCell(1).getStringCellValue();
    			System.out.println("email---"+mail);
    			
    			driver.findElement(Name).clear();
    			driver.findElement(Name).sendKeys(usname);
    			driver.findElement(email).clear();
    			driver.findElement(email).sendKeys(mail);
    			
    		}
    	}
    	
    	 public void fiilcontinue(String ph)
    		{
    			driver.findElement(phone).sendKeys(ph);

    		}
    	 
    	 
    	 public void buttonvarify()
    	    {
    	   Select selectelement=new Select(driver.findElement(services)) ;
    	    List<WebElement> option = selectelement.getOptions();
    	    System.out.println(option.size());
    	   selectelement.selectByValue("Doctor Consultation at Home");
    	    
    	   Select selecttime=new Select(driver.findElement(Time)) ;
    	  List<WebElement> op = selecttime.getOptions();
    	  System.out.println(op.size());
    	   
    	   
    	  selecttime.selectByValue("08:30 AM - 10:30 AM");
    	  
    	
    	    }
    	
    	

        	public void datepick()
        	{
        	
        		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			       driver.findElement(date).click();
			 	   

			 	while(true)
			 	{
			 		
			 		WebElement month=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div"));
			 		String month1=month.getText();
			 		if(month1.equals("October 2023"))
			 		{
			 			System.out.println(month1);
			 			break;
			 		}
			 		else
			 		{
			 			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/span[31]")).click();
			 		}
			 	}

			 	List<WebElement> alldates = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/span"));
			 	for(WebElement dateelement:alldates)
			 	{
			 		String date=dateelement.getText();
			 		if(date.equals("31"))
			 		{
			 			dateelement.click();
			 			break;
			 			
        	}
			 	}
        	}
        	
        		
        	 } 
	

