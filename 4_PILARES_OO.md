pod# 4 Pilares da Orientação a Objetos em Java

---

## 1. Encapsulamento

> Protege os dados internos da classe. Só expõe o que precisa ser exposto.

```java
public class Audio {
    private int totalReproducoes; // ninguém acessa direto

    public void reproduz() {
        this.totalReproducoes++; // só muda por aqui
    }

    public int getTotalReproducoes() {
        return totalReproducoes; // só leitura
    }
}
```

**Pergunta-chave:** "Faz sentido alguém alterar isso diretamente?"
- Sim → getter + setter
- Não → só getter (ou método específico que controla a mudança)

---

## 2. Herança

> Uma classe filha herda atributos e métodos da classe pai. Evita repetição de código.

```java
public class Audio {
    private String titulo;
    public String getTitulo() { return titulo; }
    public void reproduz() { ... }
}

public class Music extends Audio {
    private String cantor; // atributo próprio de Music
    // já herda getTitulo() e reproduz() de Audio
}

public class Podcast extends Audio {
    private String apresentador; // atributo próprio de Podcast
    // já herda getTitulo() e reproduz() de Audio
}
```

**Regra:** use `extends` quando a relação for **"é um tipo de"**.
- `Music` **é um** `Audio` ✓
- `Favoritas` **não é um** `Audio` — só usa `Audio` como parâmetro ✓

---

## 3. Polimorfismo

> O mesmo código se comporta de formas diferentes dependendo do objeto real.

```java
public class Music extends Audio {
    @Override
    public int getClassificacao() {
        return getTotalReproducoes() > 2000 ? 6 : 10;
    }
}

public class Podcast extends Audio {
    @Override
    public int getClassificacao() {
        return getTotalCurtidas() > 500 ? 10 : 8;
    }
}
```

```java
// mesmo método, comportamentos diferentes
public void inclua(Audio audio) {
    audio.getClassificacao(); // chama Music ou Podcast dependendo do objeto
}
```

**Sinal de polimorfismo:** `@Override` — você está reescrevendo o comportamento herdado.

---

## 4. Abstração

> Expõe só o que importa. Esconde a complexidade interna.

```java
// quem usa Favoritas não precisa saber COMO a classificação é calculada
// só sabe que existe e retorna um número
favoritas.inclua(musica);
favoritas.inclua(podcast);
```

```java
// Audio abstrai o comportamento comum de todo áudio
// Music e Podcast só se preocupam com o que é específico deles
public class Audio {
    public void reproduz() { this.totalReproducoes++; } // lógica comum aqui
}
```

**Abstração com interface:**
```java
public interface Tributavel {
    double getValorImposto(); // só o contrato — sem implementação
}
```

---

## Resumo para fixar

| Pilar | Em uma frase | Palavra-chave |
|---|---|---|
| Encapsulamento | Protege os dados, controla o acesso | `private` + getters/setters |
| Herança | Filha reutiliza o que o pai já tem | `extends` |
| Polimorfismo | Mesmo método, comportamentos diferentes | `@Override` |
| Abstração | Mostra o essencial, esconde o resto | `interface` / superclasse |

---

## Como os 4 pilares aparecem no sistema de músicas

```
Audio                    ← Abstração (define o contrato comum)
├── private atributos    ← Encapsulamento (protege os dados)
├── extends Music        ← Herança (Music reutiliza Audio)
└── @Override getClass   ← Polimorfismo (cada um calcula diferente)
```
