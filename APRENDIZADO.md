# Aprendizado - Java com Alura

Curso: **Java: criando a sua primeira aplicação**
Projeto: ByteBank

---

## Aula 01 - Fundamentos de Java

### Conceitos aprendidos

#### 1. Primeira classe e método `main`
O ponto de entrada de qualquer aplicação Java é o método `main`:

```java
public class PrimeiraClasse {
    public static void main(String[] args) {
        System.out.println("Concluí a aula 01 e agora estou mergulhando em Java!");
    }
}
```

- `public class` — declaração de uma classe pública
- `main` — método executado ao iniciar o programa
- `System.out.println` — imprime uma mensagem no console

---

#### 2. Variáveis e tipos de dados

```java
var saldo = leitura.nextDouble();   // inferência de tipo com var
double percentual = saldo * (10.0 / 100);
```

- `double` — tipo numérico com casas decimais
- `var` — palavra-chave que permite inferência de tipo (Java 10+)

---

#### 3. Entrada de dados com `Scanner`

```java
Scanner leitura = new Scanner(System.in);
System.out.println("Digite um saldo: ");
var saldo = leitura.nextDouble();
```

- `Scanner` é uma classe do pacote `java.util` usada para ler entradas do usuário
- `nextDouble()` lê um número decimal digitado

**Exemplo prático — cálculo de reajuste de 10%:**

```java
double percentual = saldo * (10.0 / 100);
var valorFinal = saldo + percentual;
System.out.println("O saldo com reajuste de 10% é: " + valorFinal);
```

---

#### 4. Classes e Objetos (Orientação a Objetos)

Uma **classe** é um molde para criar objetos. Um **objeto** é uma instância dessa classe.

```java
Funcionario caique = new Funcionario("Caique", 01, LocalDate.of(1995, 07, 28));
System.out.println(caique);
```

---

#### 5. Atributos e Encapsulamento

A classe `Funcionario` possui atributos privados, acessados via **getters** e **setters**:

```java
public class Funcionario {
    private String nome;
    private int matricula;
    private LocalDate dataNascimento;
}
```

- `private` — o atributo só pode ser acessado dentro da própria classe (encapsulamento)
- **Getter** — método para ler o valor do atributo (`getNome()`)
- **Setter** — método para alterar o valor do atributo (`setNome(String nome)`)

---

#### 6. Construtores

O construtor inicializa o objeto com valores no momento da criação:

```java
public Funcionario(String nome, int matricula, LocalDate dataNascimento) {
    this.nome = nome;
    this.matricula = matricula;
    this.dataNascimento = dataNascimento;
}
```

- `this` — referencia o próprio objeto, diferenciando o atributo do parâmetro

---

#### 7. Método `toString`

Sobrescreve a forma como o objeto é exibido ao ser impresso:

```java
@Override
public String toString() {
    return "Funcionario{" +
            "nome='" + getNome() + '\'' +
            ", matricula=" + getMatricula() +
            ", dataNascimento=" + getDataNascimento() +
            '}';
}
```

- `@Override` — indica que o método está sobrescrevendo um método da classe pai (`Object`)

---

#### 8. Data com `LocalDate`

```java
import java.time.LocalDate;

LocalDate dataNascimento = LocalDate.of(1995, 07, 28);
```

- `LocalDate` — classe da API `java.time` para representar datas sem horário

---

---

#### 9. Como Java funciona — Bytecode e JVM

```java
System.out.println("WORA (Write Once, Run Anywhere)");
System.out.println("Bytecode é interpretado pela JVM");
```

- **Código-fonte** (`.java`) — linguagem de alto nível, legível para humanos
- **Compilação** — o compilador Java transforma o `.java` em **Bytecode** (`.class`)
- **Bytecode** — linguagem intermediária em hexadecimal, não legível para humanos nem para o SO
- **JVM (Java Virtual Machine)** — máquina virtual que lê e executa o Bytecode em qualquer sistema operacional
- **WORA** — *Write Once, Run Anywhere*: escreva o código uma vez e execute em qualquer lugar que tenha JVM

```
Código-fonte (.java) → Compilador → Bytecode (.class) → JVM → Execução
```

---

## O que aprendi nessa aula

- Configurar o ambiente de desenvolvimento, instalando a **JDK 17** e a IDE **IntelliJ**
- As diferenças entre JVM, JRE e JDK:
  - **JVM (Java Virtual Machine)** — Máquina Virtual do Java responsável por executar o bytecode
  - **JRE (Java Runtime Environment)** — Ambiente de Execução do Java que fornece as bibliotecas padrões para o JDK compilar o código e para a JVM executar o programa
  - **JDK (Java Development Kit)** — Kit de Desenvolvimento Java responsável por compilar código-fonte em bytecode
- Fazer o "Alô Mundo!" no Java e executar o primeiro programa pelo IntelliJ

---

## Resumo dos Conceitos

| Conceito | O que é |
| --- | --- |
| `class` | Molde para criar objetos |
| `main` | Ponto de entrada do programa |
| `var` | Inferência de tipo automática |
| `private` | Encapsulamento de atributos |
| Getter/Setter | Métodos de acesso aos atributos |
| Construtor | Inicializa o objeto |
| `toString` | Representa o objeto como texto |
| `Scanner` | Lê entradas do usuário |
| `LocalDate` | Representa datas |

---

## Aula 02 - Variáveis, Tipos Primitivos e Operadores Aritméticos

### Conceitos aprendidos

#### 1. Tipos primitivos em Java

Java possui tipos primitivos para armazenar diferentes categorias de dados:

```java
int anoDeLancamento = 2022;       // número inteiro
boolean incluindoNoAno = true;    // verdadeiro ou falso
double notaDoFilme = 9.1;         // número com casas decimais
```

| Tipo | O que armazena | Exemplo |
| --- | --- | --- |
| `int` | Números inteiros | `2022`, `-5`, `0` |
| `double` | Números decimais | `9.1`, `3.14` |
| `boolean` | Verdadeiro ou falso | `true`, `false` |
| `String` | Texto | `"Top Gun"` |

---

#### 1.1 Os oito tipos primitivos de Java

Java possui exatamente oito tipos primitivos, que são os tipos de dados mais básicos e fundamentais da linguagem, utilizados para representar valores simples e definidos pela própria linguagem.

##### `boolean`
Representa valores lógicos, podendo assumir apenas dois valores: `true` ou `false`. Utilizado em expressões condicionais, loops e outros casos onde se deseja avaliar se uma condição é verdadeira ou falsa.

```java
boolean ativo = true;
boolean expirado = false;
```

##### `byte`
Representa valores numéricos inteiros de **8 bits**. Faixa de valores: **-128 a 127**.

```java
byte idade = 25;
```

##### `char`
Representa caracteres individuais. Pode armazenar qualquer caractere Unicode e é delimitado por aspas simples (`''`).

```java
char letra = 'A';
char simbolo = '@';
```

##### `short`
Representa valores numéricos inteiros de **16 bits**. Faixa de valores: **-32.768 a 32.767**.

```java
short ano = 2026;
```

##### `int`
Representa valores numéricos inteiros de **32 bits**. É o tipo mais utilizado para números inteiros em Java. Faixa de valores: **-2.147.483.648 a 2.147.483.647**.

```java
int populacao = 215000000;
```

##### `long`
Representa valores numéricos inteiros de **64 bits**, utilizado para valores inteiros muito grandes. Faixa de valores: **-9.223.372.036.854.775.808 a 9.223.372.036.854.775.807**. O sufixo `L` é obrigatório.

```java
long distanciaEstrelas = 9_460_730_472_580_800L;
```

##### `float`
Representa valores numéricos de ponto flutuante (com casas decimais) em **32 bits**. Pode representar números decimais com até **7 dígitos** de precisão. O sufixo `f` é obrigatório.

```java
float preco = 19.99f;
```

##### `double`
Similar ao `float`, mas ocupa **64 bits** de memória e pode representar números decimais com até **15 dígitos** de precisão. É o tipo padrão para números decimais em Java.

```java
double pi = 3.141592653589793;
```

---

##### Tabela comparativa dos tipos primitivos

| Tipo | Bits | Faixa / Descrição |
| --- | --- | --- |
| `boolean` | — | `true` ou `false` |
| `byte` | 8 | -128 a 127 |
| `char` | 16 | Qualquer caractere Unicode |
| `short` | 16 | -32.768 a 32.767 |
| `int` | 32 | -2.147.483.648 a 2.147.483.647 |
| `long` | 64 | -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807 |
| `float` | 32 | Até 7 dígitos decimais |
| `double` | 64 | Até 15 dígitos decimais |

---

#### 2. Operadores Aritméticos

Os operadores aritméticos realizam cálculos matemáticos entre valores numéricos:

| Operador | Operação | Exemplo | Resultado |
| --- | --- | --- | --- |
| `+` | Adição | `5 + 3` | `8` |
| `-` | Subtração | `10 - 4` | `6` |
| `*` | Multiplicação | `2 * 6` | `12` |
| `/` | Divisão | `10 / 2` | `5` |
| `%` | Resto da divisão | `10 % 3` | `1` |

```java
int soma        = 5 + 3;   // 8
int subtracao   = 10 - 4;  // 6
int produto     = 2 * 6;   // 12
int divisao     = 10 / 2;  // 5
int resto       = 10 % 3;  // 1
```

> O operador `%` (módulo) retorna o **resto** da divisão inteira. Útil para verificar se um número é par (`n % 2 == 0`) ou para limitar valores dentro de um intervalo.

---

#### 3. Operadores de Atribuição Composta

Combinam uma operação aritmética com a atribuição, simplificando o código:

```java
int valor1 = 10;
valor1 += 15;  // equivalente a: valor1 = valor1 + 15  →  25
```

| Operador | Equivalente a |
| --- | --- |
| `+=` | `x = x + n` |
| `-=` | `x = x - n` |
| `*=` | `x = x * n` |
| `/=` | `x = x / n` |
| `%=` | `x = x % n` |

---

#### 4. Concatenação de String com variáveis

O operador `+` também serve para unir texto com valores de variáveis:

```java
int anoDeLancamento = 2022;
System.out.println("Ano de lançamento: " + anoDeLancamento);
// Saída: Ano de lançamento: 2022
```

---

#### 5. Formatação de Strings com `String.format`

O método `String.format` permite construir Strings formatadas usando **placeholders** (marcadores de posição):

```java
String nome = "Maria";
int idade = 30;
double preco = 55.99;

String mensagem = String.format("Nome: %s, Idade: %d, Preço: %.2f", nome, idade, preco);
System.out.println(mensagem);
// Saída: Nome: Maria, Idade: 30, Preço: 55,99
```

💡 Tipos mais usados

| Placeholder | Tipo de dado | Exemplo |
| --- | --- | --- |
| `%s` | String | `nome` |
| `%d` | inteiro | `idade`, `quantidade` |
| `%.2f` | decimal | `55.99` |

---

#### 6. Casting

Casting é a conversão de um tipo de dado em outro. Em Java, existem dois tipos:

##### Casting implícito

Realizado **automaticamente pelo compilador** quando o tipo de destino é maior e comporta todos os valores do tipo de origem:

```java
int x = 10;
double y = x; // casting implícito
```

##### Casting explícito

Necessário quando o tipo de destino é **menor ou incompatível** com o tipo de origem. Usa o operador de casting `(tipo)`:

```java
double x = 10.5;
int y = (int) x; // casting explícito
```

> A parte decimal é **descartada** na conversão — no exemplo acima, `y` recebe o valor `10`.

##### Tabela de conversões

| De → Para | `byte` | `short` | `int` | `long` | `float` | `double` |
| --- | --- | --- | --- | --- | --- | --- |
| `byte` | — | implícito | implícito | implícito | implícito | implícito |
| `short` | explícito | — | implícito | implícito | implícito | implícito |
| `int` | explícito | explícito | — | implícito | implícito | implícito |
| `long` | explícito | explícito | explícito | — | implícito | implícito |
| `float` | explícito | explícito | explícito | explícito | — | implícito |
| `double` | explícito | explícito | explícito | explícito | explícito | — |

---

### O que aprendi nessa aula

- A trabalhar com **variáveis**: recurso utilizado para armazenar valores em memória
- Sobre **tipos primitivos**:
  - Inteiros: `byte`, `short`, `int`, `long`
  - Ponto flutuante: `double` e `float`
  - `char`: contém um único caractere
  - `boolean`: recebe 2 valores, `true` ou `false`
- Como representar textos em Java, utilizando a classe `String`
- A realizar **casting** de valores, para resolver situações de tipos incompatíveis no momento de realizar um cálculo ou atribuição de uma variável
- Declarar variáveis com os tipos primitivos `int`, `double` e `boolean`
- Usar os cinco operadores aritméticos: `+`, `-`, `*`, `/` e `%`
- Diferenciar divisão inteira de divisão com ponto flutuante
- Usar operadores de atribuição composta (`+=`, `-=`, etc.) para simplificar operações
- Concatenar texto com variáveis usando o operador `+`

---

### Resumo dos Conceitos — Aula 02

| Conceito | O que é |
| --- | --- |
| `int` | Tipo para números inteiros |
| `double` | Tipo para números decimais |
| `boolean` | Tipo para verdadeiro/falso |
| `+` | Adição (ou concatenação de texto) |
| `-` | Subtração |
| `*` | Multiplicação |
| `/` | Divisão |
| `%` | Resto da divisão |
| `+=` | Atribuição com adição |

---

## Aula 03 - Controle de Fluxo: Condicionais e Laços de Repetição

### Conceitos aprendidos

#### 1. Leitura de dados com `Scanner`

A classe `Scanner` permite capturar diferentes tipos de entrada do usuário:

```java
Scanner scanner = new Scanner(System.in);

String anime = scanner.nextLine();   // lê uma String (linha completa)
int ano      = scanner.nextInt();    // lê um número inteiro
double nota  = scanner.nextDouble(); // lê um número decimal

scanner.close(); // boa prática: fechar o Scanner ao final
```

| Método | Tipo lido |
| --- | --- |
| `nextLine()` | `String` (linha completa) |
| `nextInt()` | `int` |
| `nextDouble()` | `double` |

---

#### 2. Estruturas condicionais — `if / else if / else`

Permitem executar blocos de código conforme uma condição:

```java
int anoDeLancamento = 2022;
boolean incluidoNoPlano = true;
String plano = "Plus";
double notaDoFilme = 8.1;

if (anoDeLancamento >= 2022) {
    System.out.println("Lançamento mais vistos!");
} else {
    System.out.println("Filme que vale a pena assistir!");
}

if (incluidoNoPlano == true && plano.equals("Plus")) {
    System.out.println("acesso liberado");
} else {
    System.out.println("deve pagar a entrada");
}
```

- `&&` — operador lógico **E**: ambas as condições precisam ser verdadeiras
- `||` — operador lógico **OU**: basta uma condição ser verdadeira
- `.equals()` — método para comparar o conteúdo de Strings (não use `==` para Strings)

---

#### 3. Estrutura condicional alternativa — `switch`

Ideal quando há várias opções para um mesmo valor:

```java
int dia = scanner.nextInt();
String nomeDia = "";

switch (dia) {
    case 1:
        nomeDia = "Domingo";
        break;
    case 2:
        nomeDia = "Segunda-feira";
        break;
    // ...
    default:
        System.out.println("Valor inválido");
        break;
}
```

- Cada `case` representa um valor possível
- `break` encerra o bloco para evitar que os casos seguintes sejam executados
- `default` é executado quando nenhum `case` corresponde ao valor

---

#### 4. Laço de repetição — `for`

Usado quando o número de repetições é conhecido:

```java
double mediaAvaliacao = 0;

for (int i = 0; i < 3; i++) {
    System.out.println("Digite uma nota para o anime");
    double nota = scanner.nextDouble();
    mediaAvaliacao += nota;
}

System.out.println("Media de avaliacao: " + mediaAvaliacao / 3);
```

Estrutura: `for (inicialização; condição; incremento)`

- **inicialização** — `int i = 0`: define o contador inicial
- **condição** — `i < 3`: enquanto verdadeira, o laço continua
- **incremento** — `i++`: atualiza o contador a cada iteração

---

#### 5. Laço de repetição — `while`

Usado quando o número de repetições não é conhecido previamente:

```java
double mediaAvaliacao = 0;
double nota = 0;
int total = 0;

while (nota != -1) {
    System.out.println("Digite uma nota ou -1 para encerrar");
    nota = scanner.nextDouble();

    if (nota != -1) {
        mediaAvaliacao += nota;
        total++;
    }
}

System.out.println("Media de avaliacao: " + mediaAvaliacao / total);
```

- O laço continua enquanto a condição for verdadeira
- Útil para menus e entradas com quantidade indefinida

---

#### 6. Combinando condicionais e laços — Jogo de Adivinhação

Exemplo prático que une `while`, `if/else if` e `Random`:

```java
int numeroGerado = new Random().nextInt(100);
int tentativas = 0;
int numeroDigitado = 0;

while (tentativas < 5) {
    System.out.println("Digite um número de 1 a 100");
    numeroDigitado = scanner.nextInt();
    tentativas++;
}

if (numeroDigitado < numeroGerado) {
    System.out.println("O número digitado é menor que o gerado");
} else if (numeroDigitado > numeroGerado) {
    System.out.println("O número digitado é maior que o gerado");
}

if (tentativas == 5 && numeroDigitado != numeroGerado) {
    System.out.println("Você não conseguiu acertar. O número era: " + numeroGerado);
}
```

- `new Random().nextInt(100)` — gera um número aleatório entre 0 e 99

---

### Desafios da Aula 03

| Desafio | Conceito principal |
| --- | --- |
| `NumeroMaior` | `if / else if / else` para comparar dois números |
| `ParOuImpar` | Operador `%` para verificar paridade |
| `Positivo` | `if / else` para classificar um número |
| `Tabuada` | Laço `for` para gerar a tabuada |
| `Fatorial` | Laço `for` com acumulador multiplicativo |
| `CalculadoraArea` | `while` + `if/else if` formando um menu interativo |

---

### O que aprendi nessa aula

- Capturar diferentes tipos de entrada do usuário com `Scanner` (`nextLine`, `nextInt`, `nextDouble`)
- Usar estruturas condicionais `if / else if / else` para controlar o fluxo do programa
- Usar `switch` como alternativa ao `if` quando há múltiplos valores possíveis para uma variável
- Usar o laço `for` quando a quantidade de repetições é conhecida
- Usar o laço `while` quando a condição de parada depende de um evento externo (ex: usuário digitar -1)
- Combinar laços e condicionais para criar programas interativos como menus e jogos

---

### Resumo dos Conceitos — Aula 03

| Conceito | O que é |
| --- | --- |
| `Scanner` | Lê entradas do usuário |
| `if / else` | Executa blocos com base em condições |
| `switch` | Alternativa ao `if` para múltiplos casos |
| `for` | Laço com número de repetições definido |
| `while` | Laço com repetições baseadas em condição |
| `&&` / `\|\|` | Operadores lógicos E / OU |
| `%` | Resto da divisão (útil para par/ímpar) |
| `Random` | Gera números aleatórios |
| `break` | Encerra um `case` no `switch` |