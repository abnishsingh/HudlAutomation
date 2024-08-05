package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stepdefs.Hooks;
import utility.ConfigReader;

public class LoginPage {
    ConfigReader configReader = new ConfigReader();
    String baseUrl = configReader.getProperty("baseUrl");
    String menu= "//a[@data-qa-id='login-select']";
    String subMenu= "//a[@data-qa-id='login-hudl']";
    By username = By.id("username");
    By password = By.id("password");
    String loginButton = "//button[contains(.,'Log In')]";

    String errorMsg="//span[contains(@class,'ulp-input-error-message')]";

    String continueButton="//button[contains(.,'Continue')][@class='c1d1b1e07 c94ec4107 c3a9491fe cc1fd6969 _button-login-id']";



    public void loadURL(){
        Hooks.driver.get(baseUrl);
        String wTitle=Hooks.driver.getTitle();
        Assert.assertEquals("Landing Page not loaded","Hudl • Connected solutions for high-performance video and data analysis",wTitle);
        Hooks.driver.manage().window().maximize();
        directToLoginPage();
    }

    private void directToLoginPage(){
        WebElement ele=Hooks.driver.findElement(By.xpath(menu));
        if(ele!=null){
            ele.click();
            ele=Hooks.driver.findElement(By.xpath(subMenu));
            if(ele!=null){
                ele.click();
                String wTitle=Hooks.driver.getTitle();
                Assert.assertEquals("Login Page not loaded","Log In",wTitle);
                return;
            }
        }
    }

    public String getError(){
       WebElement ele=Hooks.driver.findElement(By.xpath(errorMsg));
       return ele.getText();
    }

    public void enterUsername(String user) {
        Hooks.driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass) {
        Hooks.driver.findElement(password).sendKeys(pass);
    }
    public void clickLoginButton() {
        Hooks.driver.findElement(By.xpath(loginButton)).click();
    }

    public void clickContinueButton() {
        Hooks.driver.findElement(By.xpath(continueButton)).click();
    }





}
