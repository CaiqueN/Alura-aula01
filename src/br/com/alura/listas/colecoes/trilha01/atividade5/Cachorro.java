package br.com.alura.listas.colecoes.trilha01.atividade5;

public class Cachorro extends Animal {
    public static void executar () {
        Animal animal = new Cachorro();

        if (animal instanceof Cachorro) {
            Cachorro cachorro = (Cachorro) animal;
        }else {
            System.out.println("O objeto não é um Cachorro.");
        }
    }

}
