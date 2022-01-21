package fox.marcelo.DigitalBank.application;

import fox.marcelo.DigitalBank.domain.*;

public class DigitalBankApplication {
    public static void main(String[] args) {

        Bank bank = new Bank();

        Client clientOne = new Client("Marcelo", 30);
        Client clientTwo = new Client("Priscilla", 28);

        Account accountOne = new CheckingAccount(clientOne);
        Account accountTwo = new SavingsAccount(clientTwo);

        bank.accountsAdd(accountOne);
        bank.accountsAdd(accountTwo);

        accountOne.deposit(400);
        accountTwo.deposit(1000);

        accountTwo.withdrawal(200);

        accountOne.transfer(100,accountTwo);

        accountOne.statementBalance();

        bank.accountsList();
    }
}
