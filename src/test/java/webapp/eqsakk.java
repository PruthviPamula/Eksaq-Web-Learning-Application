package webapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eqsakk {
		WebDriver wd;
		WebDriverWait wait;
		JavascriptExecutor js;
		ExtentHtmlReporter htmlreporter;
		ExtentReports Sravani;
		ExtentTest test;
		
		@BeforeTest
		public void t() {
			ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("Sravani.html");
			Sravani = new ExtentReports();
			Sravani.attachReporter(htmlreporter);
			WebDriverManager.chromedriver().setup();
			wd= new ChromeDriver();
			wd.manage().window().maximize();
			wd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			wd.get("https://uat.eksaqonline.com/");
	}
	@Test()
	public void test1() throws InterruptedException {
		Thread.sleep(3000);
			test = Sravani.createTest("This my first test");
			wd.findElement(By.xpath("(//*[@role='button'])[3]")).click();
			test.pass("alert button clicked succesfully");
			wd.findElement(By.xpath("(//*[@href='https://uat.eksaqonline.com/index.php/user-account'])[3]")).click();
			test.pass("login button clicked Succesfully");
			wd.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("testorguat1@mailinator.com");
			test.pass("user name entered Succesfully");
			wd.findElement(By.xpath("(//*[@class='input-text'])[2]")).sendKeys("Abcd@123");
			test.pass("password entered Succesfully");
			js = (JavascriptExecutor)wd;
		    js.executeScript("window.scrollBy(0,100)");
			wd.findElement(By.xpath("(//*[@type='submit'])[3]")).click();
			test.pass("submitt button clicked succesfully");
			wd.findElement(By.xpath("(//*[@href='https://uat.eksaqonline.com/index.php/all-programs'])[2]")).click();
			test.pass("Course button clicked succesfully");
			js = (JavascriptExecutor)wd;
		    js.executeScript("window.scrollBy(0,300)");
			wd.findElement(By.xpath("//*[text() = 'RCA NAGARAM']")).click();
			test.pass("RCA Course buttton clicked Succesfully");
			wd.findElement(By.xpath("(//*[@type='number'])[1]")).sendKeys("5");
			test.pass("data entered Succesfully");
			wd.findElement(By.xpath("(//*[@type='number'])[2]")).sendKeys("5");
			test.pass("data entered Succesfully ");
			js= (JavascriptExecutor)wd;
		    js.executeScript("window.scrollBy(0,200)");
		    Thread.sleep(3000);
			wd.findElement(By.xpath("//*[text() = 'Subscribe']")).click();
			test.pass(" Subscribe button clicked Succesfully");
			Thread.sleep(3000);
			wd.findElement(By.xpath("//*[text() = 'View cart']")).click();
			test.pass("View Cart button clicked Succesfully");
			js= (JavascriptExecutor)wd;
		    js.executeScript("window.scrollBy(0,500)");
			wd.findElement(By.xpath("//*[contains(text(), 'Proceed to Checkout')]")).click();
			test.pass("Checkout button clicked Succesfully");
			js= (JavascriptExecutor)wd;
		    js.executeScript("window.scrollBy(0,800)");
		    Thread.sleep(3000);
		    wd.findElement(By.xpath("(//*[@type='radio'])[2]")).click();
		    test.pass("Radio button clicked Succesfully");
		    Thread.sleep(3000);
			wd.findElement(By.xpath("(//*[@type='submit'])[4]")).click();
			test.pass("Submit button clicked Succesfully");
		
	}
			@AfterTest
				public void at() {
				wd.quit();
				Sravani.flush();
				System.out.println("Test Passed Successfully");
			}
	}

