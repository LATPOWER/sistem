package mx.com.simojica.domain;

import java.io.Serializable;

public class Expediente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2379161200260629486L;
	
	
	public long idExpediente;
	public String name;
	public String apellidoPaterno;
	
	public long getIdExpediente() {
		return idExpediente;
	}
	public void setIdExpediente(long idExpediente) {
		this.idExpediente = idExpediente;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	

}
