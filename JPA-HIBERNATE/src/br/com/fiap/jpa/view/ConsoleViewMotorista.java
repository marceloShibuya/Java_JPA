package br.com.fiap.jpa.view;

import java.util.Calendar;

import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.FailCommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleViewMotorista {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		Motorista motorista = new Motorista(1233,"Marcelo Shibuya",Calendar.getInstance(),222,Genero.MASCULINO);
		
		try {
			dao.create(motorista);
			dao.commit();
			System.out.println("Motorista cadastraso!");
		}catch(FailCommitException e) {
			System.out.println("Motorista não cadastrado!");
		}
		
		try {
			Motorista busca = dao.read(1);
			System.out.println(busca.getNome());
		}catch(KeyNotFoundException e) {
			System.out.println("Motorista não encontrado");
		}
		
		try {
			motorista.setNome("Ricardo Shibuya");
			dao.update(motorista);
			dao.commit();
			System.out.println("Nome do motorista atualizado");
		}catch(FailCommitException e) {
			System.out.println("Nome não atualizado");
		}
		
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Motorista apagado");
		}catch(KeyNotFoundException e) {
			System.out.println("Motorista não encontrado");
		}catch(FailCommitException e) {
			System.out.println("Erro ao apagar o filme");
		}
		
		em.close();
		fabrica.close();

	}

}
