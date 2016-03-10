package co.com.virtualAsisIA.utils;

import java.util.Date;


/**
 * Interface que contiene las consultas utilizadas para utilitarios confaIps 
 * @author inf_jeissl
 *
 */
public interface UtilitariosQueries {
	
	public static final String
	
	parametrizarAccionQuery = "SELECT a.accion "
							  + "FROM acciones a "
							  + "WHERE a.id = (SELECT ua.accion_id FROM unificacion_accion ua WHERE ua.sinonimo_accion LIKE :elementoBusqueda)";


	public static final String
	
	parametrizarTemaQuery = "SELECT te.tema "
							  + "FROM tema_especifico te "
							  + "WHERE te.tema LIKE :elementoBusqueda";
	
	
	public static final String
	
	contestarPreguntaQuery = "SELECT r.respuesta "
							+ "FROM respuesta r "
							+ "WHERE r.cp_id = (select cp.id FROM clasificacion_pregunta cp "
							+ "INNER JOIN caracterizacion c on c.id = cp.caract_id "
							+ "INNER JOIN acciones a on a.id = cp.accion_id "
							+ "INNER JOIN tema_especifico te on te.id=cp.tema_id " 
							+ "WHERE c.caracterizador = :caracterizador AND a.accion = :accion AND te.tema LIKE :tema)";
	
	
	public static final String 
	
	consultarPreguntasQuery = "SELECT r.id as id, r.pregunta as pregunta, r.respuesta as respuesta, r.cp_id as cp_id "
							+ "FROM respuesta r "
							+ "INNER JOIN clasificacion_pregunta cp on r.cp_id = cp.id "
							+ "INNER JOIN tema_especifico te on cp.tema_id = te.id "
							+ "WHERE te.tema LIKE :tema";
	
	
}
