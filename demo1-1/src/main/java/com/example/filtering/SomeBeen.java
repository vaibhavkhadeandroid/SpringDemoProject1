package com.example.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Swap
 *
 */
@JsonFilter("Somebeenfilter")
public class SomeBeen {

	private String s1;
	private String s2;
	private String s3;
	
	public SomeBeen(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
		this.s1=string;
		this.s2=string2;
		this.s3=string3;
		
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getS3() {
		return s3;
	}

	public void setS3(String s3) {
		this.s3 = s3;
	}

}
