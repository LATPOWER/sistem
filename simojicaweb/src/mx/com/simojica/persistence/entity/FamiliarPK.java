package mx.com.simojica.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Embeddable
public class FamiliarPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -982695936192791278L;
	
	@Id
	@GeneratedValue(generator = "expedientes_familiar")
    @GenericGenerator(
    	
    	      name = "expedientes_familiar",
    	      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    	      parameters = {
    	    		  
    	        @Parameter(name = "sequence-name", value = "idFamiliar"),
    	        @Parameter(name = "initial_value", value = "1"),
    	        @Parameter(name = "increment_size", value = "1")
    	        }
   	    )
	@Column(name = "\"ID_FAMILIAR\"")
	private Long idFamiliar;
	
	@Id
	@JoinColumn(name = "\"IDEXPEDIENTE\"")
	@ManyToOne(cascade = CascadeType.DETACH)
 	private Expedientes expediente;
	
	public FamiliarPK() {
		super();
	}
	
	public Long getIdFamiliar() {
		return idFamiliar;
	}


	public void setIdFamiliar(Long idFamiliar) {
		this.idFamiliar = idFamiliar;
	}


	public Expedientes getExpediente() {
		return expediente;
	}


	public void setExpediente(Expedientes expediente) {
		this.expediente = expediente;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((idFamiliar == null) ? 0 : idFamiliar.hashCode());
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
		FamiliarPK other = (FamiliarPK) obj;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (idFamiliar == null) {
			if (other.idFamiliar != null)
				return false;
		} else if (!idFamiliar.equals(other.idFamiliar))
			return false;
		return true;
	}
	
	

}
