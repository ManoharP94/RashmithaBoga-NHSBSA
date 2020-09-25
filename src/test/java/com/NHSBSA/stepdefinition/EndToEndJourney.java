package com.NHSBSA.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import envReader.EnvironmentPropertiesReader;

import pajeObjects.BenefitsOrTaxCredits;
import pajeObjects.CountryPage;
import pajeObjects.DateOfBirthPage;
import pajeObjects.DiabetesPage;
import pajeObjects.GlaucomaPage;
import pajeObjects.InjuryOrIllnessPage;
import pajeObjects.LivePermanentlyInCareHome;
import pajeObjects.LiveWithPartner;
import pajeObjects.MoreThanSixteenThousandandInsavings;
import pajeObjects.NhsStartPage;
import pajeObjects.PregnantPage;
import pajeObjects.ResultsPage;

public class EndToEndJourney {
	
WebDriver driver = Hooks.driver;
	
	@Given("^I navigate to NHS Costs checker tool$")
	public void i_navigate_to_NHS_Costs_checker_tool() throws Throwable 
	{
		// Navigate to the NHS Costs Checker tool
		 driver.get(EnvironmentPropertiesReader.getProperty("URL")); 
	}

	@Given("^I am a person from Wales$")
	public void i_am_a_person_from_Wales() throws Throwable 
	{
		// click Start button
		NhsStartPage nhsStartPage = new NhsStartPage(driver);
		nhsStartPage.clickOnNextButton();
		
		// Selects Country as Wales and click Next button
		CountryPage countryPage = new CountryPage(driver);
		countryPage.clickOnWalesRadioBtn(); 
		countryPage.clickOnNextButton();
	}

	@When("^I put my circumstances into the Checker tool$")
	public void i_put_my_circumstances_into_the_Checker_tool() throws Throwable 
	{	
		DateOfBirthPage Dob = new DateOfBirthPage(driver);
		Dob.enterDateOfBirth("24", "11", "1990");
		Dob.clickOnNextButton();
		
		//select living with partner as yes and click next button
		LiveWithPartner livewithpartner = new LiveWithPartner(driver);
		livewithpartner.clickOnYesRadioButton();
		livewithpartner.clickOnNextButton();
		
		//select for claim any benifits or credits as no and click next button
		BenefitsOrTaxCredits benifitsortax = new BenefitsOrTaxCredits(driver);
		benifitsortax.clickOnNoRadioButton();
		benifitsortax.clickOnNextButton();
		
		//select for pregnant or have you given birth in the last 12 months as no and click next button
		PregnantPage pregnant = new PregnantPage(driver);
		pregnant.clickOnNoRadioButton();
		pregnant.clickOnNextButton();
		
		
		//select for an injury or illness caused by serving in the armed forces as no and click next button in page
		InjuryOrIllnessPage injuryorillness = new InjuryOrIllnessPage(driver);
		injuryorillness.clickOnNoRadioButton();
		injuryorillness.clickOnNextButton();
		
		//select for diabetes as no and click next button in page
		DiabetesPage diabetes = new DiabetesPage(driver);
		diabetes.clickOnNoRadioButton();
		diabetes.clickOnNextButton();
		
		//selects for glaucoma as no and click next button in page
		GlaucomaPage glaucoma = new GlaucomaPage(driver);
		glaucoma.clickOnNoRadioButton();
		glaucoma.clickOnNextButton();
		
		//selects for partner live permanently in a care home as no and click next button in page
		LivePermanentlyInCareHome liveinhomecare = new LivePermanentlyInCareHome(driver);
		liveinhomecare.clickOnNoRadioButton();
		liveinhomecare.clickOnNextButton();
		
		
		//elects for you and your partner have more than £16,000 in savings, investments or property as no and click next button in page
		MoreThanSixteenThousandandInsavings morethansixteenthousand = new MoreThanSixteenThousandandInsavings(driver);
		morethansixteenthousand.clickOnNoRadioButton();
		morethansixteenthousand.clickOnNextButton();
	}

	@Then("^I should get a result of whether I will get help or not$")
	public void i_should_get_a_result_of_whether_I_will_get_help_or_not() throws Throwable 
	{
		ResultsPage resultsPage = new ResultsPage(driver);
		
		Assert.assertTrue(resultsPage.getHeading().equalsIgnoreCase("Based on what you've told us\n" + 
				"You get help with NHS costs"), "Not Result Page");
	}
	
	


}
