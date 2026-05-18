# Exercício 1 — Endpoint de Registro de Frutas

## O que é esse exercício?

Criar uma API REST em Java Spring Boot que registra frutas. O endpoint recebe os dados da fruta, valida, salva no banco (KVS do Fury) e retorna o objeto criado.

---

## O Endpoint

| Verbo | Rota     | Header obrigatório |
|-------|----------|--------------------|
| POST  | /fruits  | Owner: string      |

### Request Body (o que chega)
```json
{
    "name": "maçã",
    "quantity": 12,
    "price": 1000
}
```

### Response Body (o que volta)
```json
{
    "id": "uuid",
    "name": "maçã",
    "quantity": 12,
    "price": 1000,
    "date_created": "2022-01-01T00:00-03:00",
    "date_last_updated": "2022-01-01T00:00-03:00",
    "owner": "test",
    "status": "comestível"
}
```

> O response tem mais campos que o request porque alguns são gerados automaticamente (id, datas, status).

---

## Regras de Validação

| Campo      | Regra                                      | Anotação Java         |
|------------|--------------------------------------------|-----------------------|
| `name`     | Não pode ser vazio                         | `@NotBlank`           |
| `name`     | Sem números ou caracteres especiais        | `@Pattern`            |
| `quantity` | Número inteiro maior que 0                 | `@Min(1)`             |
| `price`    | Número decimal maior que 0                 | `@DecimalMin("0.01")` |
| `owner`    | Header não pode estar vazio                | Validado no controller|

---

## Estrutura de Classes

```
FruitController   → recebe a requisição HTTP
FruitService      → lógica de negócio
FruitRepository   → salva no KVS
FruitRequest      → DTO com os dados que chegam (name, quantity, price)
Fruit             → modelo completo com todos os atributos
```

> **DTO** (Data Transfer Object) = classe que serve só para transportar dados, sem lógica. `FruitRequest` é um DTO.

---

## O Código

### FruitRequest.java — valida o que chega
```java
public class FruitRequest {

    @NotBlank(message = "name não pode ser vazio")
    @Pattern(regexp = "^[a-zA-ZÀ-ú ]+$", message = "name não pode ter números ou caracteres especiais")
    private String name;

    @NotNull
    @Min(value = 1, message = "quantity deve ser maior que 0")
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0.01", message = "price deve ser maior que 0")
    private Double price;

    // getters e setters
}
```

### Fruit.java — modelo com todos os atributos
```java
public class Fruit {
    private String id;                       // gerado automaticamente (UUID)
    private String name;                     // vem do request
    private Integer quantity;                // vem do request
    private Double price;                    // vem do request
    private OffsetDateTime dateCreated;      // gerado automaticamente
    private OffsetDateTime dateLastUpdated;  // gerado automaticamente
    private String owner;                    // vem do header
    private String status;                   // sempre "comestível" por padrão

    // getters e setters
}
```

### FruitController.java — recebe a requisição
```java
@RestController
@RequestMapping("/fruits")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping
    public ResponseEntity<Fruit> create(
            @RequestHeader("Owner") String owner,
            @RequestBody @Valid FruitRequest request) {

        if (owner == null || owner.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Fruit fruit = fruitService.create(request, owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(fruit);
    }
}
```

### FruitService.java — lógica de negócio
```java
@Service
public class FruitService {

    private final FruitRepository fruitRepository;
    private final MetricsClient metricsClient;

    public FruitService(FruitRepository fruitRepository, MetricsClient metricsClient) {
        this.fruitRepository = fruitRepository;
        this.metricsClient = metricsClient;
    }

    public Fruit create(FruitRequest request, String owner) {

        // 1. Monta o objeto
        Fruit fruit = new Fruit();
        fruit.setId(UUID.randomUUID().toString());  // gera UUID único
        fruit.setName(request.getName());
        fruit.setQuantity(request.getQuantity());
        fruit.setPrice(request.getPrice());
        fruit.setOwner(owner);
        fruit.setStatus("comestível");               // sempre esse valor por padrão
        fruit.setDateCreated(OffsetDateTime.now());
        fruit.setDateLastUpdated(OffsetDateTime.now());

        // 2. Salva no KVS
        fruitRepository.save(fruit.getId(), fruit);

        // 3. Envia métrica ao Datadog
        metricsClient.count("rampup.onboarding.{nome_do_time}.fruit", 1, "action:save");

        return fruit;
    }
}
```

### FruitRepository.java — salva no KVS
```java
@Repository
public class FruitRepository {

    private final KvsClient kvsClient;

    public FruitRepository(KvsClient kvsClient) {
        this.kvsClient = kvsClient;
    }

    public void save(String id, Fruit fruit) {
        kvsClient.set(id, fruit);
    }
}
```

---

## Fluxo Completo

```
1. Chega POST /fruits com Header Owner e Body (name, quantity, price)
         ↓
2. Controller valida o header Owner
         ↓
3. @Valid valida o body (name, quantity, price)
         ↓
4. Service monta o objeto Fruit com:
   - UUID gerado automaticamente
   - Datas de criação e atualização (agora)
   - Status "comestível" fixo
   - Owner vindo do header
         ↓
5. Salva no KVS do Fury
         ↓
6. Envia métrica ao Datadog
         ↓
7. Retorna 201 com o objeto completo
```

---

## Conceitos Importantes

### JSON
Formato de troca de dados. Cada linha é um par `chave: valor`.
```json
"name": "maçã"   →  chave: name  |  valor: maçã
```
Toda vez que ver um JSON de response, cada campo vira um atributo na classe Java.

### UUID
Identificador único universal. Garante que cada fruta tenha um ID diferente de todas as outras.
```java
UUID.randomUUID().toString()  // ex: "550e8400-e29b-41d4-a716-446655440000"
```

### OffsetDateTime
Tipo Java para data e hora com fuso horário. Usado nos campos `date_created` e `date_last_updated`.
```java
OffsetDateTime.now()  // pega a data e hora atual
```

### snake_case vs camelCase
O JSON usa `date_created` (snake_case) mas Java usa `dateCreated` (camelCase).
Para o Spring converter automaticamente:
```properties
# application.properties
spring.jackson.property-naming-strategy=SNAKE_CASE
```

### Status HTTP
| Código | Significado |
|--------|-------------|
| 201    | Created — recurso criado com sucesso |
| 400    | Bad Request — dados inválidos |

---

## KVS (Key Value Store)
Banco de dados simples do Fury. Funciona como um dicionário:
- **Chave** → ID da fruta (UUID)
- **Valor** → objeto Fruit completo

```
"550e8400-..."  →  { name: "maçã", quantity: 12, ... }
```

---

## Métrica no Datadog
Após salvar, enviamos um contador para monitoramento:
```
Nome:  rampup.onboarding.{nome_do_time}.fruit
Tag:   action:save
```
Serve para saber quantas frutas foram criadas e monitorar se o sistema está funcionando.
