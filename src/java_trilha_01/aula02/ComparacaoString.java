package java_trilha_01.aula02;

public class ComparacaoString {
    public static void main(String[] args) {
        String senha = "Corinthians@07";
        if (senha.equals("Corinthians@07")){
            System.out.println("Acesso autorizado a libertadores");
        }else {
            System.out.println("Acesso negado");
        }
    }
}
