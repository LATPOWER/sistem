package mx.com.simojica.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "\"DIRECCION\"")
@IdClass(DireccionPK.class)
public class Direccion implements Serializable {
	
	private static final long serialVersionUID = -5118250332162675873L;
	
	
	public Direccion() {
		super();
	}
	
	public Direccion(Expedientes expediente, String calleAvenida, String numero, String colonia, String ciudadEstado,
			String manzana, String codigoPostal) {
		super();
		this.expediente = expediente;
		this.calleAvenida = calleAvenida;
		this.numero = numero;
		this.colonia = colonia;
		this.ciudadEstado = ciudadEstado;
		this.manzana = manzana;
		this.codigoPostal = codigoPostal;
	}

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
	@ManyToOne(cascade = CascadeType.MERGE)
 	private Expedientes expediente;
	
	@Column(name = "\"CALLE_AV\"")
	private String calleAvenida;
	
	@Column(name = "\"NUMERO\"")
	private String numero;
	
	@Column(name = "\"COLONIA\"")
	private String colonia;
	
	@Column(name = "\"CD_EDO\"")
	private String ciudadEstado;
	
	@Column(name = "\"MANZANA\"")
	private String manzana;
	
	@Column(name = "\"CP\"")
	private String codigoPostal;


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

	public String getCalleAvenida() {
		return calleAvenida;
	}

	public void setCalleAvenida(String calleAvenida) {
		this.calleAvenida = calleAvenida;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCiudadEstado() {
		return ciudadEstado;
	}

	public void setCiudadEstado(String ciudadEstado) {
		this.ciudadEstado = ciudadEstado;
	}

	public String getManzana() {
		return manzana;
	}

	public void setManzana(String manzana) {
		this.manzana = manzana;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calleAvenida == null) ? 0 : calleAvenida.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((idDireccion == null) ? 0 : idDireccion.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Direccion other = (Direccion) obj;
		if (calleAvenida == null) {
			if (other.calleAvenida != null)
				return false;
		} else if (!calleAvenida.equals(other.calleAvenida))
			return false;
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
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	

}
