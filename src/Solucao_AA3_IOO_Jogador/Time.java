package Solucao_AA3_IOO_Jogador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Time {

    private ArrayList<Jogador> jogadores;

    public Time() {
        jogadores = new ArrayList<>();
    }

    public boolean adicionaJogador(Jogador jogador) {
        if(jogador.eValido()){
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

    public boolean adicionarGol(String nomeDoJogador) {
    	Jogador jogador = encontraJogadorPeloNome(nomeDoJogador);
    	
    	if (jogador == null) return false;

    	jogador.incrementarGols();
    	return true;
    }
    
    public Jogador getArtilheiro() {
    	if (jogadores.size() == 0) return null;
    	
    	Jogador artilheiro = jogadores.get(0);
    	
    	for(Jogador jogador : jogadores) {
    		if (jogador.getGols() > artilheiro.getGols()) {
    			artilheiro = jogador;
    		}
    	}
    	
    	return artilheiro;
    }
    
    public ArrayList<Jogador> pesquisar(String palavraChave) {
        ArrayList<Jogador> jogadoresEncontradas = new ArrayList<>();

        palavraChave = palavraChave.toLowerCase();

        for(Jogador jogador : jogadores) {
            String nome = jogador.getNome().toLowerCase();
            String sobrenome = jogador.getSobrenome().toLowerCase();

            if (nome.contains(palavraChave) || sobrenome.contains(palavraChave)) {
            	jogadoresEncontradas.add(jogador);
            }
        }

        return jogadoresEncontradas;
    }
    
    private Jogador encontraJogadorPeloNome(String nome) {
    	nome = nome.toLowerCase();
    	
    	for(Jogador jogador : jogadores) {
    		String nomeDoJogadorDaVez = jogador.getNome().toLowerCase();
    		if (nome.equals(nomeDoJogadorDaVez)) {
    			return jogador;
    		}
    	}
    	return null;
    }
    
}
