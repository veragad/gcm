package projetogcm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
public class QuizTeste {
	private Quiz quiz;
    private Jogador jogador; 
    private List<Questao> questoesDeTeste;

    @BeforeEach
    void setUp() {
        // RF1 IMPLEMENTADO (Carrega dados do arquivo ou fallback)
        questoesDeTeste = GerenciadorDeQuestoes.carregarQuestoesDeArquivo("questoes.json");
        
        jogador = new Jogador("Teste");
        // Seleciona a categoria 'Matematica' para garantir o uso de questões conhecidas
        quiz = new Quiz(questoesDeTeste, jogador);
        quiz.selecionarCategoria("Matematica");
    }

    // Teste 1: Valida se a seleção de categoria funciona e limita a 3 questões
    @Test
    void deveSelecionarAsQuestoesCorretasELimitar() {
        // Agora usa o getQuestoesSelecionadas() que adicionamos na classe Quiz
        assertEquals(2, quiz.getQuestoesSelecionadas().size(), "Deve selecionar o número correto de questões.");
        assertEquals("Matematica", quiz.getQuestaoAtual().getCategoria(), "A categoria da primeira questão deve ser Matemática.");
    }

    // Teste 2: Valida resposta correta (RF4 & RF5) - Verifica o estado do Jogador
    @Test
    void deveIncrementarPontuacaoSeRespostaCorreta() {
        // A primeira questão de Matemática tem a resposta correta "2" (35)
        boolean resultado = quiz.verificarResposta(2); 

        assertTrue(resultado, "A resposta deve ser considerada correta.");
        assertEquals(1, jogador.getPontuacao(), "A pontuação do JOGADOR deve ser 1.");
        assertEquals(1, jogador.getTotalRespondidas(), "O total respondido deve ser 1.");
    }

    // Teste 3: Valida resposta incorreta (RF4 & RF5) - Verifica o estado do Jogador
    @Test
    void naoDeveIncrementarPontuacaoSeRespostaIncorreta() {
        boolean resultado = quiz.verificarResposta(3); // Resposta Incorreta

        assertFalse(resultado, "A resposta deve ser considerada incorreta.");
        assertEquals(0, jogador.getPontuacao(), "A pontuação do JOGADOR deve ser 0.");
        assertEquals(1, jogador.getTotalRespondidas(), "O total respondido deve ser 1.");
    }

    // Teste 4: Valida o cálculo da taxa de acerto (RF6) - Verifica o método do Jogador
    @Test
    void deveCalcularTaxaDeAcertoCorretamente() {
        // 1. Acerta a primeira (resposta 2)
        quiz.verificarResposta(2); 
        // 2. Erra a segunda (a resposta correta é 2, vamos responder 1)
        quiz.verificarResposta(1); 
        
        // Pontuação: 1 acerto em 2 questões. 1/2 = 50.0%
        double taxaEsperada = 50.0; 

        assertEquals(taxaEsperada, jogador.calcularTaxaAcerto(), 0.0001, "A taxa de acerto deve ser 50.0%.");
    }	    
}
