package br.ufersa.quizods4.app;

import br.ufersa.quizods4.modelo.Questao;
import br.ufersa.quizods4.modelo.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Demo {

    public static void main(String[] args) {
        new Demo().iniciarAplicacao();
    }

    // Simulação de Dados (RF1: O método real seria na classe Dados)
    public static List<Questao> criarDadosIniciais() {
        List<Questao> questoes = new ArrayList<>();
        
        // Categoria: Matemática (Meta 4.6)
        questoes.add(new Questao("Quanto é 5 x 7?", List.of("30", "35", "40", "45"), "2", "Matematica"));
        
        // Categoria: Português (Meta 4.6)
        questoes.add(new Questao("Qual palavra está escrita corretamente?", List.of("Exceto", "Ecsceção", "Eçeção", "Exceção"), "4", "Português"));
            
        // Categoria: Cidadania/Sustentabilidade (Meta 4.7)
        questoes.add(new Questao("Qual ODS trata da Educação de Qualidade?", List.of("ODS 1", "ODS 4", "ODS 10", "ODS 16"), "2", "Cidadania"));

        // Mais para teste de seleção
        questoes.add(new Questao("Quanto é 2 + 2?", List.of("3", "4", "5"), "2", "Matematica"));
        questoes.add(new Questao("Qual a capital do Brasil?", List.of("Rio", "Brasília", "São Paulo"), "2", "Cidadania"));
        
        return questoes;
    }

    public void iniciarAplicacao() {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz(criarDadosIniciais()); // RF1 simulado

        System.out.println("=========================================");
        System.out.println("  BEM-VINDO ao O DESAFIO DO SABER (ODS 4)");
        System.out.println("=========================================");

        // RF2: Seleção de Categoria
        System.out.println("\nEscolha a categoria (digite o nome):");
        System.out.println("- Matemática");
        System.out.println("- Português");
        System.out.println("- Cidadania");
        System.out.print("> ");
        String categoriaEscolhida = scanner.nextLine();

        quiz.selecionarCategoria(categoriaEscolhida);

        if (quiz.getTotalQuestoes() == 0) {
            System.out.println("Categoria inválida ou sem questões. Encerrando.");
            scanner.close();
            return;
        }

        System.out.println("\n--- Quiz de " + categoriaEscolhida + " Iniciado! ---");

        // Loop principal do Quiz
        while (!quiz.isFimDoQuiz()) {
            Questao q = quiz.getQuestaoAtual();
            q.imprimirQuestao(); // RF3: Exibir Questão

            System.out.print("Sua resposta (digite o número da opção): ");
            
            // Tratamento simples para garantir entrada inteira
            if (scanner.hasNextInt()) {
                int respostaUsuario = scanner.nextInt();
                boolean acertou = quiz.verificarResposta(respostaUsuario); // RF4 & RF5

                if (acertou) {
                    System.out.println("Parabéns! Resposta Correta.");
                } else {
                    System.out.println("Ops! Resposta Incorreta.");
                }
            } else {
                System.out.println("Entrada inválida. Tentando a próxima questão.");
                quiz.verificarResposta(0); // Conta como erro
                scanner.next(); // Consome a linha inválida
            }
        }
        
        // RF6: Relatório Final
        System.out.println("\n=========================================");
        System.out.println("        FIM DO QUIZ! RELATÓRIO FINAL     ");
        System.out.println("=========================================");
        System.out.println("Pontuação Total: " + quiz.getPontuacao() + " de " + quiz.getTotalQuestoes());
        System.out.printf("Taxa de Acerto: %.2f%%\n", quiz.calcularTaxaAcerto());
        System.out.println("=========================================");

        scanner.close();
    }
  
}
