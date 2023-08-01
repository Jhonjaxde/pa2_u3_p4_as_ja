package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados{
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	public Integer getId() {
		return 8;
	};
	public void acceptar(String arg){
		
		String cadena = "JUANITO";
		LOG.info(cadena +" "+ arg);
		
	};
	
	public boolean evaluar(String arg){
		return arg.equals("holi");
		
	};
}