package fox.marcelo.DigitalBank.domain;

public class Bank {

    private Account[] accounts = new Account[100];

    public void accountsAdd(Account account) {
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] == null) {
                this.accounts[i] = account;
                break;
            }
        }
    }

    public void accountsList() {
        System.out.println("-------- Lista de Contas do Digital Innovation Bank --------");
        for (Account num : this.accounts) {
            if (num != null) {
                num.printAccount(num);
            }
        }
    }

}