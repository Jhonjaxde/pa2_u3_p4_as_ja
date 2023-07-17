package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface IHotelService {
	public List<Hotel> buscarInnerJoin();
	
	public List<Hotel> buscarOuterRightjoin();
	
	public List<Hotel> buscarOuterLeftjoinn();
	
	public List<Habitacion> buscarHabitacionOuterLeftjoin();
	
	public List<Hotel> buscarOuterFulljoin();
	public List<Hotel> buscarWhereJoin();
	public List<Hotel> buscarJoinFetch();
	
	public void guardar(Hotel hotel);
	
}
