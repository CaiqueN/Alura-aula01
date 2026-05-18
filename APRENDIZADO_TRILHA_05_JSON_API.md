# Trilha 05 — JSON e Integração com APIs

## O que é JSON?

JSON (JavaScript Object Notation) é um formato de dados leve e popular para troca de informações entre sistemas. Apesar do nome mencionar JavaScript, ele pode ser lido e produzido por praticamente qualquer linguagem de programação, incluindo Java.

---

## As duas estruturas do JSON

O JSON é construído a partir de apenas dois blocos:

| Estrutura | Símbolo de abertura | Símbolo de fechamento | O que contém |
|---|---|---|---|
| **Objeto** | `{` | `}` | pares `"chave": valor` |
| **Array** | `[` | `]` | lista de valores em ordem |

---

## Objeto JSON — e por que `endereco` abre `{` e fecha `}` após `estado`

```json
{
  "nome": "João",
  "idade": 30,
  "solteiro": false,
  "endereco": {
    "rua": "Rua 123",
    "cidade": "São Paulo",
    "estado": "SP"
  },
  "telefones": [
    "1111-1111",
    "2222-2222"
  ]
}
```

A maioria dos campos tem valores simples — `"João"` é uma string, `30` é um número, `false` é booleano. Para esses valores, basta escrever o dado diretamente após os dois-pontos.

`endereco`, porém, **não é um valor simples**. Um endereço tem rua, cidade e estado — são três informações que precisam ficar agrupadas. A solução do JSON é criar um **objeto aninhado**, que segue a mesma regra de todo objeto: abre com `{` e fecha com `}`.

Leia assim:

```
"endereco": {          ← aqui começa o objeto "endereco"
    "rua": "Rua 123",
    "cidade": "São Paulo",
    "estado": "SP"     ← último par do objeto "endereco"
}                      ← aqui o objeto "endereco" termina
```

O `}` fecha exatamente após `estado` porque esse é o **último par de chave-valor que pertence ao endereço**. Tudo que estiver entre `{` e esse `}` faz parte do `endereco` — e nada mais.

> Pense no `{` e `}` como parênteses: tudo que fica dentro deles pertence àquele grupo.

---

## Array JSON — e por que cada pessoa abre `{` e fecha `}`

```json
[
  {
    "nome": "João",
    "idade": 30
  },
  {
    "nome": "Maria",
    "idade": 25
  },
  {
    "nome": "Pedro",
    "idade": 40
  }
]
```

Aqui a estrutura exterior é um **array** — identificado pelo `[` no início e `]` no final. Um array é uma lista ordenada: o João vem primeiro, Maria em segundo, Pedro em terceiro.

Mas cada item da lista **não é um valor simples** como um número ou texto — cada item é uma pessoa com nome e idade. Por isso cada elemento do array é, ele próprio, um **objeto**:

```
[                      ← começa o array (lista)
  {                    ← começa o objeto da 1ª pessoa
    "nome": "João",
    "idade": 30
  },                   ← termina o objeto da 1ª pessoa
  {                    ← começa o objeto da 2ª pessoa
    "nome": "Maria",
    "idade": 25
  },                   ← termina o objeto da 2ª pessoa
  {                    ← começa o objeto da 3ª pessoa
    "nome": "Pedro",
    "idade": 40
  }                    ← termina o objeto da 3ª pessoa
]                      ← termina o array
```

Cada `{` abre um "bloco pessoa" e o `}` correspondente fecha esse bloco. A vírgula após o `}` separa um elemento do próximo dentro do array — o último elemento **não** leva vírgula.

---

## Resumo visual — hierarquia dos símbolos

```
{                         → objeto raiz
  "nome": "João",         → valor simples (string)
  "idade": 30,            → valor simples (número)
  "endereco": {           → valor complexo = outro objeto
    "rua": "...",
    "estado": "SP"
  },                      → fim do objeto "endereco"
  "telefones": [          → valor complexo = array
    "1111-1111",
    "2222-2222"
  ]                       → fim do array "telefones"
}                         → fim do objeto raiz
```

**Regra prática:** sempre que um valor precisar ter mais de uma informação dentro dele, você usa `{ }` para criar um objeto aninhado. Se a lista de valores estiver em ordem e puder conter vários itens, você usa `[ ]` para criar um array.

---

## Serialização e Desserialização

Ao trabalhar com APIs em Java, o JSON precisa ser convertido:

| Direção | Nome técnico | O que acontece |
|---|---|---|
| Objeto Java → JSON | **Serialização** | o objeto é transformado em texto JSON para enviar |
| JSON → Objeto Java | **Desserialização** | o texto JSON é lido e mapeado de volta para um objeto Java |

Para fazer isso em Java, utiliza-se bibliotecas como **Gson** ou **Jackson**, que mapeiam automaticamente os campos do JSON para os atributos da classe.

---

## Próximos passos

- Obter uma chave na OMDb API e testar uma busca no navegador
- Criar as classes Java que representam a resposta da API (`Filme`, `Serie`)
- Usar Gson/Jackson para desserializar o JSON retornado pela API nos objetos Java

---

## Padrões de Projeto (Design Patterns)

Padrões de projeto são **soluções reutilizáveis para problemas comuns** de desenvolvimento de software. Surgiram na década de 1990, quando desenvolvedores perceberam que projetos diferentes apresentavam problemas parecidos — e que esses problemas podiam ser resolvidos com soluções também parecidas.

> Em vez de reinventar a roda, você aplica uma solução já testada e reconhecida pela comunidade.

---

### As 3 categorias

#### 1. Padrões de Criação
Lidam com a **criação de objetos**, garantindo flexibilidade e reutilização do código.

| Padrão | O que faz |
|---|---|
| **Factory Method** | Define um método para criar objetos, deixando as subclasses decidirem qual classe instanciar |
| **Builder** | Constrói objetos complexos passo a passo, separando a construção da representação |
| **Singleton** | Garante que uma classe tenha apenas uma instância em toda a aplicação |

---

#### 2. Padrões de Estrutura
Lidam com a **organização de objetos em estruturas maiores**, reduzindo o acoplamento entre eles.

| Padrão | O que faz |
|---|---|
| **Adapter** | Permite que interfaces incompatíveis trabalhem juntas, funcionando como um adaptador |
| **Facade** | Fornece uma interface simplificada para um conjunto complexo de classes |
| **Composite** | Agrupa objetos em estruturas de árvore para representar hierarquias todo-parte |

---

#### 3. Padrões de Comportamento
Lidam com a **comunicação entre objetos**, definindo como eles interagem em situações específicas.

| Padrão | O que faz |
|---|---|
| **Observer** | Define uma dependência entre objetos: quando um muda, os outros são notificados automaticamente |
| **Command** | Encapsula uma requisição como um objeto, permitindo parametrizar, enfileirar e desfazer ações |
| **Strategy** | Define uma família de algoritmos intercambiáveis, permitindo trocar o comportamento em tempo de execução |

---

### Por que usar?

- Código mais **legível** — outros desenvolvedores já conhecem os padrões
- Código mais **flexível** — fácil de estender sem quebrar o que já existe
- Código mais **fácil de manter** — estrutura previsível e testada
