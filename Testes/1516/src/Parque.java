public class Parque implements IParque{
    public void entra(String cartao, String matricula) throws SemPermissaoException{

    }
    public void sai(String matricula) throws VeiculoNaoExisteException{

    }
    public boolean noParque(String matricula){
        return false;
    }
    public boolean equals(){
        return true;
    }
}
