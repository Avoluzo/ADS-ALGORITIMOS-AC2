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
        while (true) {

            System.out.println("MENU:\n - 1: saldo \n - 2: deposito \n - 3: saque \n - 0: sair ");
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

                    break;
                case 3:
                    System.out.print("Digite o valor desejado: ");
                    float withdraw = scanner.nextFloat();
                    balance = balance - withdraw;
                    System.out.println("o valor de seu saldo atual, em reais é de :" + balance);

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
