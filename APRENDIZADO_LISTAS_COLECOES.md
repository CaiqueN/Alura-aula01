# Listas e Coleções — Java

---

## Construtores e Herança — Refatoração

### Antes da refatoração

Sem construtor declarado, os objetos eram criados com `new` vazio e os dados definidos via `set`:

```java
Filme filme = new Filme();
filme.setNome("Avatar");
filme.setAnoDeLancamento(2009);

Serie lost = new Serie();
lost.setNome("Lost");
lost.setAnoDeLancamento(2000);
```

O Java gerava automaticamente um **construtor padrão vazio** quando nenhum construtor era declarado.

---

### Depois da refatoração

Foi criado um construtor em `Titulo` recebendo `nome` e `anoDeLancamento` como obrigatórios:

```java
public Titulo(String nome, int anoDeLancamento) {
    this.nome = nome;
    this.anoDeLancamento = anoDeLancamento;
}
```

A partir daí, as classes filhas (`Filme` e `Serie`) são **obrigadas** a ter construtores que chamem o `super()`:

```java
// Serie
public Serie(String nome, int anoDeLancamento) {
    super(nome, anoDeLancamento);
}

// Filme
public Filme(String nome, int anoDeLancamento) {
    super(nome, anoDeLancamento);
}
```

E a criação dos objetos ficou mais curta:

```java
Filme meuFilme = new Filme("O Poderoso Chefão", 1970);
Serie lost = new Serie("Lost", 2000);
```

---

### Por que a IDE reclamou ao adicionar o construtor em Titulo?

Quando você declara qualquer construtor com parâmetros, o Java **para de gerar o construtor vazio automaticamente**. As subclasses que chamavam implicitamente `super()` sem argumentos passam a ter erro de compilação.

Sem construtor em `Titulo`:
```java
// Java gera automaticamente:
public Titulo() {}  // construtor padrão vazio

// Serie chama implicitamente:
super(); // ok, existe
```

Com construtor em `Titulo`:
```java
public Titulo(String nome, int anoDeLancamento) { ... }
// construtor vazio sumiu — Serie quebra
```

**Herança não herda construtores.** Cada classe precisa declarar o próprio.

---

### Pontos importantes

- O construtor **obriga** quem cria o objeto a passar os dados essenciais
- `super()` deve ser a **primeira linha** do construtor da subclasse
- Uma classe pode ter **mais de um construtor** (sobrecarga), desde que os parâmetros sejam diferentes
- Construtores podem fazer **validações**, não só atribuições
- `get` e `set` ainda são necessários mesmo com construtor — o construtor define na criação, o `set` permite alterar depois, o `get` permite ler

---

## Exercício — Classe Aluno herda de Pessoa

### O problema

```java
public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class Aluno extends Pessoa {
    private int matricula;
    private String curso;

    public Aluno(String nome, int idade, int matricula, String curso) {
        this.matricula = matricula;  // ERRO — não chamou super()
        this.curso = curso;
    }
}
```

**Erro:** o construtor de `Aluno` não chama o construtor de `Pessoa`. Como `Pessoa` não tem mais construtor vazio, o Java não sabe como inicializar `nome` e `idade`.

### A correção

```java
public Aluno(String nome, int idade, int matricula, String curso) {
    super(nome, idade);  // inicializa a parte da Pessoa
    this.matricula = matricula;
    this.curso = curso;
}
```

### Por que `Pessoa` é a classe pai?

Porque `Aluno extends Pessoa`. A lógica é:

- `Pessoa` é **genérica** — qualquer pessoa tem nome e idade
- `Aluno` é **específica** — um aluno é uma pessoa, com matrícula e curso a mais

> Todo aluno é uma pessoa, mas nem toda pessoa é um aluno.

Por isso `Pessoa` é a superclasse (pai) e `Aluno` é a subclasse (filho).
