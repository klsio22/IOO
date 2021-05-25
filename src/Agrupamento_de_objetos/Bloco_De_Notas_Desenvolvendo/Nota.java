package Agrupamento_de_objetos.Bloco_De_Notas_Desenvolvendo;

public class Nota {
    private String titulo;
    private String texto;

    public Nota() {
        this("", "");
    }

    public Nota(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
