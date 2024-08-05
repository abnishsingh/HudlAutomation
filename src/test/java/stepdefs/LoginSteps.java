package stepdefs;

import org.junit.Assert;
import pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    LoginPage loginPage=new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.loadURL();
    }
    @When("user enters valid {string} and {string}")
    public void user_enters_valid_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.clickContinueButton();
        loginPage.enterPassword(password);
    }

    @When("user enters invalid {string} and {string}")
    public void user_enters_invalid_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.clickContinueButton();
        loginPage.enterPassword(password);
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginButton();
    }
    
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws InterruptedException {
        Thread.sleep(5000);
        String title=Hooks.driver.getTitle();
        Assert.assertEquals("Login Page Home not loaded","Home - Hudl",title);
    }

    @Then("user sees an error message")
    public void userSeesAnErrorMessage() {
        System.out.println(loginPage.getError());
    }

}
