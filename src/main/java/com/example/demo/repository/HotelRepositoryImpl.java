package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
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
		
		// select * from hotel h inner join habitacion ha on h.hot_id = ha.hab_id_hotel 
		//JPA select h1_0.hot_id,h1_0.hot_direccion,h1_0.hot_nombre from hotel h1_0 join habitacion h2_0 on h1_0.hot_id=h2_0.hab_id_hotel
		//JQPL SELECT h from Hotel h JOIN h.habitaciones ha
		TypedQuery<Hotel> myQuery =
				this.entityManager.createQuery("SELECT h from Hotel h JOIN h.habitaciones ha",Hotel.class);
		List<Hotel> listaHoteles= myQuery.getResultList();
		for(Hotel h: listaHoteles) {
			h.getHabitaciones().size();
		}
		return listaHoteles;
	}

	@Override
	public List<Hotel> seleccionarOuterRightjoin() {
		TypedQuery<Hotel> myQuery =
				this.entityManager.createQuery("SELECT h from Hotel h RIGHT JOIN h.habitaciones ha",Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftjoin() {
		TypedQuery<Hotel> myQuery =
				this.entityManager.createQuery("SELECT h from Hotel h LEFT JOIN h.habitaciones ha",Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionesOuterLeftjoin() {
		TypedQuery<Habitacion> myQuery =
				this.entityManager.createQuery("SELECT ha from Hotel h LEFT JOIN h.habitaciones ha",Habitacion.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterFulljoin() {
		TypedQuery<Hotel> myQuery =
				this.entityManager.createQuery("SELECT h from Hotel h FULL JOIN h.habitaciones ha",Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		
		//SELECT h.* FROM hotel h , habitacion ha WHERE h.hot_id = ha.habi_id-hotel
		//SELECT h FROM Hotel h , Habitacion ha WHERE h= ha.hotel
		TypedQuery<Hotel> myQuery =
				this.entityManager.createQuery("SELECT h FROM Hotel h , Habitacion ha WHERE h= ha.hotel",Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	// primero el join y luego es fetch en esta consulta
	public List<Hotel> seleccionarFetchJoin() {
		TypedQuery<Hotel> myQuery =
				this.entityManager.createQuery("SELECT h from Hotel h JOIN FETCH h.habitaciones ha",Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);
		
	}
}
