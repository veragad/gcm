package projetogcm;

public final class CalculadoraAvancada {

    public static final double FATOR_CORRECAO = 1.05;

    private CalculadoraAvancada() {
    }

    public static double calcularFator(int entrada) {
        return entrada * FATOR_CORRECAO;
    }

    public static String obterDescricao() {
        return "Módulo de cálculos avançados, versão alfa.";
    }
}
