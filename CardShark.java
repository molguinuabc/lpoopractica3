import java.util.ArrayList;

public class CardShark {
    Baraja b;
    ArrayList<Jugador> jugadores;
    int cantidadDeJugadores;
    public CardShark(int cantJugadores){
        this.cantidadDeJugadores = cantJugadores;
    }

    public void inicia() {
        b = new Baraja();
        jugadores = new ArrayList<>();
        for(int i=0; i < this.cantidadDeJugadores; i++) {
            jugadores.add(new Jugador(i+1));
        }
        b.barajar();
        reparteCartas();
        juega();
        
    }
    private void reparteCartas(){
        for(Jugador j : jugadores) {
            j.setMano(b.repartir(5));
            System.out.println("Jugador: " + j.getId()+": "+j.getMano());
        }
        System.out.println();
    }

    private void juega() {
        boolean finDeJuego = false;
        while(!finDeJuego) {
            if(jugarRonda()) {

            } else {
                publicaGanador();
                finDeJuego = true;
            }
        }
    }

    private boolean jugarRonda(){
      for(Jugador j : this.jugadores) {
          if(j.lanzarCarta() == null)
            return false;
          System.out.println(j.getCartaLanzada());  
      }
      return comparaCartas();
    }

    private boolean comparaCartas() {
        Jugador ganador = null;
        int cartaMasAlta=0;
        boolean empate = false;
        boolean resultado = true;
        ArrayList<Jugador> empatados = new ArrayList<>();
        for(int i=0; i< this.cantidadDeJugadores; i++) {
            if(jugadores.get(i).getCartaLanzada().getValor() > cartaMasAlta) {
                ganador = jugadores.get(i);
                cartaMasAlta = ganador.getCartaLanzada().getValor();
            } else if(jugadores.get(i).getCartaLanzada().getValor() == cartaMasAlta) {
                empate = true;
                empatados.add(ganador);
                empatados.add(jugadores.get(i));
            }
            
        }
        if(empate && ganador.getCartaLanzada().getValor() == empatados.get(0).getCartaLanzada().getValor()){
              System.out.println("A desempate");
                resultado = desempatar(empatados);
        } else {
            System.out.println("Jugador con carta más alta: " + ganador.getId());
            ganador.setPuntuacion(ganador.getPuntuacion()+2);
        }
        System.out.println();
        return resultado;
    }

    private boolean desempatar(ArrayList<Jugador> js) {

        System.out.println("Empatados: ");
        int cartaMasAlta = 0;
        Jugador ganador = null;
        boolean empate=false;
        int valorDeEmpate = 0;

        for(Jugador j: js) {
            Carta c = j.lanzarCarta();
            System.out.println("J: "+j.getId()+" C: "+c);
            if(c == null)
              return false;
            if(c.getValor() > cartaMasAlta) {
                cartaMasAlta = c.getValor();
                ganador = j;
            }else if (c.getValor()== cartaMasAlta) {
                empate = true;
                valorDeEmpate = cartaMasAlta;
            }
        }
        if(empate && valorDeEmpate==cartaMasAlta) {
            for(Jugador j : jugadores) {
                if(j.getCartaLanzada().getValor() == valorDeEmpate) {
                    System.out.println("Jugador " + j.getId() + " 1 punto");
                    j.setPuntuacion(j.getPuntuacion()+1);
                }
            }
            return true;
        }
        System.out.println("Jugador " + ganador.getId() + " 2 puntos");
        ganador.setPuntuacion(ganador.getPuntuacion()+2);
        return true;

    }
 
    private void publicaGanador() {
        System.out.println("Puntuaciones: ");
        for (Jugador j : jugadores) {
            System.out.println("Jugador: "+j.getId()+ " puntos: "+j.getPuntuacion());
        }
    }
    public static void main(String[] args) {
        CardShark c = new CardShark(5);
        c.inicia();
    }
}
