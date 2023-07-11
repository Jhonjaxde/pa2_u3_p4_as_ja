package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	//la descripcion de los joins no se usa en el ambito de trabajo
	public List<Hotel> seleccionarInnerjoin();

}
