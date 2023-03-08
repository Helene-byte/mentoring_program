package dto;
import lombok.Data;

@Data
public abstract class BankCard {
    String number;
    User user;

}
