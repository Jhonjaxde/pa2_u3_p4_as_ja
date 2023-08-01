package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		IPersona per = new PersonaImpl();
		per.caminar();
		// 1.- Supplier

		// clases:
		IPersonaSupplier<String> Supplier1 = new PersonaSupplierImpl();

		LOG.info("Supplier clase:" + Supplier1.getId());
		// lambdas
		IPersonaSupplier<String> Supplier2 = () -> "1723456890";
		LOG.info("Supplier lambda2:" + Supplier2.getId());
		IPersonaSupplier<String> Supplier3 = () -> {
			String cedula = "1273648712";
			cedula = cedula + "ele";
			return cedula;
		};
		LOG.info("Supplier lambda3:" + Supplier3.getId());
		// metodos referenciados
		
		
		
		MetodosReferenciados metodos = new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4 = metodos::getId;
		LOG.info("Supplier metodo referenciado:" + supplier4.getId());
		
		// 2.- Consumer/no se necesita un return
		// clases:

		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer clase:");
		consumer1.accept("Jhon chiles");

		// Lamba:
		IPersonaConsumer<String> consumer2 = cadena -> LOG.info(cadena);
		LOG.info("Consumer lambda:");
		consumer2.accept("Jhon Arteaga");
		// metodo referenciado 
		
		IPersonaConsumer<String> consumer3 = metodos::acceptar;
		LOG.info("Consumer metodos referenciados:");
		consumer3.accept("GUAR");
		// 3.- Predicate

		// Lambda:
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("Predicate lambda1:" + predicate1.evaluar(4));
		// consumer2.accept("Jhon Arteaga");

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate lambda2:" + predicate2.evaluar(95));

		// en una sola linea
		// IPersonaPredicate<String> predicate3 = letra -> "Edison".contains(letra))
		IPersonaPredicate<String> predicate3 = nombre -> {
			String nombreMio = "jhon";
			if (nombreMio.contains(nombre)) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate lambda3:" + predicate3.evaluar("j"));

		// se necesita recibir dos valores se agrega el bi"interfaz funcional"
		// excepto el supplier porque no recibe parametros{}

		// Bi

		IPersonaBIPredicate<String, String> predicate4 = (letra, cadena) -> cadena.contains(letra);
		LOG.info("Predicate lambda4:" + predicate4.evaluar("a", "augusto"));

		//metodo referenciado
		IPersonaPredicate<String> predicate5 = metodos::evaluar;
		LOG.info("Predicate metodos referenciados:");
		predicate5.evaluar("holis");
		LOG.info("Predicate lambda5:" + predicate5.evaluar("holitas"));
		// 4.- Function- para funciones de casteo
		IPersonaFunction<String, Integer> function = numero -> numero.toString();
		
		LOG.info("Function lambda:" + function.aplicar(8));

		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat(" valor");
			return valorFinal;
		};
		LOG.info("Function lambda1:" + function1.aplicar(10));
	
		
		// 5.- Unary Operator

		IPersonaUnaryOperator<Integer> unaryOperator = numero -> numero + (numero * 2);
		LOG.info("UnaryOperator lambda1:" + unaryOperator.aplicar(10));

		IPersonaUnaryOperatorFunction<Integer> unaryOperator2 = numero -> numero + (numero * 2);
		LOG.info("UnaryOperator lambda2:" + unaryOperator2.aplicar(3));
		// Metodo referenciados y dentro de estos estan los metodos high order
		// mientras yo tenga un metodo que cumpla el contrato
		// de la interfaz funcional yo le puedo pasar como una
		// implementacion de la interfaz funcional
		// con los metodos referenciados puede utilizar los lambdas
	}

}
