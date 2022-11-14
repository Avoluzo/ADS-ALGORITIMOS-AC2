import java.util.Scanner;

public class CaixaEletronico {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("CPF: ");
        String inputCPF = scanner.nextLine();


        if (!inputCPF.equals("123.456.789-00")) {
            System.out.println("CPF invalido");
            System.exit(0);
        }

        int attempts = 1;
        boolean withoutAccess = true;

        while ((attempts <= 3) && withoutAccess) {

            System.out.print("senha:");
            String inputPassword = scanner.nextLine();
            if (inputPassword.equals("01020304")) {
                withoutAccess = false;

            } else {

                System.out.println("Senha incorreta, você ainda possui " + (3 - attempts) + " tentativas restantes.");
                attempts++;
            }

        }
        if ((attempts >= 3) && withoutAccess) {
            System.out.println("acesso negado.");
            System.exit(0);
        }

        float balance = 1000.0f;
        StringBuilder extractBuilder = new StringBuilder("extrato: \n");
        while (true) {

            System.out.println("\nMENU:\n - 1: saldo \n - 2: deposito \n - 3: saque \n - 4: transferencia \n - 5: extrato \n - 0: sair ");
            int menu = scanner.nextInt();

            switch (menu) {

                case 1:
                    System.out.println("o valor de seu saldo atual, em reais é de :" + balance);

                    break;
                case 2:
                    System.out.print("Digite o valor desejado: ");
                    float deposit = scanner.nextFloat();
                    balance = balance + deposit;
                    System.out.println("o valor de seu saldo atual, em reais é de :" + balance);
                    extractBuilder.append("deposito realizado no valor: ");
                    extractBuilder.append(deposit);
                    extractBuilder.append("\nsaldo: ");
                    extractBuilder.append(balance);
                    extractBuilder.append("\n\n");
                    break;
                case 3:
                    System.out.print("Digite o valor desejado: ");
                    float withdraw = scanner.nextFloat();
                    balance = balance - withdraw;
                    System.out.println("o valor de seu saldo atual, em reais é de :" + balance);
                    extractBuilder.append("saque realizado no valor: ");
                    extractBuilder.append(withdraw);
                    extractBuilder.append("\nsaldo: ");
                    extractBuilder.append(balance);
                    extractBuilder.append("\n\n");

                    break;
                case 4:
                    System.out.print("Digite o valor a ser transferido: ");
                    float transfer = scanner.nextFloat();
                    System.out.print("Digite a conta: ");
                    int account = scanner.nextInt();
                    System.out.print("Digite a agencia: ");
                    int agency = scanner.nextInt();
                    System.out.print("Digite o banco: ");
                    int bank = scanner.nextInt();
                    balance = balance - transfer;
                    extractBuilder.append("transferencia realizado no valor: ");
                    extractBuilder.append(transfer);
                    extractBuilder.append(" para a conta:  ");
                    extractBuilder.append(account);
                    extractBuilder.append(" agencia: ");
                    extractBuilder.append(agency);
                    extractBuilder.append(" banco: ");
                    extractBuilder.append(bank);
                    extractBuilder.append("\nsaldo: ");
                    extractBuilder.append(balance);
                    extractBuilder.append("\n\n");

                    break;

                case 5:
                    System.out.print(extractBuilder);

                    break;
                case 0:
                    System.out.println("exit...");

                    break;
                default:
                    System.out.println("invalido.");
                    break;
            }
        }
    }
}
