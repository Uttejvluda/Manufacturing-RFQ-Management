package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplier_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;

	@Column(name="phone")
	private String phone;

	@Column(name="location")
	private String location;

	@Column(name="feedback")
	private int feedback;
	
	
	
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(Integer supplier_id, String name, String email, String phone, String location, int feedback) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.feedback = feedback;
	}

//	public Supplier(String name, String email, String phone, String location, int feedback) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.phone = phone;
//		this.location = location;
//		this.feedback = feedback;
//	}
//	public Supplier(Integer supplier_id,int feedback) {
//		super();
//		this.supplier_id = supplier_id;
//		this.feedback = feedback;
//	}

	@JsonBackReference
	@OneToMany(mappedBy="supplier",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Supplier_part> parts;


	public Integer getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFeedback() {
		return feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

	public List<Supplier_part> getParts() {
		return parts;
	}

	public void setParts(List<Supplier_part> parts) {
		this.parts = parts;
	}
	
	
}
