import java.time.LocalDateTime;
import java.util.*;

public class SistemaTickets {
    private Map<String, Tecnico> funcionarios; // funcionarios da empresa
    private List<Ticket> ticketsPorResolver; // tickets ainda não tratados
    private List<Ticket> ticketsResolvidos; // tickets já satisfeitos


    public void adicionaTicket(Ticket t){
        if(this.ticketsPorResolver == null) this.ticketsPorResolver = new ArrayList<>();
        this.ticketsPorResolver.add(t.clone());
    }

    public void resolveTicket(String ident) throws TecnicoNaoExisteException{
        if(!this.funcionarios.containsKey(ident)) throw new TecnicoNaoExisteException();
        else{
            Ticket t = this.ticketsPorResolver.remove(0);
            t.setHoraFecho(LocalDateTime.now());
            t.setIdentTecnico(ident);
            this.ticketsResolvidos.add(t);
        }
    }

    public Map<String, List<Ticket>> ticketsPorTecnico(){
        Map<String, List<Ticket>> ans = new HashMap<>();
        if(this.funcionarios != null && !this.funcionarios.isEmpty())
            if(this.ticketsResolvidos != null && !this.ticketsResolvidos.isEmpty()){
                for(String s : this.funcionarios.keySet()){
                    List<Ticket> resolvidosPorTec = new ArrayList<>();
                    for(Ticket t : this.ticketsResolvidos)
                        if(t.getIdentTecnico().equals(s))
                            resolvidosPorTec.add(t.clone());
                    if(!resolvidosPorTec.isEmpty()) ans.put(s, resolvidosPorTec);
                }
            }
        return ans;
    }

    public String supervisorTop(){
        TreeSet<Tecnico> supervisors = new TreeSet<>(Tecnico::compareTo);
        for(Tecnico t : this.funcionarios.values())
            if(t instanceof Supervisor) supervisors.add(t);
        return supervisors.first().getIdent();
    }
}
