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

## O que é uma API?

**API** significa *Application Programming Interface* — ou seja, **Interface de Programação de Aplicações**.

Pense assim: um garçom em um restaurante não vai até a cozinha fazer a comida. Ele anota seu pedido, leva para a cozinha e traz o resultado para você. A API funciona exatamente como esse garçom — ela é o **intermediário** entre o seu programa e outro sistema.

```
Seu programa  →  faz um pedido (requisição)  →  API
     ↑                                             ↓
Seu programa  ←  recebe a resposta (response)  ←  API
```

### Como funciona na prática?

1. **Você faz uma requisição** — envia uma URL com os parâmetros do que quer buscar
2. **O servidor processa** — busca nos seus dados o que você pediu
3. **A API retorna uma resposta** — normalmente em formato JSON

### Os dois lados de uma requisição HTTP

| Elemento | O que é |
|---|---|
| **URL** | O endereço do recurso que você quer acessar |
| **Método HTTP** | A ação que você quer fazer (`GET` = buscar, `POST` = criar, `PUT` = atualizar, `DELETE` = apagar) |
| **Parâmetros** | Filtros ou informações extras que você passa junto com a URL |
| **Resposta (Response)** | O que o servidor devolve — geralmente um JSON |

---

## A API do OMDb — como ela funciona

O **OMDb** (*Open Movie Database*) é uma API gratuita que fornece dados sobre filmes, séries e episódios. Para usá-la você precisa de uma **chave de acesso (API Key)**, obtida gratuitamente no site deles.

### Estrutura da URL

Toda requisição ao OMDb segue esse padrão:

```
http://www.omdbapi.com/?apikey=SUA_CHAVE&parametro=valor
```

### Parâmetros mais usados

| Parâmetro | O que faz | Exemplo |
|---|---|---|
| `t` | Busca por **título exato** do filme | `t=Inception` |
| `s` | Busca por **palavras-chave** (retorna lista) | `s=batman` |
| `i` | Busca por **ID IMDb** | `i=tt1375666` |
| `y` | Filtra por **ano** de lançamento | `y=2010` |
| `type` | Filtra por tipo: `movie`, `series`, `episode` | `type=movie` |

### Exemplo de URL completa

Buscando o filme "Inception" de 2010:

```
http://www.omdbapi.com/?apikey=SUA_CHAVE&t=Inception&y=2010
```

### Exemplo de resposta JSON

```json
{
  "Title": "Inception",
  "Year": "2010",
  "Rated": "PG-13",
  "Released": "16 Jul 2010",
  "Runtime": "148 min",
  "Genre": "Action, Adventure, Sci-Fi",
  "Director": "Christopher Nolan",
  "Plot": "A thief who steals corporate secrets through the use of dream-sharing technology...",
  "imdbRating": "8.8",
  "imdbID": "tt1375666",
  "Response": "True"
}
```

O campo `"Response": "True"` indica que a busca foi bem-sucedida. Se o filme não for encontrado, a resposta será:

```json
{
  "Response": "False",
  "Error": "Movie not found!"
}
```

---

## Consultando a API do OMDb com o Postman

O **Postman** é uma ferramenta visual que permite testar APIs sem precisar escrever código. É perfeito para explorar e entender como uma API funciona antes de integrá-la ao seu projeto.

### Passo a passo

**1. Abra o Postman e crie uma nova requisição**
- Clique em `New` → `HTTP Request`

**2. Configure o método e a URL**
- Método: `GET` (estamos apenas buscando dados)
- URL: `http://www.omdbapi.com/`

**3. Adicione os parâmetros na aba "Params"**

| KEY | VALUE |
|---|---|
| `apikey` | `sua_chave_aqui` |
| `t` | `Inception` |
| `y` | `2010` |

O Postman monta a URL automaticamente:
```
http://www.omdbapi.com/?apikey=sua_chave&t=Inception&y=2010
```

**4. Clique em "Send"**

O resultado aparece no painel inferior em formato JSON, já formatado e colorido para fácil leitura.

### Dica: aba "Pretty" vs "Raw"

- **Pretty** → JSON formatado e identado (mais fácil de ler)
- **Raw** → texto puro exatamente como veio do servidor

---

## Integrando a API do OMDb em Java

Java 11+ possui suporte nativo para fazer requisições HTTP sem precisar de bibliotecas externas. As três classes principais são:

| Classe | Responsabilidade |
|---|---|
| `HttpClient` | O "navegador" — gerencia as conexões |
| `HttpRequest` | O "pedido" — monta a URL e o método HTTP |
| `HttpResponse` | A "resposta" — contém o corpo retornado pelo servidor |

### Código completo comentado

```java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {

    public static void main(String[] args) throws Exception {

        // 1. Cria o cliente HTTP — é quem vai "abrir a conexão"
        HttpClient client = HttpClient.newHttpClient();

        // 2. Monta a requisição — define PARA ONDE e COMO enviar
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.omdbapi.com/?apikey=SUA_CHAVE&t=Inception"))
                .GET()           // método HTTP GET (buscar dados)
                .build();

        // 3. Envia a requisição e captura a resposta como texto (String)
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        // 4. Exibe o corpo da resposta — o JSON retornado pela API
        System.out.println(response.body());
    }
}
```

### O que cada parte faz

```java
HttpClient.newHttpClient()
// Cria um cliente padrão. É como abrir o navegador — pronto para fazer pedidos.

HttpRequest.newBuilder()
// Começa a "montar" a requisição, como preencher um formulário passo a passo.

.uri(URI.create("..."))
// Define o endereço (URL) que será acessado.

.GET()
// Define que o método HTTP é GET — apenas buscar, sem enviar dados.

.build()
// Finaliza e "constrói" o objeto HttpRequest com tudo configurado.

client.send(request, HttpResponse.BodyHandlers.ofString())
// Envia o pedido e diz que queremos receber a resposta como String (texto).

response.body()
// Retorna o conteúdo da resposta — no nosso caso, o JSON com os dados do filme.
```

### Fluxo completo visualizado

```
Main.java
   │
   ├─ HttpClient ──────── abre a conexão com o servidor
   │
   ├─ HttpRequest ──────── monta: URL + método GET
   │
   ├─ client.send() ────── envia e aguarda a resposta
   │
   └─ HttpResponse ──────── contém o JSON da API
              │
              └─ response.body() → String com o JSON
```

### Próximo passo natural: desserializar o JSON

O `response.body()` retorna o JSON como uma `String`. Para transformar esse texto em um objeto Java (ex: um `Filme`), usamos a biblioteca **Gson**:

```java
import com.google.gson.Gson;

// Classe que mapeia os campos do JSON
record Filme(String Title, String Year, String imdbRating) {}

// Converte o JSON em objeto Java
Gson gson = new Gson();
Filme filme = gson.fromJson(response.body(), Filme.class);

System.out.println(filme.Title());      // Inception
System.out.println(filme.imdbRating()); // 8.8
```

> Os nomes dos atributos do `record` precisam ser **idênticos** às chaves do JSON para o Gson mapear automaticamente.

---

## Bibliotecas e Frameworks em Java

**Bibliotecas** são coleções de classes prontas que você importa para usar funcionalidades específicas no seu projeto — como o Gson para converter JSON, por exemplo. São distribuídas como arquivos `.jar` e gerenciadas pelo Maven ou Gradle.

**Frameworks** vão além: fornecem uma arquitetura inteira para sua aplicação, com regras e padrões que guiam como você deve organizar o código.

| | Biblioteca | Framework |
|---|---|---|
| **O que fornece** | Funcionalidades prontas | Arquitetura + funcionalidades |
| **Quem manda** | Você chama quando quiser | O framework define a estrutura |
| **Exemplo** | Gson, Jackson | Spring, Hibernate |

### Frameworks populares em Java

| Framework | Para que serve |
|---|---|
| **Spring** | Criação de aplicações Web e APIs REST complexas |
| **Hibernate** | Integração com banco de dados relacional — mapeia objetos Java para tabelas automaticamente |

> Bibliotecas e frameworks são assuntos mais avançados. Antes de mergulhar neles, é importante ter uma boa base de Java e Orientação a Objetos.

---

## Record — classe imutável em uma linha

Lançado oficialmente no **Java 16** (experimental desde o Java 14), o `record` permite criar uma classe imutável de forma simples e enxuta — ideal para objetos que só carregam dados, sem comportamento.

### Sem record — muito código

```java
public final class Telefone {
    private final String ddd;
    private final String numero;

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() { return this.ddd; }
    public String getNumero() { return this.numero; }

    @Override
    public int hashCode() { return Objects.hash(ddd, numero); }

    @Override
    public boolean equals(Object obj) { ... }
}
```

### Com record — uma linha

```java
public record Telefone(String ddd, String numero) {}
```

O Java gera automaticamente por baixo dos panos:

| O que gera | Descrição |
|---|---|
| Atributos `private final` | Imutáveis por padrão |
| Construtor | Com todos os atributos |
| Getters | `ddd()` e `numero()` |
| `equals` e `hashCode` | Comparação por valor |
| `toString` | Representação legível |

### Quando usar?

Use `record` quando o objeto só vai **receber dados e ser lido**, sem precisar alterar nada depois — como dados vindos de uma API.

```java
// Perfeito para mapear resposta de API com Gson
public record TituloOmdb(String title, String year, String runtime) {}
```

> **Limitação:** sem setters — os valores são definidos na criação e não mudam.

---

## Imutabilidade

Um objeto imutável **não pode ser alterado depois de criado**. Classes como `String`, `Integer` e `Boolean` já são imutáveis por padrão em Java.

### Com record fica óbvio

```java
public record Estudante(String nome, int idade) {}

Estudante estudante1 = new Estudante("Alice", 19);

estudante1.setNome("Maria"); // ERRO — não existe setter
estudante1.nome = "Maria";   // ERRO — atributo final
```

Uma vez criado, os valores não mudam.

### Mas a String não é imutável? Então por que isso funciona?

```java
String nome = "Maria";
nome = "Alice"; // funciona?
```

Funciona, mas **não altera o objeto** — cria um novo objeto `String` com `"Alice"` e a variável passa a apontar para ele. O objeto `"Maria"` continua existindo na memória, apenas sem referência.

```
nome ──→ "Maria"     (objeto original, não foi alterado)
nome ──→ "Alice"     (novo objeto criado, variável agora aponta para ele)
```

### Por que imutabilidade é importante?

| Vantagem | Por quê |
|---|---|
| **Concorrência** | Sem necessidade de sincronização — vários threads podem ler sem risco |
| **Segurança** | Protege contra alterações acidentais ou mal-intencionadas |
| **Desempenho** | Objetos podem ser armazenados em cache e reutilizados |

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

---

## O que são bibliotecas Java?

Uma **biblioteca** é um conjunto de classes prontas que você adiciona ao projeto para usar funcionalidades que não existem por padrão no Java. Em vez de escrever do zero, você reutiliza código já criado, testado e mantido pela comunidade.

Exemplos:
- **Gson** → converte JSON em objetos Java e vice-versa
- **Jackson** → mesma função, mais usado em projetos Spring
- **OkHttp** → cliente HTTP mais simples que o nativo do Java

> A biblioteca não define como seu projeto é organizado — você a usa quando e como quiser. Isso a diferencia de um Framework.

---

## Como instalar o Gson — via arquivo `.jar`

Antes de ferramentas como Maven e Gradle, o jeito de usar uma biblioteca era baixar o arquivo `.jar` manualmente e adicioná-lo ao projeto.

**Passo a passo no IntelliJ:**

1. Acesse [mvnrepository.com](https://mvnrepository.com) e pesquise por `Gson`
2. Escolha a versão desejada e clique em **jar** para baixar o arquivo
3. No IntelliJ, abra: `File → Project Structure → Modules → Dependencies`
4. Clique em `+` → `JARs or Directories` e selecione o arquivo `.jar` baixado
5. Confirme com `Apply` → `OK`

A partir daí, as classes do Gson ficam disponíveis para importação no projeto.

> **Hoje o jeito mais comum é via Maven:** basta declarar a dependência no `pom.xml` e o Maven baixa e configura o jar automaticamente.

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
</dependency>
```

---

## Usando o Gson para converter JSON em objeto Java

Com o Gson, você converte uma `String` JSON em um objeto Java em duas etapas:

**1. Criar uma classe ou record que represente os campos do JSON**

```java
public record Pessoa(String nome, int idade, String cidade) {}
```

Os nomes dos campos precisam ser **iguais** às chaves do JSON.

**2. Usar `gson.fromJson()` para converter**

```java
String json = "{\"nome\":\"Rodrigo\",\"idade\":20,\"cidade\":\"Brasília\"}";

Gson gson = new Gson();
Pessoa pessoa = gson.fromJson(json, Pessoa.class);

System.out.println(pessoa.nome());   // Rodrigo
System.out.println(pessoa.idade());  // 20
```

Se os nomes do JSON não baterem com os atributos da classe, use a anotação `@SerializedName`:

```java
public class Titulo {
    @SerializedName("Title")   // chave no JSON é "Title" (maiúsculo)
    private String nome;       // mas o atributo Java é "nome"
}
```

---

## Flexibilizando a conversão com GsonBuilder

Por padrão, o `new Gson()` é estrito. Para cenários onde o JSON pode ter campos ausentes ou formato menos rígido, use o `GsonBuilder` para configurar o comportamento antes de criar o Gson:

```java
Gson gson = new GsonBuilder()
        .setLenient()   // tolerante a campos ausentes e formato flexível
        .create();
```

### Comportamentos com `GsonBuilder`

| Situação | Sem configuração | Com `setLenient()` |
|---|---|---|
| Campo ausente no JSON | Usa valor padrão (`0`, `null`) | Usa valor padrão, sem erro |
| Campo extra no JSON | Ignora (já é padrão) | Ignora |
| JSON com formato impreciso | Pode lançar erro | Aceita |

### Troque `int` por `Integer` para detectar campos ausentes

```java
public record Pessoa(String nome, Integer idade, String cidade) {}
//                                ^^^^^^^
// Se "idade" não vier no JSON → null (e não 0)
// Isso permite saber se o campo realmente estava ausente
```

| Tipo | Campo ausente no JSON vira |
|---|---|
| `int` | `0` — não dá para saber se veio ou estava faltando |
| `Integer` | `null` — explícito que não veio |

---

## Hierarquia de Exceções no Java

Todas as exceções do Java seguem uma hierarquia de classes. Entender essa hierarquia é essencial para saber o que capturar e em qual ordem.

```
Throwable
├── Error                        → erros irrecuperáveis do sistema
│   └── OutOfMemoryError
│   └── StackOverflowError
└── Exception                    → problemas que o código pode tratar
    ├── IOException              → checked (verificada)
    │   └── FileNotFoundException
    ├── SQLException             → checked (verificada)
    └── RuntimeException         → unchecked (não verificada)
        ├── NullPointerException
        ├── IllegalArgumentException
        │   └── NumberFormatException
        └── IndexOutOfBoundsException
```

---

### Checked Exceptions (Verificadas)

São subclasses diretas de `Exception`. O compilador **obriga** você a tratá-las — com `try-catch` ou declarando `throws` na assinatura do método.

```java
// O compilador exige tratamento — IOException é checked
public void lerArquivo() throws IOException {
    // leitura de arquivo
}
```

Exemplo: `IOException` — problema de leitura ou escrita de dados (arquivo, rede).

---

### Unchecked Exceptions (Não Verificadas)

São subclasses de `RuntimeException`. O compilador **não obriga** tratamento — são erros lógicos no código que poderiam ser evitados.

| Exceção | Quando ocorre |
|---|---|
| `NullPointerException` | Acessar atributo ou método de um objeto `null` |
| `NumberFormatException` | Converter texto inválido para número (`"abc"` → `int`) |
| `IllegalArgumentException` | Passar argumento inválido para um método (ex: URI malformada) |
| `IndexOutOfBoundsException` | Acessar índice inexistente em lista ou array |

---

### Error

Representam falhas **irrecuperáveis** do sistema — não devem ser capturadas pelo código.

| Erro | O que significa |
|---|---|
| `OutOfMemoryError` | Java não conseguiu memória suficiente do sistema |
| `StackOverflowError` | Recursão infinita esgotou a pilha de execução |

---

### Ordem dos catch — mais específico primeiro

Como as exceções seguem herança, a ordem dos blocos `catch` importa. O mais específico (classe filha) sempre vem antes do mais genérico (classe mãe).

```java
try {
    // código
} catch (NumberFormatException e) {      // filha — mais específico
    System.out.println("Número inválido");
} catch (IllegalArgumentException e) {   // mãe — mais genérico
    System.out.println("Argumento inválido");
}
```

Se inverter a ordem, o `catch (IllegalArgumentException)` captura tudo — inclusive o `NumberFormatException` — e o primeiro `catch` nunca executa. O compilador até avisa sobre isso.

> **Regra:** filha antes da mãe. Específico antes do genérico.

---

### Exemplo prático — IOException e FileNotFoundException

```java
try {
    // abre um arquivo
} catch (FileNotFoundException e) {    // filha — arquivo não encontrado
    System.out.println("Arquivo não existe");
} catch (IOException e) {             // mãe — qualquer outro erro de I/O
    System.out.println("Erro de leitura");
}
```

Um `catch (IOException)` sozinho também capturaria o `FileNotFoundException` — pois toda `FileNotFoundException` é uma `IOException`. Mas o inverso não vale: `catch (FileNotFoundException)` **não** captura `IOException`.

---

## Multi-catch — capturando várias exceções em um bloco só

Introduzido no **Java 7**, o multi-catch permite agrupar exceções diferentes num único `catch` usando o `|`, evitando repetição de código quando o tratamento é o mesmo.

**Sem multi-catch — repetição:**
```java
try {
    metodoQuePodeLancarExcecao();
} catch (NumberFormatException e) {
    System.out.println("tratando erro...");
} catch (IllegalArgumentException e) {
    System.out.println("tratando erro...");
}
```

**Com multi-catch — conciso:**
```java
try {
    metodoQuePodeLancarExcecao();
} catch (NullPointerException | IllegalArgumentException e) {
    System.out.println("tratando erro...");
}
```

Se qualquer uma das exceções listadas for lançada, o mesmo bloco `catch` é executado.

### Regra importante

Multi-catch **não é permitido** entre exceções que têm relação de herança entre si. O compilador rejeita porque a mais genérica já capturaria a mais específica:

```java
// ❌ não compila — NumberFormatException é filha de IllegalArgumentException
} catch (NumberFormatException | IllegalArgumentException e) { }

// ✅ correto — NullPointerException e IllegalArgumentException não têm herança entre si
} catch (NullPointerException | IllegalArgumentException e) { }
```

---

## Stack Trace — lendo o rastro do erro

Quando o Java lança uma exceção sem tratamento, ele imprime no console um **stack trace** — o rastro da pilha de execução. Parece assustador no começo, mas contém tudo que você precisa para encontrar o problema.

```
Exception in thread "main" java.lang.NumberFormatException: For input string: "2018-"
    at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
    at java.base/java.lang.Integer.parseInt(Integer.java:668)
    at java.base/java.lang.Integer.valueOf(Integer.java:999)
    at br.com.alura.screenmatch.modelos.Titulo.<init>(Titulo.java:22)
    at br.com.alura.screenmatch.principal.PrincipalComBusca.main(PrincipalComBusca.java:40)
```

### Como ler — de baixo para cima

| Linha | O que significa |
|---|---|
| Última linha | **Onde o problema começou** — seu código, arquivo e linha |
| Penúltima | Próximo método chamado — `<init>` significa o construtor |
| Demais linhas | Chamadas internas do Java até o ponto onde a exceção foi lançada |
| Primeira linha | **Nome da exceção** e a mensagem de erro |

**Leitura do exemplo acima:**
1. `PrincipalComBusca.java:40` → o problema começa aqui: `new Titulo(meuTituloOmdb)`
2. `Titulo.java:22` → dentro do construtor: `Integer.valueOf(meuTituloOmdb.year())`
3. Java tentou converter `"2018-"` para inteiro → impossível → `NumberFormatException`

> Na IDE você pode clicar no link `(Titulo.java:22)` e ela abre direto na linha do problema.

---

## Try/Catch — tratando exceções

O `try/catch` permite especificar o que fazer quando uma exceção ocorre, em vez de deixar o programa parar.

```java
try {
    // código que pode lançar exceção
    Titulo meuTitulo = new Titulo(meuTituloOmdb);
    System.out.println("Titulo convertido");
    System.out.println(meuTitulo);
} catch (NumberFormatException e) {
    // o que fazer se der erro
    System.out.println("Aconteceu um erro: ");
    System.out.println(e.getMessage());
}

System.out.println("O programa finalizou corretamente!");
```

**Resultado quando há erro:**
```
Aconteceu um erro:
For input string: "2018-"
O programa finalizou corretamente!
```

Sem o `try/catch`, o programa pararia na exceção e não chegaria à última linha. Com ele, o erro é capturado e a execução continua normalmente.

### Escopo — variáveis dentro do try

Uma variável declarada **dentro** do `try` só existe dentro dele:

```java
try {
    Titulo meuTitulo = new Titulo(meuTituloOmdb); // existe só aqui dentro
    System.out.println(meuTitulo); // ✅ funciona
}
System.out.println(meuTitulo); // ❌ erro de compilação — fora do escopo
```

Por isso, tudo que depende de `meuTitulo` precisa estar dentro do mesmo bloco `try`.
