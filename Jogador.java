package br.ufersa.quizods4.modelo;

public class Jogador {
    private String nome;
    private int pontuacao;
    private double taxaAcerto;

    // Construtor
    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.taxaAcerto = 0.0;
    }

    // Atualiza dados após o término do quiz
    public void atualizarDesempenho(int pontuacao, double taxaAcerto) {
        this.pontuacao = pontuacao;
        this.taxaAcerto = taxaAcerto;
    }

    // Exibe o resumo do jogador (RF6 - Relatório final)
    public void imprimirResumo() {
        System.out.println("\n===== RELATÓRIO FINAL =====");
        System.out.println("Jogador: " + nome);
        System.out.println("Pontuação final: " + pontuacao);
        System.out.printf("Taxa de acerto: %.2f%%\n", taxaAcerto);
        if (taxaAcerto >= 70) {
            System.out.println("Desempenho: Excelente! 🎯");
        } else if (taxaAcerto >= 50) {
            System.out.println("Desempenho: Bom! 👍 Continue praticando!");
        } else {
            System.out.println("Desempenho: Precisa melhorar. 💪");
        }
        System.out.println("=============================\n");
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public double getTaxaAcerto() {
        return taxaAcerto;
    }
}
