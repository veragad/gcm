package projetogcm;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List;
import java.util.stream.Collectors; 

public class Demo implements ActionListener{
	private JFrame frame;
    private JLabel lblPergunta;
    private JButton[] botoesOpcoes;
    private JLabel lblFeedback;
    private JPanel painelOpcoes;

    private Quiz quiz;
    private Jogador jogador;
    
    private static final Object[] CATEGORIAS = {"Matemática", "Português", "Cidadania"};

    private final Color COR_PADRAO_BOTAO = UIManager.getColor("Button.background"); 

    public Demo() {
        String nomeJogador = JOptionPane.showInputDialog(null, "Digite seu nome para iniciar o Quiz:", "Bem-vindo", JOptionPane.QUESTION_MESSAGE);
        
        if (nomeJogador == null || nomeJogador.trim().isEmpty()) {
            nomeJogador = "Participante";
        }
        
        this.jogador = new Jogador(nomeJogador);
        
        // CORREÇÃO: Chama o GerenciadorDeQuestoes para obter as 90 questões
        List<Questao> questoesDisponiveis = GerenciadorDeQuestoes.carregarQuestoesDeArquivo("ignorado.json");

        String categoriaSelecionada = (String) JOptionPane.showInputDialog(
            null,
            "Selecione a categoria:",
            "Seleção de Categoria",
            JOptionPane.QUESTION_MESSAGE,
            null,
            CATEGORIAS,
            CATEGORIAS[0]
        );

        if (categoriaSelecionada == null || categoriaSelecionada.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria selecionada. Encerrando.", "Fim", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        this.quiz = new Quiz(questoesDisponiveis, this.jogador);
        this.quiz.selecionarCategoria(categoriaSelecionada);


        frame = new JFrame("O Desafio do Saber (" + categoriaSelecionada + ")");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450); 
        frame.setLayout(new BorderLayout(10, 10));

        lblPergunta = new JLabel("Categoria: " + categoriaSelecionada + ". Clique em Iniciar.", SwingConstants.CENTER);
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
            botoesOpcoes[i].setFont(new Font("SansSerif", Font.PLAIN, 12));
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
        
        for (JButton b : botoesOpcoes) {
            b.setBackground(COR_PADRAO_BOTAO);
            b.setForeground(Color.BLACK); 
            b.setEnabled(true);
            b.setVisible(true); 
        }
        
        Questao q = quiz.getQuestaoAtual();
        
        if (q == null) {
            lblPergunta.setText("<html><center><font color='red'>ERRO: Nenhuma questão disponível para exibir.</font></center></html>");
            for(JButton b : botoesOpcoes) b.setEnabled(false);
            return;
        }
        
        lblPergunta.setText("<html><center><b>" + q.getCategoria() + "</b></center><br>" + q.getTexto() + "</html>"); 

        List<String> opcoes = q.getOpcoes();
        
        for (int i = 0; i < 4; i++) { 
            if (i < opcoes.size()) {
                String textoOpcao = opcoes.get(i);
                
                botoesOpcoes[i].setText("<html><b>" + (i + 1) + ". </b> &nbsp; " + textoOpcao + "</html>");
                
                botoesOpcoes[i].setEnabled(true);
            } else {
                 botoesOpcoes[i].setText(""); 
                 botoesOpcoes[i].setEnabled(false);
                 botoesOpcoes[i].setVisible(false);
            }
        }
        lblFeedback.setText("Selecione sua resposta.");
    }

    private void processarResposta(int respostaUsuario) {
        if (quiz.isFimDoQuiz()) return;

        Questao questaoAtual = quiz.getQuestaoAtual();
        if (questaoAtual == null) return;
        
        boolean acertou = quiz.verificarResposta(respostaUsuario); 
        int respostaCorretaIndice = questaoAtual.getRespostaCorretaIndice();
        
        for(JButton b : botoesOpcoes) b.setEnabled(false);

        if (respostaCorretaIndice > 0 && respostaCorretaIndice <= 4) {
             botoesOpcoes[respostaCorretaIndice - 1].setBackground(Color.GREEN);
        }
        
        if (acertou) {
            lblFeedback.setText("<html><font color='green'>CORRETO!</font> (Pontuação: " + jogador.getPontuacao() + ")</html>");
            
        } else {
            botoesOpcoes[respostaUsuario - 1].setBackground(Color.RED);
            lblFeedback.setText("<html><font color='red'>INCORRETO!</font> (Resposta correta: " + respostaCorretaIndice + ")</html>");
        }

        Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> proximaQuestao()); 
                ((Timer)e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    private void exibirRelatorioFinal() {
        painelOpcoes.setVisible(false);
        lblFeedback.setVisible(false);
        
        String categoria = quiz.getCategoriaAtual();
        
        String relatorioFinal = String.format(
            "<html><center><h2>FIM DO QUIZ DE %s!</h2>" +
            "<b>Jogador:</b> %s<br>" +
            "<b>Pontuação Final:</b> %d acerto(s) em %d questões.<br>" +
            "<b>Taxa de Acerto:</b> <font color='blue'>%.2f%%</font><br><br>" +
            "Para jogar outra categoria, feche e abra o programa novamente." +
            "</center></html>",
            categoria.toUpperCase(),
            jogador.getNome(), 
            jogador.getPontuacao(), 
            jogador.getTotalRespondidas(), 
            jogador.calcularTaxaAcerto()
        );

        lblPergunta.setPreferredSize(null); 
        lblPergunta.setText(relatorioFinal);
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
}

