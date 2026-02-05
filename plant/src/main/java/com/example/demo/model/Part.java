package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="part")
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "partid")
	private Integer partId;
	
	@Column(name = "partdescription")
	private String partDescription;
	
	@Column(name = "partspecification")
	private String partSpecification;
	
	@Column(name = "stockinhand")
	private Integer stockInHand;
	
	
	
	
	public Part() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Part(Integer partId, String partDescription, String partSpecification, Integer stockInHand) {
		super();
		this.partId = partId;
		this.partDescription = partDescription;
		this.partSpecification = partSpecification;
		this.stockInHand = stockInHand;
	}

	@OneToOne(mappedBy="part",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private ReorderRules reorderrule;
	
	@OneToOne(mappedBy="part",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private Demand demand;
	
	@OneToMany(mappedBy="part",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<PlantReorderDetails> reoderdetails;


	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getPartSpecification() {
		return partSpecification;
	}

	public void setPartSpecification(String partSpecification) {
		this.partSpecification = partSpecification;
	}

	public Integer getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(Integer stockInHand) {
		this.stockInHand = stockInHand;
	}

	public ReorderRules getReorderrule() {
		return reorderrule;
	}

	public void setReorderrule(ReorderRules reorderrule) {
		this.reorderrule = reorderrule;
	}

	public Demand getDemand() {
		return demand;
	}

	public void setDemand(Demand demand) {
		this.demand = demand;
	}

	public List<PlantReorderDetails> getReoderdetails() {
		return reoderdetails;
	}

	public void setReoderdetails(List<PlantReorderDetails> reoderdetails) {
		this.reoderdetails = reoderdetails;
	}
	
	
}
