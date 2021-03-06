package co.com.virtualAsisIA.models;
// Generated 20/11/2015 04:16:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TemaEspecifico generated by hbm2java
 */
@Entity
@Table(name="tema_especifico"
    ,schema="public"
)
public class TemaEspecifico  implements java.io.Serializable {


     private int id;
     private String tema;
     private Set clasificacionPreguntas = new HashSet(0);

    public TemaEspecifico() {
    }

	
    public TemaEspecifico(int id) {
        this.id = id;
    }
    public TemaEspecifico(int id, String tema, Set clasificacionPreguntas) {
       this.id = id;
       this.tema = tema;
       this.clasificacionPreguntas = clasificacionPreguntas;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="tema", length=50)
    public String getTema() {
        return this.tema;
    }
    
    public void setTema(String tema) {
        this.tema = tema;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="temaEspecifico")
    public Set getClasificacionPreguntas() {
        return this.clasificacionPreguntas;
    }
    
    public void setClasificacionPreguntas(Set clasificacionPreguntas) {
        this.clasificacionPreguntas = clasificacionPreguntas;
    }




}


