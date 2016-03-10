/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.virtualAsisIA.ws;

import co.com.virtualAsisIA.models.Parametrizacion;
import co.com.virtualAsisIA.models.RespuestaVO;
import co.com.virtualAsisIA.models.RespuestaWs;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.core.MediaType;
import org.apache.commons.lang3.StringUtils;

/**
 * REST Web Service
 *
 * @author inf_jeissl
 */
@Path("virtualAsistant")
public class VirtualAsistantClass {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VirtualAsistantClass
     */
    public VirtualAsistantClass() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("parametrizar/{tipo}/{busqueda}")
    public String parametrizar(@PathParam("tipo") String tipoBusqueda, @PathParam("busqueda") String elementoBusqueda) throws Exception {
        
        Parametrizacion parametrizacion = new Parametrizacion();
        String busquedaActual = StringUtils.EMPTY;
        elementoBusqueda = StringUtils.isNotEmpty(elementoBusqueda) ? elementoBusqueda.trim() : StringUtils.EMPTY;
        tipoBusqueda = StringUtils.isNotEmpty(tipoBusqueda) ? tipoBusqueda.trim() : StringUtils.EMPTY;
        parametrizacion.setElementoBusqueda(elementoBusqueda);
        parametrizacion.setTipoBusqueda(tipoBusqueda);

        if (StringUtils.isNotEmpty(elementoBusqueda) && StringUtils.isNotEmpty(tipoBusqueda)) {
            //busquedaActual = asistenteVirtualEJBLocal.parametrizar(tipoBusqueda, elementoBusqueda);
            if (StringUtils.isNotEmpty(busquedaActual)) {
                parametrizacion.setElementoEncontrado(busquedaActual);
                parametrizacion.setEstado("sucess");
            } else {
                parametrizacion.setElementoEncontrado(StringUtils.EMPTY);
                parametrizacion.setEstado("fail");
            }
        }

        Gson json = new Gson();
        String jsonResponse = json.toJson(parametrizacion);
        jsonResponse = String.format("%s(%s);", "procesarParametrizacion", jsonResponse);
        return jsonResponse;
       
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("contestarPregunta/{caracterizador}/{accion}/{tema}/{pregunta}")
    public String contestarPregunta(
            @PathParam("caracterizador") String caracterizador,
            @PathParam("accion") String accion, @PathParam("tema") String tema, @PathParam("pregunta") String pregunta) throws Exception {

        
        RespuestaWs currentResponse = new RespuestaWs();
        String response = StringUtils.EMPTY;
        String estado = StringUtils.EMPTY;

        caracterizador = StringUtils.isNotEmpty(caracterizador) ? caracterizador.trim() : StringUtils.EMPTY;
        accion = StringUtils.isNotEmpty(accion) ? accion.trim() : StringUtils.EMPTY;
        tema = StringUtils.isNotEmpty(tema) ? tema.trim() : StringUtils.EMPTY;

        if (StringUtils.isNotEmpty(caracterizador) && StringUtils.isNotEmpty(accion) && StringUtils.isNotEmpty(tema)) {

            //response = asistenteVirtualEJBLocal.contestarPregunta(caracterizador, accion, tema);
            currentResponse.setPregunta(pregunta);

            if (StringUtils.isNotEmpty(response)) {
                currentResponse.setRespuesta(response);
            } else {
                currentResponse.setRespuesta("fail");
            }
        } else {
            currentResponse.setPregunta("Ingrese Una pregunta");
            currentResponse.setRespuesta(StringUtils.EMPTY);
        }

        estado = StringUtils.isNotEmpty(response) ? "sucess" : "fail";
        currentResponse.setEstado(estado);

        Gson json = new Gson();
        String jsonResponse = json.toJson(currentResponse);
        jsonResponse = String.format("%s(%s);", "procesarRespuesta", jsonResponse);

        return jsonResponse;
       
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarPreguntas/{tema}")
    public String consultarPreguntas(@PathParam("tema") String tema) throws Exception {

        
        tema = StringUtils.isNotEmpty(tema) ? tema.trim() : StringUtils.EMPTY;
        List<RespuestaVO> preguntas = new ArrayList<RespuestaVO>();

        if (StringUtils.isNotEmpty(tema)) {
            //preguntas = asistenteVirtualEJBLocal.consultarPreguntas(tema);
        }

        Gson json = new Gson();
        String jsonResponse = json.toJson(preguntas);
        jsonResponse = String.format("%s(%s);", "mostrarOpciones", jsonResponse);

        return jsonResponse;
         
    }

}
