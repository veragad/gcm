package br.ufersa.quizods4; 

import br.ufersa.quizods4.modelo.Jogador;
import br.ufersa.quizods4.modelo.Questao;
import br.ufersa.quizods4.modelo.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    // Simula o banco de dados de questões (o mesmo usado nos testes)
    private static List<Questao> criarBancoDeQuestoes() {
        List<Questao> questoes = new ArrayList<>();
        
        // Categoria Matemática
        questoes.add(new Questao("Quanto é 5 x 7?", List.of("30", "35", "40", "45"), "2", "Matematica"));
        questoes.add(new Questao("Resultado de 15 / 3?", List.of("3", "5", "6", "12"), "2", "Matematica"));
        questoes.add(new Questao("Quanto é 2 + 2?", List.of("3", "4", "5", "6"), "2", "Matematica"));
        
        // Categoria Português
        questoes.add(new Questao("Qual palavra está escrita corretamente?", List.of("Exceto", "Ecsceção", "Eçeção", "Exceção"), "4", "Português"));
        questoes.add(new Questao("O plural de 'pão' é:", List.of("pões", "pães", "panos", "pãos"), "2", "Português"));
        
        // Categoria Cidadania (ODS)
        questoes.add(new Questao("Qual ODS trata da Educação de Qualidade?", List.of("ODS 1", "ODS 4", "ODS 10", "ODS 16"), "2", "Cidadania"));
        questoes.add(new Questao("ODS 1 é sobre:", List.of("Fome Zero", "Saúde e Bem-Estar", "Erradicação da Pobreza", "Igualdade de Gênero"), "3", "Cidadania"));
        
        return questoes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Configuração Inicial
        List<Questao> bancoDeQuestoes = criarBancoDeQuestoes();
        Quiz quiz = new Quiz(bancoDeQuestoes);

        System.out.println("=========================================");
        System.out.println("         BEM-VINDO AO QUIZ ODS 4         ");
        System.out.println("=========================================");

        // 2. Coleta o nome do Jogador
        System.out.print("Digite seu nome para começar: ");
        String nomeJogador = scanner.nextLine();
        Jogador jogador = new Jogador(nomeJogador);

        // 3. Seleção de Categoria (RF2)
        System.out.println("\nSelecione uma categoria (apenas as 3 primeiras questões serão usadas para a demo):");
        System.out.println("-> Matemática");
        System.out.println("-> Português");
        System.out.println("-> Cidadania");
        System.out.print("Digite a categoria: ");
        String categoria = scanner.nextLine();

        quiz.selecionarCategoria(categoria);
        
        // Verifica se há questões na categoria
        if (quiz.getTotalQuestoes() == 0) {
            System.out.println("\nCategoria não encontrada ou sem questões. O quiz foi encerrado.");
            scanner.close();
            return;
        }

        // 4. Loop Principal do Quiz (RF3, RF4, RF5)
        System.out.println("\n=============== QUIZ INICIADO ===============");
        
        while (!quiz.isFimDoQuiz()) {
            Questao questaoAtual = quiz.getQuestaoAtual();
            
            // Exibe a questão (Método da classe Questao)
            questaoAtual.imprimirQuestao();
            
            int respostaUsuario = 0;
            boolean entradaValida = false;
            
            // Loop para garantir entrada numérica e válida (1-4)
            while (!entradaValida) {
                System.out.print("Sua resposta (Digite o número da opção): ");
                if (scanner.hasNextInt()) {
                    respostaUsuario = scanner.nextInt();
                    if (respostaUsuario >= 1 && respostaUsuario <= 4) {
                        entradaValida = true;
                    } else {
                        System.out.println("Opção inválida. Digite um número entre 1 e 4.");
                    }
                } else {
                    System.out.println("Entrada inválida. Digite um número.");
                    scanner.next(); // Consome a entrada inválida
                }
            }
            // Consome a quebra de linha após o nextInt
            scanner.nextLine(); 

            // Verifica a resposta (Método da classe Quiz)
            boolean acertou = quiz.verificarResposta(respostaUsuario);
            System.out.println(acertou ? "✅ Resposta correta!" : "❌ Resposta incorreta.");
        }

        System.out.println("\n=============== FIM DO QUIZ ===============");
        
        // 5. Relatório Final (RF6)
        double taxaAcerto = quiz.calcularTaxaAcerto();
        int pontuacaoFinal = quiz.getPontuacao();

        // Atualiza o objeto Jogador
        jogador.atualizarDesempenho(pontuacaoFinal, taxaAcerto);

        // Imprime o resumo final (Método da classe Jogador)
        jogador.imprimirResumo();

        scanner.close();
    }
}
