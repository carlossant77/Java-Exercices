import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        var conta = new ContaBancaria(5000);

        String menu = """
                \nSISTEMA BANCÁRIO
                  ==================================
                  O que deseja realizar?
                  1) Consultar Saldo
                  2) Consultar limite do cheque especial
                  3) Sacar Dinheiro
                  4) Pagar um boleto
                  5) Realizar Depósito
                  6) Verificar uso do cheque especial
                  0) Encerrar Serviço
                    """;

        boolean bancoAtivo = true;

        while (bancoAtivo) {
            System.out.println(menu);
            int option = scanner.nextInt();

            if (option < 0 || option > 6) {
                System.out.println("Insira uma opção válida para prosseguir.");
            }

            if (option == 1) {
                System.out.println(conta.getSaldo());
            }

            if (option == 2) {
                System.out.println(conta.getLimiteChequeEspecial());
            }

            if (option == 3) {
                System.out.println("Insira o valor que deseja sacar: ");
                double value = scanner.nextDouble();
                conta.realizarSaque(value);
            }

            if (option == 4) {
                System.out.println("Insira o valor do boleto: ");
                double value = scanner.nextDouble();
                conta.pagarBoleto(value);
            }

            if (option == 5) {
                System.out.println("Insira o valor do depósito: ");
                double value = scanner.nextDouble();
                conta.realizarDeposito(value);
            }

            if (option == 6) {
                System.out.println(conta.getUsoChequeEspecial());
            }

            if (option == 0) {
                System.out.println("Adeus! Volte sempre!!");
                bancoAtivo = false;
            }
        }
    }
}
