package dto;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public abstract class BankCard {
    String number;
    User user;


}
