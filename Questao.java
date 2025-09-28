package br.ufersa.quizods4.modelo;

import java.util.List;

public class Questao {
    private String texto;
    private List<String> opcoes;
    private String respostaCorreta;
    private String categoria;

    // Construtor
    public Questao(String texto, List<String> opcoes, String respostaCorreta, String categoria) {
        this.texto = texto;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
        this.categoria = categoria;
    }

    // Método para exibir a questão no console
    public void imprimirQuestao() {
        System.out.println("\n== Categoria: " + categoria + " ==");
        System.out.println("Pergunta: " + texto);
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + ". " + opcoes.get(i));
        }
    }

    // Getters para a lógica de verificação
    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public String getCategoria() {
        return categoria;
    }
}
