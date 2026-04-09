package br.com.alura.trilha02.screenmatch.aula01.modelo;

public class Filme {
    private String nome;
    private int anoDeLancamento;
    private boolean incluindoPlano;
    private double somaAvaliacao;
    private int totalDeAvaliacao;
    private int duracaoMinutos;

    public int getTotalDeAvaliacao() {
        return totalDeAvaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluindoPlano() {
        return incluindoPlano;
    }

    public void setIncluindoPlano(boolean incluindoPlano) {
        this.incluindoPlano = incluindoPlano;
    }

    public double getSomaAvaliacao() {
        return somaAvaliacao;
    }

    public void setSomaAvaliacao(double somaAvaliacao) {
        this.somaAvaliacao = somaAvaliacao;
    }

    public void setTotalDeAvaliacao(int totalDeAvaliacao) {
        this.totalDeAvaliacao = totalDeAvaliacao;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " +anoDeLancamento);
    }

    public void avaliacao (double nota) {
        somaAvaliacao += nota;
        totalDeAvaliacao ++;
    }

    public double media () {
        return somaAvaliacao / totalDeAvaliacao;
    }
}
