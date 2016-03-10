package co.com.virtualAsisIA.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RespuestaWs {
	
	private String pregunta;
	private String respuesta;
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPregunta() {
		return pregunta;
	}
	
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
	/**
	 * Constructor por defecto de la clase
	 */
	public RespuestaWs(){	
	}
	
	
	/**
	 * Constructor clase
	 * @param id
	 * @param pregunta
	 * @param respuesta
	 */
	public RespuestaWs(String pregunta, String respuesta, String estado){
		this.setPregunta(pregunta);
		this.setRespuesta(respuesta);
		this.setEstado(estado);
	}
	
	
}
