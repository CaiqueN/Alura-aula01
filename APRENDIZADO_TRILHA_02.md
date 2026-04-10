c# Aprendizado - Java com Alura — Trilha 02

Curso: **Java: aplicando a Orientação a Objetos**
Projeto: ScreenMatch

---

## Aula 01 - Introdução à Orientação a Objetos

### Conceitos aprendidos

#### 1. Problemas da Programação Estruturada (Procedural)

Na programação estruturada, as regras de negócio ficam espalhadas pelo código, o que gera dois problemas principais:

- **Repetição de código** — a mesma lógica precisa ser escrita em vários lugares
- **Dificuldade de manutenção** — uma alteração numa regra exige mudanças em múltiplos pontos

---

#### 2. Orientação a Objetos como solução

A Orientação a Objetos (OO) resolve esses problemas ao permitir **centralizar** as características e comportamentos de uma entidade em um único lugar.

Esse princípio é chamado de **encapsulamento**: agrupar dados (atributos) e comportamentos (métodos) que pertencem a uma mesma entidade dentro de uma única estrutura — a **classe**.

---

#### 3. Classe vs. Objeto

| Conceito | Definição |
| --- | --- |
| **Classe** | Modelo/esqueleto que define quais atributos e comportamentos os objetos terão |
| **Objeto** | Instância concreta de uma classe, com valores próprios nos atributos |

rA **classe** é como a planta de uma casa: ela descreve como a casa será, mas não é a casa em si. O **objeto** é a casa construída a partir dessa planta — algo concreto que existe na memória do programa.

```java
// Classe = o molde (definição)
public class Filme {
    String nome;
    int anoDeLancamento;
}

// Objeto = instância criada a partir do molde
Filme meuFilme = new Filme();
meuFilme.nome = "Top Gun";
meuFilme.anoDeLancamento = 2022;
```

- `new Filme()` — cria um novo objeto do tipo `Filme` na memória
- Cada objeto é independente: dois objetos da mesma classe podem ter valores de atributos completamente diferentes

---

#### 4. Por que não se pode usar `System.out.println` dentro de uma classe sem o método `main`?

Em Java, **código executável não pode ficar solto dentro de uma classe** — ele precisa estar dentro de um **método**.

O método `main` é o **ponto de entrada** da aplicação: é ele que a JVM procura e executa ao iniciar o programa.

```java
// ERRADO — código solto na classe, fora de qualquer método
public class Filme {
    String nome;
    System.out.println("teste"); // ERRO DE COMPILAÇÃO
}
```

```java
// CERTO — código dentro do método main
public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        System.out.println(meuFilme.nome);
    }
}
```

**Por quê?**

| O que acontece | Explicação |
| --- | --- |
| A JVM não executa a classe diretamente | Ela procura especificamente o método `main` para iniciar |
| Atributos ficam na classe | São declarados fora de métodos — definem a estrutura do objeto |
| Código executável fica em métodos | `System.out.println`, cálculos, lógica — tudo dentro de métodos |
| `main` é o ponto de partida | Sem ele, a JVM não sabe por onde começar a execução |

---

#### 5. Os Quatro Pilares da Orientação a Objetos

A OO é sustentada por quatro princípios fundamentais:

##### 1. Encapsulamento
Agrupa dados (atributos) e comportamentos (métodos) de uma entidade em uma única classe, escondendo os detalhes internos do mundo externo.

```java
public class Filme {
    private double avaliacao; // atributo privado

    public void setAvaliacao(double avaliacao) { // acesso controlado
        this.avaliacao = avaliacao;
    }
}
```

##### 2. Herança
Permite que uma classe **filha** herde atributos e métodos de uma classe **pai**, evitando repetição de código.

```java
public class Serie extends Produto { // Serie herda de Produto
    int temporadas;
}
```

##### 3. Polimorfismo
Um mesmo método pode ter **comportamentos diferentes** dependendo do objeto que o executa.

```java
produto.exibirDetalhes(); // comportamento varia conforme o tipo: Filme, Série, etc.
```

##### 4. Abstração
Processo de identificar e modelar apenas as características **relevantes** de uma entidade para o sistema, ignorando detalhes desnecessários.

```java
// De um filme real, abstraímos apenas o que o sistema precisa:
String nome;
int anoDeLancamento;
double avaliacao;
// (ignoramos cor dos olhos do diretor, orçamento de marketing, etc.)
```

---

##### Resumo dos Quatro Pilares

| Pilar | O que faz |
| --- | --- |
| **Encapsulamento** | Agrupa e protege dados dentro da classe |
| **Herança** | Permite que uma classe reutilize código de outra |
| **Polimorfismo** | Um mesmo método age de formas diferentes conforme o objeto |
| **Abstração** | Modela apenas o que é relevante para o sistema |

---

#### 4. Criando a classe `Filme`

O primeiro passo do projeto ScreenMatch foi criar a classe `Filme`, definindo os atributos que todo filme possui:

```java
package java_trilha_02;

public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluindoPlano;
    double avaliacao;
    int totalDeAvaliacao;
    int duracaoMinutos;
}
```

| Atributo | Tipo | O que representa |
| --- | --- | --- |
| `nome` | `String` | Título do filme |
| `anoDeLancamento` | `int` | Ano em que o filme foi lançado |
| `incluindoPlano` | `boolean` | Se o filme está incluso no plano |
| `avaliacao` | `double` | Nota/avaliação do filme |
| `totalDeAvaliacao` | `int` | Quantidade de avaliações recebidas |
| `duracaoMinutos` | `int` | Duração do filme em minutos |

---

#### 5. Abstração e Modelagem

A definição dos atributos de uma classe é um processo de **abstração**: identificar quais características do mundo real são relevantes para o sistema que está sendo construído.

- Esse processo evolui com a experiência e com as necessidades do projeto
- Nem sempre todos os atributos possíveis de uma entidade precisam ser modelados — apenas os que o sistema vai utilizar

---

### O que aprendi nessa aula

- A importância de organizar **Regras de Negócio** para evitar repetição e facilitar manutenção
- O conceito de **Orientação a Objetos** como solução para os problemas da programação estruturada
- O que é **encapsulamento**: centralizar atributos e comportamentos de uma entidade em uma classe
- Como criar uma **classe** em Java no IntelliJ
- A diferença conceitual entre **classe** (modelo) e **objeto** (instância)
- Como definir **atributos** em uma classe usando tipos primitivos e `String`
- Que a modelagem de atributos é um processo de **abstração** que evolui com o projeto

---

### Nessa aula, você aprendeu

- O que é uma **classe**, sua estrutura, como criar e por que isso é um conceito fundamental na orientação a objetos
- O que são **atributos**: as "características" de um objeto, e a definir e visualizar esses valores
- A **instanciar objetos**
- Sobre os **métodos** (ou comportamentos) de um objeto
- A pensar nas entidades do mundo real em forma de **objetos**, que possuem características (**atributos**) e comportamentos ou ações (**métodos**)

---

### Resumo dos Conceitos — Aula 01

| Conceito | O que é |
| --- | --- |
| Programação Estruturada | Código organizado em sequências e funções, sem agrupamento por entidade |
| Orientação a Objetos | Paradigma que agrupa dados e comportamentos em classes |
| Encapsulamento | Centralizar características e comportamentos de uma entidade em um único lugar |
| Classe | Modelo que define atributos e comportamentos dos objetos |
| Objeto | Instância concreta de uma classe |
| Atributo | Característica/dado que um objeto possui |
| Abstração | Processo de identificar quais características do mundo real modelar no sistema |

---

### Desafio — Aula 01

Quatro pequenos desafios para praticar criação de classes, atributos e métodos.

#### Desafio 1 — Classe `Pessoa`

Criar uma classe com um método que imprime uma saudação.

```java
public class Pessoa {
    void saudacao() {
        System.out.println("Olá mundo");
    }
}
```

Instanciado em `Principal.java`:
```java
Pessoa pessoa = new Pessoa();
pessoa.saudacao();
```

---

#### Desafio 2 — Classe `Calculadora`

Criar uma classe com um método que retorna o dobro de um número inteiro.

```java
public class Calculadora {
    public int dobroNumero(int numero) {
        return numero * 2;
    }
}
```

Instanciado em `CalculadoraMain.java`:
```java
Calculadora calculadora = new Calculadora();
int resultado = calculadora.dobroNumero(7); // 14
System.out.println(resultado);
```

---

#### Desafio 3 — Classe `Aluno`

Modelar uma entidade com atributos e método de exibição.

| Atributo | Tipo | O que representa |
| --- | --- | --- |
| `nome` | `String` | Nome do aluno |
| `cpf` | `String` | Documento do aluno |
| `endereco` | `String` | Endereço do aluno |
| `idade` | `int` | Idade do aluno |
| `escola` | `String` | Instituição de ensino |

```java
void exibirFichaAluno() {
    System.out.println("Nome: " + nome);
    System.out.println("Número do documento: " + cpf);
    System.out.println("Endereço: " + endereco);
    System.out.println("Idade do aluno: " + idade);
    System.out.println("Escola: " + escola);
}
```

---

#### Desafio 4 — Classe `Musica`

Aplicar o mesmo padrão da classe `Filme` para modelar músicas, com avaliação e cálculo de média.

| Atributo | Tipo | O que representa |
| --- | --- | --- |
| `titulo` | `String` | Título da música |
| `artista` | `String` | Nome do artista |
| `anoDeLancamento` | `int` | Ano de lançamento |
| `somaAvaliacao` | `double` | Acumulador das notas |
| `numAvaliacoes` | `int` | Total de avaliações recebidas |

```java
void exibirFichaTecnica() { ... }  // imprime titulo, artista e ano
void avalia(double nota) { somaAvaliacao += nota; numAvaliacoes++; }
double media() { return somaAvaliacao / numAvaliacoes; }
```

Instanciado em `MusicaMain.java`:
```java
Musica lista = new Musica();
lista.titulo = "Nome da musica";
lista.artista = "Claude";
lista.anoDeLancamento = 2026;

lista.exibirFichaTecnica();
lista.avalia(3.5);
lista.avalia(7.6);
lista.avalia(5.7);

System.out.println("Media de avaliações " + lista.media()); // ~5.6
```

---

### O que pratiquei no desafio

- Criar classes com **atributos** de diferentes tipos primitivos e `String`
- Definir **métodos void** (sem retorno) para exibir informações
- Definir **métodos com retorno** (`int`, `double`) para calcular valores
- **Instanciar objetos** e atribuir valores via notação de ponto
- Reutilizar o padrão de **acumulador + contador** para calcular médias

---

## Aula 02 - Utilizando a classe Filme

### Conceitos aprendidos

#### 1. Renomeando a classe `Main` para `Principal`

A classe principal foi renomeada de `Main` para `Principal`, seguindo uma nomenclatura mais descritiva em português, alinhada ao projeto ScreenMatch.

---

#### 2. Criando uma instância da classe `Filme`

`Filme` é um tipo por referência (não primitivo). Para criar um objeto, usa-se a palavra-chave `new`:

```java
Filme meuFilme = new Filme();
```

- Isso cria um objeto `Filme` na memória (heap)
- A variável `meuFilme` armazena a **referência** para esse objeto, não o objeto em si

---

#### 3. Atribuindo valores aos atributos com a sintaxe de ponto

Após criar a instância, os atributos são preenchidos via **notação de ponto**:

```java
meuFilme.nome = "O poderoso chefão";
meuFilme.anoDeLancamento = 1972;
meuFilme.duracaoEmMinutos = 175;
```

---

#### 4. Acessando e imprimindo os atributos

```java
System.out.println(meuFilme.nome);
System.out.println(meuFilme.anoDeLancamento);
```

---

#### 5. Classe vs. Instância — acesso a atributos

| Forma de acesso | Resultado |
| --- | --- |
| `Filme.nome` | **Erro** — atributos de instância não existem na classe, apenas nos objetos |
| `meuFilme.nome` | **Correto** — acessa o atributo do objeto criado |

A **classe é o molde**; os atributos só ganham valores nas **instâncias (objetos)** criadas a partir dela.

---

#### 6. Métodos na classe `Filme`

Além dos atributos, a classe `Filme` passou a ter **métodos** — comportamentos que o objeto pode executar:

```java
void exibeFichaTecnica() {
    System.out.println("Nome do filme" + nome);
    System.out.println("Ano de lançamento" + anoDeLancamento);
}

void avaliacao(double nota) {
    somaAvaliacao += nota;
    totalDeAvaliacao++;
}

double media() {
    return somaAvaliacao / totalDeAvaliacao;
}
```

| Método | O que faz |
| --- | --- |
| `exibeFichaTecnica()` | Imprime nome e ano de lançamento do filme |
| `avaliacao(double nota)` | Acumula a nota em `somaAvaliacao` e incrementa `totalDeAvaliacao` |
| `media()` | Retorna a média das avaliações (`somaAvaliacao / totalDeAvaliacao`) |

- Métodos `void` não retornam valor
- Métodos com tipo de retorno (ex: `double`) usam `return` para devolver o resultado

---

#### 7. Código completo — `PrincipalFilme.java`

```java
package java_trilha_02.aula01;

public class PrincipalFilme {
    public static void main(String[] args) {

        // Assim que instancia um objeto
        Filme filme = new Filme();
        filme.nome = "Dragon ball Broly";
        filme.anoDeLancamento = 2019;
        filme.duracaoMinutos = 180;

        filme.exibeFichaTecnica();
        filme.avaliacao(8);
        filme.avaliacao(10);
        filme.avaliacao(5);

        System.out.println(filme.somaAvaliacao);   // 23.0
        System.out.println(filme.totalDeAvaliacao); // 3
        System.out.println(filme.media());          // 7.666...
    }
}
```

---

### O que aprendi nessa aula

- Como criar uma **instância** de uma classe usando `new`
- Que variáveis de tipos por referência armazenam a **referência** ao objeto, não o objeto diretamente
- Como atribuir valores a atributos de um objeto com a **sintaxe de ponto**
- Como imprimir atributos de um objeto com `System.out.println`
- A diferença entre acessar um atributo pela **classe** (impossível para atributos de instância) e pela **instância** (correto)
- Como definir **métodos** em uma classe e chamá-los via notação de ponto
- A diferença entre métodos `void` (sem retorno) e métodos com tipo de retorno
- Como acumular valores em atributos com `+=` e `++` dentro de um método

---

### Resumo dos Conceitos — Aula 02

| Conceito | O que é |
| --- | --- |
| `new Filme()` | Cria um novo objeto do tipo `Filme` na memória |
| Tipo por referência | Variável que armazena o endereço do objeto, não o valor direto |
| Notação de ponto | Sintaxe `objeto.atributo` ou `objeto.metodo()` para acessar dados e comportamentos |
| Instância | Objeto concreto criado a partir de uma classe |
| Classe como molde | A classe define a estrutura; os valores existem apenas nos objetos |
| Método `void` | Método que executa uma ação e não retorna valor |
| Método com retorno | Método que processa dados e devolve um resultado com `return` |

---

## Encapsulamento — Modificadores de Acesso, Getters, Setters e Construtores

### Conceitos aprendidos

#### 1. O problema de atributos públicos

Quando os atributos são `public`, qualquer código externo pode modificá-los diretamente, sem nenhum controle:

```java
ContaBancaria conta = new ContaBancaria();
conta.saldo = -9999; // ninguém impede isso!
```

Isso viola o princípio do encapsulamento: o objeto não tem controle sobre seus próprios dados.

---

#### 2. `private` — ocultando os dados

O modificador `private` restringe o acesso ao atributo para dentro da própria classe. Nenhuma outra classe consegue ler ou modificar o atributo diretamente.

```java
public class ContaBancaria {
    private int numeroConta;
    private int saldo;
    public String titular; // ainda público (sem restrição)
}
```

| Modificador | Quem pode acessar |
| --- | --- |
| `public` | Qualquer classe |
| `private` | Apenas a própria classe |

---

#### 3. Getters e Setters — acessando atributos privados com controle

Para permitir que código externo leia ou altere atributos `private`, criamos métodos específicos chamados **getter** (leitura) e **setter** (escrita).

```java
// Getter — retorna o valor do atributo
public int getSaldo() {
    return saldo;
}

// Setter — define o valor do atributo
public void setSaldo(int saldo) {
    this.saldo = saldo;
}
```

**Convenção de nomenclatura:**
- Getter: `get` + nome do atributo com inicial maiúscula → `getSaldo()`
- Setter: `set` + nome do atributo com inicial maiúscula → `setSaldo(int saldo)`

---

#### 4. A palavra-chave `this`

Dentro de um setter, o parâmetro e o atributo têm o mesmo nome. O `this` resolve a ambiguidade, referenciando o **atributo do objeto atual**:

```java
public void setSaldo(int saldo) {
    this.saldo = saldo; // this.saldo = atributo da classe; saldo = parâmetro do método
}
```

| Expressão | O que representa |
| --- | --- |
| `this.saldo` | O atributo `saldo` do objeto |
| `saldo` (sem `this`) | O parâmetro recebido pelo método |

---

#### 5. Construtor — inicializando o objeto na criação

O construtor é um método especial executado automaticamente no momento do `new`. Ele permite inicializar atributos obrigatórios já na criação do objeto.

```java
public class Produto {
    private String nome;
    private double preco;

    // Construtor
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
```

Uso:
```java
Produto produto = new Produto("Celular", 2000.0); // já inicializado
```

**Diferença: com e sem construtor**

| Abordagem | Como inicializa |
| --- | --- |
| Sem construtor | `produto.setNome("Celular")` após o `new` |
| Com construtor | `new Produto("Celular", 2000.0)` — obrigatório na criação |

---

#### 6. Métodos de negócio encapsulados

Com encapsulamento, a lógica que altera o estado do objeto fica **dentro da própria classe**, não no código externo:

```java
public void aplicarDesconto(double percentual) {
    double desconto = preco * (percentual / 100);
    preco -= desconto;
}
```

O código externo só chama o método — a implementação está protegida dentro da classe:

```java
produto.aplicarDesconto(10);
System.out.println(produto.getPreco()); // preço já com desconto aplicado
```

---

### Desafios praticados

#### Desafio — `ContaBancaria`

```java
ContaBancaria conta = new ContaBancaria();
conta.setNumeroConta(1234);
conta.setSaldo(100);
conta.setTitular("Italo");

System.out.println(conta.getNumeroConta()); // 1234
System.out.println(conta.getSaldo());       // 100
System.out.println(conta.getTitular());     // Italo

conta.setSaldo(1600);
System.out.println(conta.getSaldo());       // 1600
```

#### Desafio — `IdadePessoa`

```java
IdadePessoa info = new IdadePessoa();
info.setIdade(38);
info.setNome("Pedro");

System.out.println(info.getNome());  // Pedro
System.out.println(info.getIdade()); // 38
```

#### Desafio — `Produto` (com construtor e desconto)

```java
Produto produto = new Produto("Celular", 2000.0);

System.out.println(produto.getNome());  // Celular
System.out.println(produto.getPreco()); // 2000.0

produto.aplicarDesconto(10);
System.out.println(produto.getPreco()); // 1800.0
```

#### Desafio — `Aluno` (encapsulado, com cálculo de média)

Classe com quatro notas privadas e um método que calcula a média automaticamente.

| Atributo | Tipo | O que representa |
| --- | --- | --- |
| `nome` | `String` | Nome do aluno |
| `nota` / `nota2` / `nota3` / `nota4` | `double` | Quatro notas bimestrais |

```java
public double mediaCalculada() {
    return (nota + nota2 + nota3 + nota4) / 4;
}
```

Uso em `AlunoDoisMain`:
```java
Aluno aluno = new Aluno();
aluno.setNome("Italo");
aluno.setNota(7.5);
aluno.setNota2(8.9);
aluno.setNota3(10.0);
aluno.setNota4(6.5);

System.out.println(aluno.getNome());          // Italo
System.out.println(aluno.mediaCalculada());   // 8.225
```

> Diferença em relação ao `Aluno` da Aula 01: aqui os atributos são `private`, o acesso é feito via getters/setters, e a lógica de média fica encapsulada dentro da própria classe.

#### Desafio — `Livro`

Classe simples com dois atributos privados e getters/setters.

| Atributo | Tipo | O que representa |
| --- | --- | --- |
| `titulo` | `String` | Título do livro |
| `autor` | `String` | Nome do autor |

```java
Livro lib = new Livro();
lib.setTitulo("Novel Naruto");
lib.setAutor("Kishimoto");

System.out.println(lib.getTitulo()); // Novel Naruto
System.out.println(lib.getAutor());  // Kishimoto
```

---

### O que aprendi nessa seção

- Por que atributos `public` são perigosos — qualquer código externo pode corromper o estado do objeto
- Como usar `private` para proteger os dados da classe
- Como criar **getters** e **setters** para fornecer acesso controlado a atributos privados
- A convenção de nomenclatura `get`/`set` + nome com inicial maiúscula
- O uso de `this` para diferenciar atributo da classe e parâmetro do método com mesmo nome
- Como criar um **construtor** para inicializar atributos obrigatórios na criação do objeto
- Como encapsular lógica de negócio em métodos da própria classe (ex: `aplicarDesconto`)

---

### Resumo dos Conceitos — Encapsulamento

| Conceito | O que é |
| --- | --- |
| `private` | Modificador que restringe o acesso ao atributo à própria classe |
| `public` | Modificador que permite acesso de qualquer lugar |
| Getter | Método que retorna o valor de um atributo privado (`getNome()`) |
| Setter | Método que define o valor de um atributo privado (`setNome(String nome)`) |
| `this` | Referência ao objeto atual — diferencia atributo do parâmetro de mesmo nome |
| Construtor | Método especial chamado no `new` para inicializar o objeto |
| Método de negócio | Lógica que altera o estado do objeto encapsulada dentro da própria classe |

---