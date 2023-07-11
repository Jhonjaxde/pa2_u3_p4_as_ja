package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Hotel;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> seleccionarInnerjoin() {
		
		//select * from hotel h inner join habitacion ha on h.hot_id = ha.hab_id_hotel 
		//select h1_0.hot_id,h1_0.hot_direccion,h1_0.hot_nombre from hotel h1_0 join habitacion h2_0 on h1_0.hot_id=h2_0.hab_id_hotel
		//SELECT h from Hotel h JOIN h.habitaciones ha
		TypedQuery<Hotel> myQuery =
				this.entityManager.createQuery("SELECT h from Hotel h JOIN h.habitaciones ha",Hotel.class);
		return myQuery.getResultList();
	}

}
