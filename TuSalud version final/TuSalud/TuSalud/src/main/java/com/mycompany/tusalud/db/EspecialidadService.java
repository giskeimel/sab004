/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class EspecialidadService {

    public EspecialidadService() {
    
    }
    
    public Especialidad consultarDeFamil(int id) throws LoginException {
        Especialidad deFam=null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Especialidad e WHERE e.id = :id");
            query.setParameter("id",id);
            deFam = (Especialidad) query.uniqueResult();

            session.getTransaction().commit();
        }catch(Exception e){
            MiDialogo.mostrar(e, "no se encuentra la especialidad");
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return deFam;
    }
    public Especialidad consultarEspecialidad(String nombre) throws LoginException {
        Especialidad der=null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Especialidad e WHERE e.nombre= :nombre");
            query.setParameter("nombre",nombre);
            der = (Especialidad) query.uniqueResult();

            session.getTransaction().commit();
        }catch(Exception e){
            MiDialogo.mostrar(e, "no se encuentra la especialidad");
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return der;
    }

    public List<Derivacion> consultaDerivacion(Paciente paciente) throws LoginException {
        List<Derivacion> derivaciones = null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Derivacion d WHERE d.paciente.id = :idPaciente AND d.aprobado = true ORDER BY d.especialidad.id ASC");
            query.setParameter("idPaciente", paciente.getId());
            derivaciones = query.list();

            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return derivaciones;
    }
    
    /**
     *
     * @param paciente
     * @return Lista de especialidades que corresponden al paciente o null en el
     * caso de que derivaciones.
     * @throws LoginException
     */
    public List<Especialidad> consultarEspecialidadAp(Paciente paciente) throws BDException, LoginException {
        List<Especialidad> especialidades = null;

        //en derivaciones se recuperan las derivaciones del paciente
        List<Derivacion> derivaciones = consultaDerivacion(paciente);
        if ((derivaciones == null) || (derivaciones.isEmpty())) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Derivacion derivacion : derivaciones) {
            if (sb.length() > 0) {
                sb.append(" OR ");
            }
            sb.append("(e.id = ");
            sb.append(derivacion.getEspecialidad().getId());
            sb.append(")");
        }

        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Especialidad e WHERE " + sb.toString());
            especialidades = query.list();
            session.getTransaction().commit();
            
            if (especialidades.isEmpty()){
                throw new BDException("La lista esta vacia");
            }
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return especialidades;
    }

    public List<Especialidad> getListaDeEspecialidadesEnDB() throws BDException{
        List<Especialidad> listaDeEspecialidades = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Especialidad");
            listaDeEspecialidades = (List<Especialidad>) query.list();
                        
            if (listaDeEspecialidades.isEmpty()){
                throw new BDException("La lista esta vacia");
            }
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la lista de turnos", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        return listaDeEspecialidades;
    }
}    


