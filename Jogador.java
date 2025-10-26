package projetogcm;

public class Jogador {
//Representa o jogador atual, contendo seu estado (pontuação e total respondidas).
	private String nome;
    private int pontuacao;
    private int totalRespondidas;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.totalRespondidas = 0;
    }

    // Método para atualizar o estado do jogador (chamado por Quiz)
    public void registrarResposta(boolean acertou) {
        if (acertou) {
            this.pontuacao++;
        }
        this.totalRespondidas++;
    }

    // Getters para Relatório Final (RF6)
    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getTotalRespondidas() {
        return totalRespondidas;
    }

    // RF6: Cálculo da Taxa de Acerto (agora no Jogador, com seus dados)
    public double calcularTaxaAcerto() {
        if (totalRespondidas == 0) return 0.0;
        return ((double) pontuacao / totalRespondidas) * 100;
    }	
	    
}