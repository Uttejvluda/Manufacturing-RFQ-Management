package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NegativeOrZero;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="supplier_part")
public class Supplier_part {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "partid")
	private int partid;


	@Column(name = "partname")
	private String partname;

	private int quantity;

	@Column(name = "timeperiod")
	private int timeperiod;
	
	
	
	public Supplier_part() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public Supplier_part(int id, int partid, String partname, int quantity, int timeperiod) {
//		super();
//		this.id = id;
//		this.partid = partid;
//		this.partname = partname;
//		this.quantity = quantity;
//		this.timeperiod = timeperiod;
//	}


//	
	public Supplier_part(int id, int partid, String partname, int quantity, int timeperiod, Supplier supplier) {
		super();
		this.id = id;
		this.partid = partid;
		this.partname = partname;
		this.quantity = quantity;
		this.timeperiod = timeperiod;
		this.supplier = supplier;
	}


	@ManyToOne
	@JoinColumn(name="sid")
	@JsonBackReference
	private Supplier supplier;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPartid() {
		return partid;
	}


	public void setPartid(int partid) {
		this.partid = partid;
	}


	public String getPartname() {
		return partname;
	}


	public void setPartname(String partname) {
		this.partname = partname;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getTimeperiod() {
		return timeperiod;
	}


	public void setTimeperiod(int timeperiod) {
		this.timeperiod = timeperiod;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	
}
