package AA3_IOO_3;

import Agrupamento_de_objetos.Bloco_De_Notas_Desenvolvendo.Nota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Time {

    private ArrayList<Jogador> jogadores;

    public Time() {
        jogadores = new ArrayList<>();
    }

    public boolean adicionaJogador(Jogador jogador) {
        if (jogador.eValido()) {
            jogadores.add(jogador);
            return true;
        }
        return false;
    }

    public List<Jogador> getJogadores() {
        return Collections.unmodifiableList(jogadores);
    }

    public Jogador getJogador(int indice) {
        return jogadores.get(indice);
    }

    public int getQuantidadeDeJogadores() {
        return jogadores.size();
    }

    public Jogador remover(int indice) {
        Jogador jogadorRemovido = jogadores.remove(indice);
        return jogadorRemovido;
    }

    public ArrayList<Jogador> pesquisar(String palavraChave) {
        ArrayList<Jogador> jogadoresEncontradas = new ArrayList<>();

        palavraChave = palavraChave.toLowerCase();

        for (Jogador jogador : jogadores) {
            String nome = jogador.getNome().toLowerCase();
            String sobrenome = jogador.getSobrenome().toLowerCase();

            if (nome.contains(palavraChave) || sobrenome.contains(palavraChave)) {
                jogadoresEncontradas.add(jogador);
            }
        }

        return jogadoresEncontradas;
    }


    public boolean existeJogador(String palavraChave1 , String palavraChave2) {


        for (Jogador jogador : jogadores) {
            String nome = jogador.getNome().toLowerCase();
            String sobrenome = jogador.getSobrenome().toLowerCase();

            if (nome.equals(palavraChave1.toLowerCase()) ||
                    sobrenome.equals(palavraChave2)) {
                return true;
            }

        }
        return false;
    }

    public boolean existeJogador(String palavraChave1 ) {


        for (Jogador jogador : jogadores) {
            String nome = jogador.getNome().toLowerCase();

            if (nome.equals(palavraChave1.toLowerCase())) {
                return true;
            }

        }
        return false;
    }

    public boolean golsJogador(String palavraChave1 , int gols) {

        for (Jogador jogador : jogadores) {
            String nome = jogador.getNome().toLowerCase();

            if (nome.equals(palavraChave1.toLowerCase())){
                jogador.setGols(gols);
                return true;
            }

        }
        return false;
    }


}
