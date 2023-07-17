package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public void insertar(Hotel hotel);
	//la descripcion de los joins no se usa en el ambito de trabajo
	public List<Hotel> seleccionarInnerjoin();
	
	public List<Hotel> seleccionarOuterRightjoin();
	
	public List<Hotel> seleccionarOuterLeftjoin();
	
	public List<Habitacion> seleccionarHabitacionesOuterLeftjoin();
	
	public List<Hotel> seleccionarOuterFulljoin();
	
	public List<Hotel> seleccionarWhereJoin();
	
	
	public List<Hotel> seleccionarFetchJoin();


}
