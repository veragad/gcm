package projetogcm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class RegistroEventos {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    public static final String COMPONENTE_QUIZ = "QUIZ_GCM";

    private RegistroEventos() {
    }

    public static void registrar(String usuario, String evento) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.printf("[%s] [AUDIT - %s] Usuário: %s | Evento: %s%n", 
                          timestamp, 
                          COMPONENTE_QUIZ,
                          usuario.toUpperCase(), 
                          evento);
    }
}
