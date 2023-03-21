package service.impl;

import dto.BankCard;
import dto.Subscription;
import dto.User;
import service.api.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceImpl implements Service  {

    private static List <BankCard> bankCards = new ArrayList<>();

    private static List <Subscription> subscriptions = new ArrayList<>();
    @Override
    public void subscribe(BankCard bankCard) {
        bankCards.add(bankCard);
        Subscription subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
        subscriptions.add(subscription);
        System.out.println(subscription);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return subscriptions.stream().filter(subscription -> subscription.getBankcard().equals(bankCardNumber)).findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return bankCards.stream().map(BankCard::getUser).collect(Collectors.toUnmodifiableList());
    }
}
