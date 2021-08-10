package Agrupamento_de_objetos.Bloco_De_Notas_Desenvolvendo;

import java.util.ArrayList;

public class Nota {
    private String titulo;
    private String texto;

    private ArrayList<String> erros;

    public Nota() {
        this("", "");
    }

    public Nota(String titulo, String texto) {
        erros = new ArrayList<>();
        setTitulo(titulo);
        setTexto(texto);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.trim();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTexto(String texto) {
        this.texto = texto.trim();
    }

    public String getTexto() {
        return texto;
    }

    public ArrayList<String> getErros() {
        return erros;
    }

    public boolean eValido() {
        erros.clear();

        if (titulo.isEmpty())
            erros.add("1. Título não pode ser vazio");

        if (texto.isEmpty())
            erros.add("2. Texto não pode ser vazio");

        return erros.isEmpty();
    }





}
