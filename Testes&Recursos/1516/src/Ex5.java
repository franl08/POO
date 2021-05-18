public class Ex5 {
    public double qtsKmsTotal(){
        double ans = 0.0;
        for(Empregado e : this.empregados)
            if(e instanceof Motorista)
                ans += e.getNKms();
        return ans;
    }
}
