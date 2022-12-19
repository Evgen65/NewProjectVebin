import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class TestBase {

    WebDriver wd;
   public static ApplicationManager app =new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }






}
