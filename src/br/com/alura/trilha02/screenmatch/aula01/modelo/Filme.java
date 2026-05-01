package br.com.alura.trilha02.screenmatch.aula01.modelo;

import br.com.alura.trilha03.Titulo;
import br.com.alura.trilha04.aula.Classificavel;

public class Filme extends Titulo implements Classificavel {
    String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return super.getDuracaoEmMinutos();
    }

    @Override
    public int getClassificacao() {
        return (int) (media()) /2;
    }
}
