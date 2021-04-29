package Agrupamento_de_objetos.Bloco_De_Notas_Adicionar_Listagem;

import java.util.ArrayList;

public class BlocoDeNotas {

    private ArrayList<Nota> notas;
    
    public BlocoDeNotas() {
        notas = new ArrayList<>();
    }
    
    public boolean adicionaNota(Nota nota) {
        return notas.add(nota);
    }
    
    public ArrayList<Nota> getNotas() {
        return notas;
    }
    
    public int getQuantidadeDeNotas() {
        return notas.size();
    }
}
