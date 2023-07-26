package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;

	@Override
	public CuentaBancaria buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepository.selecionar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaBancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public List<CuentaBancaria> reporteCta() {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepository.seleccionarCta();
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepository.selecionarPorNumero(numero);
	}

	@Override
	public void guardar(CuentaBancaria cta) {
		this.cuentaBancariaRepository.insertar(cta);
		
	}

	
}