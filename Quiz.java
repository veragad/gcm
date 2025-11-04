package projetogcm;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class Quiz {	
	private List<Questao> todasQuestoes;
    private List<Questao> questoesSelecionadas;
    private Jogador jogador; 
    private int indiceQuestaoAtual;
    private String categoriaAtual; 

    public Quiz(List<Questao> todasQuestoes, Jogador jogador) { 
        this.todasQuestoes = todasQuestoes;
        this.jogador = jogador;
        this.indiceQuestaoAtual = 0;
        this.questoesSelecionadas = new ArrayList<>();
    }

    public void selecionarCategoria(String categoria) {
        this.categoriaAtual = categoria; 
        this.indiceQuestaoAtual = 0; 
       
        questoesSelecionadas = todasQuestoes.stream()
            .filter(q -> q.getCategoria().equalsIgnoreCase(categoria))
            .collect(Collectors.toList());
           
    }

    // Verifica a resposta
    public boolean verificarResposta(int indiceRespostaUsuario) {
        if (questoesSelecionadas == null || indiceQuestaoAtual >= questoesSelecionadas.size()) {
            return false;
        }

        Questao q = questoesSelecionadas.get(indiceQuestaoAtual);
        
        boolean respostaValida = (indiceRespostaUsuario >= 1 && indiceRespostaUsuario <= 4);
        
        boolean acertou = false;
        if (respostaValida) {
            acertou = String.valueOf(indiceRespostaUsuario).equals(q.getRespostaCorreta());
        }

        // Usa o método SIMPLIFICADO do Jogador, pois só há um ciclo.
        jogador.registrarResposta(acertou && respostaValida);
        
        indiceQuestaoAtual++; 
        
        return acertou && respostaValida;
    }

    // Getters auxiliares
    public Questao getQuestaoAtual() {
        if (questoesSelecionadas != null && indiceQuestaoAtual < questoesSelecionadas.size()) {
            return questoesSelecionadas.get(indiceQuestaoAtual);
        }
        return null; 
    }
    
    // MÉTODO CRÍTICO: Detecta o fim da categoria
    public boolean isFimDoQuiz() {
        if (questoesSelecionadas == null) return true;
        // Termina quando o índice AVANÇA para ser IGUAL ou MAIOR que o tamanho da lista.
        return indiceQuestaoAtual >= questoesSelecionadas.size();
    }
    
    public String getCategoriaAtual() {
        return categoriaAtual;
    }
}

