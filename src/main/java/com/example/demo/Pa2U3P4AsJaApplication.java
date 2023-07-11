package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4AsJaApplication implements CommandLineRunner{
	@Autowired
	private IHotelService hotelService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AsJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Hotel hot = new Hotel();
		hot.setNombre("criaturitas");
		hot.setDireccion("av venida");
		
		Habitacion hab = new Habitacion();
		hab.setNumero("78");
		hab.setValor(new BigDecimal(10));
		*/
		//System.out.println(this.hotelService.buscarInnerJoin());
		List<Hotel> listaHotel = this.hotelService.buscarInnerJoin();
		for(Hotel h:listaHotel) {
			System.out.println(h.getNombre());
		}
		
	}

}
