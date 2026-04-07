package java_trilha_02.aula01.desafio;

public class MusicaMain {
    public static void executar() {
        Musica lista = new Musica();
        lista.titulo = "Nome da musica";
        lista.artista = "Claude";
        lista.anoDeLancamento = 2026;

        lista.exibirFichaTecnica();

        lista.avalia(3.5);
        lista.avalia(7.6);
        lista.avalia(5.7);

        double mediaPega = lista.media();
        System.out.println("Media de avaliações " + mediaPega);
    }
}
