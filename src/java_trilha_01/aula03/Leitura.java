package java_trilha_01.aula03;

import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do anime");
        String anime = scanner.nextLine();
        System.out.println(anime);
        System.out.println("Digite o ano de lançamento");
        int anoLancamento = scanner.nextInt();
        System.out.println(anoLancamento);
        System.out.println("Atribua uma nota a esse anime");
        double nota = scanner.nextDouble();
        System.out.println(nota);

        scanner.close();

    }
}
