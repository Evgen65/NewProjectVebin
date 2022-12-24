import models.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        //app.studentForm().pause(3000);
        app.studentForm().selectItemForms();
        app.studentForm().selectPracticeForm();
    }

    @Test
    public void StudentFormTest() {
        Student student = Student.builder()
                .firstName("Jonh")
                .lastName("Dow")
                .email("john@mail.com")
                .gender("Male")
                .phone("12121234567")
                .birthday("30 June 2000")
                .subject("Math,English")
                .hobbies("Sports , Music")
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon")
                .build();
        app.studentForm().fillStudentForm(student);

        app.studentForm().uploadPhoto("");
      //  app.studentForm().submitForm();

    }


}
