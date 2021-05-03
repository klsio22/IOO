package EXlista_IOO_06.Nota_pesistente;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BancoDeDados {

    private File arquivo;
    private static final String NOME_DO_ARQUIVO = "nota.txt";
    
    public BancoDeDados() {
        arquivo = new File(NOME_DO_ARQUIVO);
    }
    
    public void salvar(String texto) {
        try {
            FileWriter escritor = new FileWriter(arquivo);
            escritor.write(texto);
            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getTexto() {
        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor);
            
            String texto = buffer.readLine();
            
            return texto;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }
}
