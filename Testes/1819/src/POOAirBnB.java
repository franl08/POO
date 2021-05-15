import java.io.*;
import java.util.*;

public class POOAirBnB implements Serializable, OrdenaImoveis{
    private Map<String, Imovel> imoveis;
    private Map<String, Client> clientes;
    private OrdenaImoveis ordenaImoveis;

    public Imovel getImovel(String codImovel) throws ImovelNaoExistente{
        if(!this.imoveis.containsKey(codImovel)) throw new ImovelNaoExistente("Imovel não existente");
        else return this.imoveis.get(codImovel).clone();
    }

    public double valorTotalAluguerCliente(String codCliente){
        double res = 0;
        if(this.clientes.containsKey(codCliente)){
            for(Aluguer a : this.clientes.get(codCliente).getMeusAlugueres())
                res += this.imoveis.get(a.getCodImovel()).precoDia();
        }
        return res;
    }

    public Map<String, Set<String>> clientesPorImovel(){
        Map<String, Set<String>> ans = new HashMap<>();
        for(Client c : this.clientes.values())
            for(Aluguer i : this.clientes.get(c.getCodCliente()).getMeusAlugueres()){
                if(ans.containsKey(i.getCodImovel()))
                    ans.get(i.getCodImovel()).add(c.getCodCliente());
                else{
                    Set<String> toAdd = new HashSet<>();
                    toAdd.add(c.getCodCliente());
                    ans.put(i.getCodImovel(), toAdd);
                }
            }
        return ans;
    }

    public List<Imovel> imoveisPorTipoArea(){
        return this.ordenaImoveis(new ComparaTipoArea());
    }

    public void gravaObj(String name) throws IOException, FileNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public static POOAirBnB carregaObj(String name) throws IOException, FileNotFoundException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
        POOAirBnB ans = (POOAirBnB) ois.readObject();
        ois.close();
        return ans;
    }
}
