package java_trilha_02.aula01;

public class PrincipalFilme {
    public static void executar() {

        //Assim que instancia um objeto
        Filme filme = new Filme();
        filme.nome = "Dragon ball Broly";
        filme.anoDeLancamento = 2019;
        filme.duracaoMinutos = 180;

        filme.exibeFichaTecnica();
        filme.avaliacao(8);
        filme.avaliacao(10);
        filme.avaliacao(5);

        System.out.println(filme.somaAvaliacao);
        System.out.println(filme.totalDeAvaliacao);
        System.out.println(filme.media());

    }

}
