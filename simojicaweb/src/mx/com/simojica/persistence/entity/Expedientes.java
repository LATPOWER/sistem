package mx.com.simojica.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "\"EXPEDIENTES\"")
public class Expedientes implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 8924442470478910765L;
	
	@Id
	@GeneratedValue(generator = "expedientes_sequence")
    @GenericGenerator(
    	
    	      name = "expedientes_sequence",
    	      
    	      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    	      parameters = {
    	    		  
    	        @Parameter(name = "sequence-name", value = "idExpediente"),
    	        @Parameter(name = "initial_value", value = "1"),
    	        @Parameter(name = "increment_size", value = "1")
    	        }
    	    )
	@Column(name = "\"IDEXPEDIENTE\"")
	private Long idExpediente;
	
	@Column(name = "\"APELLIDOPATERNO\"")
	private String apellidoPaterno;
	@Column(name = "\"APELLIDOMATERNO\"")
	private String apellidoMaterno;
	@Column(name = "\"NOMBRE\"")
	private String nombre;
	@Column(name = "\"FECHAACTUAL\"")
	private Date fechaActual;
	@Column(name = "\"FECHANACIMIENTO\"")
	private Date fechaNacimiento;
	@Column(name = "\"TELEFONO\"")
	private String telefono;
	@Column(name = "\"EDAD\"")
	private String edad;
	@Column(name = "\"FOT\"")
	private byte[] fot;
	
	@Column(name = "\"ID_DIRECCION\"")
	private Long idDirecion;
	
	@Column(name = "\"ID_HISTO_CLINICA\"")
	private Long idHistoriaClinica;
	
	@Column(name = "\"ID_FAMILIAR1\"")
	private Long idFamiliar1;
	
	@Column(name = "\"ID_FAMILIAR2\"")
	private Long idFamiliar2;
	
	@JoinColumns
	 ({
		  @JoinColumn(name = "\"ID_DIRECCION\"", insertable = false, updatable = false),
		  @JoinColumn(name = "\"IDEXPEDIENTE\"", insertable = false, updatable = false)
		})
	@OneToOne(cascade = CascadeType.REFRESH)
	private Direccion direccion;
	
	@JoinColumns
	({
	  @JoinColumn(name = "\"ID_HISTO_CLINICA\"", insertable = false, updatable = false),
	  @JoinColumn(name = "\"IDEXPEDIENTE\"", insertable = false, updatable = false)
	})

	@OneToOne(cascade = CascadeType.MERGE)
	private HistoriaClinica historiaClinica;
	@JoinColumns
	({
	  @JoinColumn(name ="\"ID_FAMILIAR1\"" , insertable = false, updatable = false),
	  @JoinColumn(name ="\"IDEXPEDIENTE\"", insertable = false, updatable = false)
	})		
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Familiar familiar1;
	@JoinColumns
	({
	  @JoinColumn(name ="\"ID_FAMILIAR2\"", insertable = false, updatable = false),
	  @JoinColumn(name = "\"IDEXPEDIENTE\"", insertable = false, updatable = false)
	})	

	@OneToOne(cascade = CascadeType.MERGE)
	private Familiar familiar2;
	
	
	public Expedientes() {
		super();
	}
	

	public Long getIdExpediente() {
		return idExpediente;
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
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public byte[] getFot() {
		return fot;
	}
	public void setFot(byte[] fot) {
		this.fot = fot;
	}

	public Long getIdDirecion() {
		return idDirecion;
	}

	public void setIdDirecion(Long idDirecion) {
		this.idDirecion = idDirecion;
	}

	public Long getIdHistoriaClinica() {
		return idHistoriaClinica;
	}

	public void setIdHistoriaClinica(Long idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
	}

	public Long getIdFamiliar1() {
		return idFamiliar1;
	}

	public void setIdFamiliar1(Long idFamiliar1) {
		this.idFamiliar1 = idFamiliar1;
	}

	public Long getIdFamiliar2() {
		return idFamiliar2;
	}

	public void setIdFamiliar2(Long idFamiliar2) {
		this.idFamiliar2 = idFamiliar2;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}

	public Familiar getFamiliar1() {
		return familiar1;
	}

	public void setFamiliar1(Familiar familiar1) {
		this.familiar1 = familiar1;
	}

	public Familiar getFamiliar2() {
		return familiar2;
	}

	public void setFamiliar2(Familiar familiar2) {
		this.familiar2 = familiar2;
	}

	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoMaterno == null) ? 0 : apellidoMaterno.hashCode());
		result = prime * result + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
		result = prime * result + ((idExpediente == null) ? 0 : idExpediente.hashCode());
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
		Expedientes other = (Expedientes) obj;
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
		if (idExpediente == null) {
			if (other.idExpediente != null)
				return false;
		} else if (!idExpediente.equals(other.idExpediente))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
