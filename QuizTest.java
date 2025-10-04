package br.ufersa.quizods4.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

public class QuizTest {

    private Quiz quiz;
    private List<Questao> questoesDeTeste;

    // Método de simulação de dados (usado na Demo)
    private List<Questao> criarDadosIniciais() {
        List<Questao> questoes = new ArrayList<>();
        
        // 0. Matemática (Correta: 2)
        questoes.add(new Questao("Quanto é 5 x 7?", List.of("30", "35", "40", "45"), "2", "Matematica"));
        
        // 1. Português (Correta: 4)
        questoes.add(new Questao("Qual palavra está escrita corretamente?", List.of("Exceto", "Ecsceção", "Eçeção", "Exceção"), "4", "Português"));
            
        // 2. Cidadania (Correta: 2)
        questoes.add(new Questao("Qual ODS trata da Educação de Qualidade?", List.of("ODS 1", "ODS 4", "ODS 10", "ODS 16"), "2", "Cidadania"));

        // 3. Matemática (Correta: 2) - Para testar o limite
        questoes.add(new Questao("Quanto é 2 + 2?", List.of("3", "4", "5", "6"), "2", "Matematica"));
        
        return questoes;
    }

    // Configuração executada antes de CADA teste
    @BeforeEach
    void setUp() {
        questoesDeTeste = criarDadosIniciais();
        quiz = new Quiz(questoesDeTeste);
        // Garante que o quiz comece com um conjunto de 3 questões (Matemática)
        quiz.selecionarCategoria("Matematica");
    }

    // Teste 1: Valida se a seleção de categoria funciona (RF2)
    @Test
    void deveSelecionarAsQuestoesCorretas() {
        // A categoria 'Matematica' tem 2 questões no nosso array de teste.
        // O método 'selecionarCategoria' limita o quiz a 3 questões.
        // Vamos testar a categoria 'Cidadania', que tem apenas 1 questão.
        Quiz quizCidadania = new Quiz(questoesDeTeste);
        quizCidadania.selecionarCategoria("Cidadania");

        assertEquals(1, quizCidadania.getTotalQuestoes(), 
                     "Deve haver exatamente 1 questão na categoria Cidadania.");
    }

    // Teste 2: Valida resposta correta (RF4 & RF5)
    @Test
    void deveIncrementarPontuacaoSeRespostaCorreta() {
        // A primeira questão de Matemática é "Quanto é 5 x 7?", R: 2
        boolean resultado = quiz.verificarResposta(2); 

        assertTrue(resultado, "A resposta deve ser considerada correta.");
        assertEquals(1, quiz.getPontuacao(), "A pontuação deve ser 1 após o acerto.");
    }

    // Teste 3: Valida resposta incorreta (RF4 & RF5)
    @Test
    void naoDeveIncrementarPontuacaoSeRespostaIncorreta() {
        // A primeira questão de Matemática é "Quanto é 5 x 7?", R: 2
        boolean resultado = quiz.verificarResposta(3); // Erro proposital

        assertFalse(resultado, "A resposta deve ser considerada incorreta.");
        assertEquals(0, quiz.getPontuacao(), "A pontuação deve permanecer 0 após o erro.");
    }

    // Teste 4: Valida o cálculo da taxa de acerto (RF6)
    @Test
    void deveCalcularTaxaDeAcertoCorretamente() {
        // Quiz tem 3 questões de Matemática
        
        // 1. Acerta (R: 2)
        quiz.verificarResposta(2); 
        // 2. Erra (R: 3)
        quiz.verificarResposta(3); 
        // 3. Acerta (R: 2)
        quiz.verificarResposta(2);

        // Pontuação: 2 acertos em 3 questões. 2/3 = 66.666...%
        double taxaEsperada = 66.66666666666666; 

        assertEquals(taxaEsperada, quiz.calcularTaxaAcerto(), 0.0001, 
                     "A taxa de acerto deve ser de aproximadamente 66.67%.");
    }

    // Teste 5: Valida taxa de acerto após 0 respostas (Evitar divisão por zero)
    @Test
    void deveRetornarZeroSeNenhumaResposta() {
        assertEquals(0.0, quiz.calcularTaxaAcerto(), "A taxa deve ser 0% se nenhuma resposta foi dada.");
    }
}
