import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private List<Cartas> cartas;
    private int numeroRondas;

    public Juego(int numeroJugadores) {
        this.jugadores = crearJugadores(numeroJugadores);
    }
    private List<Jugador> crearJugadores(int numeroJugadores) {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < numeroJugadores; i++) {
            jugadores.add(new Jugador("Jugador"+i,50));
        }
        return jugadores;
    }
    public List<Cartas> crearBaraja(){
        List<Cartas> baraja = new ArrayList<>();
        String[] simbolos = {"Corazon","Diamante","Trebol","Espadas"};
        String[] valores = {"As","2","3","4","5","6","7","8","9","10","J","Q","K"};

        for(String simbolo : simbolos) {
            for(String valor : valores) {
                Cartas carta = new Cartas(simbolo,valor);
                baraja.add(carta);
            }
        }
        return baraja;
    }
    private void barajar(){
        Collections.shuffle(cartas);
    }
    private void repartirCartas(){
        for(Jugador jugador : jugadores) {
            for(int i=0;i<5;i++){
                jugador.agregarCarta(cartas.remove(0));
            }
        }
    }
    private void limpiarCartas(){
        for(Jugador jugador : jugadores) {
            jugador.borrarCarta();
        }
    }

    public Juego(int numeroJugadores, int numeroRondas){
        this.jugadores = crearJugadores(numeroJugadores);
        this.numeroRondas = numeroRondas;
    }

    public void jugar(){
        for (int ronda = 0; ronda < numeroRondas; ronda++) {
            System.out.println("Ronda: " + ronda);
            this.cartas = crearBaraja();
            barajar();
            repartirCartas();
            mostrarCartas();
            jugarCarta();
        }
    }

    private void mostrarCartas(){
        for(Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": "+ jugador.getCartas());
        }
    }

    private void jugarCarta(){
        for(Jugador jugador : jugadores) {
            int valorCarta = jugador.jugarCarta().getValorNumerico();
            System.out.println("Jugador " + jugador.getNombre() + " carta seleccionada "+ valorCarta);
        }
    }
}