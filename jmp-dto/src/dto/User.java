package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@AllArgsConstructor
public class User {
    String name;
    String surname;
    LocalDate birthday;

}
