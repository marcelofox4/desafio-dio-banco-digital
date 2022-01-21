package fox.marcelo.DigitalBank.domain;

public abstract class Account {

    private static final int BANK_BRANCH = 1;
    private static int NUMBER_GENERATOR;

    protected int number;
    protected double balanceAvailable;
    protected Client client;

    public Account(Client client) {
        NUMBER_GENERATOR++;
        this.number = NUMBER_GENERATOR;
        this.balanceAvailable = 0.0;
        this.client = client;
    }

    public void withdrawal(double moneyValue) {
        boolean isWithdrawalValidation = this.balanceAvailable >= 0 && this.balanceAvailable >= moneyValue;
        if (isWithdrawalValidation) {
            this.balanceAvailable -= moneyValue;
            System.out.println("Saque de R$" + String.format("%.2f", moneyValue) + " realizado");
            System.out.println();
        } else {
            System.out.println("Saldo insuficinete. SALDO = R$" + String.format("%.2f", this.balanceAvailable));
            System.out.println();
        }
    }

    public void deposit(double moneyValue) {
        if (moneyValue > 0) {
            this.balanceAvailable += moneyValue;
            System.out.println("Deposito de R$" + String.format("%.2f", moneyValue) + " realizado");
        } else {
            System.out.println("Digite um valor maior que zero!");
        }
    }

    public void transfer(double moneyValue, Account account) {
        boolean isTranferValidation = this.balanceAvailable >= 0 && this.balanceAvailable >= moneyValue;
        if (isTranferValidation) {
            this.withdrawal(moneyValue);
            account.deposit(moneyValue);
            System.out.println("Tranferência Realizada\n");
        } else {
            System.out.println("Transferência não realizada\n");
        }
    }

    public void statementBalance() {

        System.out.println("Cliente: " + this.client.getName());
        System.out.println("Agência: " + BANK_BRANCH);
        System.out.println("Número da Conta: " + this.number);
        System.out.println("Seu saldo é: R$ " + String.format("%.2f", this.balanceAvailable) + "\n");
    }

    public void printAccount(Account account) {
        System.out.println("-----------------------------------------");
        System.out.println("Número da Conta: " + this.number);
        System.out.println("Nome do Cliente: " + client.getName());
        System.out.println("Idade do Cliente: " + client.getAge());
        System.out.println("Saldo é: R$ " + String.format("%.2f", this.balanceAvailable));
        System.out.println("-----------------------------------------");
        System.out.println();
    }
}
