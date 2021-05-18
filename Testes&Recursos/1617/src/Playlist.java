import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist{
    private String nome;
    private Map<String, List<Faixa>> musicas;

    public Playlist(String nome, Map<String, List<Faixa>> musicas){
        this.nome = nome;
        this.setMusicas(musicas);
    }

    public void setMusicas(Map<String, List<Faixa>> musicas) {
        this.musicas = new HashMap<>();
        if(musicas != null)
            for(String s : musicas.keySet()) {
                List<Faixa> toAdd = new ArrayList<>();
                List<Faixa> faixas = musicas.get(s);
                for (Faixa f : faixas)
                    toAdd.add(f.clone());
                if (this.musicas.containsKey(s)) {
                    List<Faixa> fs = this.musicas.get(s);
                    List<Faixa> tmp = new ArrayList<>();
                    for (Faixa f : fs)
                        tmp.add(f.clone());
                    for (Faixa f : toAdd)
                        tmp.add(f.clone());
                    this.musicas.put(s, tmp);
                } else this.musicas.put(s, toAdd);
            }
    }

    public Map<String, List<Faixa>> getMusicas(){
        Map<String, List<Faixa>> ans = new HashMap<>();
        if(this.musicas != null)
            for(String s : this.musicas.keySet()){
                List<Faixa> toAdd = new ArrayList<>();
                List<Faixa> faixas = this.musicas.get(s);
                for(Faixa f : faixas)
                    toAdd.add(f.clone());
                ans.put(s, toAdd);
            }
        return ans;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Faixa> getFaixas(String autor) throws AutorInexistenteException{
        List<Faixa> ans = new ArrayList<>();
        if(!this.musicas.containsKey(autor)) throw new AutorInexistenteException("Autor " + autor + " não existe");
        else{
            List<Faixa> faixasDoAutor = this.musicas.get(autor);
            for(Faixa f : faixasDoAutor)
                ans.add(f.clone());
        }
        return ans;
    }

    public double tempoTotal(String autor) throws AutorInexistenteException{
        double ans = 0.0;
        if(!this.musicas.containsKey(autor)) throw new AutorInexistenteException("Autor " + autor + " não existe");
        else{
            List<Faixa> faixasDoAutor = this.musicas.get(autor);
            for(Faixa f : faixasDoAutor)
                ans += f.getDuracao();
        }
        return ans;
    }

    public List<Faixa> todasAsFaixas(){
        List<Faixa> ans = new ArrayList<>();
        if(this.musicas != null)
            for(List<Faixa> fs : this.musicas.values())
                for(Faixa f : fs)
                    ans.add(f.clone());
        return ans;
    }

    public void addFaixa(Faixa f, Map<Integer, List<Faixa>> m){
        int c = f.getClassificacao();
        List<Faixa> fs = m.get(c);
        if(fs == null) {
            fs = new ArrayList<>();
            fs.add(f.clone());
        }
        else fs.add(f.clone());

        m.put(c, fs);
    }

    public Map<Integer, List<Faixa>> faixasPorClass(){
        Map<Integer, List<Faixa>> ans = new HashMap<>();
        this.musicas.values().forEach(f -> f.forEach(c-> addFaixa(c, ans)));
        return ans;
    }
}
