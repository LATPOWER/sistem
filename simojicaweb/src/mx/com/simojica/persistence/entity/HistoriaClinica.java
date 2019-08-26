package mx.com.simojica.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "\"HISTCLINICA\"")
@IdClass(HistoriaClinicaPK.class)
public class HistoriaClinica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -119434291905802744L;
	
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
 	private Expedientes expediente;
	
	@Column(name = "\"ANT_HEREDO_FAMILIARES\"")
	private String antecedentesHeredoFamiliares;
	
	@Column(name = "\"PERSONALES_PATOLOGICOS\"")
	private String personalesPatologicos;
	
	@Column(name = "\"SENO_MATERNO\"")
	private String senoMaterno;
	
	@Column(name = "\"INMUNIZACIONES\"")
	private String inmunizaciones;
	
	@Column(name = "\"DES_PSI\"")
	private String descripcionPsicomotriz;
	
	
	@Column(name = "\"PESO_NACIMIENTO\"")
	private String pesoNacimiento;
	
	
	@Column(name = "\"TALLA_NACIMIENTO\"")
	private String tallNacimiento;
	
	
	@Column(name = "\"OBSERVACIONES\"")
	private String observaciones;
	
	public HistoriaClinica() {
		super();
	}
	

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

	public String getAntecedentesHeredoFamiliares() {
		return antecedentesHeredoFamiliares;
	}

	public void setAntecedentesHeredoFamiliares(String antecedentesHeredoFamiliares) {
		this.antecedentesHeredoFamiliares = antecedentesHeredoFamiliares;
	}

	public String getPersonalesPatologicos() {
		return personalesPatologicos;
	}

	public void setPersonalesPatologicos(String personalesPatologicos) {
		this.personalesPatologicos = personalesPatologicos;
	}

	public String getSenoMaterno() {
		return senoMaterno;
	}

	public void setSenoMaterno(String senoMaterno) {
		this.senoMaterno = senoMaterno;
	}

	public String getInmunizaciones() {
		return inmunizaciones;
	}

	public void setInmunizaciones(String inmunizaciones) {
		this.inmunizaciones = inmunizaciones;
	}

	public String getDescripcionPsicomotriz() {
		return descripcionPsicomotriz;
	}

	public void setDescripcionPsicomotriz(String descripcionPsicomotriz) {
		this.descripcionPsicomotriz = descripcionPsicomotriz;
	}

	public String getPesoNacimiento() {
		return pesoNacimiento;
	}

	public void setPesoNacimiento(String pesoNacimiento) {
		this.pesoNacimiento = pesoNacimiento;
	}

	public String getTallNacimiento() {
		return tallNacimiento;
	}

	public void setTallNacimiento(String tallNacimiento) {
		this.tallNacimiento = tallNacimiento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHistoriaClinica == null) ? 0 : idHistoriaClinica.hashCode());
		result = prime * result + ((pesoNacimiento == null) ? 0 : pesoNacimiento.hashCode());
		result = prime * result + ((senoMaterno == null) ? 0 : senoMaterno.hashCode());
		result = prime * result + ((tallNacimiento == null) ? 0 : tallNacimiento.hashCode());
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
		HistoriaClinica other = (HistoriaClinica) obj;
		if (idHistoriaClinica == null) {
			if (other.idHistoriaClinica != null)
				return false;
		} else if (!idHistoriaClinica.equals(other.idHistoriaClinica))
			return false;
		if (pesoNacimiento == null) {
			if (other.pesoNacimiento != null)
				return false;
		} else if (!pesoNacimiento.equals(other.pesoNacimiento))
			return false;
		if (senoMaterno == null) {
			if (other.senoMaterno != null)
				return false;
		} else if (!senoMaterno.equals(other.senoMaterno))
			return false;
		if (tallNacimiento == null) {
			if (other.tallNacimiento != null)
				return false;
		} else if (!tallNacimiento.equals(other.tallNacimiento))
			return false;
		return true;
	}
	
	
	



}
