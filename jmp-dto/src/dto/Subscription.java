package dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Subscription {

    String bankcard;
    LocalDate startDate;

    public Subscription(Object number, LocalDate now) {
    }
}
