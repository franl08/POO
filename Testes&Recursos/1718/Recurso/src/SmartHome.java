import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SmartHome implements Serializable {
    Map<String, Eletrodomestico> eletrodomesticos;

    public SmartHome(Map<String, Eletrodomestico> novosEletrodomesticos){
        this.setEletrodomesticos(novosEletrodomesticos);
    }

    public void setEletrodomesticos(Map<String, Eletrodomestico> eletrodomesticos){
        if(this.eletrodomesticos == null) this.eletrodomesticos = new HashMap<>();
        for(String s : eletrodomesticos.keySet())
            this.eletrodomesticos.put(s, eletrodomesticos.get(s).clone());
    }

    public void addEletrodomestico(Eletrodomestico e){
        if(this.eletrodomesticos == null) this.eletrodomesticos = new HashMap<>();
        this.eletrodomesticos.put(e.getIdent(), e.clone());
    }

    public void desligaEletrodomestico(String id) throws EletrodomesticoNaoExisteException{
        if(!this.eletrodomesticos.containsKey(id)) throw new EletrodomesticoNaoExisteException();
        else{
            this.eletrodomesticos.get(id).EletrodomesticoOFF();
        }
    }

    public void gravaEletrodomesticosEcologicos(String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        for(Eletrodomestico e : this.eletrodomesticos.values())
            if(e instanceof EletrodomesticoEcologico)
                oos.writeObject(e);
        oos.flush();
        oos.close();
    }

    public double consumoParcial(){
        double ans = 0.0;
        for(Eletrodomestico e : this.eletrodomesticos.values())
            if(e instanceof EletrodomesticoEcologico || e instanceof EletrodomesticoInteligente)
                ans += e.getConsumoParcial();
        return ans;
    }
}
