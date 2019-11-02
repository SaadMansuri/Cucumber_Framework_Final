/**
 * @author rahul.rathore
 *	
 *	16-Aug-2016
 */
package com.cucumber.framework.stepdefinition;

import org.testng.Assert;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.settings.ObjectRepo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author rahul.rathore
 *
 *         16-Aug-2016
 *
 */
public class SearchStepDfn {
	
	private HomePage hPage;

	@Given("^: I am at the home page$")
	public void _i_am_at_the_home_page() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
		hPage = new HomePage(ObjectRepo.driver);
		ObjectRepo.data.put("HomePage", hPage);
	}

	@When("^: I entered the \"([^\"]*)\" in search field$")
	public void _i_click_on_the_something_search_filter(String search)
			throws Throwable {
		hPage.search.sendKeys(search);
		//hPage.navigateTo(search);
	}
	
	@When("^: I click  on search button$")
	public void i_click_on_search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	hPage.searchbtn.click();
	}
	
	@And("^: The title should be \"([^\"]*)\" search page$")
    public void _the_title_should_be_something_search_page(String title)
			throws Throwable {
		Assert.assertTrue(hPage.checkForTitle(title));
	}

}
