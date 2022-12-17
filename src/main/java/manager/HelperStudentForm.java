package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HelperStudentForm extends HelperBase {
    public HelperStudentForm(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[text()='Practice Form']"));
    }

    public void fillStudentForm(Student student) {
        type(By.cssSelector("input[placeholder='First Name']"), student.getFirstName());
        type(By.cssSelector("input[placeholder='Last Name']"), student.getLastName());
        type(By.cssSelector("input[placeholder='name@example.com']"), student.getEmail());
        type(By.cssSelector("label[for='gender-radio-1']"), student.getGender());
        type(By.cssSelector("input[placeholder='Mobile Number']"), student.getPhone());
        clickBirthday(student.getBirthday());
        type(By.cssSelector("label[for='hobbies-checkbox-1']"), student.getHobbies());
        type(By.cssSelector("textarea[placeholder='Current Address']"), student.getAddress());
        selectState(student.getState());
        selectCity(student.getCity());

    }


    public void clickBirthday(String birthday) {
        click(By.id("dateOfBirthInput"));
        click(By.xpath("//select[contains(.,'2000')]"));
        pause(5000);
        click(By.xpath("//select[contains(.,'June')]"));
        pause(5000);
        click(By.xpath("//div[contains(@aria-label,'Choose Friday, June 30th, 2000')]"));
        pause(3000);

    }

    private void selectCity(String city) {
        click(By.xpath("(//div[@aria-hidden='true'])[2]"));
        click(By.xpath("//div[text()='Delhi']"));

    }

    public void selectState(String state) {
        click(By.xpath("(//div[@aria-hidden='true'])[1]"));
        click(By.xpath("//div[text()='NCR']"));

    }

//    public void checkPolicy() {
//        Rectangle rect = wd.findElement(By.xpath("(//div[@aria-hidden='true'])[1]")).getRect();
//        int x = rect.getX() + 5;
//        int y = rect.getY() + 1 / 4 * rect.getHeight();
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().perform();
//
//    }

}

