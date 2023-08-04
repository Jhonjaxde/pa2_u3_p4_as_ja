package com.example.demo.repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {
	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CuentaBancaria selecionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	public List<CuentaBancaria> seleccionarCta() {
		TypedQuery<CuentaBancaria> myQuery=this.entityManager.createQuery(
				"SELECT c FROM CuentaBancaria c INNER JOIN c.transferencia t"
				,CuentaBancaria.class);
		
		return myQuery.getResultList();
	}

	@Override
	public CuentaBancaria selecionarPorNumero(String numero) {
		
		return this.entityManager.find(CuentaBancaria.class, numero);
	}

	@Override
	public void insertar(CuentaBancaria cta) {
		LOG.info("Hilo repository: "+ Thread.currentThread().getName());
		//sumar , restar , multiplicar : logica que demora un segundo
		//cada vez que llama el metodo se va a demorar un segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.entityManager.persist(cta);
		
	}
	
	

}