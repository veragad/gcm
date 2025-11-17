package projetogcm;
import java.util.ArrayList;      
import java.util.Arrays;
import java.util.List;
 
public class GerenciadorDeQuestoes {
	public static List<Questao> carregarQuestoesDeArquivo(String nomeArquivo) {
        return criarDadosIniciais(); 
    }
    
    private static List<Questao> criarDadosIniciais() {
        List<Questao> questoes = new ArrayList<>();
        
        // ==========================================================
        // Categoria: Português (30 questões)
        // ==========================================================
        questoes.add(new Questao("Português 1: Qual é o coletivo de cães?", Arrays.asList("Bando", "Matilha", "Rebanho", "Junta"), "2", "Português")); // Resposta: Matilha
        questoes.add(new Questao("Português 2: Em que tempo verbal está a frase: 'Eu comi o bolo'?", Arrays.asList("Presente", "Pretérito Perfeito", "Futuro", "Pretérito Imperfeito"), "2", "Português")); // Resposta: Pretérito Perfeito
        questoes.add(new Questao("Português 3: Qual a classe gramatical de 'rapidamente'?", Arrays.asList("Adjetivo", "Substantivo", "Advérbio", "Verbo"), "3", "Português")); // Resposta: Advérbio
        questoes.add(new Questao("Português 4: O plural de 'lápis' é:", Arrays.asList("Lápises", "O Lápis", "Os Lápis", "Lápis"), "3", "Português")); // Resposta: Os Lápis
        questoes.add(new Questao("Português 5: Qual palavra é acentuada pela regra dos paroxítonos?", Arrays.asList("Café", "Pássaro", "Coração", "Tênis"), "4", "Português")); // Resposta: Tênis
        questoes.add(new Questao("Português 6: Escolha os artigos definidos?", Arrays.asList("Um, Uma", "O, A", "Algum, Alguma", "Este, Esta"), "2", "Português")); // Resposta: O, A
        questoes.add(new Questao("Português 7: Qual palavra é sinônimo de 'alegre'?", Arrays.asList("Triste", "Contente", "Bravo", "Quieto"), "2", "Português")); // Resposta: Contente
        questoes.add(new Questao("Português 8: Qual figura de linguagem é: 'O silêncio gritava na sala'?", Arrays.asList("Metáfora", "Hipérbole", "Ironia", "Paradoxo"), "4", "Português")); // Resposta: Paradoxo
        questoes.add(new Questao("Português 9: Em que frase o 'porquê' deve ser usado separado e com acento?", Arrays.asList("Por quê você não veio?", "Você não veio por quê?", "Ele não veio por quê choveu.", "Gostaria de saber o por quê."), "2", "Português")); // Resposta: Você não veio por quê?
        questoes.add(new Questao("Português 10: Qual a ortografia correta?", Arrays.asList("Exceção", "Ecsceção", "Eçeção", "Esceção"), "1", "Português")); // Resposta: Exceção
        questoes.add(new Questao("Português 11: Qual é o diminutivo de 'casa'?", Arrays.asList("Cazinha", "Casinha", "Casebre", "Casetinha"), "2", "Português")); // Resposta:  2 Casinha
        questoes.add(new Questao("Português 12: Um substantivo que nomeia seres de forma geral é:", Arrays.asList("Próprio", "Comum", "Abstrato", "Concreto"), "2", "Português")); // Resposta: Comum
        questoes.add(new Questao("Português 13: Qual é o tipo de sujeito em: 'Choveu muito ontem'?", Arrays.asList("Simples", "Composto", "Oculto", "Oração sem sujeito"), "4", "Português")); // Resposta: Oração sem sujeito
        questoes.add(new Questao("Português 14: Qual é o antônimo de 'generoso'?", Arrays.asList("Bondoso", "Mesquinho", "Caridoso", "Amável"), "2", "Português")); // Resposta: Mesquinho
        questoes.add(new Questao("Português 15: O prefixo 'bi-' significa:", Arrays.asList("Três", "Quatro", "Dois", "Um"), "3", "Português")); // Resposta: Dois
        questoes.add(new Questao("Português 16: Qual a regra de acentuação para 'pássaro'?", Arrays.asList("Oxítona", "Paroxítona", "Proparoxítona", "Nenhuma"), "3", "Português")); // Resposta: Proparoxítona
        questoes.add(new Questao("Português 17: Qual é o pronome demonstrativo correto para 'o livro que está longe de mim e de você'?", Arrays.asList("Este", "Esse", "Aquele", "Isto"), "3", "Português")); // Resposta: Aquele
        questoes.add(new Questao("Português 18: Qual pontuação indica uma pausa breve?", Arrays.asList("Ponto final", "Vírgula", "Ponto de exclamação", "Dois pontos"), "2", "Português")); // Resposta: Vírgula
        questoes.add(new Questao("Português 19: Qual é o gerúndio do verbo 'comer'?", Arrays.asList("Comi", "Comeria", "Comendo", "Comido"), "3", "Português")); // Resposta: Comendo
        questoes.add(new Questao("Português 20: A palavra 'beleza' é um substantivo:", Arrays.asList("Concreto", "Abstrato", "Comum", "Próprio"), "2", "Português")); // Resposta: Abstrato
        questoes.add(new Questao("Português 21: Qual é o aumentativo de 'voz'?", Arrays.asList("Vozes", "Vozinha", "Vozarrão", "Vozona"), "3", "Português")); // Resposta: Vozarrão
        questoes.add(new Questao("Português 22: Qual palavra está corretamente separada em sílabas?", Arrays.asList("A-tle-ta", "At-le-ta", "A-tleta", "A-tl-e-ta"), "1", "Português")); // Resposta: A-tle-ta
        questoes.add(new Questao("Português 23: O que significa 'ratificar'?", Arrays.asList("Retificar (corrigir)", "Confirmar (validar)", "Assinar", "Anular"), "2", "Português")); // Resposta: Confirmar (validar)
        questoes.add(new Questao("Português 24: Qual palavra é proparoxítona?", Arrays.asList("Árvore", "Amigo", "Abacaxi", "Capacete"), "1", "Português")); // Resposta: Árvore
        questoes.add(new Questao("Português 25: O que é um ditongo?", Arrays.asList("Duas vogais na mesma sílaba", "Duas vogais em sílabas diferentes", "Duas consoantes juntas", "Um som de vogal e consoante"), "1", "Português")); // Resposta 1: Duas vogais na mesma sílaba
        questoes.add(new Questao("Português 26: Qual é a regência verbal correta?", Arrays.asList("Eu assisti o filme", "Eu assisti no filme", "Eu assisti ao filme", "Eu assisti para o filme"), "3", "Português")); // Resposta 3: Eu assisti ao filme
        questoes.add(new Questao("Português 27: Qual é o adjetivo pátrio de quem nasce no estado da Paraíba?", Arrays.asList("Paraibense", "Paraibaense", "Paraibandense", "Paraibano"), "4", "Português")); // Resposta: Paraibano
        questoes.add(new Questao("Português 28: Qual dos termos indica uma conjunção adversativa?", Arrays.asList("Portanto", "Pois", "Contudo", "Conforme"), "3", "Português")); // Resposta 3: Contudo
        questoes.add(new Questao("Português 29: O que é eufemismo?", Arrays.asList("Exagero de uma ideia", "Suavização de uma expressão desagradável", "Uso de uma parte pelo todo", "Repetição de uma ideia"), "2", "Português")); // Resposta 2: Suavização de uma expressão desagradável
        questoes.add(new Questao("Português 30: Quais destes são pronomes pessoais oblíquos átonos?", Arrays.asList("Eu, Tu, Ele", "Me, Te, Se", "Meu, Teu, Seu", "Este, Esse, Aquele"), "2", "Português")); // Resposta: Me, Te, Se
        
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
     // Categoria: Cidadania (30 questões - NOVA SÉRIE)
     // ==========================================================
     questoes.add(new Questao("Cidadania 1: Qual o termo para o direito de peticionar e manifestar-se contra o Estado?", Arrays.asList("Habeas Corpus", "Mandado de Injunção", "Direito de Reunião", "Direito de Petição"), "4", "Cidadania")); // Resposta: Direito de Petição
     questoes.add(new Questao("Cidadania 2: A Constituição Federal de 1988 é apelidada de:", Arrays.asList("Constituição Cidadã", "Constituição da Redemocratização", "Constituição da Ordem", "Constituição do Povo"), "1", "Cidadania")); // Resposta: Constituição Cidadã
     questoes.add(new Questao("Cidadania 3: Qual a função principal do Poder Executivo em nível federal?", Arrays.asList("Criar leis", "Fiscalizar o Judiciário", "Administrar o governo e executar as leis", "Julgar inconstitucionalidades"), "3", "Cidadania")); // Resposta: Administrar o governo e executar as leis
     questoes.add(new Questao("Cidadania 4: O voto é facultativo para qual faixa etária no Brasil?", Arrays.asList("Entre 16 e 18 anos e acima de 70 anos", "Somente acima de 70 anos", "Somente para analfabetos", "Entre 18 e 70 anos"), "1", "Cidadania")); // Resposta: Entre 16 e 18 anos e acima de 70 anos
     questoes.add(new Questao("Cidadania 5: Qual ODS trata do empoderamento feminino?", Arrays.asList("ODS 3 - Saúde e Bem-Estar", "ODS 5 - Igualdade de Gênero", "ODS 8 - Trabalho Decente", "ODS 10 - Redução das Desigualdades"), "2", "Cidadania")); // Resposta: ODS 5 - Igualdade de Gênero
     questoes.add(new Questao("Cidadania 6: O que significa ter um direito Inalienável?", Arrays.asList("Pode ser vendido", "Não pode ser transferido ou retirado", "Depende de autorização do governo", "Só vale para quem é alfabetizado"), "2", "Cidadania")); // Resposta: Não pode ser transferido ou retirado
     questoes.add(new Questao("Cidadania 7: O que é o princípio da Separação dos Poderes?", Arrays.asList("Divisão do país em estados", "Autonomia das Forças Armadas", "Divisão de funções entre Executivo, Legislativo e Judiciário", "Divisão do território em municípios"), "3", "Cidadania")); // Resposta: Divisão de funções entre Executivo, Legislativo e Judiciário
     questoes.add(new Questao("Cidadania 8: Qual é a função de um vereador no Brasil?", Arrays.asList("Executar obras públicas estaduais", "Julgar o Prefeito", "Legislar e fiscalizar o Executivo municipal", "Representar o município no Congresso"), "3", "Cidadania")); // Resposta: Legislar e fiscalizar o Executivo municipal
     questoes.add(new Questao("Cidadania 9: O que é um referendo?", Arrays.asList("Consulta ao povo antes de uma lei ser criada", "Consulta ao povo para ratificar uma lei já aprovada pelo Congresso", "Ato de anular uma eleição", "Processo de impeachment"), "2", "Cidadania")); // Resposta: Consulta ao povo para ratificar uma lei já aprovada pelo Congresso
     questoes.add(new Questao("Cidadania 10: Qual dos Objetivos de Desenvolvimento Sustentável (ODS) foca primariamente na inclusão social, econômica e política de todos, independentemente de idade, sexo, deficiência, raça, etnia ou religião?", Arrays.asList("ODS 1 - Erradicação da Pobreza", "ODS 5 - Igualdade de Gênero", "ODS 10 - Redução das Desigualdades", "ODS 16 - Paz, Justiça e Instituições Eficazes"), "3", "Cidadania")); // Resposta: ODS 10 - Redução das Desigualdades
     questoes.add(new Questao("Cidadania 11: Qual lei brasileira estabelece os direitos dos idosos?", Arrays.asList("Código Civil", "Estatuto do Idoso", "Lei do Amparo Social", "Código de Defesa do Consumidor"), "2", "Cidadania")); // Resposta: Estatuto do Idoso
     questoes.add(new Questao("Cidadania 12: Qual o nome do processo que retira um mandato eletivo de um político?", Arrays.asList("Ação Popular", "Voto de Confiança", "Impeachment", "Consulta Popular"), "3", "Cidadania")); // Resposta: Impeachment
     questoes.add(new Questao("Cidadania 13: O que significa dizer que o voto é secreto?", Arrays.asList("O eleitor não pode falar em quem votou", "A contagem dos votos é feita em sigilo", "Ninguém pode saber o voto do eleitor", "Somente o TSE tem acesso ao voto"), "3", "Cidadania")); // Resposta: Ninguém pode saber o voto do eleitor
     questoes.add(new Questao("Cidadania 14: Qual é o direito mais importante, do qual todos os outros dependem?", Arrays.asList("Direito à Propriedade", "Direito à Liberdade de Expressão", "Direito à Vida", "Direito à Educação"), "3", "Cidadania")); // Resposta: Direito à Vida
     questoes.add(new Questao("Cidadania 15: O que é um país laico?", Arrays.asList("Que não tem leis escritas", "Que segue uma religião oficial", "Que separa o Estado das religiões", "Que proíbe todas as religiões"), "3", "Cidadania")); // Resposta: Que separa o Estado das religiões
     questoes.add(new Questao("Cidadania 16: Qual dos instrumentos a seguir garante o acesso a informações públicas no Brasil?", Arrays.asList("Habeas Data", "Lei de Acesso à Informação (LAI)", "Mandado de Segurança", "Ação Civil Pública"), "2", "Cidadania")); // Resposta: Lei de Acesso à Informação (LAI)
     questoes.add(new Questao("Cidadania 17: O que significa solidariedade como princípio de cidadania?", Arrays.asList("Acúmulo de riqueza", "Comportamento de rivalidade", "Apoio mútuo e cooperação entre indivíduos", "Apenas doação de dinheiro"), "3", "Cidadania")); // Resposta: Apoio mútuo e cooperação entre indivíduos
     questoes.add(new Questao("Cidadania 18: Qual dos Objetivos de Desenvolvimento Sustentável (ODS) foca em promover o Estado de Direito e garantir o acesso à justiça para todos?", Arrays.asList("ODS 14 - Vida Debaixo D'água", "ODS 15 - Vida Terrestre", "ODS 16 - Paz, Justiça e Instituições Eficazes", "ODS 17 - Parcerias e Meios de Implementação"), "3", "Cidadania")); // Resposta: ODS 16 - Paz, Justiça e Instituições Eficazes
     questoes.add(new Questao("Cidadania 19: Quem exerce a função de chefe do Poder Executivo em um município?", Arrays.asList("Governador", "Vereador", "Deputado Estadual", "Prefeito"), "4", "Cidadania")); // Resposta: Prefeito
     questoes.add(new Questao("Cidadania 20: O que é corrupção em termos cívicos?", Arrays.asList("Gasto excessivo em obras", "Uso indevido do poder para ganho privado", "Atraso na entrega de projetos", "Mudança de partido político"), "2", "Cidadania")); // Resposta: Uso indevido do poder para ganho privado
     questoes.add(new Questao("Cidadania 21: O que é o direito à Liberdade de Expressão?", Arrays.asList("Direito de falar qualquer coisa sem consequências", "Direito de manifestar ideias e opiniões, respeitando a lei e os direitos alheios", "Direito de difamar autoridades", "Direito de exigir silêncio"), "2", "Cidadania")); // Resposta: Direito de manifestar ideias e opiniões, respeitando a lei e os direitos alheios
     questoes.add(new Questao("Cidadania 22: Qual ODS visa Garantir padrões de consumo e produção sustentáveis?", Arrays.asList("ODS 7 - Energia Limpa", "ODS 9 - Indústria, Inovação e Infraestrutura", "ODS 12 - Consumo e Produção Responsáveis", "ODS 13 - Ação Contra a Mudança Global do Clima"), "3", "Cidadania")); // Resposta: ODS 12 - Consumo e Produção Responsáveis
     questoes.add(new Questao("Cidadania 23: Qual documento é o ponto de partida para os direitos humanos no mundo?", Arrays.asList("Carta Magna", "Declaração Universal dos Direitos Humanos", "Constituição Americana", "Tratado de Versalhes"), "2", "Cidadania")); // Resposta: Declaração Universal dos Direitos Humanos
     questoes.add(new Questao("Cidadania 24: O que é Direito ao Contraditório e Ampla Defesa?", Arrays.asList("Direito de mentir no tribunal", "Direito de ser julgado apenas uma vez", "Garantia de defesa técnica e de refutar acusações", "Obrigação de se defender sozinho"), "3", "Cidadania")); // Resposta: Garantia de defesa técnica e de refutar acusações
     questoes.add(new Questao("Cidadania 25: O que significa democracia direta?", Arrays.asList("O povo elege representantes, mas não participa das decisões", "O povo toma as decisões diretamente, sem representantes", "O governo decide e o povo apenas aprova", "O judiciário tem mais poder que o executivo"), "2", "Cidadania")); // Resposta: O povo toma as decisões diretamente, sem representantes
     questoes.add(new Questao("Cidadania 26: Qual é a idade mínima para se candidatar a Deputado Federal no Brasil?", Arrays.asList("18 anos", "21 anos", "30 anos", "35 anos"), "2", "Cidadania")); // Resposta: 21 anos
     questoes.add(new Questao("Cidadania 27: Qual Objetivo de Desenvolvimento Sustentável (ODS) da ONU busca garantir o acesso universal a serviços de energia modernos, confiáveis e sustentáveis?", Arrays.asList("ODS 4 - Educação de Qualidade", "ODS 6 - Água Potável e Saneamento", "ODS 7 Energia Limpa e Acessível", "ODS 11 - Cidades e Comunidades Sustentáveis"), "3", "Cidadania")); // Resposta: ODS 7 - Energia Limpa e Acessível
     questoes.add(new Questao("Cidadania 28: O que é o Princípio da Isonomia (ou Igualdade perante a lei)?", Arrays.asList("Todos têm os mesmos bens materiais", "Todos devem obedecer às mesmas leis", "Tratamento igual para todos, mas desigual na medida de suas desigualdades", "O governo tem mais direitos que os cidadãos"), "3", "Cidadania")); // Resposta: Tratamento igual para todos, mas desigual na medida de suas desigualdades
     questoes.add(new Questao("Cidadania 29: Qual é o documento mais importante de um estado (como São Paulo ou Bahia)?", Arrays.asList("Estatuto Estadual", "Lei Orgânica Estadual", "Constituição Federal", "Constituição Estadual"), "4", "Cidadania")); // Resposta: Constituição Estadual
     questoes.add(new Questao("Cidadania 30: Qual a principal característica que define a Cidadania Plena?", Arrays.asList("Ter um emprego formal", "Ter mais de 18 anos", "Ter todos os direitos civis, políticos e sociais garantidos e exercidos", "Morar na capital"), "3", "Cidadania")); // Resposta: Ter todos os direitos civis, políticos e sociais garantidos e exercidos
     return questoes;
    }
    
}
