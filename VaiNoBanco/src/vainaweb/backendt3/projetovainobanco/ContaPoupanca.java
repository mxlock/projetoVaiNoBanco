package vainaweb.backendt3.projetovainobanco;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, String agencia, String titular, String cpf) {
        super(numero, agencia, titular, cpf);
    }

    @Override
    public boolean saque(double valor) {
        if (super.saque(valor)) {
            double juros = valor * 0.02;
            this.saldo -= juros;
            System.out.printf("Juros de R$%.2f aplicados. Novo saldo: R$%.2f%n", juros, this.saldo);
            return true;
        } else {
            return false;
        }
    }
}
