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
public class ConsultaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3872979156854556582L;
	
	@Id
	@GeneratedValue(generator = "expedientes_consulta")
    @GenericGenerator(
    	
    	      name = "expedientes_consulta",
    	      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    	      parameters = {
    	    		  
    	        @Parameter(name = "sequence-name", value = "idConsulta"),
    	        @Parameter(name = "initial_value", value = "1"),
    	        @Parameter(name = "increment_size", value = "1")
    	        }
    	    )
	@Column(name = "\"ID_CONSULTA\"")
	private Long idConsulta;
	
	@Id
 	@JoinColumn(name = "\"IDEXPEDIENTE\"")
 	@ManyToOne(cascade = CascadeType.DETACH)
	private Expedientes expediente;
	
	public ConsultaPK() {
		super();
	}
	
	public Long getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
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
		result = prime * result + (int) (idConsulta ^ (idConsulta >>> 32));
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
		ConsultaPK other = (ConsultaPK) obj;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (idConsulta != other.idConsulta)
			return false;
		return true;
	}
 
}
