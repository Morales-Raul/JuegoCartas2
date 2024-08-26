public class Cartas {
    private String valor; // El valor que tiene la carta se As, 2, 3, 4...
    private String simbolo; // Corazones, Espadas, Trebol, Diamante

    //Metodo constructor
    //Metodo al instanciar un objeto a la clase Cartas
    public Cartas(String valor, String simbolo) {
        this.valor = valor;
        this.simbolo = simbolo;
    }

    //Obtiene le simbolo de la carta
    public String getSimbolo(){
        return simbolo;
    }

    public int getValorNumerico(){
        switch (valor){
            case "As": //Valor numerico devuelto para el AS
                return 11;
            case "J": //Valor numerico devuelto para J,Q, y K
            case "Q":
            case "K":
                return 10;
            default: //Valor numerico para las cartas que lleven numero
                return Integer.parseInt(valor);
        }
    }

    @Override
    public String toString(){
        return valor + " de " + simbolo;
    }
}
