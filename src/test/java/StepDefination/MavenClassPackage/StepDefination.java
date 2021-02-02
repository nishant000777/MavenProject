package StepDefination.MavenClassPackage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import VOXIBrowser.VOXILandingPage;
import junit.framework.TestCase;

public class StepDefination extends VOXILandingPage {


    @Given("^I am on VOXI landing Page$")
    public void I_am_on_VOXI_landing_Page() throws Throwable {
        ChromeInitialization();


    }

    @When("^VOXI url loads$")
    public void VOXI_url_loads() throws Throwable {
        System.out.println("url loaded");

    }

    @When("^I selects Phone and Plan$")
    public void I_selects_Phone_and_Plan() throws Throwable {
        SelectPhoneAndPlan();
    }

    @Then("^submit order to checkout \"([^\"]*)\"$")
    public void submit_order_to_checkout(String TestCaseID) throws Throwable {
        GoToCheckout(TestCaseID);

    }

    @And("^Select Extra$")
    public void selectExtra() throws Throwable {
        select_Extra();
    }

    @And("^skip extra$")
    public void skipExtra() throws Throwable {
        skip_extra();
    }
}


