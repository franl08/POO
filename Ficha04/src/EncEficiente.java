import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Exercicio 2 da Ficha4 de POO
 */
public class EncEficiente {
    private String nomeCliente;
    private int nif;
    private String morada;
    private String numEncomenda;
    private LocalDate data;
    private List<LinhaEncomenda> encomendas;
    /**
     * Construtor parametrizado de EncEficiente
     * @param nomeCliente
     * @param nif
     * @param morada
     * @param numEncomenda
     * @param data
     * @param encomendas
     */
    public EncEficiente(String nomeCliente, int nif, String morada, String numEncomenda, LocalDate data, List<LinhaEncomenda> encomendas) {
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.numEncomenda = numEncomenda;
        this.data = data;
        this.setEncomendas(encomendas);
    }

    /**
     * Construtor vazio de EncEficiente
     */
    public EncEficiente() {
        this.nomeCliente = null;
        this.nif = -1;
        this.morada = null;
        this.numEncomenda = null;
        this.data = LocalDate.now();
        this.encomendas = new ArrayList<LinhaEncomenda>();
    }

    /**
     * Construtor de EncEficiente sendo dado outro EncEficiente
     * @param e
     */
    public EncEficiente(EncEficiente e){
        this.nomeCliente = e.getNomeCliente();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.numEncomenda = e.getNumEncomenda();
        this.data = e.getData();
        this.setEncomendas(e.getEncomendas());
    }

    /**
     * toString de EncEficiente
     * @return
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Encomenda:\n")
                .append("Nome do Cliente: ").append(nomeCliente)
                .append(" | NIF: ").append(nif)
                .append(" | Morada: ").append(morada)
                .append(" | Num da Encomenda: ").append(numEncomenda)
                .append(" | Data: ").append(data.toString())
                .append(" | Encomendas: ").append(encomendas.toString());
        return sb.toString();
    }

    /**
     * Teste de igualdade para EncEficiente.
     * @param o
     * @return true em caso de igualdade, false caso contrario
     */
    public boolean equals(Object o){
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        EncEficiente l = (EncEficiente) o;
        return (this.nomeCliente.equals(l.getNomeCliente()) && this.nif == l.getNif() && this.morada.equals(l.getMorada())
                && this.numEncomenda.equals(l.getNumEncomenda()) && this.data.equals(l.getData()) && this.encomendas.equals(l.getEncomendas()));
    }

    /**
     * Clone de EncEficiente.
     * @return clone da classe
     */
    public EncEficiente clone(){
        return new EncEficiente(this);
    }

    /**
     * Getter do Nome de Cliente.
     * @return nome do cliente
     */
    public String getNomeCliente() {
        return this.nomeCliente;
    }

    /**
     * Setter do Nome de Cliente.
     * @param nomeCliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * Getter do NIF.
     * @return nif
     */
    public int getNif() {
        return this.nif;
    }

    /**
     * Setter do NIF.
     * @param nif
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Getter da Morada.
     * @return morada
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * Setter da Morada.
     * @param morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Getter do Num de Encomenda.
     * @return num de Encomenda
     */
    public String getNumEncomenda() {
        return this.numEncomenda;
    }

    /**
     * Setter do Num de Encomenda.
     * @param numEncomenda
     */
    public void setNumEncomenda(String numEncomenda) {
        this.numEncomenda = numEncomenda;
    }

    /**
     * Getter da Data.
     * @return data da encomenda
     */
    public LocalDate getData() {
        return this.data;
    }

    /**
     * Setter da Data.
     * @param data
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Getter das Linhas de Encomenda.
     * @return linhas de encomenda
     */
    public List<LinhaEncomenda> getEncomendas() {
        return this.encomendas;
    }

    /**
     * Setter das Linhas de Encomenda.
     * @param encomendas
     */
    public void setEncomendas(List<LinhaEncomenda> encomendas) {
        this.encomendas = new ArrayList<>();
        for (LinhaEncomenda l : encomendas)
            this.encomendas.add(l.clone());
    }

    /**
     * Calcula o valor total de uma determinada encomenda.
     * Alinea ii)
     * @return valor total da encomenda
     */
    public double calculaValorTotal(){
        double valor = 0;
        for (LinhaEncomenda l : this.encomendas){
            valor += l.calculaValorLinhaEnc();
        }
        return valor;
    }

    /**
     * Calcula o valor de desconto de uma determinada encomenda.
     * Alinea iii)
     * @return valor de desconto
     */
    public double calculaValorDesconto(){
        double valor = 0;
        for (LinhaEncomenda l : this.encomendas){
            valor += l.calculaValorDesconto();
        }
        return valor;
    }

    /**
     * Calcula o num total de produtos da encomenda.
     * Alinea iv)
     * @return num total de produtos
     */
    public int numeroTotalProdutos(){
        int total = 0;
        for (LinhaEncomenda l : this.encomendas){
            total += l.getQuantidade();
        }
        return total;
    }

    /**
     * Verifica se existe um produto com uma determinada referencia.
     * @param refProduto
     * @return true caso exista, false caso contrario
     */
    public boolean existeProdutoEncomenda(String refProduto){
        for (LinhaEncomenda l : this.encomendas)
            if (refProduto.equals(l.getReferencia())) return true;
        return false;
    }

    /**
     * Adiciona uma linha a encomenda.
     * @param linha
     */
    public void adicionaLinha(LinhaEncomenda linha){
        this.encomendas.add(linha.clone());
    }

    /**
     * Remove um produto da encomenda.
     * @param codProduto
     */
    public void removeProduto(String codProduto){
        this.encomendas.removeIf(l -> codProduto.equals(l.getReferencia()));
    }

}
