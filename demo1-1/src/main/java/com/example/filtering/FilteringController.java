package com.example.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("filtering")
	public MappingJacksonValue getsomebean() {
		
	SomeBeen been	= new SomeBeen("value1","value2","value3");
	SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
			
			.filterOutAllExcept("s1","s2") 	;	
	MappingJacksonValue mappingJacksonValue=  new MappingJacksonValue(been);
			
			FilterProvider filters= new SimpleFilterProvider()
			.addFilter("Somebeenfilter", filter);
			mappingJacksonValue.setFilters(filters);
			
			return mappingJacksonValue;
				
	}
	
	@GetMapping("filtering-list")
	public MappingJacksonValue getsomebeanlist() {
		

		
		List list= Arrays.asList(new SomeBeen("value1","value2","value3")
				,new SomeBeen("ahwyeqywl","aejfbjbshv","ajbhjab"));
		
		MappingJacksonValue mappingJacksonValue=  getFilteredData(list, "s3","s2");
				
				return mappingJacksonValue;
		
		
		
		
				
	}
	
	
	private MappingJacksonValue getFilteredData(Object  beenclass,String...filterproperty) {
		
		
SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
				
				.filterOutAllExcept(filterproperty) 	;	
		MappingJacksonValue mappingJacksonValue=  new MappingJacksonValue(beenclass);
				
				FilterProvider filters= new SimpleFilterProvider()
				.addFilter("Somebeenfilter", filter);
				mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
