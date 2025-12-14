package projetogcm;

public final class PatchSeguranca {

    public static final String VERSAO_PATCH = "1.0.1_GCM";
    public static final boolean PATCH_APLICADO = true;

    private PatchSeguranca() {
    }

    public static boolean validarAplicacao() {
        return PATCH_APLICADO;
    }

    public static String obterVersao() {
        return VERSAO_PATCH;
    }

    public static boolean isPatchObsoleto(String versaoAlvo) {
        // Usa a comparação lexicográfica para verificar se a versão atual é "menor" (mais antiga)
        return VERSAO_PATCH.compareTo(versaoAlvo) < 0;
    }
}
