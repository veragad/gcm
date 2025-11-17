package projetogcm;
import javax.swing.*;   
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo implements ActionListener{
	private JFrame frame;
    private JLabel lblPergunta;
    private JButton[] botoesOpcoes;
    private JLabel lblStatus;
    private JPanel painelOpcoes;
    private JPanel painelControle;
    private JButton btnProxima;
    private JButton btnNovoQuiz;

    private Quiz quiz;
    private Jogador jogador;

    private static final String[] CATEGORIAS = {"Português", "Matemática", "Cidadania"};
    private final Color COR_PADRAO_BOTAO = UIManager.getColor("Button.background");

    // =========================================================
    // 1. CONSTRUTOR PADRÃO
    // =========================================================
    public Demo() {
        iniciarAppComNome();
    }

    // =========================================================
    // 2. NOVO CONSTRUTOR
    // =========================================================
    public Demo(Jogador jogadorExistente) {
        this.jogador = jogadorExistente;
        iniciarAppSemNome();
    }

    // =========================================================
    // 3. MÉTODOS DE INICIALIZAÇÃO E VALIDAÇÃO
    // =========================================================

    private void iniciarAppComNome() {
        String nomeJogador = null;
        boolean nomeValido = false;

        while (!nomeValido) {
            nomeJogador = JOptionPane.showInputDialog(null, "Digite seu nome:", "DESAFIO DO SABER", JOptionPane.QUESTION_MESSAGE);

            if (nomeJogador == null) {
                int confirmacaoSaida = JOptionPane.showConfirmDialog(
                    null,
                    "Você deseja sair do Desafio do Saber?",
                    "Confirmação de Saída",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirmacaoSaida == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            } else if (nomeJogador.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Por favor, digite um nome válido para começar o Quiz.",
                    "Nome Inválido",
                    JOptionPane.WARNING_MESSAGE
                );
            } else {
                nomeValido = true;
            }
        }

        this.jogador = new Jogador(nomeJogador.trim());

        iniciarAppSemNome();
    }

    private void iniciarAppSemNome() {
        List<Questao> questoesDisponiveis = GerenciadorDeQuestoes.carregarQuestoesDeArquivo("ignorado.json");

        String categoriaSelecionada = null;

        while (categoriaSelecionada == null) {
            categoriaSelecionada = selecionarCategoria();

            if (categoriaSelecionada == null) {
                int confirmacao = JOptionPane.showConfirmDialog(
                    null,
                    "Você não selecionou uma categoria. Deseja sair do Desafio do Saber?",
                    "Confirmação de Saída",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirmacao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        }

        this.quiz = new Quiz(questoesDisponiveis, this.jogador);
        this.quiz.selecionarCategoria(categoriaSelecionada);

        this.jogador.adicionarCategoriaRespondida(categoriaSelecionada);

        configurarJanela(categoriaSelecionada);

        exibirTelaInicial();
    }

    private String selecionarCategoria() {
        String categoriaSelecionada = (String) JOptionPane.showInputDialog(
            null,
            "Selecione a categoria para começar:",
            "Seleção de Categoria (30 Qs por cat.)",
            JOptionPane.QUESTION_MESSAGE,
            null,
            CATEGORIAS,
            CATEGORIAS[0]
        );
        return categoriaSelecionada;
    }

    private void configurarJanela(String categoria) {
        if (frame != null) {
            frame.dispose();
        }

        frame = new JFrame("O Desafio do Saber - " + categoria);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                actionPerformed(new ActionEvent(btnNovoQuiz, ActionEvent.ACTION_PERFORMED, "NOVO_QUIZ"));
            }
        });

        frame.setSize(750, 650);
        frame.setLayout(new BorderLayout(10, 10));

        lblPergunta = new JLabel("", SwingConstants.CENTER);
        lblPergunta.setFont(new Font("SansSerif", Font.BOLD, 18));
        frame.add(lblPergunta, BorderLayout.NORTH);

        painelOpcoes = new JPanel(new GridLayout(2, 2, 10, 10));
        botoesOpcoes = new JButton[4];

        for (int i = 0; i < 4; i++) {
            botoesOpcoes[i] = new JButton("Opção " + (i + 1));
            botoesOpcoes[i].addActionListener(this);
            botoesOpcoes[i].setActionCommand(String.valueOf(i + 1));
            botoesOpcoes[i].setEnabled(false);
            botoesOpcoes[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
            painelOpcoes.add(botoesOpcoes[i]);
        }
        frame.add(painelOpcoes, BorderLayout.CENTER);

        JPanel painelRodape = new JPanel(new BorderLayout());

        lblStatus = new JLabel("Status: Pronto.", SwingConstants.LEFT);
        lblStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblStatus.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        painelRodape.add(lblStatus, BorderLayout.WEST);

        painelControle = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 5));

        btnNovoQuiz = new JButton("Menu Principal");
        btnNovoQuiz.setActionCommand("NOVO_QUIZ");
        btnNovoQuiz.addActionListener(this);
        painelControle.add(btnNovoQuiz);

        btnProxima = new JButton("Próxima Questão >>");
        btnProxima.setActionCommand("PROXIMA");
        btnProxima.addActionListener(this);
        btnProxima.setEnabled(false);
        painelControle.add(btnProxima);

        painelRodape.add(painelControle, BorderLayout.EAST);
        frame.add(painelRodape, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void exibirTelaInicial() {
        lblPergunta.setText("<html><center><font size='6'>Bem-vindo(a), " + jogador.getNome() + "!</font><br><br>Você está prestes a iniciar o Quiz de <b>" + quiz.getCategoriaAtual() + "</b> (30 questões).<br>Clique no botão abaixo para começar!</center></html>");

        JButton btnIniciar = new JButton("INICIAR O QUIZ!");
        btnIniciar.setFont(new Font("SansSerif", Font.BOLD, 24));
        btnIniciar.setActionCommand("INICIAR");
        btnIniciar.addActionListener(this);

        painelOpcoes.removeAll();
        painelOpcoes.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
        painelOpcoes.add(btnIniciar);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();

        btnProxima.setVisible(false);
        lblStatus.setText("Total de questões: " + quiz.getQuestoesSelecionadas().size());
    }

    private void exibirPlacarEEncerrar() {
        btnProxima.setVisible(false);
        btnNovoQuiz.setVisible(false);
        lblStatus.setText("Pronto para sair.");

        int acertosTotais = jogador.getPontuacaoTotalSessao();
        int respondidasTotais = jogador.getTotalRespondidasTotalSessao();
        double taxaTotal = jogador.calcularTaxaAcertoTotalSessao();

        String categoriasListadas = String.join(", ", jogador.getCategoriasRespondidas());
        if (categoriasListadas.isEmpty()) {
            categoriasListadas = "Nenhuma (sessão cancelada no início)";
        }

        String relatorio = String.format(
            "<html><center><h1>👋 O Desafio do Saber Agradece! 👋</h1>" +
            "<h2>Placar Acumulado da Sessão</h2>" +
            "<b>Jogador:</b> %s<br>" +
            "<b>Categorias Respondidas:</b> %s<br>" +
            "---<br>" +
            "<b>Acertos Totais:</b> <font color='green'>%d acerto(s)</font> em %d questões.<br>" +
            "<b>Taxa de Acerto Geral:</b> <font color='blue'>%.2f%%</font><br><br>" +
            "Pressione o botão 'SAIR' abaixo para fechar o programa." +
            "</center></html>",
            jogador.getNome(),
            categoriasListadas,
            acertosTotais,
            respondidasTotais,
            taxaTotal
        );

        lblPergunta.setText(relatorio);

        painelOpcoes.removeAll();
        painelOpcoes.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));

        JButton btnSairDefinitivo = new JButton("SAIR DO PROGRAMA");
        btnSairDefinitivo.setFont(new Font("SansSerif", Font.BOLD, 24));
        btnSairDefinitivo.setActionCommand("SAIR_DEFINITIVO");
        btnSairDefinitivo.addActionListener(this);

        painelOpcoes.add(btnSairDefinitivo);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if ("INICIAR".equals(comando)) {
            painelOpcoes.removeAll();
            painelOpcoes.setLayout(new GridLayout(2, 2, 10, 10));
            for (JButton b : botoesOpcoes) painelOpcoes.add(b);
            painelOpcoes.revalidate();

            btnProxima.setVisible(true);
            quiz.resetQuizFlow(); // Garante que o índiceAtual volte para 0
            carregarQuestaoAtual(); // Carrega a Questão 1 (índice 0)

        } else if ("PROXIMA".equals(comando)) {
            quiz.avancarParaProximaQuestao(); // Avança o índice (de 0 para 1, por exemplo)
            carregarQuestaoAtual(); // Carrega a nova questão (Questão 2, índice 1)

        } else if ("RECOMEÇAR_CATEGORIA".equals(comando)) {
            btnProxima.setText("Próxima Questão >>");
            btnProxima.setActionCommand("PROXIMA");

            quiz.resetQuizFlow();
            jogador.resetScores();

            painelOpcoes.setVisible(true);
            carregarQuestaoAtual();

        } else if ("NOVO_QUIZ".equals(comando)) {

            painelOpcoes.setVisible(false);

            String[] opcoes = {"Mudar Categoria", "Sair do Programa", "Continuar Quiz"};

            int escolha = JOptionPane.showOptionDialog(
                frame,
                "O que você deseja fazer?",
                "Menu Principal",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[2]
            );

            painelOpcoes.setVisible(true);

            if (escolha == 0) { // Mudar Categoria
                frame.dispose();
                new Demo(this.jogador);
            } else if (escolha == 1) { // SAIR DO PROGRAMA
                exibirPlacarEEncerrar();
            }

        } else if (comando != null && comando.matches("[1-4]")) {
            int respostaUsuario = Integer.parseInt(comando);
            processarResposta(respostaUsuario);
        } else if ("SAIR_DEFINITIVO".equals(comando)) {
            System.exit(0);
        }
    }

    private void atualizarStatus() {
        int atual = quiz.getIndiceAtual();
        int total = quiz.getQuestoesSelecionadas().size();

        String status = String.format(
            "| Jogador: %s | Questão %d de %d | Acertos: %d | Taxa: %.1f%%",
            jogador.getNome(),
            atual + 1, // Exibe o índice atual + 1
            total,
            jogador.getPontuacao(),
            jogador.calcularTaxaAcerto()
        );
        lblStatus.setText(status);
    }

    private void carregarQuestaoAtual() {
        btnProxima.setEnabled(false);

        if (quiz.isFimDoQuiz()) {
            exibirRelatorioFinal();
            return;
        }
        
        // Remove a lógica de "RECOMEÇAR_CATEGORIA" daqui para simplificar o fluxo.

        for (JButton b : botoesOpcoes) {
            b.setBackground(COR_PADRAO_BOTAO);
            b.setForeground(Color.BLACK);
            b.setEnabled(true);
            b.setVisible(true);
        }

        Questao q = quiz.getQuestaoAtual(); // Obtém a questão no índice atual (sem avançar)

        if (q == null) {
            lblPergunta.setText("<html><center><font color='red'>ERRO: Nenhuma questão disponível.</font></center></html>");
            for (JButton b : botoesOpcoes) b.setEnabled(false);
            return;
        }

        int numQuestao = quiz.getIndiceAtual() + 1;
        lblPergunta.setText("<html><center><b>" + q.getCategoria() + "</b> - Questão " + numQuestao + "</center><br>" + q.getTexto() + "</html>");

        List<String> opcoes = q.getOpcoes();

        for (int i = 0; i < 4; i++) {
            if (i < opcoes.size()) {
                String textoOpcao = opcoes.get(i);
                botoesOpcoes[i].setText("<html><b>" + (i + 1) + ". </b> &nbsp; " + textoOpcao + "</html>");
                botoesOpcoes[i].setEnabled(true);
                botoesOpcoes[i].setVisible(true);
            } else {
                botoesOpcoes[i].setText("");
                botoesOpcoes[i].setEnabled(false);
                botoesOpcoes[i].setVisible(false);
            }
        }
        atualizarStatus();
    }
    
    // Método proximaQuestao() foi simplificado para funcionar como um wrapper para o fluxo de fim de quiz
    private void proximaQuestao() {
        if (quiz.isFimDoQuiz()) {
            exibirRelatorioFinal();
            return;
        }
        if (btnProxima.getActionCommand().equals("RECOMEÇAR_CATEGORIA")) {
            btnProxima.setText("Próxima Questão >>");
            btnProxima.setActionCommand("PROXIMA");
            btnProxima.setEnabled(false);
        }
        carregarQuestaoAtual();
    }


    private void processarResposta(int respostaUsuario) {
        if (quiz.isFimDoQuiz()) return;

        Questao questaoAtual = quiz.getQuestaoAtual();
        if (questaoAtual == null) return;

        boolean acertou = quiz.verificarResposta(respostaUsuario);
        int respostaCorretaIndice = questaoAtual.getRespostaCorretaIndice();

        for (JButton b : botoesOpcoes) b.setEnabled(false);

        if (respostaCorretaIndice > 0 && respostaCorretaIndice <= 4) {
            botoesOpcoes[respostaCorretaIndice - 1].setBackground(Color.GREEN);
        }

        if (!acertou) {
            botoesOpcoes[respostaUsuario - 1].setBackground(Color.RED);
            botoesOpcoes[respostaUsuario - 1].setForeground(Color.WHITE);
            lblPergunta.setText("<html><center><font color='red'>INCORRETO!</font></center><br>" + questaoAtual.getTexto() + "</html>");
        } else {
            lblPergunta.setText("<html><center><font color='green'>CORRETO!</font></center><br>" + questaoAtual.getTexto() + "</html>");
        }

        btnProxima.setEnabled(true);
        atualizarStatus();
        
    }

    private void exibirRelatorioFinal() {
        painelOpcoes.setVisible(false);

        btnProxima.setText("Recomeçar esta Categoria");
        btnProxima.setActionCommand("RECOMEÇAR_CATEGORIA");
        btnProxima.setEnabled(true);
        btnProxima.setVisible(true);

        btnNovoQuiz.setText("Mudar Categoria / Sair");

        String categoria = quiz.getCategoriaAtual();

        String relatorioFinal = String.format(
            "<html><center><h2>🎉 FIM DO QUIZ DE %s! 🎉</h2>" +
            "<b>Jogador:</b> %s<br>" +
            "<b>Pontuação Final:</b> <font color='green'>%d acerto(s)</font> em %d questões.<br>" +
            "<b>Taxa de Acerto:</b> <font color='blue'>%.2f%%</font><br><br>" +
            "Use o botão 'Recomeçar' para refazer o quiz ou 'Mudar Categoria / Sair' para encerrar ou escolher outra categoria." +
            "</center></html>",
            categoria.toUpperCase(),
            jogador.getNome(),
            jogador.getPontuacao(),
            jogador.getTotalRespondidas(),
            jogador.calcularTaxaAcerto()
        );

        lblPergunta.setPreferredSize(null);
        lblPergunta.setText(relatorioFinal);

        lblStatus.setText("Quiz Finalizado.");

        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Demo());
    }	
	    
}
