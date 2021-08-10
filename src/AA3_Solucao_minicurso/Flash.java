package AA3_Solucao_minicurso;

import java.util.ArrayList;

public class Flash {
    private static ArrayList<String> mensagens = new ArrayList<>();
    
    public static void mensagem(String mensagem) {
        mensagens.add(mensagem);
    }
    
    public static ArrayList<String> getMensagens() {
        ArrayList<String> msgs = new ArrayList<>();
        msgs.addAll(mensagens);
        limpar();
        
        return msgs;
    }
    
    public static void limpar() {
        mensagens.clear();
    }
}