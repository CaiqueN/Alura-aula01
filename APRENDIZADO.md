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

## Resumo dos Conceitos

| Conceito | O que é |
|---|---|
| `class` | Molde para criar objetos |
| `main` | Ponto de entrada do programa |
| `var` | Inferência de tipo automática |
| `private` | Encapsulamento de atributos |
| Getter/Setter | Métodos de acesso aos atributos |
| Construtor | Inicializa o objeto |
| `toString` | Representa o objeto como texto |
| `Scanner` | Lê entradas do usuário |
| `LocalDate` | Representa datas |