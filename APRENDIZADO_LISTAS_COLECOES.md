# Listas e Coleções — Java

---

## Map e HashMap

### Map
Interface que associa **chave → valor**. Útil para buscas, atualizações e recuperação de dados por uma chave única.

```java
Map<String, Integer> idades = new HashMap<>();
idades.put("Ana", 25);
idades.put("João", 30);

System.out.println(idades.get("Ana")); // 25
```

---

### HashMap
Implementação mais comum do `Map`, usa tabela hash internamente.

- Acesso, inserção e remoção em tempo **O(1)** — não depende do tamanho da coleção
- **Não garante ordem** de inserção dos elementos
- Chaves são únicas — colocar a mesma chave sobrescreve o valor anterior

```java
Map<String, String> capitais = new HashMap<>();
capitais.put("Brasil", "Brasília");
capitais.put("Argentina", "Buenos Aires");

System.out.println(capitais.get("Brasil")); // Brasília
System.out.println(capitais.containsKey("Chile")); // false
```

---

### Resumo rápido

| | Map | HashMap |
|---|---|---|
| O que é | Interface | Classe concreta |
| Ordem | não garante | não garante |
| Performance | — | O(1) |
| Chaves duplicadas | não permite | não permite |

> Mesma lógica do `List` x `ArrayList`: declare com `Map`, instancie com `HashMap`.

```java
Map<String, Integer> mapa = new HashMap<>();
```

---

## Implementações de List

### ArrayList
Array dinâmico — o mais usado no dia a dia.
- Acesso rápido por índice (`lista.get(0)`)
- Inserção/remoção no meio é mais lenta (precisa reorganizar o array)
- Use quando você **lê e percorre** a lista com frequência

```java
List<String> lista = new ArrayList<>();
lista.add("Ana");
lista.add("João");
System.out.println(lista.get(0)); // Ana
```

---

### LinkedList
Lista encadeada — cada elemento aponta para o próximo.
- Inserção/remoção em qualquer posição é rápida
- Acesso por índice é mais lento (precisa percorrer do início)
- Use quando você **insere e remove** elementos com frequência

```java
List<String> lista = new LinkedList<>();
lista.add("Ana");
lista.add("João");
```

---

### Vector
Igual ao `ArrayList`, mas **sincronizado** (seguro para múltiplas threads).
- Mais lento por causa da sincronização
- Na prática raramente usado — prefira `ArrayList` + controle manual de thread se precisar

---

### Stack
Pilha **LIFO** — último a entrar, primeiro a sair.
- `push()` adiciona no topo
- `pop()` remove do topo
- Use quando a ordem de processamento deve ser invertida

```java
Stack<String> pilha = new Stack<>();
pilha.push("primeiro");
pilha.push("segundo");
System.out.println(pilha.pop()); // segundo
```

---

### Resumo rápido

| Classe | Melhor para |
|---|---|
| `ArrayList` | leitura e iteração |
| `LinkedList` | muita inserção/remoção |
| `Vector` | ambiente multi-thread (raro) |
| `Stack` | ordem LIFO |

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

## foreach, casting e instanceof

### Percorrer um ArrayList com foreach

Para cada elemento da lista, o loop pega um item de cada vez sem precisar de índice:

```java
ArrayList<String> nomes = new ArrayList<>();
nomes.add("Ana");
nomes.add("João");

for (String nome : nomes) {
    System.out.println(nome);
}
// Ana
// João
```

> Leia como: "para cada `nome` dentro de `nomes`, faça..."

---

### Casting — converter um objeto para outro tipo compatível

Quando você tem um objeto de um tipo pai e sabe que na verdade ele é um tipo filho, pode fazer o casting para acessar os métodos do filho:

```java
Animal animal = new Cachorro(); // tipo declarado: Animal | objeto real: Cachorro

Cachorro cachorro = (Cachorro) animal; // casting
cachorro.latir(); // agora tem acesso aos métodos de Cachorro
```

> Atenção: se o objeto real **não for** um `Cachorro`, o Java lança `ClassCastException` em tempo de execução.

---

### instanceof — verificar o tipo real de um objeto

Antes de fazer o casting, use `instanceof` para garantir que o objeto é do tipo esperado:

```java
Animal animal = new Cachorro();

if (animal instanceof Cachorro) {
    Cachorro cachorro = (Cachorro) animal;
    cachorro.latir();
}
```

Combinando os três conceitos:

```java
ArrayList<Animal> lista = new ArrayList<>();
lista.add(new Cachorro());
lista.add(new Gato());

for (Animal animal : lista) {
    if (animal instanceof Cachorro) {
        Cachorro c = (Cachorro) animal;
        c.latir();
    }
}
```

> `instanceof` evita o `ClassCastException` ao checar o tipo antes de converter.

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

---

## Projeto Final — Sistema de Compras com Cartão de Crédito

### Objetivo

Aplicar listas e ordenação em um sistema real: um cartão de crédito que registra compras e exibe um extrato ordenado.

---

### Estrutura do projeto

| Classe | Responsabilidade |
|---|---|
| `CartaoDeCredito` | Guarda o limite, saldo e a lista de compras |
| `Compras` | Representa uma compra com descrição e valor |
| `TestarCartao` | Ponto de entrada — lê dados e exibe o extrato |

---

### Relacionamento entre as classes

`CartaoDeCredito` tem uma `List<Compras>` — uma lista de compras associada ao cartão:

```java
private List<Compras> compras = new ArrayList<>();
```

O método `lancaCompra` só adiciona se houver saldo:

```java
public boolean lancaCompra(Compras compras) {
    if (this.saldo > compras.getValor()) {
        this.saldo -= compras.getValor();
        this.compras.add(compras);
        return true;
    }
    return false;
}
```

> O `return false` fora do `if` é importante — sem ele o método sempre retornaria `true` mesmo quando a compra falhou.

---

### Ordenação de listas

Para ordenar uma lista com `Collections.sort()`, o Java precisa saber **como comparar** os objetos. Há duas formas:

#### 1. `Comparable` — ordenação natural definida na própria classe

A classe implementa `Comparable<T>` e define o método `compareTo`:

```java
public class Compras implements Comparable<Compras> {
    @Override
    public int compareTo(Compras outra) {
        return Double.compare(this.valor, outra.valor); // ordena por valor crescente
    }
}
```

#### 2. `Comparator` — ordenação definida na hora do sort

Sem alterar a classe, passa a lógica direto no `sort`:

```java
// Por valor
Collections.sort(lista, Comparator.comparingDouble(Compras::getValor));

// Por descrição
Collections.sort(lista, Comparator.comparing(Compras::getDescricao));
```

#### Quando usar cada um

| | `Comparable` | `Comparator` |
|---|---|---|
| Onde fica a lógica | Dentro da classe | Fora, na hora do sort |
| Quando usar | Há uma ordem natural óbvia | Múltiplos critérios ou sem acesso à classe |

---

### O que o `Collections.sort` exige

`Collections.sort(lista)` só funciona se os objetos implementam `Comparable`. Sem isso, o Java lança erro de compilação porque não sabe a regra de comparação.

`Collections.sort(lista, comparator)` aceita qualquer objeto, pois a regra vem de fora.

---

### Fluxo do sistema

```
Usuário digita limite
    → CartaoDeCredito criado com saldo = limite

Loop: usuário digita descrição + valor
    → Compras criada
    → lancaCompra verifica saldo
        → saldo suficiente: adiciona à lista, desconta saldo
        → saldo insuficiente: encerra o loop

Exibe extrato:
    → Collections.sort ordena as compras
    → for-each imprime cada compra
    → exibe saldo final
```
