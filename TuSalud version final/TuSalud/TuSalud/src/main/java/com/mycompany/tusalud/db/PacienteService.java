/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Direccion;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.TuSaludException;
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class PacienteService {
     
    public Paciente buscarPaciente(int hcp){
         Paciente paciente=null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Paciente p WHERE p.historia_clinica = :hcp");
            query.setParameter("hcp", hcp);
            paciente = (Paciente) query.uniqueResult();

            session.getTransaction().commit();
        }catch(Exception e){
            MiDialogo.mostrar(e, "no se encuentra al paciente");
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return paciente;
    } 
    
    public Paciente getPacientePorId(int idPaciente){
        Paciente paciente = null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Paciente p WHERE p.id = :idPaciente");
            query.setParameter("idPaciente", idPaciente);
            paciente = (Paciente) query.uniqueResult();

            session.getTransaction().commit();
        }catch(Exception e){
            MiDialogo.mostrar(e, "no se encuentra al paciente");
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return paciente;
    } 
    
    public void guardarPacienteEnBD(Paciente paciente) throws BDException {
        Session session = null;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.saveOrUpdate(paciente);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el paciente", e);
        } if(session.isOpen()){
            session.close();
        }
    }
    
    public void eliminarPacienteEnBD(Paciente paciente) throws BDException {
        Session session = null;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.delete(paciente);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al eliminar el paciente", e);
        } if(session.isOpen()){
            session.close();
        }
    }
    
    public Paciente crearPaciente(Cuenta cuenta, String nombre, String apellido, int historia_clinica, String email, Direccion direccion, Lugar lugar) throws TuSaludException {
        //LA IDEA ES QUE CUANDO CREA UN PACIENTE LE CREE UNA DERIVACION APROVADA DE FAMILIA
        Paciente paciente = new Paciente();
        paciente.setApellido(apellido);
        paciente.setCuenta(cuenta);
        paciente.setHistoria_clinica(historia_clinica);
        paciente.setNombre(nombre);
        paciente.setEmail(email);
        paciente.setDireccion(direccion);
        paciente.setObservaciones(email);
        paciente.setLugarDesignado(lugar);

        
       
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            session.saveOrUpdate(paciente);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new TuSaludException("Error al pedir el paciente", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        
        
        return paciente;
    }
    
    public List<Paciente> getListaDePacientesDeLugar(Integer idLugar) {
        List<Paciente> pacientes = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Paciente p WHERE p.lugarDesignado.id = :idLugar order by p.apellido asc");
            query.setParameter("idLugar", idLugar);
            
            pacientes = (List<Paciente>) query.list();
            
            if (pacientes.isEmpty()){
                MiDialogo.mostrar("La lista de pacientes esta vacia", "Mensaje");
            }
            
        } catch (HibernateException e) {
            e.printStackTrace();
            MiDialogo.mostrar(e, "Error lista de pacientes");
        } finally {
            if (session.isOpen())
                session.close();
        }
        return pacientes;
    }
    
    public List<Object[]> getListaDePacientesPorIndice(Integer idLugar, String valor) {
        List<Object[]> pacientes = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("SELECT id,apellido,nombre,historia_clinica,telefono FROM Paciente p WHERE ((p.nombre LIKE :valor) OR (p.apellido LIKE :valor) OR (p.historia_clinica LIKE :valor)) AND (p.id_lugar = :idLugar)");
            query.setParameter("idLugar", idLugar);
            query.setParameter("valor", valor);
            
            pacientes = (List<Object[]>) query.list();
            
            if (pacientes.isEmpty()){
               Query query2 = session.createSQLQuery("SELECT id,apellido,nombre,historia_clinica,telefono FROM Paciente p WHERE p.id_lugar = :idLugar");
               query2.setParameter("idLugar", idLugar);
               pacientes = (List<Object[]>) query2.list();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            MiDialogo.mostrar(e, "Error lista de pacientes");
        } finally {
            if (session.isOpen())
                session.close();
        }
        return pacientes;
    }
}
