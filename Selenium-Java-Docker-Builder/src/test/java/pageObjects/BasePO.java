package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePO {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePO(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void initialise(Object obj) {
		try {
			PageFactory.initElements(driver, obj);
		} catch (Exception e) {
			// StaleElementReferenceException
			e.printStackTrace();
		}
	}

	public void waitForPageToLoad() {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean domReady = js.executeScript("return document.readyState").equals("complete");
		if (!domReady) {
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return (Boolean) js.executeScript("return document.readyState").equals("complete");
				}
			});

		}
	}
}
