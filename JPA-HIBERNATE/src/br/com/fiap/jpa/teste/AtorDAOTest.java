package br.com.fiap.jpa.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import br.com.fiap.jpa.dao.AtorDAO;
import br.com.fiap.jpa.entity.Ator;
import br.com.fiap.jpa.entity.Atuacao;
import br.com.fiap.jpa.exception.FailCommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.impl.AtorDAOImpl;

class AtorDAOTest {
	
	private static AtorDAO dao;
	private Ator ator; 
	
	@BeforeAll
	static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		dao = new AtorDAOImpl(em);
	}

	@BeforeEach
	void cadastrar() {
		ator = new Ator("Marcelo",new GregorianCalendar(2000,Calendar.AUGUST,24),2.00f,Atuacao.AVENTURA);
		try {
			dao.create(ator);
			dao.commit();
		}catch(FailCommitException e) {
			fail("Falha no teste");
		}
	}
	
	@Test
	void cadastrarComSucessoTest() {
		assertNotEquals(0,ator.getCodigo());
	}
	
	@Test
	void buscarComSucessoTest() {
		try {
			Ator busca = dao.read(ator.getCodigo());
			assertNotNull(busca);
			assertEquals("Marcelo",ator.getNome());
		}catch(KeyNotFoundException e) {
			fail("Falha no teste");
		}
	}

	@Test
	void atualizarComSucessoTest() {
		
		ator.setNome("Denise");
		ator.setAtuacao(Atuacao.ACAO);;
		
		try {
			dao.update(ator);
			dao.commit();
		}catch(FailCommitException e) {
			fail("Falha no teste");
		}
	
		try {
			Ator busca = dao.read(ator.getCodigo());
			assertEquals("Denise",busca.getNome());
			assertEquals(Atuacao.ACAO,busca.getAtuacao());
		}catch(KeyNotFoundException e) {
			fail("Falha no teste");
		}
	}
	
	@Test
	void removerComSucessoTest() {
		
		try {
			dao.delete(ator.getCodigo());
			dao.commit();
		}catch(KeyNotFoundException | FailCommitException e) {
			fail("Falha no teste");
		}
		
		assertThrows(KeyNotFoundException.class,() -> {dao.read(ator.getCodigo());});
	}
	
	
	
}
