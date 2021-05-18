import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {
    TreeMap<String, Lampada> lamps;

    public CasaInteligente(){
        this.lamps = new TreeMap<>();
    }

    public CasaInteligente(Collection<Lampada> novasLampadas){
        Iterator<Lampada> i = novasLampadas.iterator();
        while(i.hasNext()){
            Lampada l = i.next();
            this.lamps.put(l.getIdent(), l.clone());
        }
    }

    public int qtEmEco(){
        int ans = 0;
        if(this.lamps != null)
            for(Lampada l : this.lamps.values())
                if(l.getEstado() == 2) ans++;
        return ans;
    }

    public void removeLampada(String id) throws LampadaNaoExisteException{
        if(this.lamps == null || !this.lamps.containsKey(id)) throw new LampadaNaoExisteException("Não existe nenhuma lâmpada com ID " + id);
        else{
            this.lamps.remove(id);
        }
    }

    public double consumoTotal(){
        double ans = 0.0;
        if(this.lamps != null){
            for(Lampada l : this.lamps.values())
                ans += l.getConsumoTotal();
        }
        return ans;
    }

    public Set<String> topConsumo(int x){
        TreeSet<Lampada> ord = new TreeSet<>(new comparadorLampada());
        for(Lampada l : this.lamps.values())
            ord.add(l.clone());
        return ord.stream().map(Lampada::getIdent).limit(x).collect(Collectors.toSet());
    }

    class comparadorLampada implements Comparator<Lampada>{
        public int compare(Lampada a, Lampada b){
            return Double.compare(a.getConsumoTotal(), b.getConsumoTotal());
        }
    }

    public void gravaLeds(String nome) throws LampLedWriteFail, IOException {
        try {
            FileOutputStream f = new FileOutputStream(nome);
            ObjectOutputStream oos = new ObjectOutputStream(f);

            for (Lampada l : this.lamps.values())
                if (l instanceof LampadaLed)
                    oos.writeObject(l);
            oos.flush();
            oos.close();
        }
        catch (IOException i){
            throw new LampLedWriteFail("Falha ao escrever as Lâmpadas LED");
        }
    }
}
