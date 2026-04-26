package br.com.alura.trilha03.desafio;

public class TesteNumeroPrimo {
    public static void executar(){
        VerificarNumeroPrimo cheque = new VerificarNumeroPrimo();

        cheque.verificarNumeroPrimo(12);

        GeradorNumero gerar = new GeradorNumero();
        int proximoNumero = gerar.geradorNumero(18);
        System.out.println("Proximo numero após 18 ë: " + proximoNumero);

        NumeroPrimo primo = new NumeroPrimo();
        primo.listarNumeros(50);
    }
}
