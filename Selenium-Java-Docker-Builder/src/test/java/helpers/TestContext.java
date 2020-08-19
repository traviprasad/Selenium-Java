package helpers;

import managers.PageObjectManager;
import managers.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TestContext {
	
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext() throws IOException {
		driverManager = new DriverManager();
		WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10);
		pageObjectManager = new PageObjectManager(driverManager.getDriver(),wait);
	}
	
	public DriverManager getWebDriverManager() {
		return driverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
