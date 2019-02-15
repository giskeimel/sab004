/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.excepciones.LoginException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class ConsultaEspecialidad {
    
      
    public List<Derivacion> consultaDerivacion(Paciente paciente) throws LoginException {
        List<Derivacion> derivaciones = null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Derivacion d WHERE d.paciente.id = :idPaciente");
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
    public List<Especialidad> consultarEspecialidadAp(Paciente paciente) throws LoginException {
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
            sb.append(derivacion.getEspecialidad().getIdEspecialidad());
            sb.append(")");
        }

        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Especialidad e WHERE " + sb.toString());
            especialidades = query.list();
            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return especialidades;
    }

    }    

