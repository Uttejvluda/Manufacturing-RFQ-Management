package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {


	private String result;

	public Result(String result) {
		super();
		this.result = result;
	}
	
	
}
