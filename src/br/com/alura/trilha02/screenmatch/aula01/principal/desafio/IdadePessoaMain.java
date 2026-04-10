package br.com.alura.trilha02.screenmatch.aula01.principal.desafio;

public class IdadePessoaMain {
    public static void executar() {
        IdadePessoa info = new IdadePessoa();

        info.setIdade(38);
        info.setNome("Pedro");

        System.out.println("Nome da pessoa: " + info.getNome());
        System.out.println("Idade da pessoa: " + info.getIdade());
    }
}
