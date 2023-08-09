package com.example.demo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;

public interface ICuentaBancariaService {
	
	public CuentaBancaria buscar(Integer id);
	public void actualizar(CuentaBancaria cuentaBancaria);
	public List<CuentaBancaria> reporteCta();
	public CuentaBancaria buscarPorNumero(String numero);
	public void guardar(CuentaBancaria cta);
	
	public String agregar2(CuentaBancaria cta);
	
	public void agregarAsincrono(CuentaBancaria cuentaBancaria);
	
	public CompletableFuture<String>  agregarAsincrono2(CuentaBancaria cuentaBancaria);

}