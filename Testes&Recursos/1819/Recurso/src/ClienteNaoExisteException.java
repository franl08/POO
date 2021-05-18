public class ClienteNaoExisteException extends Exception{
    public ClienteNaoExisteException(){
        super();
    }

    public ClienteNaoExisteException(String s){
        super(s);
    }
}
