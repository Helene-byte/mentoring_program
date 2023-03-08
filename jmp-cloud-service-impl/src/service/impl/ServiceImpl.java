package service.impl;

import dto.BankCard;
import dto.Subscription;
import dto.User;
import service.api.Service;

import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service  {

    private static List <BankCard> bankCards;
    static {
        bankCards.add(new BankCard() {
        })
    }

    @Override
    public void subscribe(BankCard bankCard) {

    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
