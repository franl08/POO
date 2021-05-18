import java.io.Serializable;

public class Exercicio implements Serializable {
    private Actividade actividade;
    private String professor;
    private String codExercicio;

    public Exercicio clone(){
        return new Exercicio(); // não é assim, mas não é necessário codificar pq não é pedido
    }

    public Actividade getActividade(){
        return this.actividade.clone();
    }

    public String getProfessor(){
        return this.professor;
    }
}
