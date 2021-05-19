public class LinhaEncomenda {

    private String referencia;
    private String descricao;
    private double precoSemTaxas;
    private int quantidade;
    private double imposto;
    private double descontoComercial;

    public LinhaEncomenda() {
        this.referencia = "";
        this.descricao = "";
        this.precoSemTaxas = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.descontoComercial = 0;
    }

    public LinhaEncomenda(String referencia, String descricao, double precoSemTaxas, int quantidade, double imposto, double descontoComercial) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.precoSemTaxas = precoSemTaxas;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.descontoComercial = descontoComercial;
    }

    public LinhaEncomenda(LinhaEncomenda linha) {
        this.referencia = linha.getReferencia();
        this.descricao = linha.getDescricao();
        this.precoSemTaxas = linha.getPrecoSemTaxas();
        this.quantidade = linha.getQuantidade();
        this.imposto = linha.getImposto();
        this.descontoComercial = linha.getDescontoComercial();
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoSemTaxas() {
        return this.precoSemTaxas;
    }

    public void setPrecoSemTaxas(double precoSemTaxas) {
        this.precoSemTaxas = precoSemTaxas;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDescontoComercial() {
        return this.descontoComercial;
    }

    public void setDescontoComercial(double descontoComercial) {
        this.descontoComercial = descontoComercial;
    }

    public double calculaValorLinhaEnc() {
        return this.quantidade * (1 + (this.imposto - this.descontoComercial)/100)*this.precoSemTaxas;
    }

    public double calculaValorDesconto() {
        return this.quantidade * this.descontoComercial/100 * this.precoSemTaxas;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Linha de Encomenda {\n");
        sb.append("\tReferência = '").append(referencia).append("',\n");
        sb.append("\tDescrição = '").append(descricao).append("',\n");
        sb.append("\tPreço antes de impostos = ").append(precoSemTaxas).append(",\n");
        sb.append("\tQuantidade encomendada = ").append(quantidade).append(",\n");
        sb.append("\tImposto = ").append(String.format("%.2f%%",imposto)).append(",\n");
        sb.append("\tDesconto comercial = ").append(String.format("%.2f%%",descontoComercial)).append(",\n");
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LinhaEncomenda that = (LinhaEncomenda) o;
        return Double.compare(that.precoSemTaxas, this.precoSemTaxas) == 0 &&
                this.quantidade == that.quantidade &&
                Double.compare(that.imposto, this.imposto) == 0 &&
                Double.compare(that.descontoComercial, this.descontoComercial) == 0 &&
                this.referencia.equals(that.referencia) &&
                this.descricao.equals(that.descricao);
    }

    public LinhaEncomenda clone() {
        return new LinhaEncomenda(this);
    }
}
