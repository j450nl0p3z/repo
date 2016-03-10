/*
 * Clase encargada de la persistencia en base de datos
 */
package co.com.virtualAsisIA.persistence;

import co.com.virtualAsisIA.interfaces.IVirtualAsistant;
import co.com.virtualAsisIA.models.RespuestaVO;
import co.com.virtualAsisIA.utils.HibernateUtil;
import co.com.virtualAsisIA.utils.UtilitariosQueries;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author SABAOT
 */
public class UnidadPersistencia implements IVirtualAsistant {

    private static Logger slf4jLogger  = LoggerFactory.getLogger(UnidadPersistencia.class);
    
    /**
     * Metodo usado para obtener listas de registros de una tabla específica
     *
     * @param entidad : Entidad usada par la búsqueda.
     * @return Lista de registros de la entidad especificada.
     */
    public static <T> List<T> consultarRegistros(T entidad) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();

        try {
            List<T> estados = ses.createCriteria(entidad.getClass()).list();
            return estados;
        } catch (Exception ex) {
            System.out.println("Error al recuperar los registros de la base de datos " + ex);
            return null;
        }
    }

    /**
     * Método usado para obtener un registros de una tabla específica
     *
     * @param entidad : Entidad usada par la búsqueda.
     * @param id: Id de la entidad a buscar
     * @return entidad especificada.
     */
    public static <T> T consultarRegistroPorId(T entidad, String nombreCampoId, int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();

        try {
            entidad = (T) ses.createCriteria(entidad.getClass()).add(Restrictions.eq(nombreCampoId, id)).uniqueResult();
            return entidad;
        } catch (Exception ex) {
            System.out.println("Error al recuperar los registros de la base de datos " + ex);
            return null;
        }
    }

    /**
     * Método usado para obtener un registros de una tabla específica
     *
     * @param entidad : Entidad usada par la búsqueda.
     * @param propiedades: propiedades de búsqueda
     * @return entidad especificada.
     */
    public static <T> T consultarRegistroPorPropiedades(T entidad, Map<String, Object> propiedades) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();

        try {

            Criteria criterio = ses.createCriteria(entidad.getClass());

            for (Entry<String, Object> propiedad : propiedades.entrySet()) {
                String key = propiedad.getKey();
                Object value = propiedad.getValue();
                criterio.add(Restrictions.eq(key, value));
            }

            entidad = (T) criterio.uniqueResult();
            return entidad;

        } catch (Exception ex) {
            System.out.println("Error al recuperar los registros de la base de datos " + ex);
            return null;
        }
    }

    /**
     * Método usado para obtener un registros de una tabla específica
     *
     * @param entidad : Entidad usada par la búsqueda.
     * @param propiedades: propiedades de búsqueda
     * @return entidad especificada.
     */
    public static <T> List<T> consultarRegistrosPorPropiedades(T entidad, Map<String, Object> propiedades) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();

        try {

            Criteria criterio = ses.createCriteria(entidad.getClass());

            for (Entry<String, Object> propiedad : propiedades.entrySet()) {
                String key = propiedad.getKey();
                Object value = propiedad.getValue();
                criterio.add(Restrictions.eq(key, value));
            }

            List<T> entidades = criterio.list();
            return entidades;

        } catch (Exception ex) {
            System.out.println("Error al recuperar los registros de la base de datos " + ex);
            return null;
        }
    }

    /**
     * Método usado para guardar o actualizar un registro de una tabla
     * específica
     *
     * @param entidad : Entidad a guardar.
     * @return boolean true si es exitosa la operación de lo contrario retornará
     * false.
     */
    public static <T> boolean guardarRegistro(T entidad) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();

        try {
            Transaction transaccion = ses.beginTransaction();
            ses.saveOrUpdate(entidad);
            transaccion.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Error al recuperar los registros de la base de datos " + ex);
            return false;
        }

    }

    /**
     * Método usado para eliminar un registro de una tabla específica
     *
     * @param entidad : Entidad a guardar.
     * @param nombreCampo : Entidad a guardar.
     * @param id : Entidad a guardar.
     * @return boolean true si es exitosa la operación de lo contrario retornará
     * false.
     */
    public static <T> boolean eliminarRegistro(T entidad, String nombreCampo, int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        try {
            Transaction transaccion = ses.beginTransaction();
            entidad = (T) ses.createCriteria(entidad.getClass()).add(Restrictions.eq(nombreCampo, id)).uniqueResult();
            ses.delete(entidad);
            transaccion.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public String parametrizar(String tipoBusqueda, String elementoBusqueda) throws Exception {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();

        String queryString = StringUtils.EMPTY;

        if (tipoBusqueda.equals("accion")) {
            queryString = UtilitariosQueries.parametrizarAccionQuery;    

        } else if (tipoBusqueda.equals("tema")) {

            queryString = UtilitariosQueries.parametrizarTemaQuery;
            elementoBusqueda = elementoBusqueda + "%";
        }

        String elementoEncontrado = StringUtils.EMPTY;

        try {
//            Query query = em.createNativeQuery(queryString);      
//            query.setParameter("elementoBusqueda", elementoBusqueda);
//            elementoEncontrado = this.findEntity(elementoEncontrado, query, em);
            
            //Mirar esta opción con inner joins usando criteria
            
//            Criteria c = session.createCriteria(Dokument.class, "dokument");
//            c.createAlias("dokument.role", "role"); // inner join by default
//            c.createAlias("role.contact", "contact");
//            c.add(Restrictions.eq("contact.lastName", "Test"));
//            return c.list();
//            http://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/querycriteria.html#querycriteria-associations
//            http://docs.jboss.org/hibernate/core/3.6/javadocs/org/hibernate/Criteria.html

        } catch (Exception ex) {
            slf4jLogger.error("No se encontro la parametrizacion, " + ex);
        }

         ses.close();
        
        return elementoEncontrado;
    }

    @Override
    public String contestarPregunta(String caracterizador, String accion, String tema) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RespuestaVO> consultarPreguntas(String tema) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
