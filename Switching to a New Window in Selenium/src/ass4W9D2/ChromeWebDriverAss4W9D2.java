package ass4W9D2;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeWebDriverAss4W9D2 {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 * @throws InterruptedException 
	 */

	@BeforeTest
	public void setUp() throws InterruptedException {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

	}

	/**
	 * Test Chrome windows
	 * 
	 * @throws InterruptedException
	 */
		@Test
		public void LearnEnglishWebSite() throws InterruptedException {
	

			// New Tabs
			// WindowType to create a new tab is TAB.
			WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
			newTab.get("https://www.adobe.com/sa_en/");
			System.out.println(driver.getTitle());
			Thread.sleep(2000);


			// New window
			// WindowType to create a new tab is Window.
			WebDriver newwindow = driver.switchTo().newWindow(WindowType.WINDOW);
			newwindow.get("https://www.google.com.sa/");
			System.out.println(driver.getTitle());
			Thread.sleep(2000);

			//handle opened windows and close them
			//https://www.browserstack.com/guide/handle-multiple-windows-in-selenium
			//https://www.lambdatest.com/blog/how-to-handle-multiple-windows-in-selenium-webdriver-using-java/
			Set<String> windows1 = driver.getWindowHandles(); 
			System.out.println(windows1); 
			for (String window : windows1) 
			{ 

			driver.switchTo().window(window); 
            String pageTitle=driver.getTitle();
            System.out.println("The web page title of child window is:"+pageTitle);
            driver.close();
            System.out.println("Child window closed");
			Thread.sleep(2000);
			}

			// Private incognito window
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.navigate().to("https://github.com/");
			System.out.println(driver.getTitle());
			Thread.sleep(2000);

		}
		
		/**
		 * Tear down the setup after test completes
		 */
		@AfterTest
		public void terminateBrowser() {
			// Close the browser
			driver.close();

			// Quite the selenium
			driver.quit();
		}
		

}
