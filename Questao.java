package projetogcm;
import java.util.List;

public class Questao {
	private String texto;
    private List<String> opcoes;
    private String respostaCorreta; // String ("1" a "4")
    private String categoria;

    public Questao(String texto, List<String> opcoes, String respostaCorreta, String categoria) {
        this.texto = texto;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
        this.categoria = categoria;
    }

    public String getTexto() {
        return texto;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public String getRespostaCorreta() {
        return respostaCorreta;
    }
    // Adicionado para suportar o feedback visual na View
    public int getRespostaCorretaIndice() {
        try {
            return Integer.parseInt(this.respostaCorreta);
        } catch (NumberFormatException e) {
            return -1; // Retorna um valor inválido em caso de erro
        }
    }

    public boolean isRespostaCorreta(int respostaUsuario) {
        return respostaUsuario == getRespostaCorretaIndice();
    }
}