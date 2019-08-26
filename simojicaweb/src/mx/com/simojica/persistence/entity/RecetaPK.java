package mx.com.simojica.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Embeddable
public class RecetaPK implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3873304180521182371L;
	
	
	@Id
	@GeneratedValue(generator = "expedientes_receta")
    @GenericGenerator(
    	
    	      name = "expedientes_receta",
    	      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    	      parameters = {
    	    		  
    	        @Parameter(name = "sequence-name", value = "idReceta"),
    	        @Parameter(name = "initial_value", value = "1"),
    	        @Parameter(name = "increment_size", value = "1")
    	        }
   	    )
	@Column(name = "\"ID_RECETA\"")
	private Long idReceta;
	
	@Id
	@JoinColumn(name = "\"ID_CONSULTA\"")
	@OneToOne(cascade = CascadeType.DETACH)
 	private Consulta consulta;
	
	public RecetaPK() {
		super();
	}
	
	public Long getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(Long idReceta) {
		this.idReceta = idReceta;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((idReceta == null) ? 0 : idReceta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecetaPK other = (RecetaPK) obj;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (idReceta == null) {
			if (other.idReceta != null)
				return false;
		} else if (!idReceta.equals(other.idReceta))
			return false;
		return true;
	}	
	

}
