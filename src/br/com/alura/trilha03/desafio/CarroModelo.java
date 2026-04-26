package br.com.alura.trilha03.desafio;

public class CarroModelo {
    public static void executar() {
        Carro carro = new Carro();

        Carro2 carro2 = new Carro2();
        carro2.setModelo("Uno");

        carro.setModelo("Honda");
        carro.setPreco1(30);
        carro.setPreco2(40);
        carro.setPreco3(50);

        System.out.println("Carro 2" + carro2.getModelo());
        System.out.println("Modelo do carro: " + carro.getModelo());
        System.out.println("Primeiro ano o preço foi: " + carro.getPreco1());
        System.out.println("Segundo ano o preço foi: " + carro.getPreco2());
        System.out.println("Terceiro ano o preço foi: " + carro.getPreco3());

        System.out.println("Menor preço: " + carro.getMenorPreco());
        System.out.println("Maior preço: " + carro.getMaiorPreco());
    }
}
