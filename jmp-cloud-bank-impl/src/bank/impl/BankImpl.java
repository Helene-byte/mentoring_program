package bank.impl;

import bank.api.Bank;
import dto.*;

import java.util.Random;

public class BankImpl implements Bank {

    private Random random = new Random();
//TODO cases implementation
    @Override
    public BankCard createBankCard(BankCardType bankCardType, User user) {

        if (bankCardType == BankCardType.CREDIT){
            return new CreditBankCard(random.nextLong()+"", user);
        }else if(bankCardType == BankCardType.DEBIT){
            return new DebitBankCard(random.nextLong()+"", user);
        }
        return null;
    }
}
