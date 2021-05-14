package Herança_e_Polimorfismo.Exemplo_Conta_Bacaria;

public class ContaCorrente extends Conta {

    private double taxaAdministrativa = 5;

    public ContaCorrente(Cliente cliente, int numero) {
        super(cliente, numero);
    }

    public void cobrarTaxaAdministrativa() {
        sacar(taxaAdministrativa);
    }
}
