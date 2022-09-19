package fpu.si4p.t2.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mesa
{
	@Id
	private Long id;
	private int numCadeiras;
	private int estado;
	
	public Mesa(){}
	
	public Mesa(Long id, int numCadeiras, int estado) {
		super();
		this.id = id;
		this.numCadeiras = numCadeiras;
		this.estado = estado;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumCadeiras() {
		return numCadeiras;
	}
	public void setNumCadeiras(int numCadeiras) {
		this.numCadeiras = numCadeiras;
	}	
}
