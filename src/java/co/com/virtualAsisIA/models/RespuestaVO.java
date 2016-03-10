package co.com.virtualAsisIA.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

/**
 * Clase value object(VO) utilizada para la consulta de las preguntas y
 * respuestas de un tema determinado Esta clase se utilizará para efectuar el
 * correspondiente Native Query.
 * 
 * @author inf_jeissl
 * 
 */
@SqlResultSetMapping(name = "RespuestaVO", entities = { @EntityResult(entityClass = RespuestaVO.class, fields = {
		@FieldResult(name = "id", column = "id"),
		@FieldResult(name = "pregunta", column = "pregunta"),
		@FieldResult(name = "respuesta", column = "respuesta"),
		@FieldResult(name = "cp_id", column = "cp_id") }) }, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "pregunta"),
		@ColumnResult(name = "respuesta"), @ColumnResult(name = "cp_id") })

@Entity
public class RespuestaVO implements Serializable  {

	private static final long serialVersionUID = 3137067325402018284L;
	
	private int id;
	private String pregunta;
	private String respuesta;
	private int cp_id;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "pregunta", nullable = false)
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	@Column(name = "respuesta", nullable = false)
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Column(name = "cp_id", nullable = false)
	public int getCp_id() {
		return cp_id;
	}

	public void setCp_id(int cp_id) {
		this.cp_id = cp_id;
	}

	
	public RespuestaVO(){}
	
	public RespuestaVO(int id, String pregunta, String respuesta, int cp_id){
		
		this.setId(id);
		this.setPregunta(pregunta);
		this.setRespuesta(respuesta);
		this.setCp_id(cp_id);

	}
}
