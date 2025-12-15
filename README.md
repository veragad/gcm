# gcm
Disciplina De Gerenciamento de Configuração e Mudanças
# Desafio do Saber – Quiz Interativo em Java (GCM)

## Apresentação

O **Desafio do Saber** é um sistema de **quiz interativo** desenvolvido em **Java**, com foco na aplicação de conceitos de lógica de programação, interface gráfica e testes automatizados. O projeto utiliza a biblioteca **Java Swing** para construção da interface gráfica e **JUnit 5** para a realização de testes unitários, assegurando a confiabilidade da lógica do jogo.

Além disso, o projeto conta com **Integração Contínua (CI)** configurada por meio do **GitHub Actions**, permitindo a execução automática de testes a cada atualização do código.

---

## Tecnologias Utilizadas

* Linguagem de programação: Java 8 (JRE 1.8)
* Interface gráfica: Java Swing
* Gerenciador de build: Gradle
* Testes unitários: JUnit 5 (JUnit Jupiter)
* Integração contínua (CI): GitHub Actions
* Dependências adicionais:

  * Google Gson (utilizada para possível leitura de arquivos JSON contendo questões do quiz)

---

## Execução do Projeto

### Pré-requisitos

Para executar o projeto, é necessário possuir:

* Java Development Kit (JDK) 8 ou superior
* Gradle instalado no sistema

---

### Clonagem do Repositório

```bash
git clone https://github.com/veragad/gcm.git
cd gcm
```

---

### Compilação e Execução

O projeto está configurado com o Gradle e possui o método `main` implementado na classe **Demo.java**.

```bash
gradle run
```

---

## Testes Unitários

O sistema inclui testes unitários responsáveis por validar os principais aspectos da lógica do jogo, tais como:

* Cálculo da pontuação do jogador
* Verificação das respostas
* Fluxo de execução do quiz

Os testes estão implementados na classe **QuizTeste.java** e são executados automaticamente pelo processo de Integração Contínua.

Para executar os testes localmente:

```bash
gradle test
```

---

## Estrutura do Projeto

O projeto segue a estrutura padrão recomendada pelo Gradle para aplicações Java, separando o código-fonte principal do código de testes.

```
.
├── .github/
│   └── workflows/
│       └── java_ci.yml
├── src/
│   ├── main/java/projetogcm/
│   │   ├── Jogador.java
│   │   ├── Quiz.java
│   │   └── Demo.java
│   └── test/java/projetogcm/
│       └── QuizTeste.java
├── build.gradle
└── README.md
```

---

## Funcionalidades

* Sistema de quiz interativo com interface gráfica em Java Swing
* Mecanismo de perguntas e respostas
* Controle de pontuação do jogador
* Testes unitários com JUnit 5
* Integração contínua com GitHub Actions

---

## Contribuições

Contribuições podem ser realizadas por meio de *fork* do repositório, criação de uma nova *branch*, implementação das melhorias desejadas e envio de um *pull request*.

---

## Contato

Para dúvidas, sugestões ou contribuições, entre em contato:

Vera Gadelha
E-mail: [vera.gadelha@alunos.ufersa.edu.br](mailto:vera.gadelha@alunos.ufersa.edu.br)

---

Este projeto possui caráter educacional e tem como objetivo demonstrar a aplicação prática de Java, interface gráfica, testes unitários e Integração Contínua no desenvolvimento de software.

