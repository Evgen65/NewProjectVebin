package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperStudentForm studentForm;
    public void init(){
        wd=new ChromeDriver();


        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://demoqa.com/");
        studentForm=new HelperStudentForm(wd);

    }

    public void stop() {
    }
    public HelperStudentForm studentForm() {
        return studentForm;
    }
}
