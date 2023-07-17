package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHotelRepository;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService{
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public List<Hotel> buscarInnerJoin() {
		
		return this.hotelRepository.seleccionarInnerjoin();
	}

	@Override
	public List<Hotel> buscarOuterRightjoin() {
		
		return this.hotelRepository.seleccionarOuterRightjoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftjoinn() {
		
		return this.hotelRepository.seleccionarOuterLeftjoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftjoin() {
		
		return this.hotelRepository.seleccionarHabitacionesOuterLeftjoin();
	}

	@Override
	public List<Hotel> buscarOuterFulljoin() {
		
		return this.hotelRepository.seleccionarOuterFulljoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		
		return this.hotelRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> buscarJoinFetch() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarFetchJoin();
	}

	@Override
	public void guardar(Hotel hotel) {
		
		for(Habitacion ha: hotel.getHabitaciones()){
			ha.setValorIncluidoIva(ha.getValor().multiply(new BigDecimal(1.12)));
		}	
		this.hotelRepository.insertar(hotel);
	}

}
