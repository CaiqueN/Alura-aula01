package java_trilha_01.aula03;

public class Condicional {
    public static void main(String[] args) {
        int anoDeLancamento = 2022;
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;
        String plano ="Plus";

        if(anoDeLancamento >= 2022){
            System.out.println("Lançamento mais vistos!");
        }else {
            System.out.println("Filme que vale a pena assistir!");
        }

        if (incluidoNoPlano && plano.equals("Plus")) {
            System.out.println("acesso liberado");
        }else {
            System.out.println("deve pagar a entrada");
        }

        if(notaDoFilme >= 8.1){
            System.out.println("Nota positiva");
        }else {
            System.out.println("Nota negativa");
        }
    }
}
