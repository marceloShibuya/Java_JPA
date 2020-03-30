package br.com.fiap.jpa.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.exception.FailCommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.impl.CorridaDAOImpl;

class CorridaDAOTest {
	
	CorridaDAO dao;
	Corrida corrida;
	
	@BeforeAll
	void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.creatEntityManager();
		dao = new CorridaDAOImpl(em);
	}
	
	@BeforeEach
	void cadastrar() {
		corrida = new Corrida(1,"SBC","SCS",Calendar.getInstance(),200);
		try {
			dao.create(corrida);
			dao.commit();
		}catch(FailCommitException e) {
			fail("Falha no teste");
		}
	}

	@Test
	void cadastrarComSucesso() {
		assertNotEquals(0,corrida.getCodigo());
	}
	
	@Test
	void buscarComSucesso() {
		try {
			Corrida busca = dao.read(corrida.getCodigo());
			assertNotNull(busca);
			assertEquals(1,corrida.getCodigo());
		}catch(KeyNotFoundException e) {
			fail("Falha no teste");
		}
	}
	
	@Test
	void atualizarComSucesso() {
		
		corrida.setDestino("STA");
		
		try {
			dao.update(corrida);
			dao.commit();
		}catch(FailCommitException e) {
			fail("Falha no teste");
		}
		
		try {
			Corrida busca = dao.read(corrida.getCodigo());
			assertEquals("STA",busca.getDestino());
		}catch(KeyNotFoundException e) {
			fail("Falha no teste");
		}
	}

	@Test
	void removerComSucesso() {
		try {
			dao.delete(corrida.getCodigo());
			dao.commit();
		}catch(FailCommitException | KeyNotFoundException e) {
			fail("Falha no teste");
		}
		assertThrows(KeyNotFoundException.class,() -> {dao.read(corrida.getCodigo());});
	}
	
	
	
}
