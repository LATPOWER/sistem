package mx.com.simojica.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "\"CONSULTA\"")
@IdClass(ConsultaPK.class)
public class Consulta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -414300120805069103L;
	
	
	public Consulta() {
		super();
	}
		
	public Consulta( Receta receta, String pad_actual, String impresionDiagnostica, String plan,
			String nombre, Date fecha_actual, String peso_actual, String talla_actual, String temperatura,
			String observaciones, String edad) {
		super();
		//this.consultaPk = consultaPk;
		this.receta = receta;
		this.pad_actual = pad_actual;
		this.impresionDiagnostica = impresionDiagnostica;
		this.plan = plan;
		this.nombre = nombre;
		this.fecha_actual = fecha_actual;
		this.peso_actual = peso_actual;
		this.talla_actual = talla_actual;
		this.temperatura = temperatura;
		this.observaciones = observaciones;
		this.edad = edad;
	}

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
 	private Expedientes expediente;
	
	@JoinColumn(name = "\"ID_RECETA\"")
	@OneToOne(cascade = CascadeType.DETACH)
	
	private Receta receta;
//	@Column(name = "\"ID_RECETA\"")
//	private Receta idRecenta;
	
	@Column(name = "\"PAD_ACTUAL\"")
	private String pad_actual;
	@Column(name = "\"IMPRESION_DIAGNOSTICA\"")
	private String impresionDiagnostica;
	@Column(name = "\"PLAN\"")
	private String plan;
	@Column(name = "\"NOMBRE\"")
	private String nombre;
	@Column(name = "\"FECHA_ACTUAL\"")
	private Date fecha_actual;
	@Column(name = "\"PESO_ACTUAL\"")
	private String peso_actual;
	@Column(name = "\"TALLA_ACTUAL\"")
	private String talla_actual;
	@Column(name = "\"TEMPERATURA\"")
	private String temperatura;
	@Column(name = "\"OBSERVACIONES\"")
	private String observaciones;
	@Column(name = "\"EDAD\"")
	private String edad;

	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	public String getPad_actual() {
		return pad_actual;
	}
	public void setPad_actual(String pad_actual) {
		this.pad_actual = pad_actual;
	}
	public String getImpresionDiagnostica() {
		return impresionDiagnostica;
	}
	public void setImpresionDiagnostica(String impresionDiagnostica) {
		this.impresionDiagnostica = impresionDiagnostica;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_actual() {
		return fecha_actual;
	}
	public void setFecha_actual(Date fecha_actual) {
		this.fecha_actual = fecha_actual;
	}
	public String getPeso_actual() {
		return peso_actual;
	}
	public void setPeso_actual(String peso_actual) {
		this.peso_actual = peso_actual;
	}
	public String getTalla_actual() {
		return talla_actual;
	}
	public void setTalla_actual(String talla_actual) {
		this.talla_actual = talla_actual;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
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
		result = prime * result + ((idConsulta == null) ? 0 : idConsulta.hashCode());
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
		Consulta other = (Consulta) obj;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (idConsulta == null) {
			if (other.idConsulta != null)
				return false;
		} else if (!idConsulta.equals(other.idConsulta))
			return false;
		return true;
	}
	

}
