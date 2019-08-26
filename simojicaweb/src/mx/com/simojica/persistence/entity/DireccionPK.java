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
public class DireccionPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 840010452740268129L;
	
	@Id
	@GeneratedValue(generator = "expedientes_direccion")
    @GenericGenerator(
    	
    	      name = "expedientes_direccion",
    	      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    	      parameters = {
    	    		  
    	        @Parameter(name = "sequence-name", value = "idDireccion"),
    	        @Parameter(name = "initial_value", value = "1"),
    	        @Parameter(name = "increment_size", value = "1")
    	        }
   	    )
	
	@Column(name = "\"ID_DIRECCION\"")
	private Long idDireccion;
	
	@Id
	@JoinColumn(name = "\"IDEXPEDIENTE\"")
	@OneToOne(cascade = CascadeType.DETACH)
 	private Expedientes expediente;

	
	
	public DireccionPK() {
		super();
	}
	
	
	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
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
		result = prime * result + ((idDireccion == null) ? 0 : idDireccion.hashCode());
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
		DireccionPK other = (DireccionPK) obj;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (idDireccion == null) {
			if (other.idDireccion != null)
				return false;
		} else if (!idDireccion.equals(other.idDireccion))
			return false;
		return true;
	}	
	
}
