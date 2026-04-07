package java_trilha_02.aula01.desafio;

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
