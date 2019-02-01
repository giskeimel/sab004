
import com.mycompany.tusalud.controladores.TurnoCtrl;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TestTurno {
        public static void main(String[] args) {
            
            TurnoCtrl controller = null;
            Turno turno = null;
            try {
//                Turno turno = new Turno();
//                turno.setIdTurno(1);
//                turno.setLibre(false);
                
                
                controller = new TurnoCtrl();
                turno = controller.getTurno(1);
            } catch (BDException ex) {
                //Mostrar el error al usuario, que el turno no existe
                //Dialogo.mostrarError(ex.getMessage());
                return;
            }
            
            /*
            Como guardar
            */
            turno.setLugar(null);
            try {
                controller.guardarTurno(turno);
            } catch (BDException ex) {
                //Mostrar el error al usuario, que el turno no existe
                //Dialogo.mostrarError(ex.getMessage());                    
            }
            
            /*
            Como cancelar
            */
            try {
                controller.cancelarTurno(turno);
            } catch (BDException ex) {
                //Mostrar el error al usuario, que el turno no existe
                //Dialogo.mostrarError(ex.getMessage());                    
            }
        }
}
