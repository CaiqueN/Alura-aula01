package java_trilha_02.aula01;

public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluindoPlano;
    double somaAvaliacao;
    int totalDeAvaliacao;
    int duracaoMinutos;

    void exibeFichaTecnica(){
        System.out.println("Nome do filme" + nome);
        System.out.println("Ano de lançamento" +anoDeLancamento);
    }

    void avaliacao (double nota) {
        somaAvaliacao += nota;
        totalDeAvaliacao ++;
    }

    double media () {
        return somaAvaliacao / totalDeAvaliacao;
    }
}
