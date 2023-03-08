package bank.api;

import dto.BankCard;
import dto.BankCardType;
import dto.User;

public interface Bank {
    public BankCard createBankCard(BankCardType bankCardType, User user);
}
