package co.com.virtualAsisIA.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Parametrizacion {

	private String estado;
	private String elementoBusqueda;
	private String elementoEncontrado;
	private String tipoBusqueda;
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getElementoBusqueda() {
		return elementoBusqueda;
	}

	public void setElementoBusqueda(String elementoBusqueda) {
		this.elementoBusqueda = elementoBusqueda;
	}

	public String getElementoEncontrado() {
		return elementoEncontrado;
	}

	public void setElementoEncontrado(String elementoEncontrado) {
		this.elementoEncontrado = elementoEncontrado;
	}

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

	/**
	 * Constructor por defecto
	 */
	public Parametrizacion(){	
	}
	
	/**
	 * Constructor de la clase Parametrizacion
	 * @param accionBusqueda
	 * @param accion
	 * @param estado
	 */
	public Parametrizacion(String elementoBusqueda, String elementoEncontrado, String tipoBusqueda, String estado){	
		this.setElementoBusqueda(elementoBusqueda);
		this.setElementoEncontrado(elementoEncontrado);
		this.setTipoBusqueda(tipoBusqueda);
		this.setEstado(estado);
	}
		
}
