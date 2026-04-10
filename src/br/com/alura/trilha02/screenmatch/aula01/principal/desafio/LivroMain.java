package br.com.alura.trilha02.screenmatch.aula01.principal.desafio;

public class LivroMain {
    public static void executar() {
        Livro lib = new Livro();

        lib.setTitulo("Novel Naruto");
        lib.setAutor("Kishimoto");

        System.out.println("Nome do livro clássico de Naruto: " + lib.getTitulo());
        System.out.println("Nome do Autor do livro clássico de Naruto: " + lib.getAutor())
        ;
    }
}
