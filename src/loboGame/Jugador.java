package loboGame;


public class Jugador {

    private Juego juego;
    private String usuario;
    private String clave;

    //creación del constructor
    public Jugador() {
        juego = new Juego();
        setUsuario("joel");
        setClave("12345");

        System.out.println(getUsuario());
    }

    public boolean ingresar(){
        System.out.println("Ingresaste al juego");

        String usuario = "";
        String clave = "";
        boolean sinLogear = true;

        do {
            System.out.print(" Ingrese el usuario: ");
            usuario = Utilitario.entrada.nextLine();
            System.out.print(" Ingrese el clave: ");
            clave = Utilitario.entrada.nextLine();

            if (this.usuario.equalsIgnoreCase(usuario) && this.clave.equalsIgnoreCase(clave)) {
                jugar();
                break;
            }

            System.out.println(" Datos erroneos! ");
            System.out.print(" Para salir, ingrese (s): ");
            if (Utilitario.entrada.nextLine().toUpperCase().equals("S")) {
                sinLogear = false;
            }

        } while (sinLogear);

        return true;
    }

    private void jugar(){
        System.out.println("¡Comenzando el juego!");
        juego.jugarLobo();
        
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty()) {
            usuario = "Anonimo";
        }
        this.usuario = usuario.toUpperCase();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        if (clave == null || clave.isEmpty()) {
            clave = "";
        }
        this.clave = clave;
    }

}
