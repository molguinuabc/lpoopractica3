import java.util.ArrayList;
import java.util.Random;

class Jugador {
    private ArrayList<Carta> mano;
    private int id;
    private Carta cartaLanzada;
    private int puntuacion;

    public Jugador(int id) {
        this.mano = null;
        this.cartaLanzada = null;
        this.id = id;
    } 

    public Jugador(int id, ArrayList<Carta> mano) {
        this.mano = mano;
        this.cartaLanzada = null;
        this.id = id;
    }

    public Carta lanzarCarta() {
        int cantidadDeCartasEnMano = mano.size();
        if (cantidadDeCartasEnMano == 0) {
            return null;
        }
        Random random = new Random();
        int posicionDeLaCarta = random.nextInt(cantidadDeCartasEnMano);
        this.cartaLanzada = mano.remove(posicionDeLaCarta);
        return cartaLanzada;
    }

    public Carta getCartaLanzada() {
        return this.cartaLanzada;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public ArrayList<Carta> getMano() {
        return this.mano;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    
}