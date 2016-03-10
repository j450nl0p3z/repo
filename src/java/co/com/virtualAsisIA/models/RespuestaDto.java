package co.com.virtualAsisIA.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RespuestaDto {

	private List<RespuestaVO> opcionesPregunta;

	public List<RespuestaVO> getOpcionesPregunta() {
		return opcionesPregunta;
	}

	public void setOpcionesPregunta(List<RespuestaVO> opcionesPregunta) {
		this.opcionesPregunta = opcionesPregunta;
	}

	public RespuestaDto() {
		opcionesPregunta = new ArrayList<RespuestaVO>();
	}

	public RespuestaDto(List<RespuestaVO> opcionesPregunta) {
		opcionesPregunta = new ArrayList<RespuestaVO>();
		this.setOpcionesPregunta(opcionesPregunta);
	}

}
