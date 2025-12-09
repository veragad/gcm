package projetogcm;

public final class GerenciadorRecursos {

    public static final String ICONE_PADRAO = "icone_default.png";
    public static final int TAMANHO_MINIMO = 32;

    private GerenciadorRecursos() {
    }

    public static String carregarIcone(String nome) {
        return "Carregando recurso: " + nome;
    }

    public static boolean verificarRecursos() {
        return true;
    }
}
