package java_trilha_01.aula03;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double mediaAvaliacao = 0;
        double nota = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite uma nota para o anime");
            nota = scanner.nextDouble();
            mediaAvaliacao += nota;
        }

        System.out.println("Media de avaliacao" + mediaAvaliacao / 3);

    }

}
