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

    // Simulação de Dados (RF1: O método real leria um arquivo JSON/CSV)
    public static List<Questao> criarDadosIniciais() {
        List<Questao> questoes = new ArrayList<>();
        
        // Dados para teste de categoria e pontuação
        questoes.add(new Questao("Quanto é 5 x 7?", List.of("30", "35", "40", "45"), "2", "Matematica")); // Correta: 2
        questoes.add(new Questao("Qual palavra está escrita corretamente?", List.of("Exceto", "Ecsceção", "Eçeção", "Exceção"), "4", "Português")); // Correta: 4
        questoes.add(new Questao("Qual ODS trata da Educação de Qualidade?", List.of("ODS 1", "ODS 4", "ODS 10", "ODS 16"), "2", "Cidadania")); // Correta: 2

        // Questão extra para categoria Matemática (será usada na demo)
        questoes.add(new Questao("Quanto é 2 + 2?", List.of("3", "4", "5", "6"), "2", "Matematica"));
        
        return questoes;
    }

    public void iniciarAplicacao() {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz(criarDadosIniciais()); // RF1 simulado

        System.out.println("=========================================");
        System.out.println("  DEMO: O DESAFIO DO SABER (ODS 4)");
        System.out.println("=========================================");

        // RF2: Seleção de Categoria
        System.out.println("\nEscolha a categoria (digite o nome):");
        System.out.println("- Matematica");
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

        System.out.println("\n--- Quiz de " + categoriaEscolhida + " Iniciado! (" + quiz.getTotalQuestoes() + " Questões) ---");

        // Loop principal do Quiz
        while (!quiz.isFimDoQuiz()) {
            Questao q = quiz.getQuestaoAtual();
            q.imprimirQuestao(); // RF3: Exibir Questão

            System.out.print("Sua resposta (digite o número da opção): ");
            
            int respostaUsuario = 0;
            // Garantir que a entrada seja um número
            if (scanner.hasNextInt()) {
                respostaUsuario = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.next(); // Consome a linha inválida
                continue; // Volta para o início do loop sem processar a resposta
            }
            scanner.nextLine(); // Consome a quebra de linha

            boolean acertou = quiz.verificarResposta(respostaUsuario); // RF4 & RF5

            if (acertou) {
                System.out.println("-> Parabéns! Resposta Correta.");
            } else {
                System.out.println("-> Ops! Resposta Incorreta.");
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
