package br.com.alura.trilha02.screenmatch.aula01.desafio.principal;

import br.com.alura.trilha02.screenmatch.aula01.desafio.modelo.Aluno;

public class AlunoMain  {
    public static void executar() {
        Aluno aluno = new Aluno();
        aluno.idade = 30;
        aluno.nome = "Nome do aluno";
        aluno.cpf = "12345678";
        aluno.escola = "Faculdade do aluno";
        aluno.endereco = "Endereço do aluno";

        aluno.exibirFichaAluno();
    }
}
