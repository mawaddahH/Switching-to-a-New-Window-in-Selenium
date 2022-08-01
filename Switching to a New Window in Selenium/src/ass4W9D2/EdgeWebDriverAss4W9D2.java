package ass4W9D2;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EdgeWebDriverAss4W9D2 {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 * 
	 * @throws InterruptedException
	 */

	@BeforeTest
	public void setUp() throws InterruptedException {
		// the path for open WebSite
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\lo0ol\\Downloads" + "\\Compressed\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.youtube.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

	}

	/**
	 * Test Edge windows
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
		driver.close();

		// handle opened windows and close them
		// https://www.browserstack.com/guide/handle-multiple-windows-in-selenium
		// https://www.lambdatest.com/blog/how-to-handle-multiple-windows-in-selenium-webdriver-using-java/
		Set<String> windows1 = driver.getWindowHandles();
		System.out.println(windows1);
		for (String window : windows1) {

			driver.switchTo().window(window);
			String pageTitle = driver.getTitle();
			System.out.println("The web page title of child window is:" + pageTitle);
			driver.close();
			System.out.println("Child window closed");

		}

		// Private incognito window
		//https://stackoverflow.com/questions/36547933/how-to-start-edge-browser-in-incognito-mode-using-selenium-remote-webdriver
		EdgeOptions options = new EdgeOptions();
		options.addArguments("InPrivate");
		driver = new EdgeDriver(options);
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
		// Quite the selenium
		driver.quit();
	}
}
