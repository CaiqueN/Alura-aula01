package br.com.alura.trilha03.desafio;

public class Cachorro extends Animal{

    @Override
    public void emitirSom() {
        System.out.println("Som do Cachorro: Au-au");
    }

    public void abanarRabo() {
        System.out.println("Cachorro feliz");
    }
}
