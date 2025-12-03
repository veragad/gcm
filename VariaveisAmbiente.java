package projetogcm;

public final class VariaveisAmbiente {

    public static final String AMBIENTE_ATUAL = "DESENVOLVIMENTO";
    public static final String URL_API_BASE = "http://localhost:8080/quiz/api/v1";
    public static final int TIMEOUT_SEGUNDOS = 10;

    private VariaveisAmbiente() {
        // Impedir instanciação
    }

    public static boolean isDesenvolvimento() {
        return "DESENVOLVIMENTO".equals(AMBIENTE_ATUAL);
    }
}
