package pajeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CountryPage  extends BasePage{

	public CountryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.ID, using = "label-wales")
	private WebElement walesRadioBtn;
	
	 public void clickOnWalesRadioBtn() 
		{
	    	walesRadioBtn.click();
	    }

}
