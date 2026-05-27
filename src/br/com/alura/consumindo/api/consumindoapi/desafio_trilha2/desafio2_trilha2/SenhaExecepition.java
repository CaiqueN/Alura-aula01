package br.com.alura.consumindo.api.consumindoapi.desafio_trilha2.desafio2_trilha2;

public class SenhaExecepition extends RuntimeException {
    public static class SenhaInvalidaException extends RuntimeException {

        public SenhaInvalidaException(String mensagem) {
            super(mensagem);
        }
    }
}