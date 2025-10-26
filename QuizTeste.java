package projetogcm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class QuizTeste {
	private Quiz quiz;
    private Jogador jogador; 
    private List<Questao> questoesDeTeste;

    // M�todo de simula��o de dados (RF1)
    private List<Questao> criarDadosIniciais() {
        List<Questao> questoes = new ArrayList<>();
        
        // CORRE��O: Usando Arrays.asList() em vez de List.of()
        // Categoria: Matematica
        questoes.add(new Questao("Quanto � 5 x 7?", Arrays.asList("30", "35", "40", "45"), "2", "Matematica"));
        questoes.add(new Questao("Quanto � 2 + 2?", Arrays.asList("3", "4", "5", "6"), "2", "Matematica"));
        
        // Categoria: Portugu�s
        questoes.add(new Questao("Qual palavra est� escrita corretamente?", Arrays.asList("Exceto", "Ecsce��o", "E�e��o", "Exce��o"), "4", "Portugu�s"));
        
        // Categoria: Cidadania
        questoes.add(new Questao("Qual ODS trata da Educa��o de Qualidade?", Arrays.asList("ODS 1", "ODS 4", "ODS 10", "ODS 16"), "2", "Cidadania"));
        
        return questoes;
    }

    // Configura��o executada antes de CADA teste
    @BeforeEach
    void setUp() {
        questoesDeTeste = criarDadosIniciais();
        jogador = new Jogador("Teste"); 
        // A categoria 'Matematica' tem 2 quest�es nos dados de teste.
        quiz = new Quiz(questoesDeTeste, jogador); 
        quiz.selecionarCategoria("Matematica");
    }

    // Teste 1: Valida se a sele��o de categoria funciona e o limite (RF2)
    @Test
    void deveSelecionarAsQuestoesCorretasELimitar() {
        // A categoria 'Matem�tica' tem 2 quest�es nos dados de teste. O limite � 3.
        assertEquals(2, quiz.getTotalQuestoes(), "Deve haver 2 quest�es na categoria Matem�tica.");
        
        // A categoria 'Cidadania' tem 1 quest�o. O limite deve ser 1.
        Quiz quizCidadania = new Quiz(questoesDeTeste, new Jogador("Teste2"));
        quizCidadania.selecionarCategoria("Cidadania");
        assertEquals(1, quizCidadania.getTotalQuestoes(), "Deve haver 1 quest�o na categoria Cidadania.");
    }

    // Teste 2: Valida resposta correta (RF4 & RF5) - Verifica o estado do Jogador
    @Test
    void deveIncrementarPontuacaoSeRespostaCorreta() {
        boolean resultado = quiz.verificarResposta(2); // Resposta Correta (para 'Quanto � 5 x 7?')

        assertTrue(resultado, "A resposta deve ser considerada correta.");
        assertEquals(1, jogador.getPontuacao(), "A pontua��o do JOGADOR deve ser 1.");
        assertEquals(1, jogador.getTotalRespondidas(), "O total respondido deve ser 1.");
    }

    // Teste 3: Valida resposta incorreta (RF4 & RF5) - Verifica o estado do Jogador
    @Test
    void naoDeveIncrementarPontuacaoSeRespostaIncorreta() {
        boolean resultado = quiz.verificarResposta(3); // Resposta Incorreta

        assertFalse(resultado, "A resposta deve ser considerada incorreta.");
        assertEquals(0, jogador.getPontuacao(), "A pontua��o do JOGADOR deve ser 0.");
        assertEquals(1, jogador.getTotalRespondidas(), "O total respondido deve ser 1.");
    }

    // Teste 4: Valida o c�lculo da taxa de acerto (RF6) - Verifica o m�todo do Jogador
    @Test
    void deveCalcularTaxaDeAcertoCorretamente() {
        // 1. Acerta a primeira (2)
        quiz.verificarResposta(2); 
        // 2. Erra a segunda (a resposta correta � 2, vamos responder 1)
        quiz.verificarResposta(1); 
        
        // Pontua��o: 1 acerto em 2 quest�es. 1/2 = 50.0%
        double taxaEsperada = 50.0; 

        assertEquals(taxaEsperada, jogador.calcularTaxaAcerto(), 0.0001, "A taxa de acerto deve ser de 50.0% (1/2).");
    }

    // Teste 5: Valida taxa de acerto ap�s 0 respostas (Evitar divis�o por zero)
    @Test
    void deveRetornarZeroSeNenhumaResposta() {
        assertEquals(0.0, jogador.calcularTaxaAcerto(), "A taxa deve ser 0% se nenhuma resposta foi dada.");
    }		
		
}		