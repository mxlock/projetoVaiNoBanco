package vainaweb.backendt3.projetovainobanco;

public class Conta {
    protected String numero;
    protected String agencia;
    protected String titular;
    protected String cpf;
    protected double saldo;

    public Conta(String numero, String agencia, String titular, String cpf) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.cpf = cpf;
        this.saldo = 0;
    }
    
    public void deposito(double valor) {
        this.saldo += valor;
        System.out.printf("Depósito de R$%.2f realizado. Novo saldo: R$%.2f%n", valor, this.saldo);
    }

    public boolean saque(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.printf("Saque de R$%.2f realizado. Novo saldo: R$%.2f%n", valor, this.saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }
    }

    public void transferencia(Conta destino, double valor) {
        if (this.saque(valor)) {
            destino.deposito(valor);
            System.out.printf("Transferência de R$%.2f realizada para a conta %s.%n", valor, destino.numero);
        }
    }
}
