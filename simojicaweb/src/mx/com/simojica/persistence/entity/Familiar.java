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
@Table(name = "\"FAMILIAR\"")
@IdClass(FamiliarPK.class)
public class Familiar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8648234541292037238L;
	
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
 	private Expedientes expediente;
	

	@Column(name = "\"A_PATERNO\"")
	private String apellidoPaterno;
	
	@Column(name = "\"A_MATERNO\"")
	private String apellidoMaterno;
	
	@Column(name = "\"NOMBRE\"")
	private String nombre;
	
	@Column(name = "\"EDAD\"")
	private String edad;
	
	@Column(name = "\"OCUPACION\"")
	private String ocupacion;
	
	@Column(name = "\"FOT_M\"")
	private byte[] foto;
	
	public Familiar() {
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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoMaterno == null) ? 0 : apellidoMaterno.hashCode());
		result = prime * result + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
		result = prime * result + ((idFamiliar == null) ? 0 : idFamiliar.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Familiar other = (Familiar) obj;
		if (apellidoMaterno == null) {
			if (other.apellidoMaterno != null)
				return false;
		} else if (!apellidoMaterno.equals(other.apellidoMaterno))
			return false;
		if (apellidoPaterno == null) {
			if (other.apellidoPaterno != null)
				return false;
		} else if (!apellidoPaterno.equals(other.apellidoPaterno))
			return false;
		if (idFamiliar == null) {
			if (other.idFamiliar != null)
				return false;
		} else if (!idFamiliar.equals(other.idFamiliar))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
