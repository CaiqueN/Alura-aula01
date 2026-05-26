package br.com.alura.consumindo.api.consumindoapi.desafio_trilha2;

import com.google.gson.Gson;

public class EditoraLivro {
      public static void executar() {
          String jsonLivro = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Naruto\"," +
                  "\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";

          Gson gson = new Gson();
          Livro livro = gson.fromJson(jsonLivro, Livro.class);

          System.out.println("Objeto Livro: " + livro);
      }
}
