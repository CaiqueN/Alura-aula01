package java_trilha_02.aula01.desafio;

public class CarroMain {
    public static void executar() {
        Carro meuCarro = new Carro();
        meuCarro.modelo = "Gol";
        meuCarro.ano = 2023;
        meuCarro.cor = "Preto";

        meuCarro.exibeFichaTecnica();

        System.out.println("Idade do carro: " + meuCarro.calculaIdade() + " anos");
    }
}
