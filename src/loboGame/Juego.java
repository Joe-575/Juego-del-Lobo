package loboGame;

import java.util.Arrays;

public class Juego {
    public String rio;
    public String barca;
    public String[] ladoIzquierdo;
    public String[] ladoDerecho;
    public boolean vikingoEstaIzquierdo;

    public Juego(){
        this.rio                    = "..".repeat(20);
        this.barca                  = "\\_V_._?_/";
        this.ladoIzquierdo          = new String[] {"V","L","C","U"};
        this.ladoDerecho            = new String[] {"","","",""};
        this.vikingoEstaIzquierdo   = true;
    }

    private Short getOpcionMenu(){
        int opcion = -1;
        System.out.print("\n 0 Vikingo va solo  \n 1 Lobo  \n 2 Caperucita \n 3 Uvas \n 4 Salir ");

        do {
            try {
                String personaje = "";
                System.out.print("\n [-] Ingrese un personaje: ");
                opcion = Utilitario.entrada.nextInt();
                if (opcion == 4) {
                    System.out.println(" No abandones el juego...!");
                    System.exit(0);
                }

                personaje = (vikingoEstaIzquierdo)? ladoIzquierdo[opcion] : ladoDerecho[opcion];
                //trim () elimina los espacios en blanco
                if (personaje.trim().isEmpty() && opcion > 0) {
                    opcion = -1;
                    System.out.println(" No hay personaje en ese lugar...!");
                }
            } catch (Exception e) {
                Utilitario.entrada.nextLine();
            }
            
        } while (opcion >=  4 || opcion < 0);
        return (short) opcion;
    }

    private void navegarBarca(String personaje){
        if(vikingoEstaIzquierdo){
            for (int i = 0; i < rio.length(); i++) {
                setBarcaRio(i, personaje);
            }
        }else{
            for (int i = rio.length(); i>=0; i--) {
                setBarcaRio(i, personaje);
            }
        }
    }

    private void setBarcaRio(int posicionBarca, String individuo){
        String personajeIzquierda   = Arrays.toString(ladoIzquierdo);
        String personajeDerecha     = Arrays.toString(ladoDerecho);
        String rioBarca             = "\r" 
                                    + personajeIzquierda 
                                    + ".".repeat(posicionBarca) 
                                    + barca.replace("?", individuo) 
                                    + ".".repeat(rio.length()-posicionBarca) 
                                    + personajeDerecha;
        System.out.print(rioBarca);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            
        }
    }

    public void verficarRegla(){
        String mensaje = "";
        if (vikingoEstaIzquierdo) {
            if (ladoDerecho[1].equals("L") && ladoDerecho[2].equals("C")) {
                mensaje += "\n El lobo se comio a caperucita! ";
            }
            if (ladoDerecho[2].equals("C") && ladoDerecho[1].equals("U")) {
                mensaje += "\n Caperucita a comido las uvas! ";            
            } 
        }else{
            if (ladoIzquierdo[1].equals("L") && ladoIzquierdo[2].endsWith("C") ){
                mensaje += "\n El lobo se comio a caperucita!";
            }
            if (ladoIzquierdo[2].equals("L") && ladoIzquierdo[3].equals("U")) {
                mensaje += "\n Caperucita a comido las uvas! ";
                
            }
        }
        if (ladoDerecho[1].equals("L") && ladoDerecho[2].equals("C") && ladoDerecho[3].equals("U")) {
            mensaje += "\n Ha ganado....!!";
        }
        if (!mensaje.isEmpty()) {
            System.out.println(mensaje);
            System.exit(0);
        }
    }

    public void jugarLobo(){
        do {
            short opcionDelMenu = getOpcionMenu();
            String individuo = " ";
            if (vikingoEstaIzquierdo) {
                individuo = ladoIzquierdo[opcionDelMenu];
                ladoIzquierdo[opcionDelMenu] = " ";
            }else{
                individuo = ladoDerecho[opcionDelMenu];
                ladoDerecho[opcionDelMenu] = " ";
            }

            navegarBarca(individuo);
            vikingoEstaIzquierdo = !vikingoEstaIzquierdo;
            if (vikingoEstaIzquierdo) {
                ladoIzquierdo[opcionDelMenu] = individuo;
                setBarcaRio(1, individuo);
            } else {
                ladoDerecho[opcionDelMenu] = individuo;
                setBarcaRio(rio.length()," ");
            }
            
            verficarRegla();
        } while (true);
    }
}
