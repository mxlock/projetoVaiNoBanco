package vainaweb.backendt3.projetovainobanco;

public class ContaCorrente extends Conta {
    private double limiteCredito;

    public ContaCorrente(String numero, String agencia, String titular, String cpf, double limiteCredito) {
        super(numero, agencia, titular, cpf);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public boolean saque(double valor) {
    	double valorComDesconto = valor * 0.98;
        if (valorComDesconto <= this.saldo + this.limiteCredito) {
            this.saldo -= valorComDesconto;
            System.out.printf("Saque de R$%.2f realizado. Novo saldo: R$%.2f%n", valorComDesconto, this.saldo);
            return true;
        } else {
            System.out.println("Saldo e limite de crédito insuficientes para saque.");
            return false;
        }
    }
}
