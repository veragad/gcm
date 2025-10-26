package projetogcm;
import java.util.List;
import java.util.ArrayList;
public class Quiz {
	private List<Questao> todasQuestoes;
    private List<Questao> questoesSelecionadas;
    private Jogador jogador; 
    private int indiceQuestaoAtual;

    public Quiz(List<Questao> todasQuestoes, Jogador jogador) { 
        this.todasQuestoes = todasQuestoes;
        this.jogador = jogador;
        this.indiceQuestaoAtual = 0;
        this.questoesSelecionadas = new ArrayList<>(); // Inicializa para evitar NullPointer
    }

    // Seleciona e carrega as questões
    public void selecionarCategoria(String categoria) {
        questoesSelecionadas.clear(); 
        for (Questao q : todasQuestoes) {
            if (q.getCategoria().equalsIgnoreCase(categoria)) {
                questoesSelecionadas.add(q);
            }
        }
        // Limita o quiz: Se houver mais de 3, usa apenas as 3 primeiras.
        int limite = Math.min(3, questoesSelecionadas.size());
        if (limite < questoesSelecionadas.size()) {
             questoesSelecionadas = questoesSelecionadas.subList(0, limite);
        }
    }

    // Verifica a resposta
    public boolean verificarResposta(int indiceRespostaUsuario) {
        // Proteção 1: Checa se a lista de questões está vazia ou se já terminamos.
        if (questoesSelecionadas == null || indiceQuestaoAtual >= questoesSelecionadas.size()) {
            return false;
        }

        Questao q = questoesSelecionadas.get(indiceQuestaoAtual);
        
        // Se a questão 'q' fosse nula aqui, daria erro. 
        // Mas a checagem acima deve evitar isso.
        
        // Verifica se a resposta está dentro do range 1 a 4
        boolean respostaValida = (indiceRespostaUsuario >= 1 && indiceRespostaUsuario <= 4);
        
        boolean acertou = false;
        if (respostaValida) {
            // Linha com problema de execução (AQUI!)
            acertou = String.valueOf(indiceRespostaUsuario).equals(q.getRespostaCorreta());
        }

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
    
    public boolean isFimDoQuiz() {
        if (questoesSelecionadas == null) return true;
        return indiceQuestaoAtual >= questoesSelecionadas.size();
    }
    
    public int getTotalQuestoes() { 
        if (questoesSelecionadas == null) return 0;
        return questoesSelecionadas.size(); 
    }
    
}