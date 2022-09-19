package fpu.si4p.t2.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item 
{
	@Id
	private Long id;
	private double precoItem;
	private String descItem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPrecoItem() {
		return precoItem;
	}
	public void setPrecoItem(double precoItem) {
		this.precoItem = precoItem;
	}
	public String getDescItem() {
		return descItem;
	}
	public void setDescItem(String descItem) {
		this.descItem = descItem;
	}
}
