package demo.project.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class OpenBrowser {

	public static WebDriver driver;
	public static final String URL = "https://url.com";
	public String Chrome = "\\\\AMIT\\EUCIC\\demo.project.com\\src\\main\\resources\\driver\\chromedriver.exe";
	public String IE = "D:\\Selenium\\Selworkspace\\demo.project.com\\src\\main\\resources\\driver\\IEDriverServer.exe";
	
	@BeforeClass
	public void initializebrowser() throws InterruptedException {

		/*
		 * driver = new FirefoxDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.get(common.URL);
		 */

		System.setProperty("webdriver.chrome.driver", Chrome);
		// driver = new ChromeDriver(); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("test-type");
		options.addArguments("--disable-popup-blocking");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(common.URL);
		Thread.sleep(3000);

		
		/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		 
		 //Method and Description - void setCapability(java.lang.String capabilityName, boolean value)
		 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		 
		 //Among the facilities provided by the System class are standard input, standard output, and error output streams; access to externally defined "properties"; a means of loading files and libraries; and a utility method for quickly copying a portion of an array.
		 System.setProperty("webdriver.ie.driver", common.IE);
		 
		 //InternetExplorerDriver(Capabilities capabilities)
		 WebDriver driver = new InternetExplorerDriver(capabilities);
		 
		 driver.manage().window().maximize();
		 driver.get(common.URL);
		 Thread.sleep(3000);*/
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}
