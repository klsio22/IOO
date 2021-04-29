package Agrupamento_de_objetos.Bloco_De_Notas_Arquivo;

import java.util.ArrayList;

public class BlocoDeNotas {

    private ArrayList<Nota> notas;
    private BancoDeDados bd;
    
    public BlocoDeNotas() {
        bd = new BancoDeDados();        
        notas = bd.getNotas();
    }
    
    public boolean adicionaNota(Nota nota) {
        notas.add(nota);
        bd.salvar(nota);
        return true;
    }
    
    public ArrayList<Nota> getNotas() {
        return notas;
    }
    
    public int getQuantidadeDeNotas() {
        return notas.size();
    }
    
    public Nota remover(int indice) {
        if (indice >= 0 && indice < notas.size()) {
            Nota notaRemovida = notas.remove(indice);
            bd.salvar(notas);
            return notaRemovida;
        }
        
        return null;
    }
    
    public ArrayList<Nota> pesquisar(String palavraChave) {
        ArrayList<Nota> notasEncontradas = new ArrayList<>();
        
        palavraChave = palavraChave.toLowerCase();
        
        for(Nota nota : notas) {
            String titulo = nota.getTitulo().toLowerCase();
            String texto = nota.getTexto().toLowerCase();
            
            if (titulo.contains(palavraChave) || texto.contains(palavraChave)) {
                notasEncontradas.add(nota);
            }
        }
        
        return notasEncontradas;
    }
}
