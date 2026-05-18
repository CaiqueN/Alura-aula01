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
