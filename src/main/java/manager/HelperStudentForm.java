package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        //selectBirthday(student.getBirthday());
        addSubjects(student.getSubject());
        selectHobby(student.getHobbies());
        type(By.cssSelector("textarea[placeholder='Current Address']"), student.getAddress());
        // selectState(student.getState());
        //  selectCity(student.getCity());

    }

    private void selectHobby(String hobbies) {
        //label[for='hobbies-checkbox-1']
        String[] all = hobbies.split(" , ");
        for (String s : all) {
            switch (s) {
                case "Sports":
                    click(By.cssSelector("label[for='hobbies-checkbox-1']"));
                    break;
                case "Reading":
                    click(By.cssSelector("label[for='hobbies-checkbox-2']"));
                    break;
                case "Music":
                    click(By.cssSelector("label[for='hobbies-checkbox-3']"));
                    break;
            }
        }
    }

    private void addSubjects(String subject) {
        String[] all = new String[0];
        if (subject != null) {
            all = subject.split(",");
        }
        click(By.id("subjectsInput"));

        for (String sub : all) {
            WebElement el = wd.findElement(By.id("subjectsInput"));
            el.sendKeys(sub);
            el.sendKeys(Keys.ENTER);
            pause(1000);

        }

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

    private void selectBirthday(String birthday) {//30 June 2000===>["30"]["June"]["2000"]
        WebElement dbirth = wd.findElement(By.id("dateOfBirthInput"));
        dbirth.click();

        String[] data = birthday.split(" ");

        new Select(wd.findElement(By.cssSelector("select.react-datepicker__month-select"))).selectByVisibleText(data[1]);
        new Select(wd.findElement(By.cssSelector("select.react-datepicker__year-select"))).selectByValue(data[2]);
        //  String locator = "//div[text()='30']";
        // String locator = "//div[text()='"+"30"+"']";
        String locator = "//div[text()='" + data[0] + "']";

        String locator2 = String.format("//div[text()='%s']", data[0]);

        List<WebElement> list = wd.findElements(By.xpath(locator2));
        if (list.size() > 1 && Integer.parseInt(data[0]) > 14) {
            list.get(1).click();
        } else {
            list.get(0).click();
        }
    }

    public void typeBirthday(String birthday) {
        WebElement dbirth = wd.findElement(By.id("dateOfBirthInput"));
        dbirth.click();

        String nameOS = System.getProperty("os.name");   // "Mac "
        System.out.printf(nameOS);
        if (nameOS.startsWith("Mac")) {
            dbirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dbirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dbirth.sendKeys(birthday);
        dbirth.sendKeys(Keys.ENTER);


    }

    private void selectCity(String city) {
        click(By.xpath("(//div[@aria-hidden='true'])[2]"));
        click(By.xpath("//div[text()='Delhi']"));

    }

    public void selectState(String state) {
        click(By.xpath("(//div)[73]"));
        click(By.xpath("//div[contains(text(),'NCR')]"));

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

