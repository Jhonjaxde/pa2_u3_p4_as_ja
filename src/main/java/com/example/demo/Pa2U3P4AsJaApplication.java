package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4AsJaApplication implements CommandLineRunner {
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AsJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * Hotel hot = new Hotel(); hot.setNombre("criaturitas");
		 * hot.setDireccion("av venida");
		 * 
		 * Habitacion hab = new Habitacion(); hab.setNumero("78"); hab.setValor(new
		 * BigDecimal(10));
		 */
		// System.out.println(this.hotelService.buscarInnerJoin());
		/*
		 * List<Hotel> listaHotel = this.hotelService.buscarOuterLeftjoinn(); for(Hotel
		 * h:listaHotel) { System.out.println(h); }
		 * 
		 * List<Hotel> listaHotel4 = this.hotelService.buscarOuterRightjoin(); for(Hotel
		 * h:listaHotel4) { System.out.println(h); }
		 * 
		 * List<Habitacion> listaHabitacion =
		 * this.hotelService.buscarHabitacionOuterLeftjoin(); for(Habitacion ha:
		 * listaHabitacion){ System.out.println(ha); }
		 * 
		 * List<Hotel> listaHotel1 = this.hotelService.buscarOuterFulljoin(); for(Hotel
		 * h: listaHotel1){ if(h== null) { System.out.println("no existe este hotel");
		 * }else { System.out.println(h.getNombre()); } }
		 */
		System.out.println("SQL join FETCH");
		List<Hotel> listaHotel2 = this.hotelService.buscarJoinFetch();
		for (Hotel h : listaHotel2) {

			System.out.println(h.getNombre());
			System.out.println("FETCH Tiene las siguientes habitaciones:");
			for (Habitacion ha : h.getHabitaciones()) {
				System.out.println(ha.getNumero());

			}
		}
		
		/*Hotel ho = new Hotel();
		ho.setDireccion("av.plazalaguna");
		ho.setNombre("Rokio");
		
		
		
		Habitacion ha = new Habitacion();
		ha.setNumero("84");
		ha.setValor(new BigDecimal(789));
		ha.setHotel(ho);
		
		
		List<Habitacion>habitaciones = new ArrayList<>();
		habitaciones.add(ha);
		ho.setHabitaciones(habitaciones);
		
		//this.hotelService.guardar(ho);
		//System.out.println(ha.getValorIncluidoIva());
		
		
	}*/
	}
}
