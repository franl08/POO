import java.io.*;
import java.util.List;
import java.util.Map;

public class AgenciaViagens {
    private Map<String, Hotel> hoteis;
    private Map<String, List<Integer>> nifs;

    public void gravaTXT(String tipo, String nomeFicheiro) throws IOException {
        try{
            FileOutputStream fs = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            for(Hotel h : hoteis.values())
                if(h.getClass().toString().split(" ")[1].equals(tipo)){
                    if(nifs.containsKey(h.getCodigo()))
                        if(!nifs.get(h.getCodigo()).isEmpty())
                            oos.writeObject(h);
                }
            oos.flush();
            oos.close();
        }
        catch (IOException i){
            i.printStackTrace();
        }
    }

    public AgenciaViagens readFicheiro(String nomeFicheiro) throws IOException, ClassNotFoundException{
        try {
            FileInputStream fs = new FileInputStream(nomeFicheiro);
            ObjectInputStream ois = new ObjectInputStream(fs);
            return (AgenciaViagens) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new AgenciaViagens();
    }
}
