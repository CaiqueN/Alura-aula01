package br.com.alura.trilha02.screenmatch.aula01.modelo;

import br.com.alura.trilha03.Titulo;

public class Filme extends Titulo {
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
}
