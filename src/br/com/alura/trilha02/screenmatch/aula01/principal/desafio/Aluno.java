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
        if(nota >= 6 && nota <=10){
            this.nota = nota;
            System.out.println("Aluno aprovado");
        } else if(nota >=1 && nota <=5){
            System.out.println("Aluno reprovado");
        } else {
            System.out.println("Aluno reprovado por faltas");
        }
    }

    public double getNota() {
        return nota;
    }

    public void setNota2(double nota2) {
        if(nota2 >= 6 && nota2 <=10){
            this.nota2 = nota2;
            System.out.println("Aluno aprovado");
        } else if(nota2 >=1 && nota2 <=5){
            System.out.println("Aluno reprovado");
        } else {
            System.out.println("Aluno reprovado por faltas");
        }
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota3(double nota3) {
        if(nota3 >= 6 && nota3 <=10){
            this.nota3 = nota3;
            System.out.println("Aluno aprovado");
        } else if(nota3 >=1 && nota3 <=5){
            System.out.println("Aluno reprovado");
        } else {
            System.out.println("Aluno reprovado por faltas");
        }
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota4(double nota4) {
        if(nota4 >= 6 && nota4 <=10){
            this.nota4 = nota4;
            System.out.println("Aluno aprovado");
        } else if(nota4 >=1 && nota4 <=5){
            System.out.println("Aluno reprovado");
        } else {
            System.out.println("Aluno reprovado por faltas");
        }
    }

    public double getNota4() {
        return nota4;
    }

    public double mediaCalculada() {
        return (nota + nota2 + nota3 + nota4) / 4;
    }
}