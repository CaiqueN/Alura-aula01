package java_trilha_01.aula03;

import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double mediaAvaliacao = 0;
            double nota = 0;
            int total = 0;

            while (nota != -1) {
                System.out.println("Digite uma nota para o anime ou -1 para encerrar");
                nota = scanner.nextDouble();

                if(nota != -1){
                    mediaAvaliacao += nota;
                    total++;
                }

            }

            System.out.println("Media de avaliacao" + mediaAvaliacao / total);

    }
}
