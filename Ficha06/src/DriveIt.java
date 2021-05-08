import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt implements Serializable {
    private Map<String, Veiculo> veics;
    private boolean desconto;
    private static final Map<String, Comparator<Veiculo>> comps = new HashMap<>();

    public DriveIt(){
        this.veics = new HashMap<>();
        this.desconto = false;
    }

    public DriveIt(Map<String, Veiculo> m, boolean desconto){
        this.setVeics(m);
        this.desconto = desconto;
    }

    public DriveIt(Map<String, Veiculo> m){
        this.setVeics(m);
        this.desconto = false;
    }

    public DriveIt(DriveIt di){
        this.setVeics(di.getVeics());
        this.desconto = di.getDesconto();
    }

    public DriveIt clone(){
        return new DriveIt(this);
    }

    public void setVeics(Map<String, Veiculo> m){
        this.veics = new HashMap<>();
        for(Map.Entry<String, Veiculo> me : m.entrySet())
            this.veics.put(me.getKey(), me.getValue());
    }

   public Map<String, Veiculo> getVeics(){
        return this.veics.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public boolean getDesconto() {
        return this.desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    public Comparator<Veiculo> getComparator(String name){
        return comps.get(name);
    }

    public void addComparator(String name, Comparator<Veiculo> c){
        comps.put(name, c);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        DriveIt di = (DriveIt) o;
        return (veics.equals(di.getVeiculos()));
    }

    public boolean existeVeiculo(String cod){
        return this.veics.containsKey(cod);
    }

    public int quantos(){
        return this.veics.size();
    }

    public Veiculo getVeiculo(String cod) throws VeiculoNotFoundException {
        Veiculo v = this.veics.get(cod);
        if(v == null) throw new VeiculoNotFoundException("Veiculo " + cod + " não existe");
        else return v;
    }

    public void adiciona(Veiculo v) throws VeiculoAlreadyExistsException{
        if(this.veics.containsKey(v.getMatricula())) throw new VeiculoAlreadyExistsException("Veiculo " + v.getMatricula() + " já existe");
        else this.veics.put(v.getMatricula(), v);
    }

    public List<Veiculo> getVeiculos(){
        return new ArrayList<>(this.veics.values());
    }

    public void adiciona(Set<Veiculo> vs) throws VeiculoAlreadyExistsException{
        for(Veiculo v : vs)
            this.adiciona(v.clone());
    }

    public void registarAluguer(String codVeiculo, int numKms) throws VeiculoNotFoundException, InvalidValueException{
        if(this.veics.get(codVeiculo) == null) throw new VeiculoNotFoundException("Veiculo " + codVeiculo + " não existe");
        if(numKms < 0) throw new InvalidValueException("Número de kms deve ser >= 0");
        this.veics.get(codVeiculo).addViagem(numKms);
    }

    public void classificarVeiculo(String cod, int classificacao) throws VeiculoNotFoundException, InvalidValueException{
        if(this.veics.get(cod) == null) throw new VeiculoNotFoundException("Veiculo " + cod + " não existe");
        if(classificacao >= 0 && classificacao <= 10) throw new InvalidValueException("A classificação deve ser um valor entre 0 e 10");
        this.veics.get(cod).addClassificacao(classificacao);
    }

    public int custoRealKm(String cod) throws VeiculoNotFoundException{
        if(this.veics.get(cod) == null) throw new VeiculoNotFoundException("Veiculo " + cod + " não existe");
        return (int) this.veics.get(cod).getCustoRealKM();
    }

    public int quantosT(String tipo){
        int ans = 0;
        for(Map.Entry<String, Veiculo> m : this.veics.entrySet())
            if(m.getValue().getClass().toString().split(" ")[1].equals(tipo)) ans++;
        return ans;
    }

    public List<Veiculo> veiculosOrdenadosCusto(){
        return this.veics.values().stream().sorted(Comparator.comparingDouble(Veiculo::getPrecokm).reversed()).collect(Collectors.toList());
    }

    public Veiculo veiculoMaisBarato() throws VeiculoNotFoundException{
        if(this.veics.size() > 0){
            List<Veiculo> vs = veiculosOrdenadosCusto();
            return vs.get(vs.size() - 1);
        }
        else throw new VeiculoNotFoundException("Não existem veículos na empresa.");
    }

    public Veiculo menosUtilizado() throws  VeiculoNotFoundException{
        if(this.veics.size() > 0){
            int min = Integer.MAX_VALUE;
            Veiculo ans = null;
            for(Veiculo v : this.veics.values())
                if(v.getKms() < min){
                    min = v.getKms();
                    ans = v;
                }
            return ans;
        }
        else throw new VeiculoNotFoundException("Não existem veículos na empresa");
    }

    public void alteraPromocao(boolean estado){
        this.setDesconto(estado);
        this.veics.values().stream().filter(v -> v instanceof VeiculoOcasiao).forEach(v -> ((VeiculoOcasiao)v).setEmDesconto(estado));
    }

    public void defOcupacao() {
        for (Veiculo v : this.veics.values())
            if (v.getClass().toString().split(" ")[1].equals("AutocarroInteligente")) {
                AutocarroInteligente ai = (AutocarroInteligente) v;
                ai.setOcupacao((int) (85 * ai.getLotacao()) / 100);
            }
    }

    public double valorMedioKM(){
        defOcupacao();
        int ac = 0;
        for(Veiculo v : this.veics.values())
            ac += v.getCustoRealKM();
        return (double) ac / this.veics.size();
    }

    public Set<Veiculo> ordenarVeiculosSet(){
        return this.veics.values().stream().map(Veiculo::clone).collect(Collectors.toCollection(TreeSet::new));
    }

    public List<Veiculo> ordenarVeiculosList(){
        return  this.veics.values().stream().map(Veiculo::clone).sorted().collect(Collectors.toList());
    }

    public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c){
        return this.veics.values().stream().sorted(c).map(Veiculo::clone).collect(Collectors.toCollection(TreeSet::new));
    }

    public Iterator<Veiculo> ordenarVeiculo(String criterio){
        Comparator<Veiculo> c = getComparator(criterio);
        if(this.veics.isEmpty() || c == null) return null;
        return this.veics.values().stream().sorted(c).iterator();
    }

    public List<BonificaKms> daoPontos(){
        return this.veics.values().stream().filter(v -> v instanceof BonificaKms).map(v -> (BonificaKms)v.clone()).collect(Collectors.toList());
    }

    public void exportToFile(String filename){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for(Veiculo v : this.veics.values())
                writer.write(v.toString() + ",\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String saveState(){
        String outputFile = ".saves/driveIt.sv";
        try{
            FileOutputStream fos = new FileOutputStream(outputFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
            return outputFile;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void loadState(String inputFile){
        try{
            FileInputStream fis = new FileInputStream(inputFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            DriveIt copy = (DriveIt) ois.readObject();
            this.setVeics(copy.getVeics());
            this.setDesconto(copy.getDesconto());
            ois.close();
            fis.close();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}


