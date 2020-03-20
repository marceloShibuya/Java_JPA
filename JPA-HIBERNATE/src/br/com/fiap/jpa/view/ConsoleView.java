package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.FilmeDAO;
import br.com.fiap.jpa.entity.Categoria;
import br.com.fiap.jpa.entity.Filme;
import br.com.fiap.jpa.exception.FailCommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.impl.FilmeDAOImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		
		// Obter uma instancia da fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o FilmeDAOImpl
		FilmeDAO dao = new FilmeDAOImpl(em);
		
		//Criar uma instância de filme
		Filme filme = new Filme("Interestelar",180,Calendar.getInstance(),Categoria.ACAO);		
		
		//Cadastrar um filme
		try {
		dao.create(filme);
		dao.commit();
		System.out.println("Filme cadastrado!");
		}catch(FailCommitException e) {
			System.out.println("Erro ao cadastrar");
		}
		
		//Pesquisar um filme
		try {
			Filme busca = dao.read(1);
			System.out.println(busca.getTitulo());
		}catch(KeyNotFoundException e) {
			System.out.println("Filme não encontrado");
		}
		
		//Atualizar
		try {
			filme.setTitulo("Harry Potter");
			dao.update(filme);
			dao.commit();
			System.out.println("Filme atualizado");
		}catch(FailCommitException e) {
			System.out.println("Filme não atualizado");
		}
		
		//Remover
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Filme removido");
		}catch(KeyNotFoundException e) {
			System.out.println("Filme não encontrado");
		}catch(FailCommitException e) {
			System.out.println("Erro ao remover o filme");
		}
		
		
		//Fechar
		em.close();
		fabrica.close();

	}

}
