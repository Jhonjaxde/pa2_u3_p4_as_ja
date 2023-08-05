package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class Pa2U3P4AsJaApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4AsJaApplication.class);

	@Autowired
	private ICuentaBancariaService cuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AsJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		//Inicio
		long tiempoInicial = System.currentTimeMillis();
		for (int i = 0; i <=30; i++) {
			CuentaBancaria ctaDestino = new CuentaBancaria();

			ctaDestino.setNumero(String.valueOf(i));

			ctaDestino.setSaldo(new BigDecimal(100));

			ctaDestino.setTipo("A");

			this.cuentaBancariaService.guardar(ctaDestino);
		}
		// Final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		*/
		
		
		
		
		/*LOG.info("Hilo: " + Thread.currentThread().getName());

		//Inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 0; i <=100; i++) {
			CuentaBancaria ctaDestino = new CuentaBancaria();

			ctaDestino.setNumero(String.valueOf(i));

			ctaDestino.setSaldo(new BigDecimal(100));

			ctaDestino.setTipo("A");
			lista.add(ctaDestino);
		}
		
		
		//lista.stream().forEach(cta-> this.cuentaBancariaService.guardar(cta));
		lista.parallelStream().forEach(cta-> this.cuentaBancariaService.agregar2(cta));
		
		
		
		// Final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
	*/
		
		LOG.info("Hilo: " + Thread.currentThread().getName());

		//Inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 0; i <=100; i++) {
			CuentaBancaria ctaDestino = new CuentaBancaria();

			ctaDestino.setNumero(String.valueOf(i));

			ctaDestino.setSaldo(new BigDecimal(100));

			ctaDestino.setTipo("A");
			lista.add(ctaDestino);
		}
		
		
		//lista.stream().forEach(cta-> this.cuentaBancariaService.guardar(cta));
	
		Stream<String>listaFinal = 	lista.parallelStream().map(cta-> this.cuentaBancariaService.agregar2(cta));
		
		LOG.info("Se guardadon las siguientes cuentas");
		listaFinal.forEach(cadena -> LOG.info(cadena));
		
		// Final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		
	
	
	
	}

}
