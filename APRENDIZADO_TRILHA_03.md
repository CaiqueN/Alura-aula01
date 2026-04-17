# Trilha 03 - Herança em Java

## Herança

A herança é um conceito fundamental da orientação a objetos, sendo implementada em Java através da relação **é um** entre classes. Isso significa que uma classe pode herdar atributos e métodos de outra classe, tornando com isso o código mais reutilizável.

No Java, a herança é realizada através da palavra-chave `extends`. A classe que herda é chamada de **subclasse**, e a classe que é herdada é chamada de **superclasse**. A subclasse pode acessar todos os atributos e métodos públicos e protegidos da superclasse, além de poder sobrescrever os métodos da superclasse para criar comportamentos específicos.

Por exemplo:

```java
public class Conta {

  private String titular;
  private double saldo;

  public void sacar(double valor) {
    if (valor <= 0) {
      System.out.println("Valor deve ser maior do que zero!");
    } else if (saldo >= valor) {
      saldo -= valor;
      System.out.println("Saque realizado com sucesso. Saldo atual: " +saldo);
    } else {
      System.out.println("Saldo insuficiente.");
    }
  }

  public void depositar(double valor) {
    if (valor > 0) {
      saldo += valor;
      System.out.println("Depósito realizado com sucesso. Saldo atual: " +saldo);
    } else {
      System.out.println("Valor deve ser maior do que zero!");
    }
  }

  //getters e setters
}
```

```java
public class ContaPoupanca extends Conta {

  private double taxaDeJuros;

  public void calcularJuros() {
    double juros = this.getSaldo() * taxaDeJuros;
    System.out.println("Juros atual: " +juros);
  }

  public void sacar(double valor) {
    double taxaSaque = 0.01;
    super.sacar(valor + taxaSaque);
  }

  //getters e setters
}
```

No código anterior, a classe `Conta` é a superclasse e a classe `ContaPoupanca` é a subclasse. A classe `ContaPoupanca` herda os atributos e métodos da classe `Conta`, e adiciona um novo atributo `taxaDeJuros` e um novo método `calcularJuros`. Embora os atributos sejam herdados, como eles foram declarados como `private` na superclasse, não poderão ser acessados diretamente na subclasse, devendo então serem utilizados os métodos getters/setters, que são públicos.

Repare também no código anterior que a subclasse sobrescreveu o método `sacar`, para que seja descontada a taxa de saque, além de utilizar a palavra-chave `super` para chamar o método da superclasse, evitando com isso duplicar um código já existente. Essa é a grande vantagem da herança: reaproveitamento de código com flexibilidade para sobrescrever comportamentos.

## Herança múltipla

Em Java, é importante notar que a herança múltipla não é permitida. A herança múltipla ocorre quando uma subclasse herda de duas ou mais superclasses. Por exemplo:

```java
public class ContaPoupanca extends Conta, Pagamento {
  //codigo da classe omitido
}
```

O código anterior não compila, pois o `extends` aceita apenas uma única classe, ou seja, uma classe pode ter apenas uma superclasse.

Entretanto, é possível criar uma hierarquia de classes utilizando herança, simulando com isso uma herança múltipla. Por exemplo:

```java
public class Conta {
  //codigo da classe omitido
}
```

```java
public class ContaCorrente extends Conta {
  //codigo da classe omitido
}
```

```java
public class ContaCorrentePessoaFisica extends ContaCorrente {
  //codigo da classe omitido
}
```

No código anterior, a classe `ContaCorrentePessoaFisica` está herdando de `ContaCorrente`, que por sua vez herda da classe `Conta`, ou seja, indiretamente a classe `ContaCorrentePessoaFisica` vai herdar de `Conta`, pois sua superclasse herda dela.

## Anotações (Annotations)

As anotações, também conhecidas como *annotations*, são uma forma de adicionar configurações ao código Java de uma maneira bem simples. Elas são usadas para fornecer informações adicionais sobre o código, como o significado de uma classe, um método ou um atributo.

No Java, as anotações são definidas com o uso do símbolo `@` seguido do nome da anotação. Por exemplo, a anotação `@Deprecated` é usada para indicar que um método ou classe está obsoleto e não deve ser mais utilizado. Outra anotação muito útil é a `@Override`, que indica que um método está sobrescrevendo o mesmo método definido na sua classe mãe.

Diversas especificações e frameworks Java, como Hibernate, Bean Validation e Spring, utilizam anotações. Por exemplo, no Bean Validation a anotação `@NotNull` é usada para validar que um atributo não seja nulo.

As anotações são muito úteis e comuns em aplicações Java, sendo importante estar familiarizado com esse recurso, pois certamente será utilizado bastante em projetos Java.
