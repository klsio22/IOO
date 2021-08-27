package Herança_e_Polimorfismo.Exemplo_Conta_Bacaria;

public class Principal {
    private Principal() {}

    public static void main(String[] args) {
        InterfaceTexto it = new InterfaceTexto();
        it.renderizar();

        Cliente cliente = new Cliente("Klesio");
        Conta c = new ContaCorrente(cliente,1234);


    } 
}
