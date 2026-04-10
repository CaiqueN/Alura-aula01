package br.com.alura.trilha02.screenmatch.aula01.principal.desafio;

public class AlunoDoisMain {
    public static void executar(){
        Aluno aluno = new Aluno();

        aluno.setNome("Italo");
        aluno.setNota(7.5);
        aluno.setNota2(8.9);
        aluno.setNota3(10.0);
        aluno.setNota4(6.5);

        System.out.println("Nome do aluno: " + aluno.getNome());
        System.out.println("Nota: " + aluno.getNota());
        System.out.println("Nota 2: " + aluno.getNota2());
        System.out.println("Nota 3: " + aluno.getNota3());
        System.out.println("Nota 4: " + aluno.getNota4());
        System.out.println("");
        System.out.println("Calcular a medias das notas: " + aluno.mediaCalculada());

    }
}
