package br.com.alura.trilha03.desafio;

public class NumeroPrimo {
    public boolean verificarPrimalidade(int numero){
        if( numero <= 1) {
            return false;
        }

        for (int i = 2; i * i < numero ; i++) {
            if (numero % i == 0){
                return false;
            }
            
        }

        return true;
    }

    public void listarNumeros(int limitarNumeros) {
        System.out.println("Números primos até " + limitarNumeros + ":");

        for (int i = 2; i < limitarNumeros ; i++) {
            if(verificarPrimalidade(i)){
                System.out.println(i + "");
            }
            
        }
    }
}
