import Controladores.ConexionController;
import Modelos.Conexion;
import Modelos.PersonasModel;
import Vistas.*;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmPrincipal principal = new frmPrincipal();
        frmLogin login = new frmLogin();
        frmPersonas personas = new frmPersonas(principal,true);
        Conexion conexion = new Conexion();
        ConexionController controlador = new ConexionController(principal, login, personas, conexion);
        
    }
    
}
