package stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class Hooks {

    public static WebDriver driver=null;
    LoginPage page=new LoginPage();
	
	@Before
    public void beforeScenario(){
        loadChromeDriver();
    }	

	@After
    public void afterScenario(){
        quitDriver();
    }

    private void loadChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        Hooks.driver = new ChromeDriver(chromeOptions);
    }
    private void quitDriver(){
        if(driver != null){
            driver.close();
            driver.quit();
        }

    }
}