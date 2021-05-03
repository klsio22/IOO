package EXlista_IOO_06.Nota_pesistente;

public class Nota {
    private String texto;
    private BancoDeDados bd;
    
    public Nota() {
        bd = new BancoDeDados();
        this.texto = bd.getTexto();
    }
        
    public void setTexto(String texto) {
        this.texto = texto;
        bd.salvar(texto);
    }
    
    public String getTexto() {
        return texto;
    }
}
