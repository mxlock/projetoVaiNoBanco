package vainaweb.backendt3.projetovainobanco;
import java.util.Scanner;

public class ProjetoVaiNoBanco {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ContaCorrente contaCorrente = new ContaCorrente("12345", "001", "João", "123.456.789-00", 500);
	        ContaPoupanca contaPoupanca = new ContaPoupanca("54321", "002", "Marcelo", "987.654.321-00");
	        
	        int opcao;
	        do {
	            System.out.println("=== MENU ===");
	            System.out.println("1. Depositar na conta corrente");
	            System.out.println("2. Sacar da conta corrente");
	            System.out.println("3. Depositar na conta poupança");
	            System.out.println("4. Sacar da conta poupança");
	            System.out.println("5. Transferir entre contas");
	            System.out.println("0. Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();
	            
	            switch (opcao) {
	                case 1:
	                    System.out.print("Digite o valor a depositar na conta corrente: ");
	                    double valorDepositoCC = scanner.nextDouble();
	                    contaCorrente.deposito(valorDepositoCC);
	                    break;
	                case 2:
	                    System.out.print("Digite o valor a sacar da conta corrente: ");
	                    double valorSaqueCC = scanner.nextDouble();
	                    contaCorrente.saque(valorSaqueCC);
	                    break;
	                case 3:
	                    System.out.print("Digite o valor a depositar na conta poupança: ");
	                    double valorDepositoCP = scanner.nextDouble();
	                    contaPoupanca.deposito(valorDepositoCP);
	                    break;
	                case 4:
	                    System.out.print("Digite o valor a sacar da conta poupança: ");
	                    double valorSaqueCP = scanner.nextDouble();
	                    contaPoupanca.saque(valorSaqueCP);
	                    break;
	                case 5:
	                    System.out.print("Digite o valor a transferir: ");
	                    double valorTransferencia = scanner.nextDouble();
	                    System.out.print("Digite o número da conta de destino: ");
	                    String numeroContaDestino = scanner.next();
	                    Conta contaDestino = (numeroContaDestino.equals(contaCorrente.numero)) ? contaCorrente : contaPoupanca;
	                    if (contaDestino != null) {
	                        contaCorrente.transferencia(contaDestino, valorTransferencia);
	                    } else {
	                        System.out.println("Número de conta de destino inválido.");
	                    }
	                    break;
	                case 0:
	                    System.out.println("Saindo do programa...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
	                    break;
	            }
	        } while (opcao != 0);
	        
	        scanner.close();
	    }
}
