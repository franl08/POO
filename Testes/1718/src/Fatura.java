import java.time.LocalDate;

public class Fatura {
    private String name;
    private LocalDate data;
    private double valor;
    private Actividade actividade; // null caso não esteja definida

    public Fatura(String name, LocalDate data, double valor, Actividade actividade){
        this.name = name;
        this.data = data;
        this.valor = valor;
        this.actividade = actividade.clone();
    }

    public Fatura (Fatura f){
        this.name = f.getName();
        this.data = f.getData();
        this.valor = f.getValor();
        this.actividade = f.getActividade();
    }

    public Fatura clone(){
        return new Fatura(this);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Actividade getActividade() {
        return this.actividade.clone();
    }

    public void setActividade(Actividade actividade) {
        this.actividade = actividade.clone();
    }

    public double getValor(){
        return  this.valor;
    }
}
