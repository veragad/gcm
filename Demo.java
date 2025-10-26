package projetogcm;
import projetogcm.Questao;
import projetogcm.Quiz;
import projetogcm.Jogador; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo implements ActionListener{
	private JFrame frame;
    private JLabel lblPergunta;
    private JButton[] botoesOpcoes;
    private JLabel lblFeedback;
    private JPanel painelOpcoes;

    private Quiz quiz;
    private Jogador jogador;

    public Demo() {
        // 1. Coleta o nome do jogador
        String nomeJogador = JOptionPane.showInputDialog(null, "Digite seu nome para iniciar o Quiz:", "Bem-vindo", JOptionPane.QUESTION_MESSAGE);
        
        if (nomeJogador == null || nomeJogador.trim().isEmpty()) {
            nomeJogador = "Participante";
        }
        
        this.jogador = new Jogador(nomeJogador);
        List<Questao> dadosIniciais = criarDadosIniciais();
        this.quiz = new Quiz(dadosIniciais, this.jogador);

        // 2. Pede para o jogador selecionar a categoria
        Object[] categorias = {"Matematica", "Português", "Cidadania"};
        String categoriaSelecionada = (String) JOptionPane.showInputDialog(
            null,
            "Selecione a categoria para começar o Quiz:",
            "Seleção de Categoria",
            JOptionPane.QUESTION_MESSAGE,
            null,
            categorias,
            categorias[0]
        );
        
        // Trata o cancelamento da seleção, definindo um padrão
        if (categoriaSelecionada == null || categoriaSelecionada.trim().isEmpty()) {
             categoriaSelecionada = "Matematica"; 
        }

        this.quiz.selecionarCategoria(categoriaSelecionada);

        // O restante do construtor monta a GUI
        frame = new JFrame("O Desafio do Saber (ODS 4)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450); 
        frame.setLayout(new BorderLayout(10, 10));

        lblPergunta = new JLabel("Bem-vindo(a), " + this.jogador.getNome() + ". Clique em Iniciar.", SwingConstants.CENTER);
        lblPergunta.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblPergunta.setPreferredSize(new Dimension(600, 80)); 
        frame.add(lblPergunta, BorderLayout.NORTH);

        painelOpcoes = new JPanel(new GridLayout(2, 2, 10, 10));
        botoesOpcoes = new JButton[4];

        for (int i = 0; i < 4; i++) {
            botoesOpcoes[i] = new JButton("Opção " + (i + 1));
            botoesOpcoes[i].addActionListener(this);
            botoesOpcoes[i].setActionCommand(String.valueOf(i + 1));
            botoesOpcoes[i].setEnabled(false);
            painelOpcoes.add(botoesOpcoes[i]);
        }
        frame.add(painelOpcoes, BorderLayout.CENTER);

        lblFeedback = new JLabel("Status: Aguardando início.", SwingConstants.CENTER);
        lblFeedback.setFont(new Font("SansSerif", Font.PLAIN, 14));
        frame.add(lblFeedback, BorderLayout.SOUTH);

        JButton btnIniciar = new JButton("Iniciar Quiz");
        btnIniciar.setActionCommand("INICIAR");
        btnIniciar.addActionListener(this);
        frame.add(btnIniciar, BorderLayout.WEST);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if ("INICIAR".equals(comando)) {
            ((JButton)e.getSource()).setVisible(false);
            
            proximaQuestao();
            
            frame.revalidate(); 
            frame.repaint();
            
        } else if (comando != null && comando.matches("[1-4]")) {
            int respostaUsuario = Integer.parseInt(comando);
            processarResposta(respostaUsuario);
        }
    }

    private void proximaQuestao() {
        if (quiz.isFimDoQuiz()) {
            exibirRelatorioFinal();
            return;
        }
        
        Questao q = quiz.getQuestaoAtual();
        
        // Proteção contra NullPointerException (para o caso de não haver questões na categoria)
        if (q == null) {
            lblPergunta.setText("<html><center><font color='red'>ERRO: Nenhuma questão disponível para exibir.</font></center></html>");
            for(JButton b : botoesOpcoes) b.setEnabled(false);
            return;
        }
        
        lblPergunta.setText("<html><center><b>" + q.getCategoria() + "</b></center><br>" + q.getTexto() + "</html>"); 

        List<String> opcoes = q.getOpcoes();
        for (int i = 0; i < opcoes.size(); i++) {
            botoesOpcoes[i].setText(opcoes.get(i));
            botoesOpcoes[i].setEnabled(true);
        }
        lblFeedback.setText("Selecione sua resposta.");
    }

    private void processarResposta(int respostaUsuario) {
        if (quiz.isFimDoQuiz()) return;

        boolean acertou = quiz.verificarResposta(respostaUsuario);

        if (acertou) {
            lblFeedback.setText("<html><font color='green'>CORRETO!</font> (Pontuação: " + jogador.getPontuacao() + ")</html>");
        } else {
            lblFeedback.setText("<html><font color='red'>INCORRETO!</font></html>");
        }
        
        for(JButton b : botoesOpcoes) b.setEnabled(false);

        Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proximaQuestao();
                ((Timer)e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void exibirRelatorioFinal() {
        painelOpcoes.setVisible(false);
        lblFeedback.setVisible(false);
        
        String relatorio = String.format(
            "<html><center><h2>FIM DO QUIZ!</h2>" +
            "<b>Jogador:</b> %s<br>" +
            "<b>Pontuação Total:</b> %d de %d<br>" +
            "<b>Taxa de Acerto:</b> <font color='blue'>%.2f%%</font></center></html>",
            jogador.getNome(), 
            jogador.getPontuacao(), 
            jogador.getTotalRespondidas(), 
            jogador.calcularTaxaAcerto()
        );

        // Garante que o relatório final não seja cortado
        lblPergunta.setPreferredSize(null); 
        
        lblPergunta.setText(relatorio);
        frame.revalidate();
        frame.repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Demo();
            }
        });
    }

    // Método com a lista de questões (2 por categoria)
    public static List<Questao> criarDadosIniciais() {
        List<Questao> questoes = new ArrayList<>();
        
        // Categoria: Matematica (2 questões)
        questoes.add(new Questao("Quanto é 5 x 7?", 
            Arrays.asList("30", "35", "40", "45"), 
            "2", "Matematica")); 
        questoes.add(new Questao("Quanto é 2 + 2?", 
            Arrays.asList("3", "4", "5", "6"), 
            "2", "Matematica"));
        
        // Categoria: Português (2 questões)
        questoes.add(new Questao("Qual palavra está escrita corretamente?", 
            Arrays.asList("Exseto", "Ecsceção", "Eçeção", "Exceção"), 
            "4", "Português"));
        questoes.add(new Questao("Qual é o plural de 'cidadão'?", 
            Arrays.asList("Cidadões", "Cidadãos", "Cidadãoes", "Cidades"), 
            "2", "Português"));
            
        // Categoria: Cidadania (2 questões)
        questoes.add(new Questao("Qual ODS trata da Educação de Qualidade?", 
            Arrays.asList("ODS 1", "ODS 4", "ODS 10", "ODS 16"), 
            "2", "Cidadania"));
        questoes.add(new Questao("O que significa a sigla ODS?", 
            Arrays.asList("Organizações de Desenvolvimento Social", "Objetivos de Desenvolvimento Sustentável", "Ordem Democrática Social", "Operações de Defesa e Segurança"), 
            "2", "Cidadania"));
        
        return questoes;
    }
}
