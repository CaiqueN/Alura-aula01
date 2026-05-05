package br.com.alura.listas.colecoes.trilha01.atividade8;

public class Circulo implements Forma{
    double raio;

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
