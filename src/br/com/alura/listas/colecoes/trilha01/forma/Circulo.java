package br.com.alura.listas.colecoes.trilha01.forma;

public class Circulo implements Forma{
    double raio;

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
