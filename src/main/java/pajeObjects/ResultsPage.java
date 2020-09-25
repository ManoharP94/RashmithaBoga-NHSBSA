package pajeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsPage extends BasePage{
	
	@FindBy(how = How.ID, using = "result-heading")
	private WebElement resultsHeading;
	
	public ResultsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public String getHeading()
	{
		return resultsHeading.getText();
	}

}
