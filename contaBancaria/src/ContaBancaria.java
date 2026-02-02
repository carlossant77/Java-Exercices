import java.util.Scanner;

public class ContaBancaria {

    Scanner scanner = new Scanner(System.in);

    private double limiteChequeEspecial;

    private double usoChequeEspecial;

    private double saldo;

    public ContaBancaria(double saldo) {
        this.saldo = saldo;

        if (saldo < 500) {
            this.limiteChequeEspecial = 50;
        } else {
            this.limiteChequeEspecial = saldo * 0.5;
        }
    }

    public void realizarSaque(double valor) {
        if (this.saldo < valor) {
            if (this.limiteChequeEspecial - this.usoChequeEspecial < valor - this.saldo) {
                System.out.println("Saldo Insuficiente, não foi possível concluir o saque.");
                return;
            } else {
                System.out.println("Saldo Insuficiente, Deseja utilizar o limite do cheque especial? (y/n)");
                var option = scanner.next();

                if (option.equalsIgnoreCase("y")) {
                    valor -= this.saldo;
                    this.saldo = 0;
                    usoChequeEspecial += valor;

                    System.out.printf("Saque Realizado. Saldo atual: R$ %s | Cheque Especial: R$ %s usados de R$ %s",
                            this.saldo, this.usoChequeEspecial, this.limiteChequeEspecial);
                    return;
                } else {
                    System.out.println("Saldo Insuficiente, não foi possível concluir o saque.");
                    return;
                }
            }
        } else {
            this.saldo -= valor;
            System.out.printf("Saque Realizado. Saldo atual: R$ %s", this.saldo);
            return;
        }
    }

    public void pagarBoleto(double valor) {
        if (this.saldo < valor) {
            if (this.limiteChequeEspecial - this.usoChequeEspecial < valor - this.saldo) {
                System.out.println("Saldo Insuficiente, não foi possível pagar o boleto.");
                return;
            } else {
                System.out.println("Saldo Insuficiente, Deseja utilizar o limite do cheque especial? (y/n)");
                var option = scanner.next();

                if (option.equalsIgnoreCase("y")) {
                    valor -= this.saldo;
                    this.saldo = 0;
                    usoChequeEspecial += valor;

                    System.out.printf("Boleto pago. Saldo atual: R$ %s | Cheque Especial: R$ %s usados de R$ %s",
                            this.saldo, this.usoChequeEspecial, this.limiteChequeEspecial);
                    return;
                } else {
                    System.out.println("Saldo Insuficiente, não foi possível pagar o boleto.");
                    return;
                }
            }
        } else {
            this.saldo -= valor;
            System.out.printf("Boleto pago. Saldo atual: R$ %s", this.saldo);
            return;
        }
    }

    public void realizarDeposito(double valor) {
        if (usoChequeEspecial == limiteChequeEspecial) {
            valor -= usoChequeEspecial * 0.2;
            usoChequeEspecial -= limiteChequeEspecial * 0.2;
            this.saldo += valor;
            System.out.printf(
                    "Foi cobrado uma taxa de 20 porcento do limite de seu cheque especial, por limite de uso. Saldo atual: R$ %s",
                    this.saldo);
        } else {
            this.saldo += valor;
            System.out.printf("Deposito realizado! Saldo atual: R$ %s", this.saldo);
        }
    }

    public String getSaldo() {
        return "Saldo atual da conta é: " + this.saldo;
    }

    public String getLimiteChequeEspecial() {
        return "Seu limite de cheque especial é: " + this.limiteChequeEspecial;
    }

    public String getUsoChequeEspecial() {
        return "Você usou R$" + this.usoChequeEspecial + " do limite de R$" + this.limiteChequeEspecial
                + " de seu cheque especial.";
    }

}
