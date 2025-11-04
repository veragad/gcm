package projetogcm;
import com.google.gson.Gson;// NECESSITA DE GSON: com.google.code.gson:gson
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GerenciadorDeQuestoes {
	// RF1 IMPLEMENTADO: Tenta carregar as questões do arquivo JSON
    public static List<Questao> carregarQuestoesDeArquivo(String nomeArquivo) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(nomeArquivo)) {
            // Define o tipo (Lista de Questao) que o Gson deve esperar
            Type tipoListaQuestao = new TypeToken<ArrayList<Questao>>() {}.getType();
            
            List<Questao> questoes = gson.fromJson(reader, tipoListaQuestao);
            
            // Se o arquivo JSON estiver vazio, retorna lista vazia, mas não NULL
            if (questoes != null && questoes.size() > 0) {
                 System.out.println("Sucesso (RF1): Questões carregadas do arquivo " + nomeArquivo);
                 return questoes;
            }
            
            // Se o arquivo estiver vazio ou a leitura falhar sem exception:
            System.err.println("ALERTA (RF1): Arquivo JSON vazio ou inválido. Usando dados de backup.");
            return criarDadosIniciais(); // Chama o FALLBACK
            
        } catch (IOException e) {
            // Se o arquivo não for encontrado/lido (ERRO RF1), usa o fallback.
            System.err.println("ERRO CRÍTICO (RF1): Falha na leitura do arquivo '" + nomeArquivo + "'. Usando dados de backup.");
            // e.printStackTrace(); // Removido para manter a saída limpa
            return criarDadosIniciais(); 
        }
    }
    
    // FALLBACK (Antigo método criarDadosIniciais)
    // Usado SOMENTE se a leitura do arquivo JSON falhar (boa prática GCM).
    private static List<Questao> criarDadosIniciais() {
        List<Questao> questoes = new ArrayList<>();
        
        // Categoria: Matematica (2 questões)
        questoes.add(new Questao("Quanto é 5 x 7?", Arrays.asList("30", "35", "40", "45"), "2", "Matematica")); 
        questoes.add(new Questao("Quanto é 2 + 2?", Arrays.asList("3", "4", "5", "6"), "2", "Matematica"));
        
        // Categoria: Português (2 questões)
        questoes.add(new Questao("Qual palavra está escrita corretamente?", Arrays.asList("Exseto", "Ecsceção", "Eçeção", "Exceção"), "4", "Português"));
        questoes.add(new Questao("Qual é o plural de 'cidadão'?", Arrays.asList("Cidadõs", "Cidadãos", "Cidadãoes", "Cidades"), "2", "Português"));
            
        // Categoria: Cidadania (2 questões)
        questoes.add(new Questao("Qual ODS trata da Educação de Qualidade?", Arrays.asList("ODS 1", "ODS 4", "ODS 10", "ODS 15"), "2", "Cidadania"));
        questoes.add(new Questao("O que significa a sigla ODS?", Arrays.asList("Ordem de Desenvolvimento Sustentável", "Objetivos de Desenvolvimento Sustentável", "Organização para Desenvolvimento Social", "Organização de Direitos Humanos e Sociais"), "2", "Cidadania"));
        
        return questoes;
    }	
	    
	    
}
