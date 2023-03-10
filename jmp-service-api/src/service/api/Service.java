package service.api;

import dto.BankCard;
import dto.Subscription;
import dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public interface Service {

    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);
    List<User> getAllUsers();
    int PAYABLE_AGE = 18;
    default double getAverageUsersAge(){
        return getAllUsers().stream().
                mapToLong(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now())).average().getAsDouble();
    }
    static boolean isPayableUser(User user){
            return ChronoUnit.YEARS.between(user.getBirthday(),
                    LocalDate.now())>PAYABLE_AGE;
    }

}
