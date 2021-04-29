package Agrupamento_de_objetos.Bloco_De_Notas_Arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BancoDeDados {

    private File arquivo;
    private static final String NOME_DO_ARQUIVO = "notas.txt";
    private static final String DIVISOR = "¡";

    public BancoDeDados() {
        arquivo = new File(NOME_DO_ARQUIVO);
    }

    public void salvar(Nota nota) {
        try {
            FileWriter escritor = new FileWriter(arquivo, true);
            String linha = nota.getTitulo() + DIVISOR + nota.getTexto();
            escritor.write(linha + "\n");
            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void salvar(ArrayList<Nota> notas) {
        try {
            FileWriter escritor = new FileWriter(arquivo);

            for(Nota nota : notas) {
                String linha = nota.getTitulo() + DIVISOR + nota.getTexto();
                escritor.write(linha + "\n");
            }

            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Nota> getNotas() {
        ArrayList<Nota> notas = new ArrayList<>();

        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor);

            String linha = buffer.readLine();

            while(linha != null) {
                String[] dados = linha.split(DIVISOR); 
                String titulo = dados[0];
                String texto = dados[1];

                notas.add(new Nota(titulo, texto));

                linha = buffer.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return notas;
    }
}
