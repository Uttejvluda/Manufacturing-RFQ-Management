package com.example.demo.vo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierPartVo {
	private int id;
	private int partId;
	private String partName;
	private int timePeriod;
	

}
