package main.com.myApp.mode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String city;

}