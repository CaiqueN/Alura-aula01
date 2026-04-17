package br.com.alura.trilha03.desafio;

public class AnimalMain {
    public static void executar(){
        Cachorro cao = new Cachorro();
        cao.emitirSom();
        cao.abanarRabo();

        Gato felino = new Gato();
        felino.emitirSom();
        felino.arranharSofa();
    }
}
