package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        selectGender(student.getGender());
        type(By.cssSelector("input[placeholder='Mobile Number']"), student.getPhone());
        typeBirthday(student.getBirthday());
       // selectBirthday(student.getBirthday());
        type(By.cssSelector("label[for='hobbies-checkbox-1']"), student.getHobbies());
        type(By.cssSelector("textarea[placeholder='Current Address']"), student.getAddress());
        selectState(student.getState());
        selectCity(student.getCity());

    }



    private void selectGender(String gender) {
        if (gender.equals("Male")) {
            click(By.cssSelector("label[for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            click(By.cssSelector("label[for='gender-radio-2']"));
        } else if (gender.equals("Other")) {
            click(By.cssSelector("label[for='gender-radio-3']"));
        }
    }
    private void selectBirthday(String birthday) {
        WebElement dbirth = wd.findElement(By.id("dateOfBirthInput"));
        dbirth.click();

        String [] data=birthday.split(" ");

        new Select(wd.findElement(By.cssSelector("select.react-datepicker__month-select"))).selectByVisibleText("June");
        new Select(wd.findElement(By.cssSelector("select.react-datepicker__year-select"))).selectByValue("2000");
        String locator = "//div[text()='30']";
    }


    public void typeBirthday(String birthday) {
        WebElement dbirth = wd.findElement(By.id("dateOfBirthInput"));
        dbirth.click();

        String nameOS =  System.getProperty("os.name");   // "Mac "
        System.out.printf(nameOS);
        if(nameOS.startsWith("Mac")){
            dbirth.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        }else {
            dbirth.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        }
        dbirth.sendKeys(birthday);
        dbirth.sendKeys(Keys.ENTER);


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

