
import Controlador.Controlador;
import Modelo.Modelo;
import Vista.Vista;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador control= new Controlador(vista, modelo);

        vista.setVisible(true);
    }
    
}