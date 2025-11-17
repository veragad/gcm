package projetogcm;
import java.util.HashSet; 
import java.util.Set;
public class Jogador {
	private String nome;
    
    // Pontuação do QUIZ EM ANDAMENTO (usada para o status na tela)
    private int pontuacaoQuizAtual;
    private int totalRespondidasQuizAtual;
    
    // Pontuação TOTAL DA SESSÃO (soma de todos os quizzes)
    private int pontuacaoTotalSessao; 
    private int totalRespondidasTotalSessao; 
    
    // NOVO: Conjunto para rastrear categorias únicas respondidas
    private Set<String> categoriasRespondidas; 

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacaoQuizAtual = 0;
        this.totalRespondidasQuizAtual = 0;
        this.pontuacaoTotalSessao = 0;
        this.totalRespondidasTotalSessao = 0;
        this.categoriasRespondidas = new HashSet<>(); 
    }

    public String getNome() {
        return nome;
    }
    
    // --- RASTREIO DE CATEGORIAS ---
    public void adicionarCategoriaRespondida(String categoria) {
        this.categoriasRespondidas.add(categoria);
    }
    
    public Set<String> getCategoriasRespondidas() {
        return categoriasRespondidas;
    }
    
    // --- REGISTRO DE RESPOSTAS ---
    public void registrarResposta(boolean acertou) {
        if (acertou) {
            this.pontuacaoQuizAtual++;
            this.pontuacaoTotalSessao++; 
        }
        this.totalRespondidasQuizAtual++;
        this.totalRespondidasTotalSessao++; 
    }

    // --- RESET APENAS DO QUIZ ATUAL ---
    public void resetScores() {
        this.pontuacaoQuizAtual = 0;
        this.totalRespondidasQuizAtual = 0;
    }

    // --- GETTERS QUIZ ATUAL (Para Status) ---
    public int getPontuacao() {
        return pontuacaoQuizAtual;
    }
    public int getTotalRespondidas() {
        return totalRespondidasQuizAtual;
    }
    
    // --- GETTERS TOTAL DA SESSÃO (Para Relatório Final) ---
    public int getPontuacaoTotalSessao() {
        return pontuacaoTotalSessao;
    }
    public int getTotalRespondidasTotalSessao() {
        return totalRespondidasTotalSessao;
    }
    
    // --- CÁLCULOS ---
    public double calcularTaxaAcerto() { // Quiz Atual
        if (totalRespondidasQuizAtual == 0) return 0.0;
        return (double) pontuacaoQuizAtual * 100.0 / totalRespondidasQuizAtual;
    }
    
    public double calcularTaxaAcertoTotalSessao() { // Total da Sessão
        if (totalRespondidasTotalSessao == 0) return 0.0;
        return (double) pontuacaoTotalSessao * 100.0 / totalRespondidasTotalSessao;
    }	    		
}
