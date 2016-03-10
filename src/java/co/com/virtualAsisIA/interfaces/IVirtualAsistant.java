/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.virtualAsisIA.interfaces;

import co.com.virtualAsisIA.models.RespuestaVO;
import java.util.List;

/**
 *
 * @author inf_jeissl
 */
public interface IVirtualAsistant {

    /**
     * Método que parametriza las acciones registradas por los usuarios
     *
     * @param accion
     * @return String con la accion parametrizada
     */
    public String parametrizar(String tipoBusqueda, String elementoBusqueda) throws Exception;

    /**
     * Método que retorna la respuesta a una pregunta realizada por un cliente
     *
     * @param caracterizador clasifica el tipo de pregunta
     * @param accion
     * @param tema
     * @return la respuesta a la pregunta realizada
     */
    public String contestarPregunta(String caracterizador, String accion, String tema) throws Exception;

    /**
     * Método que retorna las posibles preguntas disponibles de un tema
     *
     * @param tema
     * @return Lista con las preguntas posibles y su correspondiente respuesta.
     * @throws Exception
     * @throws ConfaException
     */
    public List<RespuestaVO> consultarPreguntas(String tema) throws Exception;
}
