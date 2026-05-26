package br.com.alura.consumindo.api.consumindoapi.desafio_trilha2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversaoJson {
    public static void executar() {

        String jsonPessoa = "{\"nome\":\"Rodrigo\",\"cidade\":\"Brasília\"}";

        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);

        System.out.println("Objeto Pessoa: " + pessoa);

    }
}
