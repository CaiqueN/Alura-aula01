package br.com.alura.trilha03.desafio;

public class GeradorNumero extends NumeroPrimo {
    public int geradorNumero (int ultimoNumero){
        int proximoNumero = ultimoNumero + 1;
        while (!verificarPrimalidade(proximoNumero)){
            proximoNumero++;
        }

        return proximoNumero;
    }
}
