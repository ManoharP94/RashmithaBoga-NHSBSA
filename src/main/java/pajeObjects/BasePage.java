package pajeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	
/* Driver */
	
	public WebDriver driver;
	
	public  BasePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/* 
	 * Common Elements
	 */
	
	@FindBy(how = How.ID, using = "label-yes")
	private WebElement yesRadioButton;
	
	@FindBy(how = How.ID, using = "label-no")
	private WebElement noRadioButton;
	
	@FindBy(how = How.ID, using = "next-button")
	private WebElement nextButton;
	

	/* 
	 * Common Actions
	 */
	
	public void clickOnYesRadioButton() 
	{
    	yesRadioButton.click();
    }
	
	public void clickOnNoRadioButton() 
	{
		noRadioButton.click();
    }
	
	public void clickOnNextButton()
	{
		nextButton.click();
	}

}
