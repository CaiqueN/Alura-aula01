package br.com.alura.trilha04.desafio;

public class ConversorMoeda implements ConversaoFinanceira{

    @Override
    public void conversaoParaReal(double valorDolar) {
        double cotaDolar =  5.00;
        double valorReal = valorDolar * cotaDolar;
        System.out.println("Valor na moeda brasileira é: R$" + valorReal);
    }
}
