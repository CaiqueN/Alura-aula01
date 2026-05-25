package br.com.alura.trilha05.exercicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExercicioGsonMain {

    public static void main(String[] args) {

        // Exercício 1 — JSON completo para Pessoa
        String jsonPessoa = """
                {
                  "nome": "João",
                  "idade": 30,
                  "cidade": "São Paulo"
                }
                """;

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);
        System.out.println("=== Exercício 1 — Pessoa ===");
        System.out.println("Nome: " + pessoa.nome());
        System.out.println("Idade: " + pessoa.idade());
        System.out.println("Cidade: " + pessoa.cidade());

        // Exercício 2 — JSON com campos ausentes e campos extras
        // Gson ignora campos extras e deixa null/0 nos ausentes por padrão
        String jsonParcial = """
                {
                  "nome": "Maria",
                  "cidade": "Rio de Janeiro",
                  "profissao": "Engenheira"
                }
                """;

        Pessoa pessoaParcial = gson.fromJson(jsonParcial, Pessoa.class);
        System.out.println("\n=== Exercício 2 — Campos ausentes/extras ===");
        System.out.println("Nome: " + pessoaParcial.nome());
        System.out.println("Idade: " + pessoaParcial.idade());   // 0 — ausente no JSON
        System.out.println("Cidade: " + pessoaParcial.cidade());
        // "profissao" foi ignorado — não existe no record Pessoa

        // Exercício 3 — JSON aninhado para Livro
        String jsonLivro = """
                {
                  "titulo": "Clean Code",
                  "autor": "Robert C. Martin",
                  "editora": {
                    "nome": "Prentice Hall",
                    "pais": "Estados Unidos"
                  }
                }
                """;

        Livro livro = gson.fromJson(jsonLivro, Livro.class);
        System.out.println("\n=== Exercício 3 — Livro com JSON aninhado ===");
        System.out.println("Título: " + livro.titulo());
        System.out.println("Autor: " + livro.autor());
        System.out.println("Editora: " + livro.editora().nome());
        System.out.println("País da editora: " + livro.editora().pais());
    }
}
