package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.AtorDAO;
import br.com.fiap.jpa.entity.Ator;
import br.com.fiap.jpa.entity.Atuacao;
import br.com.fiap.jpa.exception.FailCommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.impl.AtorDAOImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleViewAtor {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		AtorDAO dao = new AtorDAOImpl(em);
		
		Ator ator = new Ator("Angelina Jolie",Calendar.getInstance(),1.80f,Atuacao.AVENTURA);
		
		//Cadastrar um ator
		try {
			dao.create(ator);
			dao.commit();
			System.out.println("Ator cadastrado");
		}catch(FailCommitException e) {
			System.out.println("Ator não cadastrado");
		}
		
		
		//Pesquisar um ator
		try {
			Ator busca = dao.read(1);
			System.out.println(busca.getNome());
		}catch(KeyNotFoundException e) {
			System.out.println("Ator não encontrado");
		}
		
		
		//Atualizar um ator
		try {
			ator.setNome("Margie Rob");
			dao.update(ator);
			dao.commit();
			System.out.println("Ator atualizado");
		}catch(FailCommitException e) {
			System.out.println("Ator não atualizado");
		}
		
		//Removar um ator
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Ator removido");
		}catch(KeyNotFoundException e) {
			System.out.println("Ator não encontrado");
		}catch(FailCommitException e) {
			System.out.println("Erro ao removar o ator");
		}
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}

}
