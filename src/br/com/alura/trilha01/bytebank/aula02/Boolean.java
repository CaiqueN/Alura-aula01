package br.com.alura.trilha01.bytebank.aula02;

public class Boolean {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        if (a && b) {
            // Este código não será executado, já que a é verdadeiro e b é falso.
        }

        boolean c = true;
        boolean e = false;
        if (c || e) {
            // Este código será executado, já que a é verdadeiro, mesmo que b seja falso.
        }

        boolean f = true;
        if (!f) {
            // Este código não será executado, já que a é verdadeiro.
        }
    }
}
