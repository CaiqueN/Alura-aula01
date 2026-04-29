package br.com.alura.trilha04.desafio;

public class CalculadoraRetangular implements CalculoGeometrico{

    @Override
    public void calcularArea(double altura, double largura) {
        double area = altura * largura;
        System.out.println("Area retangular é: " + area);
    }

    @Override
    public void calcularPerimetro(double altura, double largura) {
       double perimetro = 02 * (altura * largura);
        System.out.println("A area do perimetro é: " + perimetro);
    }
}
