package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	//Definir o atributo que armazena a única instancia
		//o static pertence a classe se fosse apenas private ele pertence ao objeto 
		private static EntityManagerFactory emf;
		
		//Construtor privado -> não é possível fazer new EntityManagerFactorySingleton();
		private EntityManagerFactorySingleton() {}
		
		//Metodo que gerencia a única instancia
		public static EntityManagerFactory getInstance() {
			//Verifica se é necessário instanciar a fabrica
			if(emf == null) {
				emf = Persistence.createEntityManagerFactory("oracle");
			}
			return emf;
		}

}
