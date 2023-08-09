package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.funcional.Main;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IHotelService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4AsJaApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4AsJaApplication.class);

	@Autowired
	private ICuentaBancariaService cuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AsJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//ASYNCRONO SIN RESPUESTA
		/*
		LOG.info("Hilo: " + Thread.currentThread().getName());

		//Inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 0; i <=10; i++) {
			CuentaBancaria ctaDestino = new CuentaBancaria();

			ctaDestino.setNumero(String.valueOf(i));

			ctaDestino.setSaldo(new BigDecimal(100));

			ctaDestino.setTipo("A");
			lista.add(ctaDestino);
			this.cuentaBancariaService.agregarAsincrono(ctaDestino);
		}
		
		
		//List<String>listaFinal = 	lista.parallelStream().map(cta-> this.cuentaBancariaService.agregar2(cta)).collect(Collectors.toList());
		
		//LOG.info("Se termino de procesar todo");
		//listaFinal.forEach(cadena -> LOG.info(cadena));
		
		// Final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		LOG.info("Se termino de procesar todo");
	*/
	//ASYCRONO FUTURO CON RESPUESTA
		
		LOG.info("Hilo: " + Thread.currentThread().getName());

		//Inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuesta= new ArrayList<>();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 0; i <=10; i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();

			ctaOrigen.setNumero(String.valueOf(i));

			ctaOrigen.setSaldo(new BigDecimal(100));

			ctaOrigen.setTipo("A");
			lista.add(ctaOrigen);
			//capturar
			CompletableFuture<String> repuesta= this.cuentaBancariaService.agregarAsincrono2(ctaOrigen);
			// guardar respuestas en una lista
			listaRespuesta.add(repuesta);
		}
		
		//esperar esa respuesta//sentencia que espera que termine
		// de procesarse todos los hilos para obtener la respuesta
		CompletableFuture.allOf(listaRespuesta.get(0),
				listaRespuesta.get(1),
				listaRespuesta.get(2),
				listaRespuesta.get(3),
				listaRespuesta.get(4),
				listaRespuesta.get(5),
				listaRespuesta.get(6),
				listaRespuesta.get(7),
				listaRespuesta.get(8),
				listaRespuesta.get(9));
		LOG.info("Respuesta 0: "+listaRespuesta.get(0).get());
		
		// Final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		LOG.info("Se termino de procesar todo");
	
	
	
	}

}
