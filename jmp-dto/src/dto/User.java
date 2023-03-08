package dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class User {
    String name;
    String surname;
    LocalDate birthday;

}
