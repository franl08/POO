import java.time.LocalDateTime;

public class Ticket {
    private String nomeO; // quem originou o pedido
    private LocalDateTime horaOcorrencia; // instante do report do ticket
    private String assunto;
    private String descricao;
    private String identTecnico; // tecnico que resolveu o ticket
    private LocalDateTime horaFecho; // instante do fecho do ticket

    public Ticket(String nomeO, LocalDateTime horaOcorrencia, String assunto, String descricao, String identTecnico, LocalDateTime horaFecho) {
        this.nomeO = nomeO;
        this.horaOcorrencia = horaOcorrencia;
        this.assunto = assunto;
        this.descricao = descricao;
        this.identTecnico = identTecnico;
        this.horaFecho = horaFecho;
    }

    public Ticket(Ticket t){
        this.nomeO = t.getNomeO();
        this.horaOcorrencia = t.getHoraOcorrencia();
        this.assunto = t.getAssunto();
        this.descricao = t.getDescricao();
        this.identTecnico = t.getIdentTecnico();
        this.horaFecho = t.getHoraFecho();
    }

    public Ticket clone(){
        return new Ticket(this);
    }

    public String getNomeO() {
        return this.nomeO;
    }

    public void setNomeO(String nomeO) {
        this.nomeO = nomeO;
    }

    public LocalDateTime getHoraOcorrencia() {
        return this.horaOcorrencia;
    }

    public void setHoraOcorrencia(LocalDateTime horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentTecnico() {
        return this.identTecnico;
    }

    public void setIdentTecnico(String identTecnico) {
        this.identTecnico = identTecnico;
    }

    public LocalDateTime getHoraFecho() {
        return this.horaFecho;
    }

    public void setHoraFecho(LocalDateTime horaFecho) {
        this.horaFecho = horaFecho;
    }

    public void executaTarefa(){

    }
}
