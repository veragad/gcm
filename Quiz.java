package projetogcm;
import java.util.Collections;    
import java.util.List;
import java.util.stream.Collectors;
public class Quiz {
	private List<Questao> todasQuestoes;
    private List<Questao> questoesCategoria;
    private Jogador jogador;
    private int indiceAtual;
    private String categoriaAtual;

    public Quiz(List<Questao> todasQuestoes, Jogador jogador) {
        this.todasQuestoes = todasQuestoes;
        this.jogador = jogador;
        this.indiceAtual = 0;
        this.questoesCategoria = Collections.emptyList();
    }
    
    public void selecionarCategoria(String categoria) {
        this.categoriaAtual = categoria;
        
        this.questoesCategoria = todasQuestoes.stream()
            .filter(q -> categoria.equals(q.getCategoria()))
            .collect(Collectors.toList());
        
        Collections.shuffle(this.questoesCategoria);
        this.indiceAtual = 0;
    }

    /**
     * Incrementa o índice da questão. Chamado apenas pelo botão "Próxima Questão" na classe Demo.
     */
    public void avancarParaProximaQuestao() {
        if (!isFimDoQuiz()) {
            this.indiceAtual++;
        }
    }

    public Questao getQuestaoAtual() {
        if (isFimDoQuiz()) {
            return null;
        }
        // Este método APENAS retorna a questão no índice atual, sem avançar.
        return this.questoesCategoria.get(indiceAtual);
    }

    public boolean verificarResposta(int respostaUsuario) {
        Questao questao = getQuestaoAtual();
        if (questao == null) {
            return false;
        }
        
        boolean acertou = questao.verificarResposta(respostaUsuario);
        jogador.registrarResposta(acertou);  
        return acertou;
    }

    public void resetQuizFlow() {
        this.indiceAtual = 0;
        if (this.questoesCategoria != null) {
            Collections.shuffle(this.questoesCategoria);
        }
    }

    public boolean isFimDoQuiz() {
        return indiceAtual >= questoesCategoria.size();
    }
    
    public String getCategoriaAtual() {
        return categoriaAtual;
    }
    
    public int getIndiceAtual() {
        return this.indiceAtual;
    }
    
    public List<Questao> getQuestoesSelecionadas() {
        return this.questoesCategoria;
    }
}
