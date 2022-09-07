import java.util.ArrayList;

public class Test {

  void main(String args[]) {
    try {
      Carta c = new Carta("K", Figura.CORAZONES);
      System.out.println(c);
      System.out.println(
        new Carta("j",Figura.DIAMANTES)+"\n"+
        new Carta("q",Figura.DIAMANTES)+"\n"+
        new Carta("a",Figura.DIAMANTES)+"\n"+
        new Carta(10,Figura.PICAS)+"\n"+
        new Carta(11,Figura.TREBOLES)
      );
      System.out.println("--------------------");
      Baraja b = new Baraja();
      System.out.println(b);
      b.barajar();
      System.out.println(b);
      ArrayList<Carta> mano = b.repartir(5);
      System.out.println(mano);
      int negras=0;
      int rojas=0;
      for (Carta carta : mano) {
        if(carta.getColor() == Color.NEGRO)
          negras++;
        else
          rojas++;
      }
      System.out.println("Negras: "+negras+" Rojas: "+ rojas);
      System.out.println(new Carta("10",Figura.PICAS));
    } catch (FueraDeRangoException e) {
      System.out.println(e);
    }
  }

}
