import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GinasioPOO implements Serializable {
    private Map<String, Cliente> clientes;

    public double valorTotalCaloriasGastas(String codCliente) throws ClienteNaoExisteException{
        double ans = 0.0;
        if(!this.clientes.containsKey(codCliente)) throw new ClienteNaoExisteException();
        else{
            Cliente c = this.clientes.get(codCliente);
            Map<LocalDate, List<Exercicio>> exercicios = c.getMeuExercicios();
            for(LocalDate l : exercicios.keySet())
                for(Exercicio e : exercicios.get(l))
                    ans += e.getActividade().caloriasGastas();
        }
        return ans;
    }

    public double totalKmsCliente(String codCliente, LocalDate dataExercicio) throws ClienteNaoExisteException, ExercicioInexistenteException {
        if(!clientes.containsKey(codCliente)) throw new ClienteNaoExisteException();
        else if(!clientes.get(codCliente).getMeuExercicios().containsKey(dataExercicio)) throw new ExercicioInexistenteException();
        else{
            double ans = 0.0;
            List<Exercicio> exs = clientes.get(codCliente).getMeuExercicios().get(dataExercicio);
            for(Exercicio e : exs)
                if(e instanceof ComDistancia)
                    ans += ((ComDistancia) e).getKmsPercorridos();
            return ans;
        }
    }

    public boolean existeProfessor(String prof){
        boolean ans = false;
        for(Cliente c : this.clientes.values()) {
            if(ans) break;
            for (List<Exercicio> exs : c.getMeuExercicios().values()) {
                if(ans) break;
                for (Exercicio e : exs)
                    if (e.getProfessor().equals(prof)) {
                        ans = true;
                        break;
                    }
            }
        }
        return ans;
    }

    public String professorMaisExigente(){
        double max = 0.0;
        String ans = "n/a";
        Map<String, Double> profsCals = new HashMap<>();
        for(Cliente c : this.clientes.values())
            for(List<Exercicio> es : c.getMeuExercicios().values())
                for(Exercicio e : es)
                    if(profsCals.containsKey(e.getProfessor())){
                        double cals = profsCals.get(e.getProfessor());
                        cals += e.getActividade().caloriasGastas();
                        profsCals.put(e.getProfessor(), cals);
                    }
                    else profsCals.put(e.getProfessor(), e.getActividade().caloriasGastas());

        for(String s : profsCals.keySet())
            if(profsCals.get(s) > max){
                ans = s;
                max = profsCals.get(s);
            }
        return ans;
    }
}
