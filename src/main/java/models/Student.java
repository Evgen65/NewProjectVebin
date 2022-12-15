package models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String birthday;
    private String subject;
    private String hobbies;
    private String address;
    private String state;
    private String city;


}
