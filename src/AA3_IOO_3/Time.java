package AA3_IOO_3;
//Klésio Antônio do Nascimento

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Time {

    private ArrayList<Jogador> jogadores;
    private int maiorArtilheiro = 0;

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

    public boolean existeJogador(String nomeJogador, String sobrenomeJogador) {

        for (Jogador jogador : jogadores) {
            String nome = jogador.getNome().toLowerCase();
            String sobrenome = jogador.getSobrenome().toLowerCase();

            if (nome.equals(nomeJogador.toLowerCase()) &&
                    sobrenome.equals(sobrenomeJogador.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean existeJogador(String nomeJogador) {

        for (Jogador jogador : jogadores) {
            String nome = jogador.getNome().toLowerCase();

            if (nome.equals(nomeJogador.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean golsJogador(String nomeDoJogador, int gols) {
        Jogador jogador = encontraJogadorPeloNome(nomeDoJogador);
        if (jogador == null) return false;
        jogador.setGols(gols);
        return true;
    }

    public void setMaiorArtilheiro(int maiorArtilheiro) {
        this.maiorArtilheiro = maiorArtilheiro;
    }

    public int getMaiorArtilheiro() {
        return maiorArtilheiro;
    }

    public String getArtilheiro() {
        List<Jogador> jogadores = getJogadores();
        String nomedoJogador = "";

        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador = jogadores.get(i);

            if (jogador.getGols() > maiorArtilheiro) {
                setMaiorArtilheiro(jogador.getGols());
                nomedoJogador = jogador.getNomeCompleto();
            }
        }
        return nomedoJogador;
    }

    private Jogador encontraJogadorPeloNome(String nome) {
        nome = nome.toLowerCase();

        for (Jogador jogador : jogadores) {
            String nomeDoJogadorDaVez = jogador.getNome().toLowerCase();
            if (nome.equals(nomeDoJogadorDaVez)) {
                return jogador;
            }
        }
        return null;
    }

}
