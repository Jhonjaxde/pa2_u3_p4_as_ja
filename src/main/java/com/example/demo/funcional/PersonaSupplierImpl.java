package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula = "1273648712";
		cedula = cedula	+"ele";	
		return cedula;
	}
	
	
}