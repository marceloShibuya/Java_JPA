package br.com.fiap.jpa.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.dao.PassageiroDAO;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Passageiro;
import br.com.fiap.jpa.exception.FailCommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.impl.PassageiroDAOImpl;

class PassageiroDAOTest {
	
	private static PassageiroDAO dao;
	private Passageiro passageiro;
	
	@BeforeAll
	void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		dao = new PassageiroDAOImpl(em);
	}
	
	@BeforeEach
	void cadastrar() {
		passageiro = new Passageiro(1,"Marcelo",new GregorianCalendar(1983,Calendar.JUNE,21),Genero.MASCULINO);
		try {
			dao.create(passageiro);
			dao.commit();
		}catch(FailCommitException e) {
			fail("Falha no teste");
		}
	}
	
	
	@Test
	void cadastrarComSucessoTest() {
		assertNotEquals(0,passageiro.getCodigo());
	}
	
	@Test
	void buscarComSucessoTest() {
		try {
			Passageiro busca = dao.read(passageiro.getCodigo());
			assertNotNull(busca);
			assertEquals("Marcelo",passageiro.getNome());
		}catch(KeyNotFoundException e) {
			fail("Falha no teste");
		}
	}
	
	@Test 
	void atualizarComSucesso() {
		
		passageiro.setNome("Ricardo");
		
		try {
			dao.update(passageiro);
			dao.commit();
		}catch(FailCommitException e) {
			fail("Falha no teste");
		}
		
		try {
			Passageiro busca = dao.read(passageiro.getCodigo());
			assertEquals("Ricardo",busca.getNome());
		}catch(KeyNotFoundException e) {
			fail("Falha no teste");
		}
	}
	
	@Test
	void removerComSucesso() {
		try {
			dao.delete(passageiro.getCodigo());
			dao.commit();
		}catch(KeyNotFoundException | FailCommitException e) {
			fail("Falha no teste");
		}
		
		assertThrows(KeyNotFoundException.class,() -> {dao.read(passageiro.getCodigo());});
	}
	
	
}
