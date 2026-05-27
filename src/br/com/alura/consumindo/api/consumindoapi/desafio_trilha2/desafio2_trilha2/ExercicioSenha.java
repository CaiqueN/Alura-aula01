package br.com.alura.consumindo.api.consumindoapi.desafio_trilha2.desafio2_trilha2;

import java.util.Scanner;

public class ExercicioSenha {
 public static void executar() {
     Scanner scanner = new Scanner(System.in);

     System.out.println("Digite sua senha: ");
     String senha = scanner.nextLine();

     try {
         validarSenha(senha);
         System.out.println("Senha válida. Acesso permitido.");
     } catch (SenhaExecepition.SenhaInvalidaException e) {
         System.out.println("Erro: " + e.getMessage());
     }
 }

    private static void validarSenha(String senha) {
        if (senha.length() < 8) {
            throw new SenhaExecepition.SenhaInvalidaException("A senha deve ter pelo menos 8 caracteres.");
        }
    }
 }

