package br.com.alura.trilha02.screenmatch.aula01.principal.desafio;

public class Aluno {
    private String nome;
    private double nota;
    private double nota2;
    private double nota3;
    private double nota4;


    public Aluno() {
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getNota4() {
        return nota4;
    }


    public double mediaCalculada() {
        return (nota + nota2 + nota3 + nota4) / 4;
    }
}