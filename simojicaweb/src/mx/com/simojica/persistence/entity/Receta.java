package mx.com.simojica.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "\"RECETA\"")

public class Receta implements Serializable{

	
	
	private static final long serialVersionUID = -5930059836997886210L;
	
	public Receta() {
		super();
	}
	
	public Receta( String aPaterno, String aMaterno, String nombre, String pesoActual,
			String tallaActual, String temperatura, String edad, String direccion, Date fecha, String rp) {
		super();
	//	this.consulta = consulta;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.nombre = nombre;
		this.pesoActual = pesoActual;
		this.tallaActual = tallaActual;
		this.temperatura = temperatura;
		this.edad = edad;
		this.direccion = direccion;
		this.fecha = fecha;
		this.rp = rp;
	}

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
	
//	@Id
//	@JoinColumn(name = "\"ID_CONSULTA\"")
//	@OneToOne(cascade = CascadeType.DETACH)
// 	private Consulta consulta;
	
	@Column(name = "\"A_PATERNO\"")
	private String aPaterno;
	
	@Column(name = "\"A_MATERNO\"")
	private String aMaterno;
	
	@Column(name = "\"NOMBRE\"")
	private String nombre;
	
	@Column(name = "\"PESO_ACTUAL\"")
	private String pesoActual;
	
	@Column(name = "\"TALLA_ACTUAL\"")
	private String tallaActual;
	
	@Column(name = "\"TEMPERATURA\"")
	private String temperatura;
	
	@Column(name = "\"EDAD\"")
	private String edad;
	
	@Column(name = "\"DIRECCION\"")
	private String direccion;
	
	@Column(name = "\"FECHA\"")
	private Date fecha;
	
	@Column(name = "\"RP\"")
	private String rp;

	public Long getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(Long idReceta) {
		this.idReceta = idReceta;
	}



	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPesoActual() {
		return pesoActual;
	}

	public void setPesoActual(String pesoActual) {
		this.pesoActual = pesoActual;
	}

	public String getTallaActual() {
		return tallaActual;
	}

	public void setTallaActual(String tallaActual) {
		this.tallaActual = tallaActual;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRp() {
		return rp;
	}

	public void setRp(String rp) {
		this.rp = rp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aMaterno == null) ? 0 : aMaterno.hashCode());
		result = prime * result + ((aPaterno == null) ? 0 : aPaterno.hashCode());
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
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
		Receta other = (Receta) obj;
		if (aMaterno == null) {
			if (other.aMaterno != null)
				return false;
		} else if (!aMaterno.equals(other.aMaterno))
			return false;
		if (aPaterno == null) {
			if (other.aPaterno != null)
				return false;
		} else if (!aPaterno.equals(other.aPaterno))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
	
 

}
