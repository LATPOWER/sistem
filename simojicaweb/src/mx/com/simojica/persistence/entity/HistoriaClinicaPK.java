package mx.com.simojica.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Embeddable
public class HistoriaClinicaPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4150154408298191794L;
	
	
	public HistoriaClinicaPK() {
		super();
	}
	

	public HistoriaClinicaPK(Long idHistoriaClinica, Expedientes expediente) {
		super();
		this.idHistoriaClinica = idHistoriaClinica;
		this.expediente = expediente;
	}

	@Id
	@GeneratedValue(generator = "expedientes_hist_clinica")
    @GenericGenerator(
    	
    	      name = "expedientes_hist_clinica",
    	      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    	      parameters = {
    	    		  
    	        @Parameter(name = "sequence-name", value = "idHistoriaClinica"),
    	        @Parameter(name = "initial_value", value = "1"),
    	        @Parameter(name = "increment_size", value = "1")
    	        }
   	    )
	@Column(name = "\"ID_HISTO_CLINICA\"")
	private Long idHistoriaClinica;
	
	@Id
	@JoinColumn(name = "\"IDEXPEDIENTE\"")
	@ManyToOne(cascade = CascadeType.DETACH)
 	private Expedientes expediente;


	public Long getIdHistoriaClinica() {
		return idHistoriaClinica;
	}


	public void setIdHistoriaClinica(Long idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
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
		result = prime * result + ((idHistoriaClinica == null) ? 0 : idHistoriaClinica.hashCode());
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
		HistoriaClinicaPK other = (HistoriaClinicaPK) obj;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (idHistoriaClinica == null) {
			if (other.idHistoriaClinica != null)
				return false;
		} else if (!idHistoriaClinica.equals(other.idHistoriaClinica))
			return false;
		return true;
	}
	

}
