import java.io.*;

public class GrowingArrayOfActividade implements Serializable{
    private Actividade[] lista;
    private int tamanho;

    public Actividade get(int indice) throws InvalidIndexException{
        if(indice >= tamanho || indice < 0) throw new InvalidIndexException();
        else return this.lista[indice].clone();
    }

    public void add(Actividade a){
        if(this.lista.length == this.tamanho){
            Actividade[] newLista = new Actividade[this.lista.length * 2];
            this.tamanho = newLista.length;
            System.arraycopy(this.lista, 0, newLista, 0, this.lista.length);
            this.lista = newLista;
        }
        this.lista[this.tamanho++] = a.clone();
    }

    public static GrowingArrayOfActividade leGrowingArrayOfActividade(String fich) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
        GrowingArrayOfActividade g = (GrowingArrayOfActividade) ois.readObject();
        ois.close();
        return g;
    }
}
