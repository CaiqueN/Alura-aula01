# Trilha 04 — Interfaces em Java

## O que é uma Interface?

Uma interface define um **contrato**: ela declara quais métodos uma classe deve implementar, sem fornecer a implementação. Isso garante que classes diferentes possam ser tratadas de forma padronizada via **polimorfismo**.

```java
public interface Tributavel {
    double getValorImposto();
}
```

> Toda classe que implementar `Tributavel` é obrigada a fornecer o método `getValorImposto()`.

---

## Implementando uma Interface

Usa-se a palavra-chave `implements`. A classe deve implementar **todos** os métodos declarados na interface.

### Produto — imposto fixo de 10%

```java
public class Produto implements Tributavel {
    private String nome;
    private double valor;

    @Override
    public double getValorImposto() {
        return this.valor * 0.1;
    }
}
```

### Servico — imposto calculado pela alíquota de ISS

```java
public class Servico implements Tributavel {
    private String descricao;
    private double valor;
    private double aliquotaISS;

    @Override
    public double getValorImposto() {
        return this.valor * this.aliquotaISS / 100;
    }
}
```

**Exemplo:** serviço de R$ 1.200,00 com alíquota de 5% → `1200 * 5 / 100 = R$ 60,00`

---

## Usando a Interface como Tipo (Polimorfismo)

Ao declarar um parâmetro com o **tipo da interface**, o método aceita qualquer objeto que a implemente.

```java
public class CalculadoraImposto {
    private double totalImposto = 0;

    public void calcularImposto(Tributavel item) {
        this.totalImposto += item.getValorImposto();
    }

    public double getTotalImposto() {
        return this.totalImposto;
    }
}
```

```java
CalculadoraImposto calculadora = new CalculadoraImposto();

Produto notebook = new Produto();
notebook.setValor(3000.0);
calculadora.calcularImposto(notebook); // chama Produto.getValorImposto()

Servico consultoria = new Servico();
consultoria.setValor(1200.0);
consultoria.setAliquotaISS(5.0);
calculadora.calcularImposto(consultoria); // chama Servico.getValorImposto()

System.out.println(calculadora.getTotalImposto()); // 300.0 + 60.0 = 360.0
```

---

## Interface vs. Classe Abstrata

| | Interface | Classe Abstrata |
|---|---|---|
| Herança múltipla | Sim (`implements A, B`) | Não (só `extends` uma) |
| Atributos de estado | Não (apenas constantes) | Sim |
| Implementação padrão | Só com `default` (Java 8+) | Sim |
| Uso principal | Definir contrato/comportamento | Compartilhar estado e lógica |

---

## Interfaces no Projeto (trilha04)

| Arquivo | Papel |
|---|---|
| `Classificavel.java` | Interface — define `getClassificacao()` |
| `Tributavel.java` | Interface — define `getValorImposto()` |
| `Filme.java` | Implementa `Classificavel` |
| `Episodio.java` | Implementa `Classificavel` |
| `Produto.java` | Implementa `Tributavel` |
| `Servico.java` | Implementa `Tributavel` |
| `FiltroRecomendacao.java` | Recebe `Classificavel` — polimorfismo |
| `CalculadoraImposto.java` | Recebe `Tributavel` — polimorfismo |

---

## Conceitos-Chave Aprendidos na Trilha 04

### Herança simples em Java

Java permite que uma classe herde de **somente uma única classe** — não existe herança múltipla de classes.

```java
public class Brinde extends Item { }        // correto
public class Brinde extends Item, Produto { } // ERRO DE COMPILAÇÃO
```

Para compensar essa limitação, Java permite implementar **múltiplas interfaces** ao mesmo tempo:

```java
public class Produto extends Item implements Tributavel, Vendavel { }
```

---

### O que é uma Interface

Uma interface é um **contrato puro**: declara quais métodos uma classe deve ter, sem fornecer implementação. Qualquer classe que escrever `implements NomeDaInterface` é obrigada a implementar todos os métodos declarados nela.

```java
public interface Tributavel {
    double getValorImposto(); // sem corpo — só a assinatura
}
```

---

### Métodos de interface são implicitamente `public`

Numa interface, **todos os métodos são públicos por padrão**. Não é necessário (nem recomendado) escrever `public` na declaração — o compilador assume isso automaticamente.

```java
public interface Tributavel {
    double getValorImposto();          // equivalente a:
    public double getValorImposto();   // mesma coisa — redundante
}
```

Ao implementar na classe, o `@Override` deve manter a visibilidade `public`:

```java
@Override
public double getValorImposto() {
    return this.valor * 0.1;
}
```

---

### Polimorfismo com interfaces

Assim como a herança permite tratar subclasses pelo tipo da superclasse, a interface permite tratar objetos diferentes pelo **tipo do contrato**. O comportamento executado depende da implementação real de cada classe.

```java
// com herança
Item item = new Produto();   // Produto é um Item

// com interface
Tributavel t = new Produto();   // Produto implementa Tributavel
Tributavel t = new Servico();   // Servico também implementa Tributavel
```

A `CalculadoraImposto` aplica exatamente isso: recebe um `Tributavel` e chama `getValorImposto()` sem saber (nem precisar saber) de qual classe veio o objeto.

```java
public void calcularImposto(Tributavel item) {
    totalImposto += item.getValorImposto(); // polimorfismo em ação
}
```

---

- **Contrato:** a interface garante que o método existe, sem ditar como funciona.
- **Polimorfismo:** o mesmo código (`calcularImposto(Tributavel)`) funciona para qualquer implementação presente ou futura.
- **Extensibilidade:** para suportar um novo tipo tributável basta criar uma nova classe que implemente `Tributavel`, sem alterar `CalculadoraImposto`.

---

## Usar uma classe como parâmetro não exige herança

Uma classe pode **receber** outra como parâmetro sem herdar dela. Herança (`extends`) só é necessária quando você quer dizer que uma classe **é um tipo** da outra.

```java
// Favoritas não herda de Audio — só recebe Audio como parâmetro
public class Favoritas {
    public void inclua(Audio audio) {
        audio.getTitulo();        // funciona pois Audio declara esse método
        audio.getClassificacao(); // funciona pois Audio declara esse método
    }
}
```

Sobre o `import`: no **mesmo pacote** o Java enxerga todas as classes automaticamente — não precisa de `import`. Só é necessário quando a classe está em outro pacote.

| Situação | Precisa de `import`? |
|---|---|
| Mesmo pacote | Não |
| Pacote diferente | Sim |
| `java.lang` (String, Integer...) | Não — Java importa automático |

---

## Encapsulamento — Getter, Setter, ou Nenhum?

A dúvida que surgiu na classe `Audio`: por que `titulo` tem getter **e** setter, mas `totalReproducoes` e `totalCurtidas` têm apenas getter?

A pergunta certa a fazer em cada atributo é:

> **"Faz sentido alguém alterar isso diretamente?"**

```java
public class Audio {
    private String titulo;          // pode mudar livremente → getter + setter
    private double duracao;         // definida na criação → só getter
    private int totalReproducoes;   // só sobe via reproduz() → só getter
    private double totalCurtidas;   // só sobe via curtir()  → só getter

    public void reproduz() { this.totalReproducoes++; }
    public void curtir()   { this.totalCurtidas++; }
}
```

Se você expusesse um `setTotalReproducoes`, alguém poderia colocar 1 milhão de reproduções sem a música ter tocado uma vez. O setter destruiria a integridade do dado.

### Setter permite mudar livremente?

Um setter simples **não impõe nenhuma restrição** — qualquer valor passa:

```java
musica.setTitulo("Novo título"); // ok
musica.setTitulo("");            // também passa — título vazio!
musica.setTitulo(null);          // também passa — null!
```

Mas você pode adicionar validação dentro do setter para controlar o que é aceito:

```java
public void setTitulo(String titulo) {
    if (titulo != null && !titulo.isEmpty()) {
        this.titulo = titulo;
    }
}
```

Agora a alteração ainda é possível, mas com controle. A pergunta ao criar um setter passa a ser duas:

1. **"Quero que isso possa ser alterado?"** → se não, nem cria o setter
2. **"Com que restrições?"** → se sim, pensa se precisa validar

### Regra prática

| Situação | O que expor |
|---|---|
| Atributo pode ser alterado livremente | getter + setter simples |
| Atributo pode ser alterado, mas com regras | getter + setter com validação |
| Atributo só muda por lógica interna (método específico) | só getter |
| Atributo nunca muda após criação | só getter (ou nem isso) |

Outros exemplos do mundo real:

- `saldoConta` — sem setter; só muda via `deposita()` e `saca()` que validam o valor
- `dataNascimento` de uma pessoa — sem setter; ninguém nasce duas vezes
- `nome` de um usuário — getter + setter; pode ser corrigido livremente

Quanto mais você pensar nisso ao modelar as classes, mais seguro e previsível fica o código.

---

## Novas Classes da Trilha 04

### `Brinde` — filha de `Item`, não tributável

```java
public class Brinde extends Item {
    private String justificativa;
    // getters e setters
}
```

Brinde herda de `Item` mas **não implementa `Tributavel`** — brindes são isentos de imposto. Isso demonstra que nem toda subclasse de `Item` precisa honrar o contrato de tributação.

---

### `Caixa` — filha de `Item`, não tributável

```java
public class Caixa extends Item {
    private double peso;
    // getters e setters
}
```

Mesmo padrão de `Brinde`: herda atributos comuns (`nome`, `preco`) de `Item` sem se comprometer com nenhuma interface adicional.

---

### `TributavelDois` — interface alternativa de tributação

```java
public interface TributavelDois {
    double calcularImpostos();
}
```

Variante da interface `Tributavel` com nomenclatura diferente no método. Ilustra que contratos podem ter nomes distintos — duas interfaces independentes que fazem a mesma coisa semanticamente, mas são incompatíveis entre si na tipagem do Java.

---

### `ServidoDois` — serviço herdando de `Item` (sem `implements`)

```java
public class ServidoDois extends Item {
    private int quantidadeHoras;

    public double calculaImposto() {
        return getPreco() * 0.12;
    }
}
```

> **Atenção:** `ServidoDois` possui o método `calculaImposto()`, mas **não declara `implements Tributavel`** nem `implements TributavelDois`. O método existe, mas a classe **não é aceita** como `Tributavel` pelo compilador — o tipo não substitui o contrato.

---

### `CalcularImpostos` — consumidora de `TributavelDois`

```java
public class CalcularImpostos {
    private double totalImposto = 0;

    public void calcularImposto(TributavelDois tributavelDois) {
        totalImposto += tributavelDois.calcularImpostos();
    }
}
```

Análoga a `CalculadoraImposto`, mas tipada em `TributavelDois`. Reforça o mesmo padrão: a calculadora depende do **contrato (interface)**, não de uma classe concreta.

---

## Fórum de Discussão — Exercício da Loja do Caio

O exercício pede para identificar as alternativas **corretas** sobre a implementação de tributação via interface.

---

### Alternativa 1 — `"Para que a classe Servico deixe de ser tributável, basta apagar dela o método calculaImposto"`

**INCORRETA.**

Apagar apenas o método causaria um **erro de compilação**. A classe ainda carregaria `implements Tributavel` no cabeçalho, e o compilador exige que todos os métodos do contrato estejam implementados. O correto seria remover **tanto o método quanto o `implements Tributavel`**:

```java
// antes (compila)
public class Servico extends Item implements Tributavel { ... }

// após apagar só o método — NÃO COMPILA
public class Servico extends Item implements Tributavel { }
//                                          ^^^^^^^^^^^ contrato quebrado

// correto: remover os dois
public class Servico extends Item { }
```

---

### Alternativa 2 — `"A CalculadoraImposto pode calcular impostos de qualquer classe que implemente Tributavel, sem conhecer a implementação específica"`

**CORRETA.**

Isso é **polimorfismo via interface**. O método `calcularImposto(Tributavel item)` aceita qualquer objeto que honre o contrato — `Produto`, `Servico`, ou qualquer nova classe futura. A calculadora não sabe (e não precisa saber) como cada uma calcula seu imposto.

```java
calculadora.calcularImposto(notebook);     // 10% do valor
calculadora.calcularImposto(consultoria);  // ISS proporcional
// mesmo método, comportamentos diferentes — polimorfismo
```

---

### Alternativa 3 — `"A classe CalculadoraImposto deveria implementar a interface Tributavel"`

**INCORRETA.**

`CalculadoraImposto` é uma **consumidora** da interface, não uma implementadora. Ela *usa* objetos `Tributavel` para somar impostos — não faz sentido semântico dizer que a própria calculadora é tributável. Implementar a interface aqui violaria o princípio de que a interface representa um **comportamento coerente** com a natureza da classe.

---

### Alternativa 4 — `"Nem todas as classes filhas de Item precisam implementar Tributavel"`

**CORRETA.**

`Brinde` e `Caixa` herdam de `Item` e nunca implementam `Tributavel`. A hierarquia de herança e o contrato de interface são **independentes** — uma classe pode herdar estado/comportamento de um pai sem assumir nenhum contrato adicional.

```
Item
├── Produto   implements Tributavel  ✓
├── Servico   implements Tributavel  ✓
├── Brinde    (sem Tributavel)       —
└── Caixa     (sem Tributavel)       —
```

---

### Alternativa 5 — `"A classe Brinde poderia herdar da classe Produto"`

**CORRETA — tecnicamente.**

Em Java, herança múltipla de classes não existe, mas `Brinde extends Produto` é sintaticamente válido. Ao fazer isso, `Brinde` herdaria também o `implements Tributavel` de `Produto` e seria obrigada a ter `getValorImposto()` (já herdado). Porém, **semanticamente**, um brinde não é um produto — herdar de `Produto` só para reaproveitar campos seria um mau uso da herança. O ideal seria manter `Brinde extends Item` e não comprometer a classe com tributação.

---

### Resumo das alternativas

| # | Afirmação | Resultado | Motivo |
|---|---|---|---|
| 1 | Basta apagar o método para deixar de ser tributável | **Incorreta** | Erro de compilação — `implements` continua no cabeçalho |
| 2 | `CalculadoraImposto` funciona para qualquer `Tributavel` | **Correta** | Polimorfismo via interface |
| 3 | `CalculadoraImposto` deveria implementar `Tributavel` | **Incorreta** | Ela consome a interface, não a implementa |
| 4 | Nem toda filha de `Item` precisa implementar `Tributavel` | **Correta** | `Brinde` e `Caixa` provam isso |
| 5 | `Brinde` poderia herdar de `Produto` | **Correta** | Válido em Java, mas semanticamente ruim |
