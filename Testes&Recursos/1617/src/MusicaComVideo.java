import java.time.LocalDateTime;
import java.util.ArrayList;

public class MusicaComVideo extends Faixa{
    private String video;

    public MusicaComVideo(String nome, String autor, double duracao, int classificacao, ArrayList<String> letra, int numeroVezesTocada, LocalDateTime utlimaVez, String video) {
        super(nome, autor, duracao, classificacao, letra, numeroVezesTocada, utlimaVez);
        this.video = video;
    }

    public void play() {
        super.play();
        System.out.println(video);
    }
}
