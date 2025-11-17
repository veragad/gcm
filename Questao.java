package projetogcm;
import java.util.List;   
public class Questao {
	private String texto;
    private List<String> opcoes;
    private String respostaCorreta; // Guardado como String ("1", "2", "3" ou "4")
    private String categoria;

    // Construtor
    public Questao(String texto, List<String> opcoes, String respostaCorreta, String categoria) {
        this.texto = texto;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
        this.categoria = categoria;
    }

    // Getters
    public String getTexto() {
        return texto;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public String getCategoria() {
        return categoria;
    }

    // Método de verificação da resposta
    public boolean verificarResposta(int respostaUsuario) {
        return String.valueOf(respostaUsuario).equals(this.respostaCorreta);
    }
    
    // Método para obter o índice da resposta correta (usado no feedback visual)
    public int getRespostaCorretaIndice() {
        try {
            return Integer.parseInt(this.respostaCorreta);
        } catch (NumberFormatException e) {
            return -1; // Retorna um valor inválido em caso de erro
        }
    }	
	    
}
