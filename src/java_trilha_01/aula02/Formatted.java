package java_trilha_01.aula02;

public class Formatted {
    public static void main(String[] args) {
        String nome = "Bruna";
        int aulas = 4;
        String mensagem = """
                  Olá, %s!
                  Boas vindas ao curso de Java.
                  Teremos %d aulas para te mostrar o que é preciso para você dar o seu primeiro mergulho na linguagem!
                  """.formatted(nome, aulas);

        System.out.println(mensagem);
    }
}
