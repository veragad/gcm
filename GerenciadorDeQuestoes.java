package projetogcm;
import java.util.ArrayList;  
import java.util.Arrays;
import java.util.List;

public class GerenciadorDeQuestoes {
	public static List<Questao> carregarQuestoesDeArquivo(String nomeArquivo) {
        System.out.println("Sucesso: Usando dados de backup (90 questões internas).");
        return criarDadosIniciais(); 
    }
    
    private static List<Questao> criarDadosIniciais() {
        List<Questao> questoes = new ArrayList<>();
        
        // ==========================================================
        // Categoria: Matemática (30 questões)
        // O valor entre aspas (ex: "2") é o índice da resposta correta.
        // ==========================================================
        questoes.add(new Questao("Matemática 1: Quanto é 7 x 8?", Arrays.asList("54", "56", "64", "68"), "2", "Matemática")); // Resposta: 56
        questoes.add(new Questao("Matemática 2: Qual é o valor de π (Pi) aproximado?", Arrays.asList("3.12", "3.14", "3.16", "3.18"), "2", "Matemática")); // Resposta: 3.14
        questoes.add(new Questao("Matemática 3: Quanto é 15²?", Arrays.asList("205", "225", "250", "255"), "2", "Matemática")); // Resposta: 225
        questoes.add(new Questao("Matemática 4: A soma dos ângulos internos de um triângulo é:", Arrays.asList("90°", "180°", "270°", "360°"), "2", "Matemática")); // Resposta: 180°
        questoes.add(new Questao("Matemática 5: Qual é a raiz quadrada de 144?", Arrays.asList("11", "12", "13", "14"), "2", "Matemática")); // Resposta: 12
        questoes.add(new Questao("Matemática 6: Quanto é 1/4 em porcentagem?", Arrays.asList("15%", "25%", "40%", "50%"), "2", "Matemática")); // Resposta: 25%
        questoes.add(new Questao("Matemática 7: Qual é o próximo número na sequência: 2, 4, 8, 16, ...?", Arrays.asList("24", "30", "32", "40"), "3", "Matemática")); // Resposta: 32
        questoes.add(new Questao("Matemática 8: Qual o valor de X em 2X + 5 = 15?", Arrays.asList("5", "10", "15", "20"), "1", "Matemática")); // Resposta: 5
        questoes.add(new Questao("Matemática 9: Perímetro de um retângulo com lados 5 e 8:", Arrays.asList("13", "26", "30", "40"), "2", "Matemática")); // Resposta: 26
        questoes.add(new Questao("Matemática 10: O que representa a hipotenusa?", Arrays.asList("Lado adjacente", "Maior lado de um triângulo retângulo", "Ângulo agudo", "Raiz quadrada"), "2", "Matemática")); // Resposta: Maior lado de um triângulo retângulo
        questoes.add(new Questao("Matemática 11: Quanto é 0.5 + 0.25?", Arrays.asList("0.65", "0.75", "1.0", "0.85"), "2", "Matemática")); // Resposta: 0.75
        questoes.add(new Questao("Matemática 12: Qual o nome da figura geométrica com 6 lados?", Arrays.asList("Pentágono", "Heptágono", "Hexágono", "Octógono"), "3", "Matemática")); // Resposta: Hexágono
        questoes.add(new Questao("Matemática 13: Quanto é (3 + 5) * 2?", Arrays.asList("16", "13", "11", "10"), "1", "Matemática")); // Resposta: 16
        questoes.add(new Questao("Matemática 14: Quanto é 10 elevado a 3?", Arrays.asList("100", "1000", "10000", "30"), "2", "Matemática")); // Resposta: 1000
        questoes.add(new Questao("Matemática 15: O que é um número primo?", Arrays.asList("Divisível por 10", "Divisível apenas por 1 e por si mesmo", "Qualquer número ímpar", "Qualquer número maior que 1"), "2", "Matemática")); // Resposta: Divisível apenas por 1 e por si mesmo
        questoes.add(new Questao("Matemática 16: Se um ângulo tem 90°, ele é:", Arrays.asList("Agudo", "Obtuso", "Reto", "Raso"), "3", "Matemática")); // Resposta: Reto
        questoes.add(new Questao("Matemática 17: Qual o valor de 5! (fatorial de 5)?", Arrays.asList("25", "100", "120", "50"), "3", "Matemática")); // Resposta: 120
        questoes.add(new Questao("Matemática 18: Quantos centímetros tem 2 metros?", Arrays.asList("20", "100", "200", "2000"), "3", "Matemática")); // Resposta: 200
        questoes.add(new Questao("Matemática 19: O que é moda em estatística?", Arrays.asList("Média", "Mediana", "Valor que mais se repete", "Maior valor"), "3", "Matemática")); // Resposta: Valor que mais se repete
        questoes.add(new Questao("Matemática 20: Quanto é 10% de 500?", Arrays.asList("5", "10", "50", "100"), "3", "Matemática")); // Resposta: 50
        questoes.add(new Questao("Matemática 21: Quantos segundos tem 1 minuto?", Arrays.asList("30", "60", "90", "100"), "2", "Matemática")); // Resposta: 60
        questoes.add(new Questao("Matemática 22: Qual é o número inteiro antecessor a -5?", Arrays.asList("-6", "-4", "-5", "0"), "1", "Matemática")); // Resposta: -6
        questoes.add(new Questao("Matemática 23: Qual é o resultado de (-2) * (-3)?", Arrays.asList("-6", "-5", "6", "5"), "3", "Matemática")); // Resposta: 6
        questoes.add(new Questao("Matemática 24: Qual o nome da unidade de medida de volume?", Arrays.asList("Metro", "Grama", "Litro", "Segundo"), "3", "Matemática")); // Resposta: Litro
        questoes.add(new Questao("Matemática 25: O que é um número composto?", Arrays.asList("Qualquer número par", "Divisível por 1 e por si mesmo", "Apenas números positivos", "Que tem mais de dois divisores"), "4", "Matemática")); // Resposta: Que tem mais de dois divisores
        questoes.add(new Questao("Matemática 26: Quanto é 1/3 + 1/6?", Arrays.asList("1/2", "2/9", "3/6", "4/3"), "1", "Matemática")); // Resposta: 1/2
        questoes.add(new Questao("Matemática 27: Qual o valor de 5 + 3 * 2?", Arrays.asList("16", "13", "11", "10"), "3", "Matemática")); // Resposta: 11
        questoes.add(new Questao("Matemática 28: Qual o número de faces de um cubo?", Arrays.asList("4", "6", "8", "12"), "2", "Matemática")); // Resposta: 6
        questoes.add(new Questao("Matemática 29: Qual é o algarismo das dezenas em 5.678?", Arrays.asList("5", "6", "7", "8"), "3", "Matemática")); // Resposta: 7
        questoes.add(new Questao("Matemática 30: O que é a mediana em estatística?", Arrays.asList("Valor que mais se repete", "Valor central de um conjunto ordenado", "Média aritmética", "Maior valor do conjunto"), "2", "Matemática")); // Resposta: Valor central de um conjunto ordenado
        
        
        // ==========================================================
        // Categoria: Português (30 questões)
        // ==========================================================
        questoes.add(new Questao("Português 1: Qual é o coletivo de cães?", Arrays.asList("Bando", "Matilha", "Rebanho", "Junta"), "2", "Português")); // Resposta: Matilha
        questoes.add(new Questao("Português 2: Em que tempo verbal está a frase: 'Eu comi o bolo'?", Arrays.asList("Presente", "Pretérito Perfeito", "Futuro", "Pretérito Imperfeito"), "2", "Português")); // Resposta: Pretérito Perfeito
        questoes.add(new Questao("Português 3: Qual a classe gramatical de 'rapidamente'?", Arrays.asList("Adjetivo", "Substantivo", "Advérbio", "Verbo"), "3", "Português")); // Resposta: Advérbio
        questoes.add(new Questao("Português 4: O plural de 'lápis' é:", Arrays.asList("Lápises", "O Lápis", "Os Lápis", "Lápis"), "3", "Português")); // Resposta: Os Lápis
        questoes.add(new Questao("Português 5: Qual palavra é acentuada pela regra dos paroxítonos?", Arrays.asList("Café", "Pássaro", "Coração", "Tênis"), "4", "Português")); // Resposta: Tênis
        questoes.add(new Questao("Português 6: O que é um artigo definido?", Arrays.asList("Um, Uma", "O, A", "Algum, Alguma", "Este, Esta"), "2", "Português")); // Resposta: O, A
        questoes.add(new Questao("Português 7: Qual palavra é sinônimo de 'alegre'?", Arrays.asList("Triste", "Contente", "Bravo", "Quieto"), "2", "Português")); // Resposta: Contente
        questoes.add(new Questao("Português 8: Qual figura de linguagem é: 'O silêncio gritava na sala'?", Arrays.asList("Metáfora", "Hipérbole", "Ironia", "Paradoxo"), "4", "Português")); // Resposta: Paradoxo
        questoes.add(new Questao("Português 9: Em que frase o 'porquê' deve ser usado separado e com acento?", Arrays.asList("Por que você não veio?", "Você não veio por quê?", "Ele não veio porque choveu.", "Gostaria de saber o porquê."), "2", "Português")); // Resposta: Você não veio por quê?
        questoes.add(new Questao("Português 10: Qual a ortografia correta?", Arrays.asList("Exceção", "Ecsceção", "Eçeção", "Esceção"), "1", "Português")); // Resposta: Exceção
        questoes.add(new Questao("Português 11: Qual é o diminutivo de 'casa'?", Arrays.asList("Casarão", "Casinha", "Casebre", "Casetinha"), "2", "Português")); // Resposta: Casinha
        questoes.add(new Questao("Português 12: Um substantivo que nomeia seres de forma geral é:", Arrays.asList("Próprio", "Comum", "Abstrato", "Concreto"), "2", "Português")); // Resposta: Comum
        questoes.add(new Questao("Português 13: Qual é o tipo de sujeito em: 'Choveu muito ontem'?", Arrays.asList("Simples", "Composto", "Oculto", "Oração sem sujeito"), "4", "Português")); // Resposta: Oração sem sujeito
        questoes.add(new Questao("Português 14: Qual é o antônimo de 'generoso'?", Arrays.asList("Bondoso", "Mesquinho", "Caridoso", "Amável"), "2", "Português")); // Resposta: Mesquinho
        questoes.add(new Questao("Português 15: O prefixo 'bi-' significa:", Arrays.asList("Três", "Quatro", "Dois", "Um"), "3", "Português")); // Resposta: Dois
        questoes.add(new Questao("Português 16: Qual a regra de acentuação para 'pássaro'?", Arrays.asList("Oxítona", "Paroxítona", "Proparoxítona", "Nenhuma"), "3", "Português")); // Resposta: Proparoxítona
        questoes.add(new Questao("Português 17: Qual é o pronome demonstrativo correto para 'aquele livro que está longe de mim e de você'?", Arrays.asList("Este", "Esse", "Aquele", "Isto"), "3", "Português")); // Resposta: Aquele
        questoes.add(new Questao("Português 18: Qual pontuação indica uma pausa breve?", Arrays.asList("Ponto final", "Vírgula", "Ponto de exclamação", "Dois pontos"), "2", "Português")); // Resposta: Vírgula
        questoes.add(new Questao("Português 19: Qual é o gerúndio do verbo 'comer'?", Arrays.asList("Comi", "Comeria", "Comendo", "Comido"), "3", "Português")); // Resposta: Comendo
        questoes.add(new Questao("Português 20: A palavra 'beleza' é um substantivo:", Arrays.asList("Concreto", "Abstrato", "Comum", "Próprio"), "2", "Português")); // Resposta: Abstrato
        questoes.add(new Questao("Português 21: Qual é o aumentativo de 'voz'?", Arrays.asList("Vozes", "Vozinha", "Vozarrão", "Vozona"), "3", "Português")); // Resposta: Vozarrão
        questoes.add(new Questao("Português 22: Qual palavra está corretamente separada em sílabas?", Arrays.asList("A-tle-ta", "At-le-ta", "A-tleta", "A-tl-e-ta"), "1", "Português")); // Resposta: A-tle-ta
        questoes.add(new Questao("Português 23: O que significa 'ratificar'?", Arrays.asList("Retificar (corrigir)", "Confirmar (validar)", "Assinar", "Anular"), "2", "Português")); // Resposta: Confirmar (validar)
        questoes.add(new Questao("Português 24: Qual palavra é proparoxítona?", Arrays.asList("Árvore", "Amigo", "Abacaxi", "Capacete"), "1", "Português")); // Resposta: Árvore
        questoes.add(new Questao("Português 25: O que é um ditongo?", Arrays.asList("Duas vogais na mesma sílaba", "Duas vogais em sílabas diferentes", "Duas consoantes juntas", "Um som de vogal e consoante"), "1", "Português")); // Resposta: Duas vogais na mesma sílaba
        questoes.add(new Questao("Português 26: Qual é a regência verbal correta?", Arrays.asList("Eu assisti o filme", "Eu assisti ao filme", "Eu assisti no filme", "Eu assisti para o filme"), "2", "Português")); // Resposta: Eu assisti ao filme
        questoes.add(new Questao("Português 27: Qual é o adjetivo pátrio de quem nasce no estado do Pará?", Arrays.asList("Parense", "Paranaense", "Paraense", "Paraibano"), "3", "Português")); // Resposta: Paraense
        questoes.add(new Questao("Português 28: Qual dos termos indica uma conjunção adversativa?", Arrays.asList("Portanto", "Pois", "Contudo", "Conforme"), "3", "Português")); // Resposta: Contudo
        questoes.add(new Questao("Português 29: O que é eufemismo?", Arrays.asList("Exagero de uma ideia", "Suavização de uma expressão desagradável", "Uso de uma parte pelo todo", "Repetição de uma ideia"), "2", "Português")); // Resposta: Suavização de uma expressão desagradável
        questoes.add(new Questao("Português 30: O que é um pronome pessoal oblíquo átono?", Arrays.asList("Eu, Tu, Ele", "Me, Te, Se", "Meu, Teu, Seu", "Este, Esse, Aquele"), "2", "Português")); // Resposta: Me, Te, Se
        
        
        // ==========================================================
        // Categoria: Cidadania (30 questões)
        // ==========================================================
        questoes.add(new Questao("Cidadania 1: Qual ODS trata da Educação de Qualidade?", Arrays.asList("ODS 1", "ODS 4", "ODS 10", "ODS 15"), "2", "Cidadania")); // Resposta: ODS 4
        questoes.add(new Questao("Cidadania 2: O que significa a sigla ODS?", Arrays.asList("Ordem de Desenvolvimento Sustentável", "Objetivos de Desenvolvimento Sustentável", "Organização de Direitos Sociais", "Operações de Defesa e Segurança"), "2", "Cidadania")); // Resposta: Objetivos de Desenvolvimento Sustentável
        questoes.add(new Questao("Cidadania 3: Qual é o principal objetivo da Lei Maria da Penha?", Arrays.asList("Proteger o idoso", "Combater a violência doméstica contra a mulher", "Garantir direitos trabalhistas", "Regulamentar o trânsito"), "2", "Cidadania")); // Resposta: Combater a violência doméstica contra a mulher
        questoes.add(new Questao("Cidadania 4: Qual órgão é responsável por administrar as eleições no Brasil?", Arrays.asList("STF", "Congresso Nacional", "TRE", "TSE"), "4", "Cidadania")); // Resposta: TSE (Tribunal Superior Eleitoral)
        questoes.add(new Questao("Cidadania 5: A Declaração Universal dos Direitos Humanos foi adotada em:", Arrays.asList("1945", "1948", "1964", "1988"), "2", "Cidadania")); // Resposta: 1948
        questoes.add(new Questao("Cidadania 6: O que é considerado o 'poder máximo' em uma democracia?", Arrays.asList("O Exército", "O Governo", "A Constituição", "O Povo"), "4", "Cidadania")); // Resposta: O Povo
        questoes.add(new Questao("Cidadania 7: Qual dos poderes tem a função de criar as leis?", Arrays.asList("Executivo", "Legislativo", "Judiciário", "Moderador"), "2", "Cidadania")); // Resposta: Legislativo
        questoes.add(new Questao("Cidadania 8: O que é o Estatuto da Criança e do Adolescente (ECA)?", Arrays.asList("Uma lei militar", "Um código de trânsito", "Uma lei que protege menores de 18 anos", "Uma norma educacional"), "3", "Cidadania")); // Resposta: Uma lei que protege menores de 18 anos
        questoes.add(new Questao("Cidadania 9: Qual é o dever básico de um eleitor brasileiro?", Arrays.asList("Votar em branco", "Justificar a ausência", "Comparecer à votação", "Não participar"), "3", "Cidadania")); // Resposta: Comparecer à votação
        questoes.add(new Questao("Cidadania 10: Qual ODS foca em 'Combate às Alterações Climáticas'?", Arrays.asList("ODS 7", "ODS 13", "ODS 14", "ODS 15"), "2", "Cidadania")); // Resposta: ODS 13
        questoes.add(new Questao("Cidadania 11: Qual é o documento mais importante de um município?", Arrays.asList("Lei Orgânica", "Constituição Federal", "Estatuto Municipal", "Código Civil"), "1", "Cidadania")); // Resposta: Lei Orgânica
        questoes.add(new Questao("Cidadania 12: Qual a idade mínima para se candidatar a Presidente no Brasil?", Arrays.asList("21 anos", "25 anos", "30 anos", "35 anos"), "4", "Cidadania")); // Resposta: 35 anos
        questoes.add(new Questao("Cidadania 13: O que é necessário para ser um 'cidadão' em sentido pleno?", Arrays.asList("Ter ensino superior", "Estar apto a votar e ser votado", "Ser maior de 18 anos", "Ter conta em banco"), "2", "Cidadania")); // Resposta: Estar apto a votar e ser votado
        questoes.add(new Questao("Cidadania 14: Qual dos direitos é fundamental na Constituição Federal?", Arrays.asList("Direito à Propriedade", "Direito à Herança", "Direito à Vida", "Direito à Liberdade de Comércio"), "3", "Cidadania")); // Resposta: Direito à Vida
        questoes.add(new Questao("Cidadania 15: O que é o voto direto?", Arrays.asList("Escolha feita por delegados", "Escolha feita pelo povo sem intermediários", "Voto secreto", "Voto por cédula de papel"), "2", "Cidadania")); // Resposta: Escolha feita pelo povo sem intermediários
        questoes.add(new Questao("Cidadania 16: Qual é a sigla da organização que mantém a paz mundial?", Arrays.asList("OEA", "OMS", "ONU", "OTAN"), "3", "Cidadania")); // Resposta: ONU
        questoes.add(new Questao("Cidadania 17: O que o 'Hino Nacional' representa?", Arrays.asList("A história política do país", "A cultura popular", "A identidade nacional e seus valores", "As Forças Armadas"), "3", "Cidadania")); // Resposta: A identidade nacional e seus valores
        questoes.add(new Questao("Cidadania 18: Qual ODS busca 'Assegurar a disponibilidade e gestão sustentável da água e saneamento para todos'?", Arrays.asList("ODS 6", "ODS 7", "ODS 9", "ODS 11"), "1", "Cidadania")); // Resposta: ODS 6
        questoes.add(new Questao("Cidadania 19: O que é a Constituição Federal?", Arrays.asList("Conjunto de leis municipais", "A lei máxima de um país", "O código civil", "Regulamento eleitoral"), "2", "Cidadania")); // Resposta: A lei máxima de um país
        questoes.add(new Questao("Cidadania 20: Quem é o chefe do Poder Executivo Federal no Brasil?", Arrays.asList("Presidente da Câmara", "Presidente da República", "Presidente do STF", "Senador"), "2", "Cidadania")); // Resposta: Presidente da República
        questoes.add(new Questao("Cidadania 21: O que é considerado um ato de vandalismo?", Arrays.asList("Manifestação pacífica", "Pintar um muro particular sem autorização", "Cantar em público", "Reciclar lixo"), "2", "Cidadania")); // Resposta: Pintar um muro particular sem autorização
        questoes.add(new Questao("Cidadania 22: Qual é o ODS que visa 'Acabar com a pobreza em todas as suas formas, em todos os lugares'?", Arrays.asList("ODS 1", "ODS 2", "ODS 3", "ODS 4"), "1", "Cidadania")); // Resposta: ODS 1
        questoes.add(new Questao("Cidadania 23: Qual dos direitos faz parte do Código de Defesa do Consumidor (CDC)?", Arrays.asList("Direito à saúde", "Direito à informação clara sobre o produto", "Direito à moradia", "Direito à educação"), "2", "Cidadania")); // Resposta: Direito à informação clara sobre o produto
        questoes.add(new Questao("Cidadania 24: O que é um plebiscito?", Arrays.asList("Votação após a lei ser criada", "Consulta prévia ao povo sobre uma lei", "Eleição para cargos públicos", "Voto de censura"), "2", "Cidadania")); // Resposta: Consulta prévia ao povo sobre uma lei
        questoes.add(new Questao("Cidadania 25: Qual a função do Poder Judiciário?", Arrays.asList("Elaborar leis", "Executar leis", "Fiscalizar o governo", "Julgar e aplicar as leis"), "4", "Cidadania")); // Resposta: Julgar e aplicar as leis
        questoes.add(new Questao("Cidadania 26: O que significa 'ética'?", Arrays.asList("Conjunto de leis escritas", "Disciplina que estuda a moral e o comportamento humano", "Regras de trânsito", "Normas de etiqueta"), "2", "Cidadania")); // Resposta: Disciplina que estuda a moral e o comportamento humano
        questoes.add(new Questao("Cidadania 27: Qual é o ODS que foca em 'Cidades e Comunidades Sustentáveis'?", Arrays.asList("ODS 9", "ODS 11", "ODS 12", "ODS 13"), "2", "Cidadania")); // Resposta: ODS 11
        questoes.add(new Questao("Cidadania 28: Qual é o significado da sigla SUS?", Arrays.asList("Serviço Único de Segurança", "Sistema de Urgência Social", "Sistema Único de Saúde", "Serviço Universal de Saúde"), "3", "Cidadania")); // Resposta: Sistema Único de Saúde
        questoes.add(new Questao("Cidadania 29: O que é um direito social básico?", Arrays.asList("Direito a ter dois carros", "Direito à moradia e alimentação", "Direito a viajar para o exterior", "Direito a ter ações em empresas"), "2", "Cidadania")); // Resposta: Direito à moradia e alimentação
        questoes.add(new Questao("Cidadania 30: Qual a capital federal do Brasil?", Arrays.asList("Rio de Janeiro", "São Paulo", "Brasília", "Salvador"), "3", "Cidadania")); // Resposta: Brasília

        return questoes;
    }
}
