package br.ufersa.quizods4.modelo;

import java.util.List;
import java.util.ArrayList;

public class Quiz {
    private List<Questao> todasQuestoes;
    private List<Questao> questoesSelecionadas;
    private int pontuacao;
    private int totalRespondidas;

    public Quiz(List<Questao> todasQuestoes) {
        this.todasQuestoes = todasQuestoes;
        this.pontuacao = 0;
        this.totalRespondidas = 0;
    }

    // RF2: Seleciona e carrega as questões para a categoria escolhida
    public void selecionarCategoria(String categoria) {
        questoesSelecionadas = new ArrayList<>();
        for (Questao q : todasQuestoes) {
            // Comparação ignorando case para flexibilidade
            if (q.getCategoria().equalsIgnoreCase(categoria)) {
                questoesSelecionadas.add(q);
            }
        }
        // Limita o quiz a 3 perguntas para a demo
        questoesSelecionadas = questoesSelecionadas.subList(0, Math.min(3, questoesSelecionadas.size()));
    }

    // RF4 & RF5: Verifica a resposta e atualiza a pontuação
    public boolean verificarResposta(int indiceRespostaUsuario) {
        if (indiceRespostaUsuario < 1 || indiceRespostaUsuario > 4) {
             // Simplesmente retorna falso para entrada inválida
             return false;
        }

        Questao q = questoesSelecionadas.get(totalRespondidas);
        
        // A resposta correta deve ser o número da opção (ex: "1", "2")
        boolean acertou = String.valueOf(indiceRespostaUsuario).equals(q.getRespostaCorreta());

        if (acertou) {
            pontuacao++;
        }
        totalRespondidas++;
        
        return acertou;
    }

    // RF6: Cálculo final
    public double calcularTaxaAcerto() {
        if (totalRespondidas == 0) return 0.0;
        return ((double) pontuacao / totalRespondidas) * 100;
    }

    // Getters auxiliares para o AppPrincipal
    public Questao getQuestaoAtual() {
        if (totalRespondidas < questoesSelecionadas.size()) {
            return questoesSelecionadas.get(totalRespondidas);
        }
        return null; 
    }
    
    public boolean isFimDoQuiz() {
        return totalRespondidas >= questoesSelecionadas.size();
    }
    
    // Métodos para o Relatório Final (RF6)
    public int getPontuacao() { return pontuacao; }
    public int getTotalQuestoes() { return questoesSelecionadas.size(); }
}
