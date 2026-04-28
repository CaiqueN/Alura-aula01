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

## Conceitos-Chave

- **Contrato:** a interface garante que o método existe, sem ditar como funciona.
- **Polimorfismo:** o mesmo código (`calcularImposto(Tributavel)`) funciona para qualquer implementação presente ou futura.
- **Extensibilidade:** para suportar um novo tipo tributável basta criar uma nova classe que implemente `Tributavel`, sem alterar `CalculadoraImposto`.
