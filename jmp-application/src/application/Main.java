package application;

import bank.impl.BankImpl;
import dto.BankCard;
import dto.BankCardType;
import dto.User;
import service.impl.ServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BankImpl bank = new BankImpl();
        ServiceImpl service = new ServiceImpl();

        User user1 = new User("Scarlett", "Ohara", LocalDate.of(1990, 12, 2));
        User user2 = new User("Jane", "Eyre", LocalDate.of(1980, 12, 2));

        final BankCard bankCard = bank.createBankCard(BankCardType.DEBIT,user1);
        service.subscribe(bankCard);
        service.subscribe(bank.createBankCard(BankCardType.DEBIT, user1));
        service.subscribe(bank.createBankCard(BankCardType.CREDIT, user1));
        service.subscribe(bank.createBankCard(BankCardType.DEBIT, user2));
        service.subscribe(bank.createBankCard(BankCardType.DEBIT, user2));


        System.out.println(service.getAllUsers());
        System.out.println(service.getSubscriptionByBankCardNumber(bankCard.getNumber()));

    }
}